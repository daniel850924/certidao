WITH orgaosadimplentes_temp AS (
                SELECT org.seq_dim_orgao
                      ,org.num_exercicio
                      ,org.num_mes
                      ,org.posicao
                      ,org.nom_periodo
                      ,org.data_ativacao
                      ,org.dtaleiextincao
                      ,org.org_ativo                --> org_ativo indica se órgão esta ativo no mês (1-ativo 0-desativado)
                      ,rem.enviou_rem enviou_rem    --> enviou_rem indica se teve remessa no mês (1-enviou 0-não enviou)
                      ,CASE WHEN org.org_ativo > NVL(rem.enviou_rem,0) THEN 1 ELSE 0 END inadimplente -->indica se situação do órgão é inadimplente.(1-adimplente 0-inadimplente)(ex. não enviou remessa, mas estava desativado = adimplente)   
                  FROM ( 
                       SELECT :exercicioCursoSelecionado AS num_exercicio
                             ,oo.seqorg AS seq_dim_orgao
                             ,op.nummes AS num_mes
                             ,op.numpos AS posicao
                             ,op.nomper AS nom_periodo
                             ,oc.data_ativacao
                             ,oe.dtaleiextincao
                             --indica se órgão esta ativo no mês (1-ativo 0-desativado)
                             ,SUM(CASE WHEN to_number(to_char(oc.data_ativacao, 'YYYYMM')) <= to_number(:exercicioCursoSelecionado||LPAD(op.nummes, 2, 0)) AND
                               to_number(to_char(NVL(NVL(oc.data_encerramento_atividades,oe.dtaleiextincao),add_months(SYSDATE,13)), 'YYYYMM')) > to_number(:exercicioCursoSelecionado||lpad(op.nummes, 2, 0)) THEN 1 ELSE 0 END) AS org_ativo   
                            FROM bi_sicom.odsper op
                             CROSS JOIN bi_sicom.odsorg oo 
                             INNER JOIN portalsicom.orgaoconvidado oc ON oo.codorg = oc.codorgao AND oo.numcgcorg = oc.cnpj
                             INNER JOIN portalsicom.municipio m       ON m.codmunicipio = oc.codmunicipio AND m.codibge = oo.codmun                                            
                             LEFT  JOIN portalsicom.orgaoextinto oe   ON oe.idorgaoextinto = oc.idorgaoconvidado
                            WHERE oo.codmun = :municipioSelecionado
                              AND op.numpos IN (1,2,3,4,5,6,7,8,9,10,11,12)   
                              AND oo.codtpoorg <> '7'     
                              AND oc.codmunicipio not like '090%'
                              AND oc.tipoorgao <> 7
                              AND oc.data_ativacao IS NOT NULL
                            GROUP BY oo.seqorg   
                                    ,op.numpos
                                    ,op.nomper
                                    ,op.nummes
                                    ,oc.data_ativacao
                                    ,oe.dtaleiextincao
                       ) org
                     LEFT JOIN
                        (SELECT oo.seqorg AS seq_dim_orgao
                               ,trh.nummesrem AS num_mes_ref
                               ,trh.numanorem AS num_ano_exercicio
                               --indica se teve remessa no mês (1-enviou 0-não enviou)
                               ,COUNT(DISTINCT oo.seqorg) AS enviou_rem
                           FROM bi_sicom.tblremhst trh
                            INNER JOIN bi_sicom.odsorg oo ON oo.seqorg = trh.seqorg
                           WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim 
                             AND oo.codmun = :municipioSelecionado
                             AND trh.numanorem = :exercicioCursoSelecionado
                             AND trh.tiprem = 'AM'
                           GROUP BY trh.nummesrem
                                   ,trh.numanorem
                                   ,oo.seqorg
                        ) rem ON rem.num_ano_exercicio = :exercicioCursoSelecionado AND rem.num_mes_ref = org.num_mes AND rem.seq_dim_orgao = org.seq_dim_orgao
             )
                                                                
--Lista os meses pegando o Menor mês Comum e o Maior mês Comum entre os òrgãos. Conforme regras Consolidado definidas, de Órgãoes Ativos
,maiorMes_temp AS (SELECT NVL(MAX(num_mes),0) AS num_mes
                    FROM(
                    SELECT op.nomper AS DSC_MES
                          ,op.numpos
                          ,op.nummes AS num_mes
                          ,op.nummes || to_char(SYSDATE,'ddYYhhmmss') as num_mes2 
                      FROM bi_sicom.odsper op
                      WHERE op.numpos in (1,2,3,4,5,6,7,8,9,10,11,12)
                      HAVING MAX(op.nummes) BETWEEN 
                                          -- Menor Mes Comum
                                          (SELECT MIN(menor_posicao) AS menor_posicao
                                                FROM (SELECT seq_dim_orgao
                                                            ,CASE WHEN inadimplente_org IS NOT NULL THEN inadimplente_org - 1 ELSE MAX(posicao) END AS maior_posicao
                                                            ,MIN(posicao) AS menor_posicao
                                                        FROM (
                                                              SELECT f.seq_dim_orgao
                                                                    ,f.posicao
                                                                    ,(SELECT COUNT(DISTINCT ff.seq_dim_orgao) 
                                                                       FROM orgaosadimplentes_temp ff
                                                                     ) AS qtde_orgao_selecionado
                                                                    ,enviou_rem
                                                                    ,inadimplente
                                                                    ,(SELECT MIN(posicao)
                                                                       FROM orgaosadimplentes_temp fff 
                                                                       WHERE fff.seq_dim_orgao = f.seq_dim_orgao
                                                                         AND inadimplente = 1
                                                                     ) AS inadimplente_org
                                                                FROM orgaosadimplentes_temp f
                                                              )
                                                        WHERE CASE WHEN qtde_orgao_selecionado = 1 THEN enviou_rem ELSE 1 END = 1
                                                        GROUP BY seq_dim_orgao,inadimplente_org,qtde_orgao_selecionado
                                                     )
                                          ) 
                                          --Maior Mes Comum             
                                          AND (SELECT MIN(maior_posicao) AS maior_posicao_comum
                                                FROM (SELECT seq_dim_orgao
                                                            ,CASE WHEN inadimplente_org IS NOT NULL THEN inadimplente_org - 1 ELSE MAX(posicao) END AS maior_posicao
                                                            ,MIN(posicao) AS menor_posicao
                                                        FROM (
                                                              SELECT f.seq_dim_orgao
                                                                    ,f.posicao
                                                                    ,(SELECT COUNT(DISTINCT ff.seq_dim_orgao) 
                                                                       FROM orgaosadimplentes_temp ff
                                                                     ) AS qtde_orgao_selecionado
                                                                    ,enviou_rem
                                                                    ,inadimplente
                                                                    ,(SELECT MIN(posicao)
                                                                        FROM orgaosadimplentes_temp fff 
                                                                        WHERE fff.seq_dim_orgao = f.seq_dim_orgao
                                                                          AND inadimplente = 1
                                                                     ) AS inadimplente_org
                                                                FROM orgaosadimplentes_temp f
                                                              )
                                                              WHERE CASE WHEN qtde_orgao_selecionado = 1 THEN enviou_rem ELSE 1 END = 1
                                                              GROUP BY seq_dim_orgao,inadimplente_org,qtde_orgao_selecionado
                                                     )
                                              )
                    GROUP BY op.nomper, op.numpos,op.nummes
                    ORDER BY op.numpos DESC)
                )

--========================= Fim Remessas em comum ===================================

,certidao AS
(
SELECT num_ano
      ,seq_municipio AS cod_municipio
      ,num_mes
      -- despesa total com pessoal (por poder)
      ,NVL(SUM(vlr_dsp_legislativo),0) AS vlr_dsp_legislativo
      ,NVL(SUM(vlr_dsp_executivo),0) AS vlr_dsp_executivo
      ,NVL(SUM(vlr_dsp_total),0) AS vlr_dsp_total
                 
      --  valor rcl e rcl ajustada
      ,NVL(SUM(vlr_rcl),0) AS vlr_rcl
      ,NVL(SUM(vlr_rcl_aju),0) AS vlr_rcl_aju               
FROM(
    SELECT ot.numano AS num_ano
          ,f.seqmun AS seq_municipio
          ,ot.nummes AS num_mes
          ,SUM (NVL(f.vlrreccorlqd,0)) AS vlr_rcl
          ,SUM(NVL(f.vlrreccorlqdajs,0)) AS vlr_rcl_aju
          ,SUM(CASE WHEN opo.codpdrorg = 1 THEN (NVL((f.vlrgstdsp),0) - NVL((f.vlrexlgst),0)) ELSE 0 END) AS vlr_dsp_legislativo
          ,SUM(CASE WHEN opo.codpdrorg = 2 THEN (NVL((f.vlrgstdsp),0) - NVL((f.vlrexlgst),0)) ELSE 0 END) AS vlr_dsp_executivo
          ,SUM(NVL(f.vlrgstdsp,0)) AS vlr_dsp_total          
     FROM bi_lrf.fatlrfana f
      INNER JOIN bi_lrf.odspdrorg opo ON f.seqpdrorg = opo.seqpdrorg
      INNER JOIN bi_sicom.odstmp ot   ON f.seqodstmp = ot.seqodstmp
     WHERE f.datfotlrf = :dataSelecionada
       AND ot.numano = :exercicioCursoSelecionado
       AND f.seqmun = :municipioSelecionado
       AND ot.nummes IN (2,4,6,8,10,12)
     GROUP BY ot.numano, f.seqmun, ot.nummes
    ) 
GROUP BY num_ano,seq_municipio, num_mes
)        

--============= fim certidao ==============

--======================================================== fim temporárias / início consulta ============================================================================
SELECT cod_municipio
      ,dt_base
      ,ano
      ,SUM(vlr_dsp_legislativo) AS vlr_dsp_legislativo
      ,SUM(prc_dps_leg) AS prc_dps_leg
      ,SUM(vlr_dsp_executivo) AS vlr_dsp_executivo
      ,SUM(prc_dps_exe) AS prc_dps_exe
      ,SUM(vlr_dsp_total) AS vlr_dsp_total
      ,SUM(prc_dps_mun) AS prc_dps_mun            
      ,SUM(vlr_rcl) AS vlr_rcl
      ,SUM(vlr_rcl_aju) AS vlr_rcl_aju
      ,MAX(dta_pub_rel_lrf) AS dta_pub_rel_lrf      
      ,NVL(MAX(situacaorreo),'Não Informou') AS situacaorreo
      ,MAX(dat_publicrgf) AS dat_publicrgf
      ,NVL(MAX(situacaorgf), 'Não Informou') AS situacaorgf
      ,(SELECT * FROM maiorMes_temp) AS maiorMes
      
      --Condições criadas para auxiliar na exibição da data-base caso o município seja Semestral ou Quadrimestral 
      ,CASE WHEN situacaoOptante = 'S' AND dt_base = '28/02/'|| :exercicioCursoSelecionado THEN 'N' 
            WHEN situacaoOptante = 'Q' AND dt_base = '28/02/'|| :exercicioCursoSelecionado THEN 'N'
            WHEN situacaoOptante = 'S' AND dt_base = '30/04/'|| :exercicioCursoSelecionado THEN 'N' 
            WHEN situacaoOptante = 'Q' AND dt_base = '30/04/'|| :exercicioCursoSelecionado THEN 'S'
            WHEN situacaoOptante = 'S' AND dt_base = '30/06/'|| :exercicioCursoSelecionado THEN 'S' 
            WHEN situacaoOptante = 'Q' AND dt_base = '30/06/'|| :exercicioCursoSelecionado THEN 'N'
            WHEN situacaoOptante = 'S' AND dt_base = '31/08/'|| :exercicioCursoSelecionado THEN 'N' 
            WHEN situacaoOptante = 'Q' AND dt_base = '31/08/'|| :exercicioCursoSelecionado THEN 'S'
            WHEN situacaoOptante = 'S' AND dt_base = '31/10/'|| :exercicioCursoSelecionado THEN 'N' 
            WHEN situacaoOptante = 'Q' AND dt_base = '31/10/'|| :exercicioCursoSelecionado THEN 'N'
            WHEN situacaoOptante = 'S' AND dt_base = '31/12/'|| :exercicioCursoSelecionado THEN 'S' 
            WHEN situacaoOptante = 'Q' AND dt_base = '31/12/'|| :exercicioCursoSelecionado THEN 'S'      
       END AS Obrigatoria_da_data
             
 FROM (
  SELECT cod_municipio
        ,dt_base
        ,ano
        -- despesa total com pessoal (por poder)
        ,NVL(SUM(vlr_dsp_legislativo),0) AS vlr_dsp_legislativo
        ,ROUND(CASE WHEN SUM(vlr_rcl_aju) > 0 THEN SUM(vlr_dsp_legislativo) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_leg
        ,NVL(SUM(vlr_dsp_executivo),0) AS vlr_dsp_executivo
        ,ROUND(CASE WHEN SUM(vlr_rcl_aju) > 0 THEN SUM(vlr_dsp_executivo) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_exe
        ,NVL(SUM(vlr_dsp_total),0) AS vlr_dsp_total
        ,ROUND(CASE WHEN SUM(vlr_rcl_aju) > 0 THEN SUM(vlr_dsp_total) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_mun       
                 
        --  valor rcl e rcl ajustada
        ,NVL(SUM(vlr_rcl),0) AS vlr_rcl
        ,NVL(SUM(vlr_rcl_aju),0) AS vlr_rcl_aju  
        ,NVL(dta_pub_rel_lrf, '-') AS dta_pub_rel_lrf
        ,NVL(situacaorreo, 'Não Informou') AS situacaorreo
        ,NVL(MAX(dat_publicrgf), '-') AS dat_publicrgf
        ,NVL(MAX(situacaorgf), 'Não Informou') AS situacaorgf
        
        --Retorna se o município é Semestral ou Quadrimestral no exercício corrente
        ,(SELECT tsc.indsitsmtano
           FROM bi_lrf.tblsmtlrfcon tsc
           WHERE tsc.datfotlrf = :dataSelecionada
             AND tsc.codmun = :municipioSelecionado
             AND tsc.numano = :exercicioCursoSelecionado
           GROUP BY tsc.indsitsmtano
         )AS situacaoOptante

  FROM(

  --busca informações da certidão
  SELECT c.cod_municipio
        ,DECODE(c.num_mes, 2, '28/02' || '/' || :exercicioCursoSelecionado, 
                           4, '30/04' || '/' || :exercicioCursoSelecionado,
                           6, '30/06' || '/' || :exercicioCursoSelecionado,
                           8, '31/08' || '/' || :exercicioCursoSelecionado,
                           10,'31/10' || '/' || :exercicioCursoSelecionado,
                           12,'31/12' || '/' || :exercicioCursoSelecionado) AS dt_base
        ,to_char(c.num_ano) as ano
        ,c.vlr_dsp_legislativo
        ,c.vlr_dsp_executivo
        ,c.vlr_dsp_total
        ,c.vlr_rcl
        ,c.vlr_rcl_aju
        ,NULL AS dta_pub_rel_lrf
        ,NULL AS situacaorreo
        ,NULL AS dat_publicrgf
        ,NULL AS situacaorgf
  FROM certidao c
  WHERE c.cod_municipio = :municipioSelecionado
    AND c.num_mes <= (SELECT * FROM maiorMes_temp) 
  
  UNION ALL
  
  -- buscar data e situação da publicação do rreo
  SELECT cod_municipio
        ,dt_base
        ,to_char(num_ano_exercicio)
        ,0 AS vlr_dsp_legislativo
        ,0 AS vlr_dsp_executivo
        ,0 AS vlr_dsp_total
        ,0 AS vlr_rcl
        ,0 AS vlr_rcl_aju
        ,dta_pub_rel_lrf
        ,situacaorreo
        ,NULL AS dat_publicrgf
        ,NULL AS situacaorgf
   FROM (
        SELECT oo.codmun AS cod_municipio            
              ,oppl.numexrtpobim AS num_ano_exercicio
              ,DECODE(oppl.numbim, 1, '28/02/' || :exercicioCursoSelecionado
                                 , 2, '30/04/' || :exercicioCursoSelecionado
                                 , 3, '30/06/' || :exercicioCursoSelecionado
                                 , 4, '31/08/' || :exercicioCursoSelecionado
                                 , 5, '31/10/' || :exercicioCursoSelecionado
                                 , 6, '31/12/' || :exercicioCursoSelecionado
                                 , NULL, '-') AS dt_base
              ,to_char(oppl.datpubrltlrf, 'DD/MM/YYYY') AS dta_pub_rel_lrf
              ,CASE WHEN to_number(to_char(oppl.datpubrltlrf, 'YYYYMMDD')) <= to_number((:exercicioCursoSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                    WHEN to_number(to_char(oppl.datpubrltlrf, 'YYYYMMDD')) > to_number((:exercicioCursoSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Intempestivo' 
               ELSE 'Não Informou' END AS situacaorreo
          FROM bi_sicom.odspubperlrf oppl
            INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = oppl.codacp
            INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
          WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
            AND oppl.numexrtpobim = :exercicioCursoSelecionado
            AND oo.codmun NOT IN (0, 9999999, 123456, 654321)
            AND oo.codmun = :municipioSelecionado
            AND trh.numanorem IN (:exercicioCursoSelecionado, :exercicioCursoSelecionado + 1)
        )
  
  UNION ALL
  
  -- buscar data e situação da publicação do rgf
  SELECT aux.cod_municipio
        ,aux.dat_base
        ,to_char(aux.num_ano) AS ano
        ,0 AS vlr_dsp_legislativo
        ,0 AS vlr_dsp_executivo
        ,0 AS vlr_dsp_total
        ,0 AS vlr_rcl
        ,0 AS vlr_rcl_aju
        ,NULL AS dta_pub_rel_lrf
        ,NULL AS situacaorreo
        ,MAX(NVL(to_char(aux.dat_publicrgf),'-')) AS dat_publicrgf
        ,MAX(CASE WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) <= to_number((:exercicioCursoSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                  WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) > to_number((:exercicioCursoSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Intempestivo' 
             ELSE 'Não Informou' END) AS situacaorgf

      FROM (          
            --data-base 28/02
            SELECT opprl.codmun AS cod_municipio
                  ,'28/02' || '/' || :exercicioCursoSelecionado AS dat_base
                  ,:exercicioCursoSelecionado as num_ano
                  ,MAX(CASE WHEN opprl.indpubrgf = 1  
                             AND opprl.numexrtpoper = :exercicioCursoSelecionado
                             AND oo.codtpoorg = '2'
                             AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                       ,2,12 -- 2º semestre
                                                       ,3, 4 -- 1º quadrimestre
                                                       ,4, 8 -- 2º quadrimestre                                     
                                                       ,5,12) <= 2  then opprl.datpubrgf end) as dat_publicrgf
             FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                     INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                     INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                     INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
               AND oo.codmun = :municipioSelecionado
               -- regra semestralidade
               AND tslc.datfotlrf = :dataSelecionada
               AND tslc.numano = :exercicioCursoSelecionado
               AND tslc.nummes = :mesSelecionado                   
             GROUP BY opprl.codmun
            
            UNION ALL
            
            --data-base 30/04
            SELECT opprl.codmun AS cod_municipio
                  ,'30/04' || '/' || :exercicioCursoSelecionado AS dat_base
                  ,:exercicioCursoSelecionado as num_ano
                  ,MAX(CASE WHEN opprl.indpubrgf = 1  
                             AND opprl.numexrtpoper = :exercicioCursoSelecionado
                             AND oo.codtpoorg = '2'
                             AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                       ,2,12 -- 2º semestre
                                                       ,3, 4 -- 1º quadrimestre
                                                       ,4, 8 -- 2º quadrimestre                                     
                                                       ,5,12) = 4  then opprl.datpubrgf end) as dat_publicrgf
             FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                     INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                     INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                     INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
               AND oo.codmun = :municipioSelecionado
               -- regra semestralidade
               AND tslc.datfotlrf = :dataSelecionada
               AND tslc.numano = :exercicioCursoSelecionado
               AND tslc.nummes = :mesSelecionado                   
             GROUP BY opprl.codmun
            
            UNION ALL
            
            --data-base 30/06
            SELECT opprl.codmun AS cod_municipio
                  ,'30/06' || '/' || :exercicioCursoSelecionado AS dat_base
                  ,:exercicioCursoSelecionado as num_ano
                  ,MAX(CASE WHEN opprl.indpubrgf = 1  
                             AND opprl.numexrtpoper = :exercicioCursoSelecionado
                             AND oo.codtpoorg = '2'
                             AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                       ,2,12 -- 2º semestre
                                                       ,3, 4 -- 1º quadrimestre
                                                       ,4, 8 -- 2º quadrimestre                                     
                                                       ,5,12) = 6  then opprl.datpubrgf end) as dat_publicrgf
             FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                     INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                     INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                     INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
               AND oo.codmun = :municipioSelecionado
               -- regra semestralidade
               AND tslc.datfotlrf = :dataSelecionada
               AND tslc.numano = :exercicioCursoSelecionado
               AND tslc.nummes = :mesSelecionado                   
             GROUP BY opprl.codmun
                     
            UNION ALL
            
            --data-base 31/08
            SELECT opprl.codmun AS cod_municipio
                  ,'31/08' || '/' || :exercicioCursoSelecionado AS dat_base
                  ,:exercicioCursoSelecionado as num_ano
                  ,MAX(CASE WHEN opprl.indpubrgf = 1  
                             AND opprl.numexrtpoper = :exercicioCursoSelecionado
                             AND oo.codtpoorg = '2'
                             AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                       ,2,12 -- 2º semestre
                                                       ,3, 4 -- 1º quadrimestre
                                                       ,4, 8 -- 2º quadrimestre                                     
                                                       ,5,12) = 8  then opprl.datpubrgf end) as dat_publicrgf
             FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                     INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                     INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                     INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
               AND oo.codmun = :municipioSelecionado
               -- regra semestralidade
               AND tslc.datfotlrf = :dataSelecionada
               AND tslc.numano = :exercicioCursoSelecionado
               AND tslc.nummes = :mesSelecionado                   
             GROUP BY opprl.codmun
                     
            UNION ALL
            
            --data-base 31/10
            SELECT opprl.codmun AS cod_municipio
                  ,'31/10' || '/' || :exercicioCursoSelecionado AS dat_base
                  ,:exercicioCursoSelecionado as num_ano
                  ,MAX(CASE WHEN opprl.indpubrgf = 1  
                             AND opprl.numexrtpoper = :exercicioCursoSelecionado
                             AND oo.codtpoorg = '2'
                             AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                       ,2,12 -- 2º semestre
                                                       ,3, 4 -- 1º quadrimestre
                                                       ,4, 8 -- 2º quadrimestre                                     
                                                       ,5,12) = 10  then opprl.datpubrgf end) as dat_publicrgf
             FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                     INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                     INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                     INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
               AND oo.codmun = :municipioSelecionado
               -- regra semestralidade
               AND tslc.datfotlrf = :dataSelecionada
               AND tslc.numano = :exercicioCursoSelecionado
               AND tslc.nummes = :mesSelecionado                   
             GROUP BY opprl.codmun
            
            UNION ALL
            
            --data-base 31/12
            SELECT opprl.codmun AS cod_municipio
                  ,'31/12' || '/' || :exercicioCursoSelecionado AS dat_base
                  ,:exercicioCursoSelecionado as num_ano
                  ,MAX(CASE WHEN opprl.indpubrgf = 1  
                             AND opprl.numexrtpoper = :exercicioCursoSelecionado
                             AND oo.codtpoorg = '2'
                             AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                       ,2,12 -- 2º semestre
                                                       ,3, 4 -- 1º quadrimestre
                                                       ,4, 8 -- 2º quadrimestre                                     
                                                       ,5,12) = 12  then opprl.datpubrgf end) as dat_publicrgf
             FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                     INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                     INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                     INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
               AND oo.codmun = :municipioSelecionado
               -- regra semestralidade
               AND tslc.datfotlrf = :dataSelecionada
               AND tslc.numano = :exercicioCursoSelecionado
               AND tslc.nummes = :mesSelecionado                   
             GROUP BY opprl.codmun
               
        ) aux
        GROUP BY aux.cod_municipio
                ,aux.dat_base
                ,aux.num_ano
  )
  GROUP BY cod_municipio
          ,ano
          ,dt_base
          ,dta_pub_rel_lrf
          ,situacaorreo
)aux
WHERE ano = :exercicioCursoSelecionado
  AND SUBSTR(dt_base,4,2) <= (SELECT * FROM maiorMes_temp)
GROUP BY cod_municipio
        ,dt_base
        ,ano
        ,situacaoOptante
ORDER BY dt_base
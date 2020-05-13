WITH FILTRO AS (
             SELECT ORG.CODMUN,
                    ORG.SEQ_ORGAO, 
                    ORG.NUM_EXERCICIO,
                    ORG.NUM_MES,
                    ORG.POSICAO,
                    ORG.NOM_PERIODO,
                    ORG.DATA_ATIVACAO,
                    ORG.DTALEIEXTINCAO,
                    ORG.ORG_ATIVO,                --> ORG_ATIVO Indica se órgão esta ativo no mês (1-Ativo 0-Desativado)
                    REM.ENVIOU_REM ENVIOU_REM,    --> ENVIOU_REM Indica se teve Remessa no mês (1-Enviou 0-Não Enviou)
                    CASE WHEN ORG.ORG_ATIVO > nvl(REM.ENVIOU_REM,0) THEN 1 ELSE 0 END INADIMPLENTE -->Indica se Situação do Órgão é Inadimplente.(1-Adimplente 0-Inadimplente)(Ex. Não enviou Remessa, mas estava Desativado = Adimplente)  
                FROM (
                    SELECT oo.codmun
                         , tr.numanoref AS NUM_EXERCICIO
                         , oo.codorg AS cod_orgao
                         , oo.seqorg AS seq_orgao
                         , op.nummes AS num_mes
                         , op.numpos AS posicao
                         , op.nomper AS nom_periodo
                         , oc.data_ativacao
                         , oe.dtaleiextincao
                           --Indica se órgão esta ativo no mês (1-Ativo 0-Desativado)
                         , SUM(CASE WHEN TO_NUMBER(TO_CHAR(OC.DATA_ATIVACAO, 'YYYYMM')) <= TO_NUMBER(tr.numanoref||LPAD(op.nummes, 2, 0)) AND
                                TO_NUMBER(TO_CHAR(NVL(NVL(OC.DATA_ENCERRAMENTO_ATIVIDADES,OE.DTALEIEXTINCAO),ADD_MONTHS(SYSDATE,13)), 'YYYYMM')) >= TO_NUMBER(tr.numanoref||LPAD(op.nummes, 2, 0)) THEN 1 ELSE 0 END) AS ORG_ATIVO   
                    FROM bi_Sicom.odsper op
                     CROSS JOIN bi_sicom.odsorg oo 
                     CROSS JOIN (SELECT tr.numanoref FROM bi_sicom.tblrem tr WHERE tr.numanoref >= 2013 GROUP BY tr.numanoref ) tr
                     INNER JOIN portalsicom.orgaoconvidado oc   ON oo.codorg = oc.codorgao AND oo.numcgcorg = oc.cnpj
                     INNER JOIN bi_sicom.odsmun om              ON oc.codmunicipio = om.codmunsic AND oo.codmun = om.seqmun
                     LEFT JOIN portalsicom.orgaoextinto oe      ON oc.idorgaoconvidado = oe.idorgaoextinto
                    WHERE 1=1
                     AND op.numpos BETWEEN 1 AND 12
                     AND oo.codtpoorg <> '7'
                     AND OC.CODMUNICIPIO NOT LIKE '090%'
                     AND OC.TIPOORGAO <> 7
                     AND OC.DATA_ATIVACAO IS NOT NULL
                    GROUP BY oo.codmun
                           , oo.codorg
                           , oo.seqorg
                           , op.nummes 
                           , op.numpos
                           , op.nomper
                           , oc.data_ativacao
                           , oe.dtaleiextincao
                           , tr.numanoref
                     ) ORG
                     LEFT JOIN ( SELECT oo.codmun
                                  , oo.seqorg AS seq_orgao
                                  , trh.nummesrem AS num_mes_ref
                                  , trh.numanorem AS num_exercicio
                                   --Indica se teve Remessa no mês (1-Enviou 0-Não Enviou)
                                  , COUNT(DISTINCT trh.seqorg) AS ENVIOU_REM
                                  , MAX(TR.DATFIMODS) AS DATFIMODS
                             FROM bi_sicom.tblremhst trh
                              INNER JOIN bi_sicom.tblrem tr ON trh.codacp = tr.codacp
                              INNER JOIN bi_sicom.odsorg oo ON trh.seqorg = oo.seqorg
                             WHERE 1 = 1 
                               AND trh.indult = 'S' 
                               AND trh.tiprem = 'AM'
                             GROUP BY oo.codmun
                                    , oo.seqorg
                                    , trh.nummesrem
                                    , trh.numanorem
                             ) REM ON REM.codmun = ORG.codmun AND REM.NUM_EXERCICIO = ORG.NUM_EXERCICIO AND REM.NUM_MES_REF = ORG.NUM_MES AND REM.SEQ_ORGAO = ORG.SEQ_ORGAO
)
--=========== Fim temporária ============
,exFechado AS (
SELECT MAX(numanoref) - 1 AS ano FROM (
SELECT tab2.CODMUN
    , tab2.NUMANOREF
    , tab2.MENORMES
    , tab2.MAIORMES
    , tab2.DATAREMLRF
FROM (
    SELECT tab.CODMUN
        , tab.NUM_EXERCICIO AS NUMANOREF
        , MIN(MENOR_POSICAO) as MENORMES
        , MIN(MAIOR_POSICAO) as MAIORMES
        , (SELECT MAX(tcl.datultcrg)
            FROM bi_lrf.tblctlcrglrf tcl) AS DATAREMLRF
    FROM (
        SELECT CODMUN
            , NUM_EXERCICIO
            , MIN(POSICAO) AS MENOR_POSICAO
            , CASE WHEN INADIMPLENTE_ORG IS NOT NULL THEN INADIMPLENTE_ORG - 1 ELSE MAX(POSICAO) END AS MAIOR_POSICAO
        FROM (
            SELECT F.CODMUN
                 , F.POSICAO
                 , F.NUM_EXERCICIO
                 , (SELECT COUNT(DISTINCT FF.SEQ_ORGAO) 
                     FROM FILTRO FF
                    ) AS QTDE_ORGAO_SELECIONADO
                 , ENVIOU_REM
                 , INADIMPLENTE
                 , (SELECT MIN(POSICAO)
                          FROM FILTRO FFF 
                          WHERE FFF.CODMUN = F.CODMUN
                           AND FFF.SEQ_ORGAO = F.SEQ_ORGAO
                           AND FFF.NUM_EXERCICIO = F.NUM_EXERCICIO
                           AND INADIMPLENTE = 1
                   ) AS INADIMPLENTE_ORG
            FROM FILTRO F
            ) 
        WHERE CASE WHEN QTDE_ORGAO_SELECIONADO = 1 THEN ENVIOU_REM ELSE 1 END = 1
        GROUP BY CODMUN
            , NUM_EXERCICIO
            , INADIMPLENTE_ORG
    ) tab
    GROUP BY tab.CODMUN
        , tab.NUM_EXERCICIO
    HAVING MIN(MAIOR_POSICAO) > 0
)tab2
WHERE tab2.CODMUN = :municipioSelecionado
  AND tab2.MAIORMES >= 2
       
UNION ALL

SELECT  NULL AS CODMUN
       ,MAX(PT.EXERCICIO) AS NUMANOREF
       ,NULL AS MENORMES
       ,NULL AS MAIORMES
       ,NULL AS DATAREMLRF
 FROM SICOM_COMUM.PERIODOTEMPESTIVIDADE PT
 WHERE PT.TIPOENVIO = 2
   AND PT.MESREF = 2
   AND TO_NUMBER(TO_CHAR(PT.PERIODOFINAL, 'YYYYMMDD')) <= TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD')) 
)
)

--========= fim tmp_exericico ===========

,certidao AS
(
SELECT num_ano
      ,seq_municipio AS cod_municipio
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
            ,SUM(CASE WHEN ot.nummes = :mesSelecionado THEN NVL((f.vlrreccorlqd),0) ELSE 0 END) AS vlr_rcl
            ,SUM(CASE WHEN ot.nummes = :mesSelecionado THEN NVL((f.vlrreccorlqdajs),0) ELSE 0 END) AS vlr_rcl_aju
            ,SUM(CASE WHEN ot.nummes = :mesSelecionado AND opo.codpdrorg = 1 THEN (NVL((f.vlrgstdsp),0) - NVL((f.vlrexlgst),0)) ELSE 0 END) AS vlr_dsp_legislativo
            ,SUM(CASE WHEN ot.nummes = :mesSelecionado AND opo.codpdrorg = 2 THEN (NVL((f.vlrgstdsp),0) - NVL((f.vlrexlgst),0)) ELSE 0 END) AS vlr_dsp_executivo
            ,SUM(CASE WHEN ot.nummes = :mesSelecionado THEN NVL((f.vlrgstdsp),0) ELSE 0 END) AS vlr_dsp_total                
       FROM bi_lrf.fatlrfana f
        INNER JOIN bi_lrf.odspdrorg opo ON f.seqpdrorg = opo.seqpdrorg
        INNER JOIN bi_sicom.odstmp ot   ON f.seqodstmp = ot.seqodstmp
       WHERE f.datfotlrf = :dataSelecionada
         AND ot.numano > :exercicioParecerSelecionado
         AND f.seqmun = :municipioSelecionado
         AND ot.nummes <= :mesSelecionado
       GROUP BY ot.numano, f.seqmun
     ) 
 GROUP BY num_ano,seq_municipio
)        

--============= fim certidao ==============

--======================================================== fim temporárias / início consulta ============================================================================
SELECT ano       
      ,vlrrclliq
      ,vlrdspexe
      ,prcdspexe
      ,vlrdspleg
      ,prcdspleg
      ,datpubrreo
      ,sitpubrreo
      ,datpubrgf
      ,sitpubrgf
      ,OpSemestralidade
      ,prevrecopcrd
      ,dspcapdotini
      ,CASE WHEN prevrecopcrd <> 0
             THEN CASE WHEN prevrecopcrd <= dspcapdotini 
                        THEN 'Cumpriu' ELSE 'Não Cumpriu' END
            ELSE 'Não houve previsão' END AS resultado
FROM (
 SELECT CASE WHEN siace.ano <= 2017
                   THEN siace.ano
                 WHEN lrf.ano > 2017
                   THEN lrf.ano END AS ano
                   
       ,NVL(CASE WHEN siace.ano <= 2017
                   THEN siace.rclexecutivo
                 WHEN lrf.ano > 2017
                   THEN lrf.vlr_rcl_aju END, 0) AS vlrrclliq
                   
       ,NVL(CASE WHEN siace.ano <= 2017
                   THEN siace.despesatotalpessoalexecutivo
                 WHEN lrf.ano > 2017
                   THEN lrf.vlr_dsp_executivo END, 0) AS vlrdspexe
       
       ,NVL(CASE WHEN siace.ano <= 2017
                   THEN siace.porcdesptotalpessoalexec
                 WHEN lrf.ano > 2017
                   THEN lrf.prc_dps_exe END, 0) AS prcdspexe
       
       ,NVL(CASE WHEN siace.ano <= 2017
                   THEN siace.despesatotalpessoalleg
                 WHEN lrf.ano > 2017
                   THEN lrf.vlr_dsp_legislativo END, 0) AS vlrdspleg 
       
       ,NVL(CASE WHEN siace.ano <= 2017
                   THEN siace.porcdesptotalpessoalleg
                 WHEN lrf.ano > 2017
                   THEN lrf.prc_dps_leg END, 0) AS prcdspleg 
       
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN to_char(siace.datapublicacao, 'DD/MM/YYYY')
                 WHEN lrf.ano > 2017
                    THEN lrf.dta_pub_rel_lrf END, '-') AS datpubrreo
       
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN siace.situacaopublicacao
                 WHEN lrf.ano > 2017
                    THEN lrf.situacaorreo END, 'Não Informou') AS sitpubrreo
       
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN to_char(siace.datapublicacao, 'DD/MM/YYYY')
                 WHEN lrf.ano > 2017
                    THEN lrf.dat_publicrgf END, '-') AS datpubrgf
       
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN siace.situacaopublicacao
                 WHEN lrf.ano > 2017
                    THEN lrf.situacaorgf END, 'Não Informou') AS sitpubrgf
       
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN siace.operacoescreditoprevinicial
                WHEN lrf.ano > 2017
                      THEN parecer_lrf.Valor_Receita END, 0) AS prevrecopcrd
                      
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN siace.despesacapitaldotacaoinicial
                WHEN parecer_lrf.ano > 2017
                      THEN parecer_lrf.Valor_Despesa END, 0) AS dspcapdotini
       
       ,NVL(CASE WHEN siace.ano <= 2017
                    THEN siace.opcaosemestralidade
                WHEN lrf.ano > 2017
                      THEN opsem.OpSemestralidade END, '-') AS OpSemestralidade
                                     
  FROM (
     
     --Consulta para retornar os valores do SIACE (para exercícios <= 2017)
     select siace.nomedomunicipio,
            siace.codmunicipio,
            siace.ano AS ano,
            siace.databaseremessa,
            siace.rclexecutivo AS rclexecutivo,
            siace.despesatotalpessoalexecutivo AS despesatotalpessoalexecutivo,
            siace.porcdesptotalpessoalexec AS porcdesptotalpessoalexec,
            siace.despesatotalpessoalleg AS despesatotalpessoalleg,
            siace.porcdesptotalpessoalleg AS porcdesptotalpessoalleg,
            siace.datapublicacao,
            siace.situacaopublicacao,
            siace.opcaosemestralidade,
            siace.operacoescreditoprevinicial,
            siace.despesacapitaldotacaoinicial
            
      from ( 
        select nomedomunicipio,
          codmunicipio,
          ano AS ano,  
          databaseremessa,  
          rclexecutivo as rclexecutivo,    
          despesatotalpessoalexecutivo as despesatotalpessoalexecutivo,  
          ROUND((despesatotalpessoalexecutivo/rclexecutivo),4) as porcdesptotalpessoalexec,  
          despesatotalpessoalleg as despesatotalpessoalleg,  
          ROUND((despesatotalpessoalleg/rclexecutivo),4) as porcdesptotalpessoalleg,  
          datapublicacao,  
          situacaopublicacao,  
          opcaosemestralidade,
          operacoescreditoprevinicial,
          (despesacapital.despesainvestimentos + despesacapital.despesainvfinanceiras + despesacapital.despesaamortdivint 
            + despesacapital.despesaamortdivext + despesacapital.despesaamortrefdivmob + despesacapital.aquisicaotitulos + despesacapital.concessaoemprestimos 
            + despesacapital.incentivocontribuinte + despesacapital.incentivoinstfinanceira + despesacapital.outrasdespesascapital ) as despesacapitaldotacaoinicial 
        from  
          (select nomedomunicipio,
            codmunicipio,
            ano,
            databaseremessa,  
            rclexecutivo,    
            despesatotalpessoalexecutivo,  
            despesatotalpessoalleg,  
            datapublicacao,  
            situacaopublicacao,  
            opcaosemestralidade,
            operacoescreditoprevinicial,
            max(execucaoorcamentaria.id) as iddaexecucaoorcamentaria  
          from  
            (select nomedomunicipio,
              codmunicipio,
              ano,  
              databaseremessa,  
              sum(receitacorrenteliqmensalpref) as rclexecutivo,    
              sum(despesatotalpessoal)          as despesatotalpessoalexecutivo,  
              sum(despesatotalpessoalleg)       as despesatotalpessoalleg,  
              datapublicacao,  
              situacaopublicacao,  
              opcaosemestralidade,
              SUM(operacoescredit) AS operacoescreditoprevinicial,  
              iddaprestacao  
            from  
              (select nomedomunicipio,
                codmunicipio,
                ano,  
                databaseremessa,  
                mesexecucao,  
                datapublicacao,  
                situacaopublicacao,  
                opcaosemestralidade,  
                iddaprestacao,  
                (  
                case  
                  when databaseremessa = '31/12/2002'  
                  then ( receitatributaria.receitacontmelhoria +receitatributaria.receitataxas +receitaimpostos.valoritbi +receitaimpostos.valorissqn +receitaimpostos.valorirrf +receitaimpostos.valoriptu +receitacorrente.receitacontribuicoes +receitapatrimonial.receitaaplicacoes +receitapatrimonial.valoroutrasreceitas +receitacorrente.receitaindustriais +receitacorrente.receitaagropecuarias +receitacorrente.receitaservicos +transferenciacorrente.cotapartefpm +transferenciacorrente.cotaparteicms +transferenciacorrente.cotaparteipva +transferenciacorrente.cotaparteipi +transferenciacorrente.transferenciafundef +transferenciacorrente.outrastransferencias +transferenciacorrente.convenios +receitacorrente.outrasreceitascorrentes -exclusaoreceita.contservprevprop -exclusaoreceita.compensregprev -exclusaoreceita.outrasduplicidades -exclusaoreceita.contpatronalprevprop -transfintragovernamental.transffundacoes -transfintragovernamental.transfautarquias -transfintragovernamental.transfempestdep  
                                                               - transfintragovernamental.transfdemaisent )  
                  else ( receitatributaria.receitacontmelhoria +receitatributaria.receitataxas +receitaimpostos.valoritbi +receitaimpostos.valorissqn +receitaimpostos.valorirrf +receitaimpostos.valoriptu +receitacorrente.receitacontribuicoes +receitapatrimonial.receitaaplicacoes +receitapatrimonial.valoroutrasreceitas +receitacorrente.receitaindustriais +receitacorrente.receitaagropecuarias +receitacorrente.receitaservicos +transferenciacorrente.cotapartefpm +transferenciacorrente.cotaparteicms +transferenciacorrente.cotaparteipva +transferenciacorrente.cotaparteipi +transferenciacorrente.transferenciafundef +transferenciacorrente.outrastransferencias +transferenciacorrente.convenios +receitacorrente.outrasreceitascorrentes -exclusaoreceita.contservprevprop -exclusaoreceita.compensregprev -exclusaoreceita.outrasduplicidades -exclusaoreceita.contpatronalprevprop -transfintragovernamental.transffundacoes -transfintragovernamental.transfautarquias -transfintragovernamental.transfempestdep  
                                                               - transfintragovernamental.transfdemaisent -deducaoreceita.deducaofundef -receitacorrente.deducoesreceitacorrente )  
                end ) AS receitacorrenteliqmensalpref,
                (operacoescredito.receitarefdivida + operacoescredito.receitaoutrasopcredito) AS operacoescredit,   
                (  
                case  
                  when mesexecucao     = 12  
                  and databaseremessa in ('31/12/2008', '31/12/2009')  
                  then  
                    case  
                      when despesamensalpessoal.nadaadeclarar = 'S'  
                      then despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalpref.subsidioprefeito + despesamensalpessoalpref.subsidioviceprefeito + despesamensalpessoalpref.subsidiosecretariosmunicipais + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.despexclanteriorapuracao  
                      else despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalpref.subsidioprefeito + despesamensalpessoalpref.subsidioviceprefeito + despesamensalpessoalpref.subsidiosecretariosmunicipais + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.outrasdespesaspessoal + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.despexclanteriorapuracao  
                    end  
                  when mesexecucao     = 12  
                  and databaseremessa in ('31/12/2011', '31/12/2012', '31/12/2013', '31/12/2014', '31/12/2015', '31/12/2016', '31/12/2017')  
                  then  
                    case  
                      when despesamensalpessoal.nadaadeclarar = 'S'  
                      then despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalpref.subsidioprefeito + despesamensalpessoalpref.subsidioviceprefeito + despesamensalpessoalpref.subsidiosecretariosmunicipais + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria  
                      else despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalpref.subsidioprefeito + despesamensalpessoalpref.subsidioviceprefeito + despesamensalpessoalpref.subsidiosecretariosmunicipais + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.outrasdespesaspessoal + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria  
                    end  
                  else  
                    case  
                      when despesamensalpessoal.nadaadeclarar = 'S'  
                      then despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalpref.subsidioprefeito + despesamensalpessoalpref.subsidioviceprefeito + despesamensalpessoalpref.subsidiosecretariosmunicipais + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.despesasanteriores + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.despesasanterioresexclusao - despesamensalpessoal.despexclanteriorapuracao  
                      else despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalpref.subsidioprefeito + despesamensalpessoalpref.subsidioviceprefeito + despesamensalpessoalpref.subsidiosecretariosmunicipais + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.outrasdespesaspessoal + despesamensalpessoal.despesasanteriores + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.despesasanterioresexclusao - despesamensalpessoal.despexclanteriorapuracao  
                    end  
                end ) as despesatotalpessoal  
              from  
                (select nomedomunicipio,
                  codmunicipio,
                  ano,  
                  databaseremessa,  
                  execucaoorcamentaria.mes as mesexecucao,  
                  datapublicacao,  
                  situacaopublicacao,  
                  opcaosemestralidade,  
                  max(execucaoorcamentaria.id) as iddaexecucaoorcamentaria,  
                  gestaofiscal.id              as iddagestaofiscal,  
                  iddaprestacao  
                from  
                  (select municipio.nome as nomedomunicipio,
                    municipio.codigoibge AS codmunicipio,
                    prestacao.exercicio AS ano,  
                    prestacao.id         as iddaprestacao,  
                    databaseremessa,  
                    remessalrf.datapublicacao as datapublicacao,  
                    (  
                    case  
                      when remessalrf.datapublicacao > add_months(databaseremessa, 1)  
                      then 'Intempestivo'  
                      else 'Tempestivo'  
                    end ) as situacaopublicacao,  
                    (  
                    case  
                      when opcaosemestralidade.tipo = 0  
                      then 'Não-optante'  
                      when statusopcaosemestralidade.temopcao = 'S'  
                      then 'Optante'  
                      else 'Perdeu o direito de optar'  
                    end ) as opcaosemestralidade  
                  from municipio@dbl_lrf_tcemg04_mexico  
                    inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id  
                    inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id  
                    inner join remessalrf@dbl_lrf_tcemg04_mexico on remessalrf.idprestacao = prestacao.id  
                    inner join opcaosemestralidade@dbl_lrf_tcemg04_mexico on opcaosemestralidade.identidadeouorgaoap = entidadeouorgaoap.id  
                    inner join statusopcaosemestralidade@dbl_lrf_tcemg04_mexico on opcaosemestralidade.id = statusopcaosemestralidade.idopcaosemestralidade  
                    inner join  
                     (select nomemunicipio,
                             codmunicipio,
                             ano,  
                             max(remessalrf.id) as iddaremessalrf,  
                             remessalrf.dtbase  as databaseremessa  
                       from municipio@dbl_lrf_tcemg04_mexico 
                         inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id  
                         inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id  
                         inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao  
                         inner join  
                          (select municipio.nome as nomemunicipio,
                                  municipio.codigoibge AS codmunicipio,
                                  prestacao.exercicio AS ano,  
                                  remessalrf.dtbase database,  
                                  max(remessalrf.dataenvio) as dataenvio1  
                             from municipio@dbl_lrf_tcemg04_mexico  
                               inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id  
                               inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id  
                               inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id          = remessalrf.idprestacao  
                               where remessalrf.dtbase in ('31/12/2002', '31/12/2003', '31/12/2004', '31/12/2005', '31/12/2006', '31/12/2007', '31/12/2008', '31/12/2009', '31/12/2010', '31/12/2011', '31/12/2012', '31/12/2013', '31/12/2014', '31/12/2015', '31/12/2016', '31/12/2017')  
                                 and municipio.codigoibge = :municipioSelecionado
                               group by municipio.nome,
                                        municipio.codigoibge,
                                        prestacao.exercicio,  
                                        remessalrf.dtbase  
                               order by remessalrf.dtbase  
                          ) on dataenvio1 = remessalrf.dataenvio and database = remessalrf.dtbase and nomemunicipio = municipio.nome  
                       group by nomemunicipio,
                                codmunicipio,
                                ano,  
                                remessalrf.dtbase,  
                                dataenvio1  
                       order by remessalrf.dtbase  
                     ) on remessalrf.id = iddaremessalrf  
                  where statusopcaosemestralidade.dtbase = databaseremessa  
                 )  
                inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on execucaoorcamentaria.idprestacaolrfexecutivo = iddaprestacao  
                inner join gestaofiscal@dbl_lrf_tcemg04_mexico on gestaofiscal.idprestacaolrf = iddaprestacao and execucaoorcamentaria.mes = gestaofiscal.mes and gestaofiscal.foiexcluida = 'N'  
                group by nomedomunicipio,
                         codmunicipio,
                         ano,  
                         databaseremessa,  
                         execucaoorcamentaria.mes,  
                         datapublicacao,  
                         situacaopublicacao,  
                         opcaosemestralidade,  
                         iddaprestacao,  
                         gestaofiscal.id  
                order by databaseremessa,  
                         execucaoorcamentaria.mes  
               )  
              inner join execucaobimestral@dbl_lrf_tcemg04_mexico on iddaexecucaoorcamentaria = execucaobimestral.idexecucaoorcamentaria and execucaobimestral.foiexcluido = 'N'  
              inner join execucaoreceita@dbl_lrf_tcemg04_mexico on execucaobimestral.idexecucaoreceita = execucaoreceita.id  
              inner join receitacorrente@dbl_lrf_tcemg04_mexico on receitacorrente.idexecucaoreceita = execucaoreceita.id and tiporeceita = 4  
              inner join receitatributaria@dbl_lrf_tcemg04_mexico on receitatributaria.id = receitacorrente.idreceitatributaria  
              inner join receitaimpostos@dbl_lrf_tcemg04_mexico on receitatributaria.idreceitaimpostos = receitaimpostos.id  
              inner join receitapatrimonial@dbl_lrf_tcemg04_mexico on receitapatrimonial.id = receitacorrente.idreceitapatrimonial  
              inner join transferenciacorrente@dbl_lrf_tcemg04_mexico on transferenciacorrente.id = receitacorrente.idtransferenciacorrente  
              inner join exclusaoreceita@dbl_lrf_tcemg04_mexico on exclusaoreceita.id = execucaoreceita.idexclusaoreceita  
              inner join transfintragovernamental@dbl_lrf_tcemg04_mexico on transfintragovernamental.id = exclusaoreceita.idexclusaorectransfcorrente  
              inner join deducaoreceita@dbl_lrf_tcemg04_mexico on deducaoreceita.idexecucaoreceita = execucaoreceita.id and deducaoreceita.tiporeceita = 4  
              inner join receitacapital@dbl_lrf_tcemg04_mexico on receitacapital.idexecucaoreceita = execucaoreceita.id and receitacapital.tiporeceita      = 1  
              inner join operacoescredito@dbl_lrf_tcemg04_mexico on receitacapital.idoperacoescredito = operacoescredito.id  
              inner join gestaofiscal@dbl_lrf_tcemg04_mexico on gestaofiscal.id = iddagestaofiscal  
              inner join despesamensalpessoal@dbl_lrf_tcemg04_mexico on despesamensalpessoal.id = gestaofiscal.iddespesamensalpessoal  
              inner join despesamensalpessoalpref@dbl_lrf_tcemg04_mexico on despesamensalpessoal.id = despesamensalpessoalpref.id  
             )  
          inner join  
            (select databaseremessaleg,  
                    mesgestao,  
                    (  
                    case  
                      when mesgestao          = 12  
                      and databaseremessaleg in ('31/12/2008', '31/12/2009')  
                      then  
                        case  
                          when despesamensalpessoal.nadaadeclarar = 'S'  
                          then despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalcam.subsidiovereadores + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.despexclanteriorapuracao - despesamensalpessoal.convocacaoextraordinaria  
                          else despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalcam.subsidiovereadores + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.outrasdespesaspessoal + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.despexclanteriorapuracao - despesamensalpessoal.convocacaoextraordinaria  
                        end  
                      when mesgestao          = 12  
                      and databaseremessaleg in ('31/12/2011', '31/12/2012', '31/12/2013', '31/12/2014', '31/12/2015', '31/12/2016', '31/12/2017')  
                      then  
                        case  
                          when despesamensalpessoal.nadaadeclarar = 'S'  
                          then despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalcam.subsidiovereadores + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.convocacaoextraordinaria  
                          else despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalcam.subsidiovereadores + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.outrasdespesaspessoal + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.convocacaoextraordinaria  
                        end  
                      else  
                        case  
                          when despesamensalpessoal.nadaadeclarar = 'S'  
                      then despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalcam.subsidiovereadores + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.despesasanteriores + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.convocacaoextraordinaria - despesamensalpessoal.despesasanterioresexclusao - despesamensalpessoal.despexclanteriorapuracao  
                      else despesamensalpessoal.vencimentosvantagens + despesamensalpessoal.inativos + despesamensalpessoal.pensionistas + despesamensalpessoal.salariofamilia + despesamensalpessoalcam.subsidiovereadores + despesamensalpessoal.obrigacoespatronais + despesamensalpessoal.repassepatronal + despesamensalpessoal.sentencasjudiciarias + despesamensalpessoal.outrasdespesaspessoal + despesamensalpessoal.despesasanteriores + despesamensalpessoal.despesasantcorrespondente + despesamensalpessoal.despesasanteriorescompetencia - despesamensalpessoal.indenizacoesdemissao - despesamensalpessoal.incentivosdemissaovoluntaria - despesamensalpessoal.sentencasjudiciariasanteriores - despesamensalpessoal.inativosfontecusteiopropria - despesamensalpessoal.convocacaoextraordinaria - despesamensalpessoal.despesasanterioresexclusao - despesamensalpessoal.despexclanteriorapuracao  
                    end  
                    end 
                    ) as despesatotalpessoalleg  
              from  
                (select databaseremessaleg,  
                        gestaofiscal.mes     as mesgestao,  
                        max(gestaofiscal.id) as iddagestaofiscal  
                   from  
                     (select prestacao.id as iddaprestacao,  
                             databaseremessaleg  
                        from municipio@dbl_lrf_tcemg04_mexico  
                          inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idcamaravereadores = entidadeouorgaoap.id  
                          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id  
                          inner join remessalrf@dbl_lrf_tcemg04_mexico on remessalrf.idprestacao = prestacao.id  
                          inner join  
                            (select max(remessalrf.id) as iddaremessalrf,  
                                    remessalrf.dtbase  as databaseremessaleg  
                               from municipio@dbl_lrf_tcemg04_mexico 
                                 inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idcamaravereadores = entidadeouorgaoap.id  
                                 inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id  
                                 inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao  
                                 inner join  
                                   (select municipio.nome as nomemunicipio,
                                           municipio.codigoibge AS codmunicipio,
                                           prestacao.exercicio AS ano,  
                                           remessalrf.dtbase database,  
                                           max(remessalrf.dataenvio) as dataenvio1  
                                      from municipio@dbl_lrf_tcemg04_mexico 
                                        inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idcamaravereadores = entidadeouorgaoap.id  
                                        inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id  
                                        inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id          = remessalrf.idprestacao  
                                      where remessalrf.dtbase in ('31/12/2002', '31/12/2003', '31/12/2004', '31/12/2005', '31/12/2006', '31/12/2007', '31/12/2008', '31/12/2009', '31/12/2010', '31/12/2011', '31/12/2012', '31/12/2013', '31/12/2014', '31/12/2015', '31/12/2016', '31/12/2017')  
                                        and municipio.codigoibge = :municipioSelecionado
                                      group by municipio.nome,
                                               municipio.codigoibge,
                                               prestacao.exercicio,  
                                               remessalrf.dtbase  
                                      order by remessalrf.dtbase  
                                   ) on dataenvio1 = remessalrf.dataenvio and database = remessalrf.dtbase and nomemunicipio = municipio.nome  
                               group by remessalrf.dtbase,  
                                        dataenvio1  
                               order by remessalrf.dtbase  
                            ) on remessalrf.id = iddaremessalrf  
                     )  
                   inner join gestaofiscal@dbl_lrf_tcemg04_mexico on gestaofiscal.idprestacaolrf = iddaprestacao and gestaofiscal.foiexcluida = 'N'  
                   group by databaseremessaleg,  
                            gestaofiscal.mes  
                   order by databaseremessaleg,  
                            gestaofiscal.mes  
                )  
              inner join gestaofiscal@dbl_lrf_tcemg04_mexico on gestaofiscal.id = iddagestaofiscal  
              inner join despesamensalpessoal@dbl_lrf_tcemg04_mexico on despesamensalpessoal.id = gestaofiscal.iddespesamensalpessoal  
              inner join despesamensalpessoalcam@dbl_lrf_tcemg04_mexico on despesamensalpessoal.id = despesamensalpessoalcam.id  
             ) on databaseremessaleg = databaseremessa and mesgestao = mesexecucao  
            group by nomedomunicipio,
                     codmunicipio,
                     ano, 
                     databaseremessa,  
                     datapublicacao,  
                     situacaopublicacao,  
                     opcaosemestralidade,  
                     iddaprestacao  
            order by databaseremessa  
           )  
          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.id = iddaprestacao  
          inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on execucaoorcamentaria.idprestacaolrfexecutivo = iddaprestacao and execucaoorcamentaria.mes = 1  
          group by nomedomunicipio,
                   codmunicipio,
                   ano,  
                   databaseremessa,  
                   rclexecutivo,
                   operacoescreditoprevinicial,  
                   datapublicacao,  
                   situacaopublicacao,  
                   opcaosemestralidade,  
                   despesatotalpessoalexecutivo,  
                   despesatotalpessoalleg  
         )  
        inner join execucaobimestral@dbl_lrf_tcemg04_mexico on iddaexecucaoorcamentaria = execucaobimestral.idexecucaoorcamentaria and execucaobimestral.foiexcluido = 'N'  
        inner join execucaodespesa@dbl_lrf_tcemg04_mexico on execucaodespesa.id = execucaobimestral.idexecucaodespesa  
        inner join despesacapital@dbl_lrf_tcemg04_mexico on despesacapital.idexecucaodespesa = execucaodespesa.id and despesacapital.tipodespesa = 1
     order by databaseremessa
    )siace                                                
   ) siace
    
    --Join para buscar dados do LRF (para exercícios > 2017)
    FULL JOIN 
    (SELECT lrf.cod_municipio AS cod_municipio
           ,lrf.ano AS ano
           ,SUM(lrf.vlr_dsp_legislativo) AS vlr_dsp_legislativo
           ,SUM(lrf.prc_dps_leg) AS prc_dps_leg
           ,SUM(lrf.vlr_dsp_executivo) AS vlr_dsp_executivo
           ,SUM(lrf.prc_dps_exe) AS prc_dps_exe
           ,SUM(lrf.vlr_dsp_total) AS vlr_dsp_total
           ,SUM(lrf.prc_dps_mun) AS prc_dps_mun            
           ,SUM(lrf.vlr_rcl) AS vlr_rcl
           ,SUM(lrf.vlr_rcl_aju) AS vlr_rcl_aju
           ,MAX(lrf.dta_pub_rel_lrf) AS dta_pub_rel_lrf
           ,MAX(lrf.dat_publicrgf) AS dat_publicrgf
           ,MAX(lrf.situacaorreo) AS situacaorreo
           ,MAX(lrf.situacaorgf) AS situacaorgf
    FROM (SELECT cod_municipio
                ,ano                
                -- despesa total com pessoal (por poder)
                ,NVL(SUM(vlr_dsp_legislativo),0) AS vlr_dsp_legislativo
                ,ROUND(CASE WHEN SUM(vlr_rcl_aju) > 0 THEN SUM(vlr_dsp_legislativo) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_leg
                ,NVL(SUM(vlr_dsp_executivo),0) AS vlr_dsp_executivo
                ,ROUND(CASE WHEN SUM(vlr_rcl_aju) > 0 THEN SUM(vlr_dsp_executivo) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_exe
                ,NVL(SUM(vlr_dsp_total),0) AS vlr_dsp_total
                ,ROUND(CASE WHEN SUM(vlr_rcl_aju) > 0 THEN SUM(vlr_dsp_total) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_mun       
                        
                -- valor rcl e rcl ajustada
                ,NVL(SUM(vlr_rcl),0) AS vlr_rcl
                ,NVL(SUM(vlr_rcl_aju),0) AS vlr_rcl_aju
          
                --Divulgação do relatório
                ,dta_pub_rel_lrf
                ,dat_publicrgf
                ,situacaorreo
                ,situacaorgf
          FROM(
          SELECT c.cod_municipio
                ,c.num_ano AS ano
                ,SUM(vlr_dsp_legislativo) AS vlr_dsp_legislativo
                ,SUM(vlr_dsp_executivo) AS vlr_dsp_executivo
                ,SUM(vlr_dsp_total) AS vlr_dsp_total         
                ,SUM(vlr_rcl) AS vlr_rcl
                ,SUM(vlr_rcl_aju) AS vlr_rcl_aju
                ,NULL AS dta_pub_rel_lrf
                ,NULL AS dat_publicrgf
                ,NULL AS situacaorreo
                ,NULL AS situacaorgf
           FROM certidao c  
           GROUP BY c.cod_municipio, c.num_ano
          
          UNION ALL
          
          -- Data e Situação da Publicação do RREO
          SELECT oo.codmun AS cod_municipio
                ,oppl.numexrtpobim AS ano
                ,0 AS vlr_dsp_legislativo
                ,0 AS vlr_dsp_executivo
                ,0 AS vlr_dsp_total                 
                ,0 AS vlr_rcl
                ,0 AS vlr_rcl_aju 
                ,to_char(oppl.datpubrltlrf, 'DD/MM/YYYY') AS dta_pub_rel_lrf
                ,NULL AS dat_publicrgf
                ,CASE WHEN to_number(to_char(oppl.datpubrltlrf, 'YYYYMMDD')) <= to_number((oppl.numexrtpobim +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                      WHEN to_number(to_char(oppl.datpubrltlrf, 'YYYYMMDD')) > to_number((oppl.numexrtpobim +1 || lpad(01, 2, 0) || 31)) THEN 'Intempestivo' 
                      ELSE 'Não Informou' END AS situacaorreo
                ,NULL AS situacaorgf
            FROM bi_sicom.odspubperlrf oppl
             INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = oppl.codacp
             INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
            WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
              AND trh.numanorem || LPAD(trh.nummesrem,2,0) >= :exercicioParecerSelecionado || LPAD(:mesSelecionado, 2, 0)
              AND (oppl.numbim = DECODE(:mesSelecionado, 2, 1, 4, 2, 6, 3, 8, 4, 10, 5, 12, 6))
              AND oppl.numexrtpobim > :exercicioParecerSelecionado
              AND oo.codmun NOT IN (0, 9999999, 123456, 654321)
              and oo.codmun = :municipioSelecionado
          
          UNION ALL
          
          -- Data e Situação da Publicação do RGF
          SELECT cod_municipio
                ,ano
                ,0 AS vlr_dsp_legislativo
                ,0 AS vlr_dsp_executivo
                ,0 AS vlr_dsp_total                
                ,0 AS vlr_rcl
                ,0 AS vlr_rcl_aju
                ,NULL AS dta_pub_rel_lrf
                ,to_char(dat_publicrgf, 'DD/MM/YYYY') AS dat_publicrgf
                ,NULL AS situacaorreo
                ,CASE WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) <= to_number((ano +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                      WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) > to_number((ano +1 || LPAD(01, 2, 0) || 31)) THEN 'Intempestivo' 
                      ELSE 'Não Informou' END AS situacaorgf
           FROM (
                SELECT opprl.codmun AS cod_municipio
                      ,opprl.numexrtpoper AS ano
                      ,DECODE(:mesSelecionado, 4, '30/04', 6, '30/06', 8, '31/08','31/12') AS num_per_bimestre
                      ,MAX(CASE WHEN opprl.indpubrgf = 1 
                            AND to_number(to_char(opprl.datpubrgf,'YYYYMM')) > to_number(:exercicioParecerSelecionado || LPAD(:mesSelecionado,2,0)) 
                            AND opprl.numexrtpoper > :exercicioParecerSelecionado
                            AND oo.codtpoorg = '2'
                            AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                      ,2,12 -- 2º semestre
                                                      ,3, 4 -- 1º quadrimestre
                                                      ,4, 8 -- 2º quadrimestre                                     
                                                      ,5,12) IN (:mesSelecionado) THEN opprl.datpubrgf END) AS dat_publicrgf                                                                                         
                 FROM bi_sicom.odspubperrgflrf opprl
                  INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                  INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                  INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
                 WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                   AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
                   AND trh.numanorem || LPAD(trh.nummesrem,2,0) >= :exercicioParecerSelecionado || LPAD(:mesSelecionado, 2, 0)
                   -- regra semestralidade
                   AND tslc.datfotlrf = :dataSelecionada
                   AND opprl.numexrtpoper > :exercicioParecerSelecionado
                   AND tslc.nummes = :mesSelecionado
                   AND opprl.codmun = :municipioSelecionado
                 GROUP BY opprl.codmun
                         ,opprl.numexrtpoper
                 ORDER BY opprl.codmun
                )
               )
           GROUP BY cod_municipio, dta_pub_rel_lrf, dat_publicrgf, situacaorreo, situacaorgf, ano
         )lrf
     GROUP BY cod_municipio, ano
    )lrf ON lrf.cod_municipio = siace.codmunicipio AND lrf.ano = siace.ano
    
    --Join para buscar dados do Parecer do LRF (para exercícios > 2017)
    FULL JOIN 
    (SELECT parecer_lrf.codibge AS codibge
           ,parecer_lrf.ano AS ano
           ,SUM(parecer_lrf.Valor_Receita) AS Valor_Receita
           ,SUM(parecer_lrf.Valor_Despesa) AS Valor_Despesa
           ,CASE WHEN SUM(parecer_lrf.Valor_Receita) <= SUM(parecer_lrf.valor_despesa) THEN 'Cumpriu' ELSE 'Não Cumpriu' END AS resultado
       FROM (
             --Valor Receita
             SELECT trh.numanorem AS ano
                   ,ore.codmun as codibge      
                   ,SUM(ore.vlrpvt) as Valor_Receita
                   ,0 AS valor_despesa            
                   ,NULL AS contOpCredito
                   ,NULL AS realizOpCredito   
              FROM bi_sicom.odsrec ore 
               INNER JOIN bi_sicom.odsnatrec onr ON onr.seqnatrec = ore.seqnatrec
               INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = ore.codacp
              WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                AND REPLACE(onr.codtpo,'.', '') LIKE '21%'
                AND ore.codmun = :municipioSelecionado
                AND trh.numanorem > :exercicioParecerSelecionado
                AND trh.tiprem = 'IP'
              GROUP BY trh.numanorem
                      ,ore.codmun
                  
            UNION ALL
            
            --Valor Despesa       
            SELECT trh.numanorem AS ano
                  ,tad.codmun as codibge
                  ,0 AS Valor_Receita
                  ,SUM(tad.vlrprv) AS valor_despesa
                  ,NULL AS contOpCredito
                  ,NULL AS realizOpCredito
             FROM bi_sicom.tblauxdsp tad
              INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = tad.codacp
              INNER JOIN bi_sicom.odsdotorc odo ON odo.seqdotorc = tad.seqdotorc
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND tad.codmun = :municipioSelecionado
               AND trh.numanorem > :exercicioParecerSelecionado
               AND odo.codnatdsp like '4%'
               AND trh.tiprem = 'IP' 
             GROUP BY trh.numanorem
                     ,tad.codmun

            UNION ALL
            
            --InfoOpCrédito
            SELECT trh.numanorem AS ano
                  ,ooc.codmun AS codibge
                  ,0 AS Valor_Receita
                  ,0 AS Valor_Despesa
                  ,NVL(DECODE(ooc.codctdcrt, 1, 'SIM', 2, 'NÃO'),'-') AS contOpCredito
                  ,NVL(DECODE(ooc.codreaoprcrt, 1, 'SIM', 2, 'NÃO'),'-') AS realizOpCredito
             FROM bi_sicom.odsoprcrt ooc
              INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = ooc.codacp
             WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
               AND trh.numanorem > :exercicioParecerSelecionado
               AND ooc.codmun = :municipioSelecionado
          )parecer_lrf 
       GROUP BY parecer_lrf.codibge, parecer_lrf.ano    
    )parecer_lrf ON parecer_lrf.codibge = lrf.cod_municipio AND parecer_lrf.ano = lrf.ano
    
    -- Buscar Optante Semestralidade do LRF (para exercícios > 2017) 
    FULL JOIN
    (SELECT opsem.codibge
           ,opsem.ano
           ,opsem.OpSemestralidade
      FROM (
            SELECT tsc.codmun AS codibge
                  ,tsc.numano AS ano
                  ,CASE WHEN tsc.indoptsmt = 'Q' THEN 'Não optante'
                        ELSE NVL(LAG(CASE WHEN tsc.indoptsmt = 'S' AND tsc.indirg = 'S' THEN 'Perdeu o direito de optar'
                                          WHEN tsc.indoptsmt = 'S' AND tsc.indirg = 'N' THEN 'Optante'
                                          ELSE 'Não optante'
                                     END
                                    ) OVER (PARTITION BY tsc.codmun ORDER BY tsc.codmun, tsc.numano),'Optante') 
                   END AS OpSemestralidade
             FROM bi_lrf.tblsmtlrfcon tsc
             WHERE tsc.datfotlrf = :dataSelecionada
               AND tsc.codmun = :municipioSelecionado
               AND tsc.numano > :exercicioParecerSelecionado
               AND tsc.nummes = 12
             GROUP BY tsc.codmun
                     ,tsc.numano
                     ,tsc.indoptsmt
                     ,tsc.indirg
           )opsem
    )opsem ON opsem.codibge = lrf.cod_municipio AND opsem.ano = lrf.ano
)aux
WHERE ano > :exercicioParecerSelecionado
  AND ano <= (SELECT ef.ano
               FROM exFechado ef)
ORDER BY aux.ano
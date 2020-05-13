WITH ExFechado AS (--lista Exercicio Fechado
SELECT 1 AS cod
      ,'Sim' AS visibilidade 
FROM (
      SELECT DISTINCT trh.numanorem AS ano
       FROM bi_sicom.tblremhst trh
        INNER JOIN bi_sicom.odsorg oo ON oo.seqorg = trh.seqorg
       WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
         AND trh.tiprem = 'AM'
         AND oo.codmun = :municipioSelecionado
         AND trh.numanorem = :exercicioSelecionado
     )aux
WHERE EXISTS 
      (
      --Tratar apenas os exercícios que o município possuem envio completo
      SELECT a.num_ano_exercicio,
             maiormes,
             a.cod_municipio, 
             a.nom_municipio
        FROM ( 
              SELECT aux.num_ano_exercicio
                    ,maiormes
                    ,om.seqmun AS cod_municipio 
                    ,om.nommun AS nom_municipio
              FROM bi_sicom.odsmun om
              INNER JOIN (SELECT a.num_ano_exercicio
                                ,a.cod_municipio
                                ,MIN(a.maiormes) AS maiormes
                                ,MIN(a.menormes) AS menormes
                          FROM(SELECT oo.codmun AS cod_municipio
                                      ,oo.seqorg AS seq_dim_orgao
                                      ,NVL(trh.numanorem,aux.ano) AS num_ano_exercicio
                                      ,NVL(MAX(trh.nummesrem),0) AS maiormes
                                      ,NVL(MIN(trh.nummesrem),0) AS menormes
                                FROM bi_sicom.odsorg oo
                                 INNER JOIN bi_sicom.odsmun om ON om.seqmun = oo.codmun
                                 INNER JOIN portalsicom.orgaoconvidado oc ON oo.codorg = oc.codorgao AND oo.codmunsic = oc.codmunicipio                          
                                 LEFT  JOIN portalsicom.orgaoextinto oe   ON oe.idorgaoextinto = oc.idorgaoconvidado
                                 LEFT JOIN (SELECT oo.seqorg
                                                   ,trh.numanorem
                                                   ,trh.nummesrem
                                               FROM bi_sicom.tblremhst trh
                                                INNER JOIN bi_sicom.odsorg oo ON oo.seqorg = trh.seqorg
                                               WHERE trh.tiprem = 'AM'
                                                 AND trh.numanorem = aux.ano
                                                 AND trh.nummesrem BETWEEN 1 AND 12
                                                 AND oo.codmun = :municipioSelecionado
                                            ) trh ON oo.seqorg = trh.seqorg
                                WHERE (NVL(oc.data_encerramento_atividades,oe.dtaleiextincao) IS NULL 
                                        OR to_number(to_char(NVL(oc.data_encerramento_atividades,oe.dtaleiextincao), 'YYYYMM')) >= to_number(aux.ano || 12))
                                  AND to_number(to_char(oc.data_ativacao, 'YYYYMM')) <= to_number(aux.ano || LPAD(12,2,0)) --Órgão Ativo no mês     
                                  AND oc.tipoorgao <> 7 -- CONSÓRCIO
                                  AND oc.data_ativacao IS NOT NULL
                                  AND oc.codmunicipio NOT LIKE '090%' -- MUNICÍPIO DE TESTE
                                  AND oo.codmun = :municipioSelecionado                         
                                GROUP BY trh.numanorem, oo.codmun, oo.seqorg
                            )a
                          GROUP BY a.cod_municipio, a.num_ano_exercicio
                       )aux ON om.seqmun = aux.cod_municipio                                  
              WHERE om.codest = 31
                AND om.seqmun NOT IN (0,9999999,123456,654321)
                AND om.seqmun = :municipioSelecionado
                AND aux.num_ano_exercicio = aux.ano 
                AND aux.menormes = 1
                AND aux.maiormes = 12
            )a
          )
GROUP BY ano
ORDER BY ano
)
SELECT * 
 FROM (
      SELECT * FROM ExFechado

      UNION ALL

      SELECT 2 AS cod
            ,'Não' AS visibilidade
       FROM dual
      WHERE NOT EXISTS (SELECT 1 FROM ExFechado)
      )
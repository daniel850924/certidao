--Impostos Não Previstos

SELECT cod_municipio
      ,nom_municipio
      ,to_char(bi_sicom.wm_concat(DISTINCT demostrativo)) AS demostrativo
FROM(
     SELECT 'IPTU' AS demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
       FROM bi_sicom.odsmun om
       WHERE om.codest = 31
         AND om.seqmun NOT IN (0, 9999999)
         AND om.seqmun NOT IN (
                               SELECT oo.codmun             
                                FROM bi_sicom.odsrec ore
                                 INNER JOIN bi_sicom.odsnatrec onr ON ore.seqnatrec = onr.seqnatrec
                                 INNER JOIN bi_sicom.tblremhst trh ON ore.codacp = trh.codacp
                                 INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
                                WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                                 AND ((trh.numanorem <= 2017 AND REPLACE(onr.codsubaln,'.', '') IN ('11120200'))
                                     OR (trh.numanorem >= 2018 AND REPLACE(onr.codtpo,'.', '') IN ('11180111')))
                                 AND oo.codmun = :municipioSelecionado
                                 AND trh.numanorem = :exercicioSelecionado
                                GROUP BY oo.codmun
                                HAVING SUM(CASE WHEN trh.tiprem = 'IP' THEN ore.vlrpvt ELSE 0 END) > 0
                              )
         AND om.seqmun = :municipioSelecionado
          
     UNION ALL

     SELECT 'ITBI' AS demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
       FROM bi_sicom.odsmun om
       WHERE om.codest = 31
         AND om.seqmun NOT IN (0, 9999999)
         AND om.seqmun NOT IN (
                               SELECT oo.codmun                                            
                                FROM bi_sicom.odsrec ore
                                 INNER JOIN bi_sicom.odsnatrec onr ON ore.seqnatrec = onr.seqnatrec
                                 INNER JOIN bi_sicom.tblremhst trh ON ore.codacp = trh.codacp
                                 INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
                                WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                                 AND ((trh.numanorem <= 2017 AND REPLACE(onr.codsubaln,'.', '') IN ('11120800'))
                                   OR (trh.numanorem >= 2018 AND REPLACE(onr.codtpo,'.', '') IN ('11180141')))
                                 AND oo.codmun = :municipioSelecionado
                                 AND trh.numanorem = :exercicioSelecionado
                                GROUP BY oo.codmun
                                HAVING SUM(CASE WHEN trh.tiprem = 'IP' THEN ore.vlrpvt ELSE 0 END) > 0
                              )
         AND om.seqmun = :municipioSelecionado
          
     UNION ALL

     SELECT 'IRRF' AS demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
       FROM bi_sicom.odsmun om
       WHERE om.codest = 31
         AND om.seqmun NOT IN (0, 9999999)
         AND om.seqmun NOT IN (
                               SELECT oo.codmun                                     
                                FROM bi_sicom.odsrec ore
                                 INNER JOIN bi_sicom.odsnatrec onr ON ore.seqnatrec = onr.seqnatrec
                                 INNER JOIN bi_sicom.tblremhst trh ON ore.codacp = trh.codacp
                                 INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
                                WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                                  AND ((trh.numanorem <= 2017 AND REPLACE(onr.codsubaln, '.', '') IN ('11120431','11120434'))
                                       OR (trh.numanorem >= 2018 AND REPLACE(onr.codtpo, '.', '') IN ('11130311','11130341')))                                     
                                  AND oo.codmun = :municipioSelecionado
                                  AND trh.numanorem = :exercicioSelecionado
                                GROUP BY oo.codmun
                                HAVING SUM(CASE WHEN trh.tiprem = 'IP' THEN ore.vlrpvt ELSE 0 END) > 0
                              )  
         AND om.seqmun = :municipioSelecionado
         
     UNION ALL

     SELECT 'ISSQN' AS demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
       FROM bi_sicom.odsmun om
       WHERE om.codest = 31
         AND om.seqmun NOT IN (0, 9999999)
         AND om.seqmun NOT IN (
                               SELECT oo.codmun                                     
                                FROM bi_sicom.odsrec ore
                                 INNER JOIN bi_sicom.odsnatrec onr ON ore.seqnatrec = onr.seqnatrec
                                 INNER JOIN bi_sicom.tblremhst trh ON ore.codacp = trh.codacp
                                 INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
                                WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                                  AND ((trh.numanorem <= 2017 AND REPLACE(onr.codsubaln, '.', '') IN ('11130501'))
                                       OR (trh.numanorem >= 2018 AND REPLACE(onr.codtpo, '.', '') IN ('11180231')))                                     
                                  AND oo.codmun = :municipioSelecionado
                                  AND trh.numanorem = :exercicioSelecionado
                                GROUP BY oo.codmun
                                HAVING SUM(CASE WHEN trh.tiprem = 'IP' THEN ore.vlrpvt ELSE 0 END) > 0
                              )  
         AND om.seqmun = :municipioSelecionado   
    )  
GROUP BY cod_municipio
        ,nom_municipio
ORDER BY nom_municipio
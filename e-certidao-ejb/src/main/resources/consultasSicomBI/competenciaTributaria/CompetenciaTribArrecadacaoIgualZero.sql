SELECT cod_municipio
      ,nom_municipio
      ,to_char(bi_sicom.wm_concat(DISTINCT demostrativo)) AS demostrativo
FROM(
     SELECT 'IPTU' as demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
      FROM bi_sicom.odsmun om
      WHERE om.codest  = 31
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
                                  AND trh.nummesrem <= 12
                                  and oo.codmun = :municipioselecionado
                                  and trh.numanorem = :exercicioselecionado
                                GROUP BY oo.codmun
                                HAVING NVL(SUM(ore.vlrarr),0) + NVL(SUM(ore.vlracr),0) - NVL(SUM(ore.vlrred),0) - NVL(SUM(ore.vlretr),0) > 0
                             )  
        AND om.seqmun = :municipioselecionado
      
     UNION ALL
 
     SELECT 'ITBI' AS demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
      FROM bi_sicom.odsmun om
      WHERE om.codest  = 31
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
                                  AND trh.nummesrem <= 12
                                  AND oo.codmun = :municipioselecionado
                                  AND trh.numanorem = :exercicioselecionado
                                GROUP BY oo.codmun
                                HAVING NVL(SUM(ore.vlrarr),0) + NVL(SUM(ore.vlracr),0) - NVL(SUM(ore.vlrred),0) - NVL(SUM(ore.vlretr),0) > 0
                             )  
        AND om.seqmun = :municipioselecionado
      
     UNION ALL

     SELECT 'IRRF' as demostrativo
            ,om.seqmun AS cod_municipio
            ,om.nommun AS nom_municipio
      FROM bi_sicom.odsmun om
      WHERE om.codest  = 31
        AND om.seqmun NOT IN (0, 9999999)
        AND om.seqmun NOT IN (
                              SELECT oo.codmun
                               FROM bi_sicom.odsrec ore
                                INNER JOIN bi_sicom.odsnatrec onr ON ore.seqnatrec = onr.seqnatrec
                                INNER JOIN bi_sicom.tblremhst trh ON ore.codacp = trh.codacp
                                INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
                               WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                                 AND ((trh.numanorem <= 2017 AND REPLACE(onr.codsubaln,'.', '') IN ('11120431','11120434'))
                                    OR (trh.numanorem >= 2018 AND REPLACE(onr.codtpo,'.', '') IN ('11130311','11130341')))
                                 AND trh.nummesrem <= 12
                                 AND oo.codmun = :municipioselecionado
                                 AND trh.numanorem = :exercicioselecionado
                               GROUP BY oo.codmun
                               HAVING NVL(SUM(ore.vlrarr),0) + NVL(SUM(ore.vlracr),0) - NVL(SUM(ore.vlrred),0) - NVL(SUM(ore.vlretr),0) > 0
                             )  
        AND om.seqmun = :municipioselecionado

    UNION ALL

    SELECT 'ISSQN' as demostrativo
           ,om.seqmun AS cod_municipio
           ,om.nommun AS nom_municipio
      FROM bi_sicom.odsmun om
      WHERE om.codest  = 31
        AND om.seqmun NOT IN (0, 9999999)
        AND om.seqmun NOT IN (
                              SELECT oo.codmun
                               FROM bi_sicom.odsrec ore
                                INNER JOIN bi_sicom.odsnatrec onr ON ore.seqnatrec = onr.seqnatrec
                                INNER JOIN bi_sicom.tblremhst trh ON ore.codacp = trh.codacp
                                INNER JOIN bi_sicom.odsorg oo     ON trh.seqorg = oo.seqorg
                               WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                                 AND ((trh.numanorem <= 2017 AND REPLACE(onr.codsubaln,'.', '') IN ('11130501'))
                                    OR (trh.numanorem >= 2018 AND REPLACE(onr.codtpo,'.', '') IN ('11180231')))
                                 AND trh.nummesrem <= 12
                                 AND oo.codmun = :municipioselecionado
                                 AND trh.numanorem = :exercicioselecionado
                               GROUP BY oo.codmun
                               HAVING NVL(SUM(ore.vlrarr),0) + NVL(SUM(ore.vlracr),0) - NVL(SUM(ore.vlrred),0) - NVL(SUM(ore.vlretr),0) > 0
                             )  
        AND om.seqmun = :municipioselecionado      
   )  
GROUP BY cod_municipio
        ,nom_municipio
ORDER BY nom_municipio 
        ,demostrativo
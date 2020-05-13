SELECT * FROM (
SELECT tsc.numano
      ,CASE WHEN tsc.indoptsmt = 'Q' THEN 'Não optante'
            ELSE NVL(LAG(CASE WHEN tsc.indoptsmt = 'S' AND tsc.indirg = 'S' THEN 'Perdeu o direito de optar'
                              WHEN tsc.indoptsmt = 'S' AND tsc.indirg = 'N' THEN 'Optante'
                              ELSE 'Não optante'
                         END
                        ) OVER (PARTITION BY tsc.codmun ORDER BY tsc.codmun, tsc.numano ,tsc.nummes),'Optante'
                    ) 
       END AS opsemestralidade
FROM bi_lrf.tblsmtlrfcon tsc
WHERE tsc.datfotlrf = :dataSelecionada
   AND tsc.codmun = :municipioSelecionado
   AND tsc.nummes = 12
)
WHERE numano = :exercicioSelecionado

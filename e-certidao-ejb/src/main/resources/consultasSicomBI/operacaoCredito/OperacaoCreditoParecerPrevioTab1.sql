SELECT CodIBGE
      ,:exercicioSelecionado AS ano
      ,SUM(Valor_Receita) AS Valor_Receita
      ,SUM(Valor_Despesa) AS Valor_Despesa
      ,CASE WHEN SUM(Valor_Receita) <> 0
             THEN CASE WHEN SUM(Valor_Receita) <= SUM(Valor_Despesa) 
                        THEN 'Cumpriu' ELSE 'Não Cumpriu' END
            ELSE 'Não houve previsão' END AS resultado
      ,MAX(contOpCredito) AS contOpCredito
      ,MAX(realizOpCredito) AS realizOpCredito
FROM (
      --Valor Receita          
      SELECT ore.codmun AS CodIBGE
            ,SUM(ore.vlrpvt) AS Valor_Receita
            ,0 AS Valor_Despesa
            ,NULL AS contOpCredito
            ,NULL AS realizOpCredito
       FROM bi_sicom.odsrec ore
        INNER JOIN bi_sicom.odsnatrec onr ON onr.seqnatrec = ore.seqnatrec
        INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = ore.codacp
       WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
         AND REPLACE(onr.codtpo,'.', '') LIKE '21%'
         AND ore.codmun = :municipioSelecionado
         AND trh.numanorem = :exercicioSelecionado
         AND trh.tiprem = 'IP'
       GROUP BY ore.codmun

      UNION ALL
      
      --Valor Despesa  
      SELECT tad.codmun as CodIBGE
            ,0 AS Valor_Receita
            ,SUM(tad.vlrprv) AS Valor_Despesa
            ,NULL AS contOpCredito
            ,NULL AS realizOpCredito
        FROM bi_sicom.tblauxdsp tad
          INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = tad.codacp
          INNER JOIN bi_sicom.odsdotorc odo ON odo.seqdotorc = tad.seqdotorc
        WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
          AND tad.codmun = :municipioSelecionado
          AND trh.numanorem = :exercicioSelecionado
          AND odo.codnatdsp like '4%'
          AND trh.tiprem = 'IP'
        GROUP BY tad.codmun
      
      UNION ALL
      
      --InfoOpCrédito
      SELECT ooc.codmun AS CodIBGE
            ,0 AS Valor_Receita
            ,0 AS Valor_Despesa
            ,NVL(DECODE(ooc.codctdcrt, 1, 'Sim', 2, 'Não'), '-') AS contOpCredito
            ,NVL(DECODE(ooc.codreaoprcrt, 1, 'Sim', 2, 'Não'), '-') AS realizOpCredito
       FROM bi_sicom.odsoprcrt ooc
         INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = ooc.codacp
       WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
         AND ooc.codmun = :municipioSelecionado
         AND trh.numanorem = :exercicioSelecionado      
    )
GROUP BY CodIBGE

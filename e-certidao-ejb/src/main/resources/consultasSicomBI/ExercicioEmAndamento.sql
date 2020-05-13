SELECT MAX(pt.exercicio) AS ano
 FROM sicom_comum.periodotempestividade pt
 WHERE pt.tipoenvio = 2
   AND pt.mesref = 1
   AND to_number(to_char(pt.periodofinal, 'YYYYMMDD')) <= to_number(to_char(SYSDATE, 'YYYYMMDD')) 
 ORDER BY pt.exercicio
         ,pt.mesref 
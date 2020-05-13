
WITH FILTRO AS
 (SELECT ORG.COD_MUNICIPIO,
         ORG.SEQ_DIM_ORGAO,
         ORG.NUM_EXERCICIO,
         ORG.NUM_MES,
         ORG.POSICAO,
         ORG.NOM_PERIODO,
         ORG.DATA_ATIVACAO,
         ORG.DTALEIEXTINCAO,
         ORG.ORG_ATIVO,
         REM.ENVIOU_REM,
         CASE
           WHEN ORG.ORG_ATIVO > NVL(REM.ENVIOU_REM, 0) THEN
            1
           ELSE
            0
         END INADIMPLENTE
    FROM (SELECT DOS.COD_MUNICIPIO,
                 :exercicioSelecionado AS NUM_EXERCICIO,
                 dos.seq_dim_orgao,
                 DP.NUM_MES,
                 POSICAO,
                 NOM_PERIODO,
                 OC.DATA_ATIVACAO,
                 OE.DTALEIEXTINCAO,
                 SUM(CASE
                       WHEN TO_NUMBER(TO_CHAR(OC.DATA_ATIVACAO, 'YYYYMM')) <=
                            TO_NUMBER(:exercicioSelecionado ||
                                      LPAD(DP.NUM_MES, 2, 0)) AND
                            TO_NUMBER(TO_CHAR(NVL(NVL(OC.DATA_ENCERRAMENTO_ATIVIDADES,
                                                      OE.DTALEIEXTINCAO),
                                                  add_months(SYSDATE, 13)),
                                              'YYYYMM')) >
                            TO_NUMBER(:exercicioSelecionado ||
                                      LPAD(DP.NUM_MES, 2, 0)) THEN
                        1
                       ELSE
                        0
                     END) AS ORG_ATIVO
            FROM sc_bipre.DIM_PERIODO DP
           CROSS JOIN sc_bipre.DIM_ORGAO_SICOM DOS
           INNER JOIN sc_bipre.DIM_INDICADOR DI
              ON DOS.SEQ_IND_TIPOORGAO = DI.SEQ_DIM_INDICADOR
           INNER JOIN PORTALSICOM.ORGAOCONVIDADO OC
              ON DOS.COD_ORGAO = OC.CODORGAO
             AND DOS.NUM_CNPJ = OC.CNPJ
           INNER JOIN PORTALSICOM.MUNICIPIO M
              ON M.CODMUNICIPIO = OC.CODMUNICIPIO
             AND M.CODIBGE = DOS.COD_MUNICIPIO
            LEFT JOIN PORTALSICOM.ORGAOEXTINTO OE
              ON OE.IDORGAOEXTINTO = OC.IDORGAOCONVIDADO
           WHERE DP.POSICAO IN (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
             AND DI.SGL_DIM_INDICADOR <> '7'
             AND OC.CODMUNICIPIO NOT LIKE '090%'
             AND OC.TIPOORGAO <> 7
             AND OC.DATA_ATIVACAO IS NOT NULL
             AND (LEAST(:municipioSelecionado) IS NULL OR
                 DOS.COD_MUNICIPIO IN (:municipioSelecionado))
             AND DOS.COD_MUNICIPIO NOT IN
                 (SELECT crc.codibge
                    FROM ctl_remessa_a_carregar crc
                   INNER JOIN dim_orgao_sicom dos
                      ON crc.idorgao = dos.seq_dim_orgao
                   INNER JOIN DIM_INDICADOR DI
                      ON DOS.SEQ_IND_TIPOORGAO = DI.SEQ_DIM_INDICADOR
                   WHERE crc.num_ano_exercicio = :exercicioSelecionado
                     AND DI.SGL_DIM_INDICADOR <> '7'
                     AND crc.tipremessa = 'AM'
                     AND crc.flg_processa IN ('A', 'E')
                     AND (LEAST(:municipioSelecionado) IS NULL OR
                         crc.codibge IN (:municipioSelecionado)))
           GROUP BY DOS.COD_MUNICIPIO,
                    dos.seq_dim_orgao,
                    POSICAO,
                    NOM_PERIODO,
                    DP.NUM_MES,
                    OC.DATA_ATIVACAO,
                    OE.DTALEIEXTINCAO) ORG
    LEFT JOIN (SELECT DR.COD_MUNICIPIO,
                     DR.SEQ_DIM_ORGAO,
                     DR.NUM_MES_REF,
                     DR.NUM_ANO_EXERCICIO,
                     COUNT(DISTINCT SEQ_DIM_ORGAO) AS ENVIOU_REM
                FROM sc_bipre.DIM_REMESSA DR
               WHERE DR.NUM_ANO_EXERCICIO = :exercicioSelecionado
                 AND DR.IND_ULTIMO = 'S'
                 AND DR.SGL_TIPO_REMESSA = 'AM'
                 AND (LEAST(:municipioSelecionado) IS NULL OR
                     dr.cod_municipio IN (:municipioSelecionado))
               GROUP BY DR.NUM_MES_REF,
                        DR.NUM_ANO_EXERCICIO,
                        DR.SEQ_DIM_ORGAO,
                        DR.COD_MUNICIPIO) REM
      ON REM.NUM_ANO_EXERCICIO = :exercicioSelecionado
     AND REM.NUM_MES_REF = ORG.NUM_MES
     AND REM.SEQ_DIM_ORGAO = ORG.SEQ_DIM_ORGAO
   ORDER BY ORG.COD_MUNICIPIO,
            ORG.SEQ_DIM_ORGAO,
            ORG.NUM_EXERCICIO,
            ORG.NUM_MES)
SELECT DM.COD_MUNICIPIO,
       DM.NOM_MUNICIPIO,
       MIN(A.MENOR_POSICAO) AS MENOR_POSICAO,
       MIN(A.MAIOR_POSICAO) AS MAIOR_POSICAO
  FROM (SELECT COD_MUNICIPIO,
               SEQ_DIM_ORGAO,
               MIN(POSICAO) AS MENOR_POSICAO,
               CASE
                 WHEN INADIMPLENTE_ORG IS NOT NULL THEN
                  INADIMPLENTE_ORG - 1
                 ELSE
                  MAX(POSICAO)
               END AS MAIOR_POSICAO
          FROM (SELECT F.COD_MUNICIPIO,
                       F.SEQ_DIM_ORGAO,
                       F.POSICAO,
                       (SELECT COUNT(DISTINCT FF.SEQ_DIM_ORGAO) FROM FILTRO FF) AS QTDE_ORGAO_SELECIONADO,
                       ENVIOU_REM,
                       INADIMPLENTE,
                       (SELECT MIN(POSICAO)
                          FROM FILTRO FFF
                         WHERE FFF.SEQ_DIM_ORGAO = F.SEQ_DIM_ORGAO
                           AND INADIMPLENTE = 1) AS INADIMPLENTE_ORG
                  FROM FILTRO F)
         WHERE CASE
                 WHEN QTDE_ORGAO_SELECIONADO = 1 THEN
                  ENVIOU_REM
                 ELSE
                  1
               END = 1
         GROUP BY COD_MUNICIPIO, SEQ_DIM_ORGAO, INADIMPLENTE_ORG
         ORDER BY COD_MUNICIPIO) A
 INNER JOIN DIM_MUNICIPIO DM
    ON A.COD_MUNICIPIO = DM.COD_MUNICIPIO
 GROUP BY DM.COD_MUNICIPIO, DM.NOM_MUNICIPIO
HAVING MIN (A.MENOR_POSICAO) = 1
 ORDER BY DM.NOM_MUNICIPIO

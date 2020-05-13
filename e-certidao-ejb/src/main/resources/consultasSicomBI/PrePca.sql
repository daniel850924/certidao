SELECT 
     tid.codmun
    ,tid.nommun
    ,ti.SEQIND
    ,ti.dscind
    ,tid.numanoref    
    ,tid.vlrpctapl
FROM bi_portalsicom.tblifcdbd tid
INNER JOIN bi_portalsicom.tblind ti ON tid.seqind = ti.seqind
WHERE ti.codind IN (1,2,3,4,8,9) --Íncices
AND tid.maxmes = 12 --Consolidado anual
AND tid.codmun = :codIbge
AND tid.numanoref = :exercicio
AND tid.datfimreg IS NULL
ORDER BY tid.codmun
        ,tid.numanoref
        ,DECODE(TI.SEQIND,3,10,TI.SEQIND)
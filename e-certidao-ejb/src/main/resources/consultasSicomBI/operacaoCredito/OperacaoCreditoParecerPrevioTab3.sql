WITH certidao AS
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
       AND ot.numano = :exercicioParecerSelecionado
       AND f.seqmun = :municipioSelecionado
       AND ot.nummes <= :mesSelecionado
     GROUP BY ot.numano, f.seqmun
    ) 
GROUP BY num_ano,seq_municipio
)        

--============= fim certidao ==============

--======================================================== fim temporárias / início consulta ============================================================================

 SELECT NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.ano
             ELSE to_number(lrf.ano) END, 0) AS ano
             
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.rclexecutivo
             ELSE lrf.vlr_rcl_aju END, 0) AS vlrrclliq
             
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.despesatotalpessoalexecutivo
             ELSE lrf.vlr_dsp_executivo END, 0) AS vlrdspexe
             
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.porcdesptotalpessoalexec
             ELSE lrf.prc_dps_exe END, 0) AS prcdspexe
             
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.despesatotalpessoalleg
             ELSE lrf.vlr_dsp_legislativo END, 0) AS vlrdspleg
        
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN to_number(siace.porcdesptotalpessoalleg)
             ELSE lrf.prc_dps_leg END, 0) AS prcdspleg
        
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN to_char(siace.datapublicacao, 'DD/MM/YYYY')
             ELSE to_char(lrf.dta_pub_rel_lrf) END, '-') AS datpubrreo
        
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.situacaopublicacao
             ELSE to_char(lrf.situacaorreo) END, 'Não Informou') AS sitpubrreo
        
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN to_char(siace.datapublicacao, 'DD/MM/YYYY')
             ELSE to_char(lrf.dat_publicrgf) END, '-') AS datpubrgf
        
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.situacaopublicacao
             ELSE to_char(lrf.situacaorgf) END, 'Não Informou') AS sitpubrgf
        
       ,NVL(CASE WHEN :exercicioParecerSelecionado <= 2017
              THEN siace.opcaosemestralidade
               END, '-') AS opcsem
        
       ,NVL(siace.operacoescreditoprevinicial,0) AS operacoescreditoprevinicial
       ,NVL(siace.despesacapitaldotacaoinicial,0) AS despesacapitaldotacaoinicial
       ,NVL(CASE WHEN siace.operacoescreditoprevinicial <> 0
                 THEN CASE WHEN (siace.operacoescreditoprevinicial) <= (despesacapitaldotacaoinicial) 
                              THEN 'Cumpriu' ELSE 'Não Cumpriu' 
                            END
                 ELSE 'Não houve previsão' END, '-') AS resultadoSiace
                                     
  FROM (
  
     --INFORMAÇÕES VINDAS DO SIACE (PARA EXERCÍCIOS ANTERIORES A 2018)
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
    where EXTRACT(YEAR FROM siace.databaseremessa )  = :exercicioParecerSelecionado                                                     
   ) siace
    RIGHT JOIN 
    (SELECT MAX(lrf.cod_municipio) AS cod_municipio
           ,MAX(lrf.ano) AS ano
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
                ,:exercicioParecerSelecionado AS ano
                
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
                ,SUM(c.vlr_dsp_legislativo) AS vlr_dsp_legislativo
                ,SUM(c.vlr_dsp_executivo) AS vlr_dsp_executivo
                ,SUM(c.vlr_dsp_total) AS vlr_dsp_total             
                ,SUM(vlr_rcl) AS vlr_rcl
                ,SUM(vlr_rcl_aju) AS vlr_rcl_aju
                ,NULL AS dta_pub_rel_lrf
                ,NULL AS dat_publicrgf
                ,NULL AS situacaorreo
                ,NULL AS situacaorgf
          FROM certidao c  
          GROUP BY c.cod_municipio
          
          UNION ALL
          
          -- Data e Situação da Publicação do RREO
          SELECT oo.codmun AS cod_municipio                
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
              AND oppl.numexrtpobim = :exercicioParecerSelecionado
              AND oo.codmun NOT IN (0, 9999999, 123456, 654321)
              AND oo.codmun = :municipioSelecionado
          
          UNION ALL
          
          -- Data e Situação da Publicação do RGF
          SELECT cod_municipio
                 ,0 AS vlr_dsp_legislativo
                 ,0 AS vlr_dsp_executivo
                 ,0 AS vlr_dsp_total                
                 ,0 AS vlr_rcl
                 ,0 AS vlr_rcl_aju
                 ,NULL AS dta_pub_rel_lrf
                 ,NVL(to_char(dat_publicrgf),'-') AS dat_publicrgf
                 ,NULL AS situacaorreo
                 ,CASE WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) <= to_number((:exercicioParecerSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                       WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) > to_number((:exercicioParecerSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Intempestivo' 
                       ELSE 'Não Informou' END AS situacaorgf
          FROM (
              SELECT opprl.codmun AS cod_municipio
                    ,DECODE(:mesSelecionado, 4, '30/04', 6, '30/06', 8, '31/08','31/12') AS num_per_bimestre
                    ,MAX(CASE WHEN opprl.indpubrgf = 1 
                          AND to_number(to_char(opprl.datpubrgf,'YYYYMM')) > to_number(:exercicioParecerSelecionado || LPAD(:mesSelecionado,2,0)) 
                          AND opprl.numexrtpoper = :exercicioParecerSelecionado
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
                AND opprl.numexrtpoper = :exercicioParecerSelecionado
                AND tslc.nummes = :mesSelecionado
                AND opprl.codmun = :municipioSelecionado
              GROUP BY opprl.codmun
                      ,opprl.numexrtpoper
              ORDER BY opprl.codmun
          )
       )
      GROUP BY cod_municipio, dta_pub_rel_lrf, dat_publicrgf, situacaorreo, situacaorgf
      )lrf
     -- group by cod_municipio
    )lrf ON lrf.cod_municipio = siace.codmunicipio
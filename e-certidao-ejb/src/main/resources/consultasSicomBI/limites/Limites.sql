SELECT NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.ano
             ELSE to_number(lrf.ano) END, 0) AS ano
             
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.optante
            END, '-') AS opcsem
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.receitacorrenteliqpref
             ELSE lrf.vlr_rcl END, 0) AS vlrrc
                    
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.receitacorrenteliqpref
             ELSE lrf.vlr_rcl_aju END, 0) AS vlrrclliq
                          
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.despesatotalpessoalpref
             ELSE lrf.vlr_dsp_executivo END, 0) AS vlrdspexe
             
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.porcentdesptotpessoalexec
             ELSE lrf.prc_dps_exe END, 0) AS prcdspexe
             
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.despesatotalpessoalpl
             ELSE lrf.vlr_dsp_legislativo END, 0) AS vlrdspleg
        
      ,nvl(case when :exercicioSelecionado <= 2017
              then siace.porcentdesptotpessoalpl
             ELSE lrf.prc_dps_leg end, 0) AS prcdspleg
        
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN to_char(siace.datapublicacao, 'DD/MM/YYYY')
             ELSE to_char(lrf.dta_pub_rel_lrf) END, '-') AS datpubrreo
        
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.situacaopublicacao
             ELSE to_char(lrf.situacaorreo) END, 'Não Informou') AS sitpubrreo
        
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN to_char(siace.datapublicacao, 'DD/MM/YYYY')
             ELSE to_char(lrf.dat_publicrgf) END, '-') AS datpubrgf
        
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.situacaopublicacao
             ELSE to_char(lrf.situacaorgf) END, 'Não Informou') AS sitpubrgf
        
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.dividaconsolidada
             ELSE lrf.vlr_div_con end, 0) AS vlrdivcon
             
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.dividaconsolidadaliquida
             ELSE lrf.vlr_div_con_liq END, 0) AS vlrdivconliq 

      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.porcentdividaconsolidliqexec
             ELSE lrf.prc_div_con_liq END, 0) AS prcdivconliq
              
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.concessaogarantia
             ELSE lrf.vlr_conc_grt END, 0) AS vlrconcgrt
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.porcentconcessaogarantiaexec
             ELSE lrf.prc_conc_grt END, 0) AS prcconcgrt
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.demonstrativoopcreditoexec
             ELSE lrf.vlr_op_sem_aro END, 0) AS vlropsemaro
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.porcentoperacoescreditoexec
             ELSE lrf.prc_op_sem_aro END, 0) AS prcopsemaro
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.aro
             ELSE lrf.vlr_aro end, 0) AS vlraro
             
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.aroexec
             ELSE lrf.prc_aro end, 0) AS prcaro
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.valorinscrsp
             ELSE lrf.vlr_ins_rsp end, 0) AS vlrinsrsp

      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.dispfinanceira
             ELSE lrf.vlr_disp_financ end, 0) AS vlrdispfinanc
       
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.impnprev END, '-') AS impnprev
             
      ,NVL(CASE WHEN :exercicioSelecionado <= 2017
              THEN siace.impnarr END, '-') AS impnarr                            
  FROM (
    
    --Informações extraidas do SIACE para exercícios anteriores a 2018
    select to_number(:exercicioSelecionado) as ano,
    codmunicipio,
    nomemunicipio,
    optante,
    receitacorrenteliqpref,
    despesatotalpessoalpref,
    porcentdesptotpessoalexec,
    despesatotalpessoalpl,
    porcentdesptotpessoalpl,
    datapublicacao,
    situacaopublicacao,
    dividaconsolidada,
    (case when (restoapagar > subtracaoresultadonominal) 
      then dividaconsolidada 
     else (case when dividaconsolidadaliquida < 0 then 0 else dividaconsolidadaliquida end) END) as dividaconsolidadaliquida,
    (case when  round((dividaconsolidadaliquida/receitacorrenteliqpref),4) < 0 
      then 0 
      else
      case when (restoapagar > subtracaoresultadonominal)
       then round((dividaconsolidada/receitacorrenteliqpref),4)
      else  
       round((dividaconsolidadaliquida/receitacorrenteliqpref),4) 
      end end
    ) as porcentdividaconsolidliqexec,
    concessaogarantia,
    porcentconcessaogarantiaexec,
    demonstrativoopcreditoexec,
    porcentoperacoescreditoexec,
    aro,
    aroexec,
    valorinscrsp,
    dispfinanceira,
    dispfinacxinscrestpagar,
    porcoperacoescredito,
    nvl(iptuprevista || itbiprevista || irrfprevista || issqnprevista, '-') as impnprev,
    nvl(ipturealizada || itbiprevista || irrfprevista || issqnrealizada, '-') as impnarr

from
(
   select nomemunicipio,
   codmunicipio,
   datapublicacao,
   situacaopublicacao,
   optante,
   despesatotalpessoalpref,
   round((despesatotalpessoalpref/receitacorrenteliqpref),4) as porcentdesptotpessoalexec,
   despesatotalpessoalpl,
   round((despesatotalpessoalpl/receitacorrenteliqpl),4) as porcentdesptotpessoalpl,
   round((despesatotalpessoalpl/receitacorrenteliqpl)+(despesatotalpessoalpref/receitacorrenteliqpref),4) as porcenttotaldesptotpessoal,
   receitacorrenteliqpref,
   aro,
   round((aro/receitacorrenteliqpref),4) as aroexec,
   demonstrativoopcreditoexec,
   round(demonstrativoopcreditoexec/receitacorrenteliqpref,4) as porcentoperacoescreditoexec,
   concessaogarantia,
   round(concessaogarantia/receitacorrenteliqpref,4) as porcentconcessaogarantiaexec,
   (valorprocenaoprocpe+valorprocenaoprocpl) as valorinscrsp,
   (dispfinanceirape+dispfinanceirapl) as dispfinanceira,
   (case when (dispfinanceirape+dispfinanceirapl) < (valorprocenaoprocpe+valorprocenaoprocpl)
     then 'Ultrapassou'
     else 'Não ultrapassou'
     end
   ) as dispfinacxinscrestpagar,
   round(operacoescreditoexercicio/receitacorrenteliqpref,4) as porcoperacoescredito,
   case when iptuprevista = 0 then 'IPTU' else '' end as iptuprevista,
   case when itbiprevista = 0 then 'ITBI' else '' end as itbiprevista,
   case when irrfprevista = 0 then 'IRRF' else '' end as irrfprevista,
   case when issqnprevista = 0 then 'ISSQN' else '' end as issqnprevista,
   case when ipturealizada = 0 then 'IPTU' else '' end as ipturealizada,
   case when itbirealizada = 0 then 'ITBI' else '' end as itbirealizada,
   case when irrfrealizada = 0 then 'IRRF' else '' end as irrfrealizada,
   case when issqnrealizada = 0 then 'ISSQN' else '' end as issqnrealizada,
   dividaconsolidada,
   nadaadeclarar,
   subtracaoresultadonominal,
   restoapagar,
   (dividaconsolidada - subtracaoresultadonominal + restoapagar  + inscricoesrestoapagardezembro  
    - (case when nadaadeclarar != 'S' then rpprocpe else 0 end) 
    + (case when nadaadeclarar != 'S' then rpprocpl else 0 end) 
    ) dividaconsolidadaliquida
    
  from
  (select nomemunicipio, 
      codmunicipio,
      datarecebimento,
      datapublicacao,
      situacaopublicacao,
      sum(valoriptu) as ipturealizada, 
      sum(valorissqn) as issqnrealizada, 
      sum(valoritbi) as itbirealizada,
      sum(valorirrf) as irrfrealizada,
      sum(despesamensaltotalpessoalpref) as despesatotalpessoalpref,
      sum(receitacorrenteliqmensalpref) as receitacorrenteliqpref,
      sum(operacoescredexerciciomensal) as operacoescreditoexercicio,
      aro,
      demonstrativoopcreditoexec,
      concessaogarantia,
      dividaconsolidada,
      subtracaoresultadonominal,
      inscricoesrestoapagardezembro,
      rpprocpe,
      nadaadeclarar,
      restoapagar
    from 
      (select distinct nomemunicipio,
          codmunicipio, 
          mesexecucaoorcamentaria,
          datarecebimento, 
          datapublicacao,
          situacaopublicacao,
          receitaimpostos.valoriptu as valoriptu, 
          receitaimpostos.valorirrf as valorirrf, 
          receitaimpostos.valorissqn as valorissqn, 
          receitaimpostos.valoritbi as valoritbi,
          (receitatributaria.receitacontmelhoria
            +receitatributaria.receitataxas
            +receitaimpostos.valoritbi
            +receitaimpostos.valorissqn
            +receitaimpostos.valorirrf
            +receitaimpostos.valoriptu
            +receitacorrente.receitacontribuicoes
            +receitapatrimonial.receitaaplicacoes
            +receitapatrimonial.valoroutrasreceitas
            +receitacorrente.receitaindustriais
            +receitacorrente.receitaagropecuarias
            +receitacorrente.receitaservicos
            +transferenciacorrente.cotapartefpm
            +transferenciacorrente.cotaparteicms
            +transferenciacorrente.cotaparteipva
            +transferenciacorrente.cotaparteipi
            +transferenciacorrente.transferenciafundef
            +transferenciacorrente.outrastransferencias
            +transferenciacorrente.convenios
            +receitacorrente.outrasreceitascorrentes
            -exclusaoreceita.contservprevprop
            -exclusaoreceita.compensregprev
            -exclusaoreceita.outrasduplicidades
            -exclusaoreceita.contpatronalprevprop
            -transfintragovernamental.transffundacoes
            -transfintragovernamental.transfautarquias
            -transfintragovernamental.transfempestdep
            -transfintragovernamental.transfdemaisent
            -deducaoreceita.deducaofundef
            -receitacorrente.deducoesreceitacorrente
          )  as receitacorrenteliqmensalpref,
          (despesamensalpessoal.vencimentosvantagens
            +despesamensalpessoal.inativos
            +despesamensalpessoal.pensionistas
            +despesamensalpessoal.salariofamilia
            +despesamensalpessoalpref.subsidioprefeito
            +despesamensalpessoalpref.subsidioviceprefeito
            +despesamensalpessoalpref.subsidiosecretariosmunicipais
            +despesamensalpessoal.obrigacoespatronais
            +despesamensalpessoal.repassepatronal
            +despesamensalpessoal.sentencasjudiciarias
            +despesamensalpessoal.outrasdespesaspessoal
            +despesamensalpessoal.despesasanteriores
            +despesamensalpessoal.despesasantcorrespondente
            +despesamensalpessoal.despesasanteriorescompetencia
            -despesamensalpessoal.inativos
            -despesamensalpessoal.pensionistas
            -despesamensalpessoal.indenizacoesdemissao
            -despesamensalpessoal.incentivosdemissaovoluntaria
            -despesamensalpessoal.sentencasjudiciariasanteriores
            -despesamensalpessoal.despesasantcorrespondente
            -despesamensalpessoal.despesasanterioresexclusao
          ) as despesamensaltotalpessoalpref,
          operacoescredito.receitaoutrasopcredito as operacoescredexerciciomensal
        from receitaimpostos@dbl_lrf_tcemg04_mexico 
          inner join receitatributaria@dbl_lrf_tcemg04_mexico on receitatributaria.idreceitaimpostos = receitaimpostos.id
          inner join receitacorrente@dbl_lrf_tcemg04_mexico on receitacorrente.idreceitatributaria = receitatributaria.id
          inner join execucaoreceita@dbl_lrf_tcemg04_mexico on execucaoreceita.id = receitacorrente.idexecucaoreceita
          inner join receitapatrimonial@dbl_lrf_tcemg04_mexico on receitapatrimonial.id = receitacorrente.idreceitapatrimonial
          inner join transferenciacorrente@dbl_lrf_tcemg04_mexico on transferenciacorrente.id = receitacorrente.idtransferenciacorrente
          inner join exclusaoreceita@dbl_lrf_tcemg04_mexico on exclusaoreceita.id = execucaoreceita.idexclusaoreceita
          inner join transfintragovernamental@dbl_lrf_tcemg04_mexico on transfintragovernamental.id = exclusaoreceita.idexclusaorectransfcorrente
          inner join deducaoreceita@dbl_lrf_tcemg04_mexico on deducaoreceita.idexecucaoreceita = execucaoreceita.id
          inner join receitacapital@dbl_lrf_tcemg04_mexico on receitacapital.idexecucaoreceita = execucaoreceita.id
          inner join operacoescredito@dbl_lrf_tcemg04_mexico on operacoescredito.id = receitacapital.idoperacoescredito,
          (select max(execucaobimestral.idexecucaoreceita) iddaexecucaoreceita, 
              max(execucaobisemestral.idresultadonominal) iddoresultadonominal,
              nomemunicipio,
              codmunicipio, 
              mesexecucaoorcamentaria,
              datarecebimento,
              datapublicacao,
              situacaopublicacao,
              iddaprestacao
            from execucaobimestral@dbl_lrf_tcemg04_mexico,
              execucaobisemestral@dbl_lrf_tcemg04_mexico,
              (select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, 
                execucaoorcamentaria.mes as mesexecucaoorcamentaria, 
                municipio.nome as nomemunicipio,
                municipio.codigoibge as codmunicipio, 
                datarecebimento,
                datapublicacao,
                (  
                     case  
                      when datapublicacao > add_months(databaseremessa, 1)  
                      then 'Intempestivo'  
                      else 'Tempestivo'  
                     end ) as situacaopublicacao,
                iddaprestacao
                from municipio@dbl_lrf_tcemg04_mexico 
                  inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                  inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                  inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                  (select prestacao.id iddaprestacao, 
                    max(remessalrf.dataenvio) as datarecebimento,
                    max(remessalrf.datapublicacao) as datapublicacao,
                    max(remessalrf.dtbase) as databaseremessa
                    from municipio@dbl_lrf_tcemg04_mexico 
                    inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                    inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                    inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                    -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                    where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                    and remessalrf.dtbase = datalimite.dtbase
                    -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                    --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                    and municipio.codigoibge = :municipioSelecionado
                    group by prestacao.id
                  )
                where iddaprestacao = prestacao.id
                  -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                  and prestacao.exercicio = :exercicioSelecionado
                order by execucaoorcamentaria.mes
              )
            where iddaexecucaoorcamentaria = execucaobimestral.idexecucaoorcamentaria
              and iddaexecucaoorcamentaria = execucaobisemestral.idexecucaoorcamentaria
            group by nomemunicipio, codmunicipio, mesexecucaoorcamentaria, datarecebimento, datapublicacao, iddaprestacao, situacaopublicacao
            order by mesexecucaoorcamentaria
          ),
          gestaofiscal@dbl_lrf_tcemg04_mexico 
          inner join despesamensalpessoal@dbl_lrf_tcemg04_mexico on gestaofiscal.iddespesamensalpessoal = despesamensalpessoal.id
          inner join despesamensalpessoalpref@dbl_lrf_tcemg04_mexico on despesamensalpessoalpref.id = despesamensalpessoal.id
        where execucaoreceita.id = iddaexecucaoreceita
          and gestaofiscal.idprestacaolrf = iddaprestacao
          and gestaofiscal.mes=mesexecucaoorcamentaria
          and receitacorrente.tiporeceita = 4
          and deducaoreceita.tiporeceita = 4
          and receitacapital.tiporeceita = 4
        order by mesexecucaoorcamentaria
      ),
      
      (select distinct (restoapagarpref + restoapagarcam + restoapagarent - restoapagaripp - resultadonominal.saldoprecatorios) restoapagar,
       (case when mesexecucaoorcamentaria1 = 12
         then inscricaorestosapagar.valorprocessado + inscricaorestosapagar.valorprocessadolegislativo
           else
             0
        end) inscricoesrestoapagardezembro,
         inscricaorestosapagar.valorprocessadolegislativo rpprocpe, --add
         resultadonominal.nadaadeclarar,
         resultadonominal.dividaconsolidada dividaconsolidada,
          (resultadonominal.disponibilidadecaixa
            +resultadonominal.aplicacaofinanceira
            +resultadonominal.ativofinanceiro
          ) as subtracaoresultadonominal,
          resultadonominal.saldoprecatorios as saldoprecatorio,
          (inscricaorestosapagar.valorprocessado
            +inscricaorestosapagar.valorprocessadolegislativo
            +inscricaorestosapagar.valorprocessadorppsas) as inscricoesrestoapagar,
          itemcomparativope.antecipacaoreceitaorcamentaria as aro,
          (demonstrativoopcredito.mobiliariainterna
            +demonstrativoopcredito.mobiliariaexterna
            +demonstrativoopcredito.contratualexterna
            +demonstrativoopcredito.aberturacredito
            +demonstrativoopcredito.derivadasppp
            +demonstrativoopcredito.demaisaquisfinanc
            +demonstrativoopcredito.pelavendatermobs
            +demonstrativoopcredito.demaisantecipreceita
            +demonstrativoopcredito.assuncaorecconfdiv
            +demonstrativoopcredito.outrasoperacoescredito
            +demonstrativoopcredito.operacoesvedadas
          ) as demonstrativoopcreditoexec,
          itemcomparativope.concessaogarantia as concessaogarantia,
          mesexecucaoorcamentaria1
        from resultadonominal@dbl_lrf_tcemg04_mexico,
          gestaofiscal@dbl_lrf_tcemg04_mexico inner join inscricaorestosapagar@dbl_lrf_tcemg04_mexico on gestaofiscal.idinscricaorestosapagar = inscricaorestosapagar.id
          inner join itemcomparativope@dbl_lrf_tcemg04_mexico on itemcomparativope.id = gestaofiscal.iditemcomparativo
          inner join demonstrativoopcredito@dbl_lrf_tcemg04_mexico on demonstrativoopcredito.id = gestaofiscal.iddemonstrativoopcredito,
          (select max(execucaobisemestral.idexecucaorestosapagar) iddaexecucaorestosapagar,
              max(execucaobisemestral.idresultadonominal) iddoresultadonominal,
              mesexecucaoorcamentaria1,
              iddaprestacao,
              iddaremessalrf
            from execucaobisemestral@dbl_lrf_tcemg04_mexico,
              (select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, 
                  execucaoorcamentaria.mes as mesexecucaoorcamentaria1, 
                  municipio.codigoibge as nomemunicipio, 
                  iddaprestacao,
                  iddaremessalrf
                from municipio@dbl_lrf_tcemg04_mexico 
                  inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                  inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                  inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                  (select prestacao.id iddaprestacao, 
                      max(remessalrf.id) as iddaremessalrf,
                      max(remessalrf.dataenvio) as datarecebimento
                    from municipio@dbl_lrf_tcemg04_mexico 
                      inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                      inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                      inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                      -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                    where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                      and remessalrf.dtbase = datalimite.dtbase
                      -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                      --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                      and municipio.codigoibge = :municipioSelecionado
                    group by prestacao.id
                  )
                where iddaprestacao = prestacao.id
                  -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                  and prestacao.exercicio = :exercicioSelecionado
                  and execucaoorcamentaria.mes = 12
                  order by execucaoorcamentaria.mes
              )
            where iddaexecucaoorcamentaria = execucaobisemestral.idexecucaoorcamentaria
            group by mesexecucaoorcamentaria1, iddaprestacao, iddaremessalrf
            order by mesexecucaoorcamentaria1
          ),
          (select (case 
                when sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago) is null 
                then 0.0 else sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago)
                end
              ) as restoapagarpref
            from execucaorestosapagar@dbl_lrf_tcemg04_mexico
              inner join restoapagaranterior@dbl_lrf_tcemg04_mexico on restoapagaranterior.idexecucaorestosapagar = execucaorestosapagar.id
              inner join itemrestoapagar@dbl_lrf_tcemg04_mexico on restoapagaranterior.iditemrestoapagarprocessado = itemrestoapagar.id,
              (select max(execucaobisemestral.idexecucaorestosapagar) iddaexecucaorestosapagar,
                  mesexecucaoorcamentaria1,
                  iddaprestacao
                from execucaobisemestral@dbl_lrf_tcemg04_mexico,
                  (select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, 
                      execucaoorcamentaria.mes as mesexecucaoorcamentaria1, 
                      municipio.codigoibge as nomemunicipio, 
                      iddaprestacao
                    from municipio@dbl_lrf_tcemg04_mexico 
                      inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                      inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                      inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                      (select prestacao.id iddaprestacao, 
                          max(remessalrf.dataenvio) as datarecebimento,
                          max(remessalrf.datapublicacao) as datapublicacao
                        from municipio@dbl_lrf_tcemg04_mexico 
                          inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                          inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                          -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                        where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                          and remessalrf.dtbase = datalimite.dtbase
                          -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                          --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                          and municipio.codigoibge = :municipioSelecionado
                        group by prestacao.id
                      )
                    where iddaprestacao = prestacao.id
                      -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                      and prestacao.exercicio = :exercicioSelecionado
                      and execucaoorcamentaria.mes = 12
                      order by execucaoorcamentaria.mes
                  )
                where iddaexecucaoorcamentaria = execucaobisemestral.idexecucaoorcamentaria
                group by mesexecucaoorcamentaria1, iddaprestacao
                order by mesexecucaoorcamentaria1
              )
            where iddaexecucaorestosapagar = execucaorestosapagar.id
              and restoapagaranterior.vinculadoa = 1
          ),
          (select (case 
                when sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago) is null 
                then 0.0 else sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago)
                end
              ) as restoapagarent
            from execucaorestosapagar@dbl_lrf_tcemg04_mexico
              inner join restoapagaranterior@dbl_lrf_tcemg04_mexico on restoapagaranterior.idexecucaorestosapagar = execucaorestosapagar.id
              inner join itemrestoapagar@dbl_lrf_tcemg04_mexico on restoapagaranterior.iditemrestoapagarprocessado = itemrestoapagar.id,
              (select max(execucaobisemestral.idexecucaorestosapagar) iddaexecucaorestosapagar,
                  mesexecucaoorcamentaria1,
                  iddaprestacao
                from execucaobisemestral@dbl_lrf_tcemg04_mexico,
                  (select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, 
                      execucaoorcamentaria.mes as mesexecucaoorcamentaria1, 
                      municipio.codigoibge as nomemunicipio, 
                      iddaprestacao
                    from municipio@dbl_lrf_tcemg04_mexico 
                      inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                      inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                      inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                      (select prestacao.id iddaprestacao, 
                          max(remessalrf.dataenvio) as datarecebimento,
                          max(remessalrf.datapublicacao) as datapublicacao
                        from municipio@dbl_lrf_tcemg04_mexico 
                          inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                          inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                          -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                        where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                          and remessalrf.dtbase = datalimite.dtbase
                          -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                          --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                          and municipio.codigoibge = :municipioSelecionado
                        group by prestacao.id
                      )
                    where iddaprestacao = prestacao.id
                      -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                      and prestacao.exercicio = :exercicioSelecionado
                      and execucaoorcamentaria.mes = 12
                      order by execucaoorcamentaria.mes
                  )
                where iddaexecucaoorcamentaria = execucaobisemestral.idexecucaoorcamentaria
                group by mesexecucaoorcamentaria1, iddaprestacao
                order by mesexecucaoorcamentaria1
              )
            where iddaexecucaorestosapagar = execucaorestosapagar.id
              and restoapagaranterior.vinculadoa = 2
          ),
          (select (case 
                when sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago) is null 
                then 0.0 else sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago)
                end
              ) as restoapagarcam
            from execucaorestosapagar@dbl_lrf_tcemg04_mexico
              inner join restoapagaranterior@dbl_lrf_tcemg04_mexico on restoapagaranterior.idexecucaorestosapagar = execucaorestosapagar.id
              inner join itemrestoapagar@dbl_lrf_tcemg04_mexico on restoapagaranterior.iditemrestoapagarprocessado = itemrestoapagar.id,
              (select max(execucaobisemestral.idexecucaorestosapagar) iddaexecucaorestosapagar,
                  mesexecucaoorcamentaria1,
                  iddaprestacao
                from execucaobisemestral@dbl_lrf_tcemg04_mexico,
                  (select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, 
                      execucaoorcamentaria.mes as mesexecucaoorcamentaria1, 
                      municipio.codigoibge as nomemunicipio, 
                      iddaprestacao
                    from municipio@dbl_lrf_tcemg04_mexico 
                      inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                      inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                      inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                      (select prestacao.id iddaprestacao, 
                          max(remessalrf.dataenvio) as datarecebimento,
                          max(remessalrf.datapublicacao) as datapublicacao
                        from municipio@dbl_lrf_tcemg04_mexico 
                          inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                          inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                          -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                        where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                          and remessalrf.dtbase = datalimite.dtbase
                          -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                          --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                          and municipio.codigoibge = :municipioSelecionado
                        group by prestacao.id
                      )
                    where iddaprestacao = prestacao.id
                      -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                      and prestacao.exercicio = :exercicioSelecionado
                      and execucaoorcamentaria.mes = 12
                      order by execucaoorcamentaria.mes
                  )
                where iddaexecucaoorcamentaria = execucaobisemestral.idexecucaoorcamentaria
                group by mesexecucaoorcamentaria1, iddaprestacao
                order by mesexecucaoorcamentaria1
              )
            where iddaexecucaorestosapagar = execucaorestosapagar.id
              and restoapagaranterior.vinculadoa = 3
          ),
          (select (case 
                when sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago) is null 
                then 0.0 else sum(itemrestoapagar.valorinscrito-itemrestoapagar.valorcancelado-itemrestoapagar.valorpago)
                end
              ) as restoapagaripp
            from execucaorestosapagar@dbl_lrf_tcemg04_mexico
              inner join restoapagaranterior@dbl_lrf_tcemg04_mexico on restoapagaranterior.idexecucaorestosapagar = execucaorestosapagar.id
              inner join itemrestoapagar@dbl_lrf_tcemg04_mexico on restoapagaranterior.iditemrestoapagarprocessado = itemrestoapagar.id,
              (select max(execucaobisemestral.idexecucaorestosapagar) iddaexecucaorestosapagar,
                  mesexecucaoorcamentaria1,
                  iddaprestacao
                from execucaobisemestral@dbl_lrf_tcemg04_mexico,
                  (select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, 
                      execucaoorcamentaria.mes as mesexecucaoorcamentaria1, 
                      municipio.codigoibge as nomemunicipio, 
                      iddaprestacao
                    from municipio@dbl_lrf_tcemg04_mexico 
                      inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                      inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                      inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                      (select prestacao.id iddaprestacao, 
                          max(remessalrf.dataenvio) as datarecebimento,
                          max(remessalrf.datapublicacao) as datapublicacao
                        from municipio@dbl_lrf_tcemg04_mexico 
                          inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                          inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                          -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                        where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                          and remessalrf.dtbase = datalimite.dtbase
                          -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                          --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                          and municipio.codigoibge = :municipioSelecionado
                        group by prestacao.id
                      )
                    where iddaprestacao = prestacao.id
                      -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                      and prestacao.exercicio = :exercicioSelecionado
                      and execucaoorcamentaria.mes = 12
                      order by execucaoorcamentaria.mes
                  )
                where iddaexecucaoorcamentaria = execucaobisemestral.idexecucaoorcamentaria
                group by mesexecucaoorcamentaria1, iddaprestacao
                order by mesexecucaoorcamentaria1
              )
            where iddaexecucaorestosapagar = execucaorestosapagar.id
              and restoapagaranterior.vinculadoa = 4
          )
        where gestaofiscal.idprestacaolrf = iddaprestacao
          and gestaofiscal.idremessalrf = iddaremessalrf          
          and resultadonominal.id = iddoresultadonominal
          and gestaofiscal.mes = 12
      )
    group by nomemunicipio,
      codmunicipio, 
      datarecebimento, 
      datapublicacao,
      situacaopublicacao,
      restoapagar,
      saldoprecatorio,
      inscricoesrestoapagar,
      inscricoesrestoapagardezembro,
      rpprocpe,
      nadaadeclarar,
      subtracaoresultadonominal,
      aro,
      demonstrativoopcreditoexec,
      concessaogarantia,
      dividaconsolidada
    order by nomemunicipio asc
  ),
  (select nomemunicipio1, 
      datarecebimento1, 
      sum(valoriptu) as iptuprevista, 
      sum(valorissqn) as issqnprevista, 
      sum(valoritbi) as itbiprevista,
      sum(valorirrf) as irrfprevista
    from 
      (
      select nomemunicipio1, 
        mesexecucaoorcamentaria,
          datarecebimento1, 
          receitaimpostos.valoriptu as valoriptu, 
          receitaimpostos.valorirrf as valorirrf, 
          receitaimpostos.valorissqn as valorissqn, 
          receitaimpostos.valoritbi as valoritbi
        from receitaimpostos@dbl_lrf_tcemg04_mexico 
          inner join receitatributaria@dbl_lrf_tcemg04_mexico on receitatributaria.idreceitaimpostos = receitaimpostos.id
          inner join receitacorrente@dbl_lrf_tcemg04_mexico on receitacorrente.idreceitatributaria = receitatributaria.id
          inner join execucaoreceita@dbl_lrf_tcemg04_mexico on execucaoreceita.id = receitacorrente.idexecucaoreceita,
        (
        select max(execucaobimestral.idexecucaoreceita) iddaexecucaoreceita, nomemunicipio1, 
          mesexecucaoorcamentaria,
            datarecebimento1
          from execucaobimestral@dbl_lrf_tcemg04_mexico,
            (
              select distinct execucaoorcamentaria.id as iddaexecucaoorcamentaria, execucaoorcamentaria.mes as mesexecucaoorcamentaria, municipio.codigoibge as nomemunicipio1, datarecebimento1
                from municipio@dbl_lrf_tcemg04_mexico 
                  inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                  inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                  inner join execucaoorcamentaria@dbl_lrf_tcemg04_mexico on prestacao.id = execucaoorcamentaria.idprestacaolrfexecutivo,
                (
                select prestacao.id iddaprestacao, 
                  max(remessalrf.dataenvio) as datarecebimento1
                  from municipio@dbl_lrf_tcemg04_mexico 
                  inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
                  inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
                  inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
                  -- trocar o ano para o mesmo ano escolhido no exercício da prestação
                  where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
                  and remessalrf.dtbase = datalimite.dtbase
                  -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
                  --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
                  and municipio.codigoibge = :municipioSelecionado
                  group by prestacao.id
                )
              where iddaprestacao = prestacao.id
                -- escolher o exercício da prestação para filtrar por exercício - nao esquecer de trocar o remessalrf.dtbase
                and prestacao.exercicio = :exercicioSelecionado
              order by execucaoorcamentaria.mes
            )
          where iddaexecucaoorcamentaria = execucaobimestral.idexecucaoorcamentaria
          group by nomemunicipio1, mesexecucaoorcamentaria, datarecebimento1
          order by mesexecucaoorcamentaria
        )
        where execucaoreceita.id = iddaexecucaoreceita
          and receitacorrente.tiporeceita = 3
      )
    group by nomemunicipio1, datarecebimento1
    order by nomemunicipio1 asc
  ),
  (select sum(receitacorrenteliqmensalpl) as receitacorrenteliqpl,
      sum(despesamensaltotalpessoalpl) as despesatotalpessoalpl
    from 
    (select distinct itemcomparativopl.receitacorrenteliquida receitacorrenteliqmensalpl, 
        (despesamensalpessoal.vencimentosvantagens
          +despesamensalpessoal.inativos
          +despesamensalpessoal.pensionistas
          +despesamensalpessoal.salariofamilia
          +despesamensalpessoalcam.subsidiovereadores
          +despesamensalpessoal.obrigacoespatronais
          +despesamensalpessoal.repassepatronal
          +despesamensalpessoal.sentencasjudiciarias
          +despesamensalpessoal.outrasdespesaspessoal
          +despesamensalpessoal.despesasanteriores
          +despesamensalpessoal.despesasantcorrespondente
          +despesamensalpessoal.despesasanteriorescompetencia
          -despesamensalpessoal.inativos
          -despesamensalpessoal.pensionistas
          -despesamensalpessoal.indenizacoesdemissao
          -despesamensalpessoal.incentivosdemissaovoluntaria
          -despesamensalpessoal.sentencasjudiciariasanteriores
          -despesamensalpessoal.despesasantcorrespondente
          -despesamensalpessoal.despesasanterioresexclusao
        ) as despesamensaltotalpessoalpl,
        gestaofiscal.mes mes
      from
        gestaofiscal@dbl_lrf_tcemg04_mexico 
        inner join itemcomparativopl@dbl_lrf_tcemg04_mexico on itemcomparativopl.id = gestaofiscal.iditemcomparativo
        inner join despesamensalpessoal@dbl_lrf_tcemg04_mexico on despesamensalpessoal.id = iddespesamensalpessoal
        inner join despesamensalpessoalcam@dbl_lrf_tcemg04_mexico on despesamensalpessoalcam.id = despesamensalpessoal.id,
        (select prestacao.id iddaprestacao, 
          max(remessalrf.id) iddaremessalrf,
          max(remessalrf.dataenvio) as datarecebimento
          from municipio@dbl_lrf_tcemg04_mexico 
          inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idcamaravereadores = entidadeouorgaoap.id
          inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
          inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
          -- trocar o ano para o mesmo ano escolhido no exercício da prestação
          where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
          and remessalrf.dtbase = datalimite.dtbase
          -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
          --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
          and municipio.codigoibge = :municipioSelecionado
          group by prestacao.id
        )
      where gestaofiscal.idprestacaolrf = iddaprestacao
       -- and gestaofiscal.idremessalrf = iddaremessalrf -- removida pois estava trazendo apenas 2 sementre 
      order by gestaofiscal.mes
    )
  ),
  (select distinct (disponibilidadefinanceira.valorcaixa
        +disponibilidadefinanceira.valorbancomovimento
        +disponibilidadefinanceira.valorbancovinculadas
        +disponibilidadefinanceira.valoraplicfinanceiras
        +disponibilidadefinanceira.valoraplicfinancrecvinc
      ) as dispfinanceirapl,
      (inscricaorestosapagar.valorprocessado
        +inscricaorestosapagar.valornaoprocessado
      ) as valorprocenaoprocpl,
      inscricaorestosapagar.valorprocessado rpprocpl -- ad
    from
      gestaofiscal@dbl_lrf_tcemg04_mexico
      inner join disponibilidadefinanceira@dbl_lrf_tcemg04_mexico on disponibilidadefinanceira.id = gestaofiscal.iddisponibilidadefinanceira
      inner join inscricaorestosapagar@dbl_lrf_tcemg04_mexico on inscricaorestosapagar.id = gestaofiscal.idinscricaorestosapagar,
      (select prestacao.id iddaprestacao, 
        max(remessalrf.id) iddaremessalrf,
        max(remessalrf.dataenvio) as datarecebimento
        from municipio@dbl_lrf_tcemg04_mexico 
        inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idcamaravereadores = entidadeouorgaoap.id
        inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
        inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
        -- trocar o ano para o mesmo ano escolhido no exercício da prestação
        where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
        and remessalrf.dtbase = datalimite.dtbase
        -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
        --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
        and municipio.codigoibge = :municipioSelecionado
        group by prestacao.id
      )
    where gestaofiscal.idprestacaolrf = iddaprestacao
      and gestaofiscal.idremessalrf = iddaremessalrf
      and gestaofiscal.mes = 12
    order by gestaofiscal.mes
  ),
  (select distinct (disponibilidadefinanceira.valorcaixa
        +disponibilidadefinanceira.valorcaixarppsas
        +disponibilidadefinanceira.valorbancomovimento
        +disponibilidadefinanceira.valorbancomovimentorppsas
        +disponibilidadefinanceira.valorbancovinculadas       
        +disponibilidadefinanceira.valorbancovinculadasrppsas
        +disponibilidadefinanceira.valoraplicfinanceiras
        +disponibilidadefinanceira.valoraplicfinanceirasrppsas
        +disponibilidadefinanceira.valoraplicfinancrecvinc
        +disponibilidadefinanceira.valoraplicfinancrecvincrppsas
      ) as dispfinanceirape,
      (inscricaorestosapagar.valorprocessado
        +inscricaorestosapagar.valornaoprocessado
      ) as valorprocenaoprocpe
    FROM gestaofiscal@dbl_lrf_tcemg04_mexico
      inner join disponibilidadefinanceira@dbl_lrf_tcemg04_mexico on disponibilidadefinanceira.id = gestaofiscal.iddisponibilidadefinanceira
      inner join inscricaorestosapagar@dbl_lrf_tcemg04_mexico on inscricaorestosapagar.id = gestaofiscal.idinscricaorestosapagar,
      (select prestacao.id iddaprestacao, 
        max(remessalrf.id) iddaremessalrf,
        max(remessalrf.dataenvio) as datarecebimento
        from municipio@dbl_lrf_tcemg04_mexico 
        inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
        inner join prestacao@dbl_lrf_tcemg04_mexico on prestacao.identidadeouorgaoap = entidadeouorgaoap.id
        inner join remessalrf@dbl_lrf_tcemg04_mexico on prestacao.id = remessalrf.idprestacao, datalimite@dbl_lrf_tcemg04_mexico
        -- trocar o ano para o mesmo ano escolhido no exercício da prestação
        where TO_CHAR(remessalrf.dtbase,'DD/MM/YYYY') = '31/12/' || TO_CHAR(:exercicioSelecionado)
        and remessalrf.dtbase = datalimite.dtbase
        -- escolher se a próxima linha é <= para tempestivo, > para intempestivo ou retirar linha para igual para filtrar
        --and remessalrf.dataenvio <= datalimite@dbl_lrf_tcemg04_mexico.datalimiteenvio
        and municipio.codigoibge = :municipioSelecionado
        group by prestacao.id
      )
    where gestaofiscal.idprestacaolrf = iddaprestacao
      and gestaofiscal.idremessalrf = iddaremessalrf
      and gestaofiscal.mes = 12
    order by gestaofiscal.mes
  ),
  (select 
      (case 
        when (opcaosemestralidade.tipo = 3 and statusopcaosemestralidade.temopcao='S')
          then 'Optante'
        when (opcaosemestralidade.tipo = 3 and statusopcaosemestralidade.temopcao='N')
          then 'Perdeu o direito de optar'
        else 'Não optante'
        end
      ) as optante 
    from municipio@dbl_lrf_tcemg04_mexico 
      inner join entidadeouorgaoap@dbl_lrf_tcemg04_mexico on municipio.idprefeitura = entidadeouorgaoap.id
      inner join opcaosemestralidade@dbl_lrf_tcemg04_mexico on opcaosemestralidade.identidadeouorgaoap = entidadeouorgaoap.id
      inner join statusopcaosemestralidade@dbl_lrf_tcemg04_mexico on statusopcaosemestralidade.idopcaosemestralidade = opcaosemestralidade.id
    -- trocar o ano para o mesmo ano escolhido no exercício da prestação
    where to_char(statusopcaosemestralidade.dtbase, 'DD/MM/YYYY') = '31/12/' || :exercicioSelecionado
      and municipio.codigoibge = :municipioSelecionado
  )
 )                                                       
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
       ,SUM(lrf.vlr_div_con) AS vlr_div_con
       ,SUM(lrf.vlr_div_con_liq) AS vlr_div_con_liq
       ,SUM(lrf.prc_div_con_liq) AS prc_div_con_liq
       ,SUM(lrf.vlr_aro) AS vlr_aro
       ,SUM(lrf.prc_aro) AS prc_aro
       ,SUM(lrf.vlr_op_sem_aro) AS vlr_op_sem_aro
       ,SUM(lrf.prc_op_sem_aro) AS prc_op_sem_aro
       ,SUM(lrf.vlr_conc_grt) AS vlr_conc_grt
       ,SUM(lrf.prc_conc_grt) AS prc_conc_grt
       ,SUM(lrf.vlr_ins_rsp) AS vlr_ins_rsp
       ,SUM(lrf.vlr_disp_financ) AS vlr_disp_financ
       ,SUM(lrf.vlr_rcl) AS vlr_rcl
       ,SUM(lrf.vlr_rcl_aju) AS vlr_rcl_aju
       ,MAX(lrf.dta_pub_rel_lrf) AS dta_pub_rel_lrf
       ,MAX(lrf.dat_publicrgf) AS dat_publicrgf
       ,MAX(lrf.situacaorreo) AS situacaorreo
       ,MAX(lrf.situacaorgf) AS situacaorgf

      FROM(
          SELECT MAX(cod_municipio) AS cod_municipio
                ,MAX(ano) AS ano
                -- Despesa Total com Pessoal (Por poder)
                ,NVL(SUM(vlr_dsp_legislativo),0) AS vlr_dsp_legislativo
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_dsp_legislativo) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_leg
                ,NVL(SUM(vlr_dsp_executivo),0) AS vlr_dsp_executivo
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_dsp_executivo) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_exe
                ,NVL(SUM(vlr_dsp_total),0) AS vlr_dsp_total
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_dsp_total) / SUM(vlr_rcl_aju) ELSE 0 END,4) AS prc_dps_mun
                        
                -- Dívida Consolidada Líquida
                ,SUM(vlr_div_con) AS vlr_div_con     
                ,SUM(vlr_div_con_liq) AS vlr_div_con_liq
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_div_con_liq) / SUM(vlr_rcl) ELSE 0 END,4) AS prc_div_con_liq
                        
                -- Operação de Crédito por Antecipação da Receita Orçamentária – ARO       
                ,NVL(SUM(vlr_aro),0) AS vlr_aro
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_aro) / SUM(vlr_rcl) ELSE 0 END,4) AS prc_aro
                        
                -- Operações de Crédito (exceto ARO)      
                ,SUM(vlr_op_sem_aro) AS vlr_op_sem_aro
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_op_sem_aro) / SUM(vlr_rcl) ELSE 0 END,4) AS prc_op_sem_aro
                        
                -- Total das garantias concedidas     
                ,NVL(SUM(vlr_conc_grt),0) AS vlr_conc_grt
                ,ROUND(CASE WHEN SUM(vlr_rcl) > 0 THEN SUM(vlr_conc_grt) / sum(vlr_rcl) ELSE 0 END,4) AS prc_conc_grt
                        
                -- Inscrições de Restos a Pagar      
                ,NVL(SUM(vlr_ins_rsp),0) AS vlr_ins_rsp
                       
                -- Disponibilidades financeiras (Sem RPPS)     
                ,NVL(SUM(vlr_disp_financ),0) AS vlr_disp_financ
                  
                --RCL e RCL Ajustada
                ,NVL(SUM(vlr_rcl),0) AS vlr_rcl
                ,NVL(SUM(vlr_rcl_aju),0) AS vlr_rcl_aju
                        
                ,NULL AS dta_pub_rel_lrf
                ,NULL AS dat_publicrgf
                ,NULL AS situacaorreo
                ,NULL AS situacaorgf
                        
              FROM(
                  SELECT ot.numano AS ano
                        ,f.seqmun AS cod_municipio
                        ,SUM(CASE WHEN ot.nummes = :mesSelecionado THEN NVL((f.vlrreccorlqd),0) ELSE 0 END) as vlr_rcl
                        ,SUM(CASE WHEN ot.nummes = :mesSelecionado THEN NVL((f.vlrreccorlqdajs),0) ELSE 0 END) AS vlr_rcl_aju
                        ,SUM(CASE WHEN ot.nummes = 12 AND opo.codpdrorg = 1 THEN (NVL((f.vlrgstdsp),0) - NVL((f.vlrexlgst),0)) ELSE 0 END) AS vlr_dsp_legislativo
                        ,SUM(CASE WHEN ot.nummes = 12 AND opo.codpdrorg = 2 THEN (NVL((f.vlrgstdsp),0) - NVL((f.vlrexlgst),0)) ELSE 0 END) AS vlr_dsp_executivo
                        ,SUM(CASE WHEN ot.nummes = 12 THEN NVL((f.vlrgstdsp),0) ELSE 0 END) AS vlr_dsp_total
                        ,SUM(CASE WHEN ot.nummes = 12 THEN NVL((f.vlrdivcos),0) ELSE 0 END) AS vlr_div_con
                        ,SUM(CASE WHEN ot.nummes = 12 THEN NVL((f.vlrdivcoslqd),0) ELSE 0 END) AS vlr_div_con_liq
                        ,SUM(CASE WHEN ot.nummes = 12 THEN NVL((f.vlraro),0) ELSE 0 END) AS vlr_aro
                        ,SUM (NVL((f.vlroprsemaro),0)) AS vlr_op_sem_aro
                        ,SUM(CASE WHEN ot.nummes = 12 THEN NVL((f.vlrcongrt),0) ELSE 0 END) AS vlr_conc_grt
                        ,SUM (NVL((f.vlriscrsp),0)) AS vlr_ins_rsp
                        ,SUM(CASE WHEN ot.nummes = 12 THEN NVL((f.vlrdsnfin),0) ELSE 0 END) AS vlr_disp_financ
                            
                   FROM bi_lrf.fatlrfana f
                    INNER JOIN bi_lrf.odspdrorg opo ON f.seqpdrorg = opo.seqpdrorg
                    INNER JOIN bi_sicom.odstmp ot   ON f.seqodstmp = ot.seqodstmp
                   WHERE f.datfotlrf = :dataSelecionada
                     AND ot.numano = :exercicioSelecionado
                     AND f.seqmun = :municipioSelecionado
                   GROUP BY ot.numano
                           ,f.seqmun
                  )
              
          UNION ALL
                       
          -- data e situação da publicação do rreo
          SELECT oppl.codmun AS cod_municipio
                ,to_number(:exercicioSelecionado) AS ano
                ,0 AS vlr_dsp_legislativo
                ,0 AS prc_dps_leg
                ,0 AS vlr_dsp_executivo
                ,0 AS prc_dps_exe
                ,0 AS vlr_dsp_total
                ,0 AS prc_dps_mun
                ,0 AS vlr_div_con
                ,0 AS vlr_div_con_liq
                ,0 AS prc_div_con_liq
                ,0 AS vlr_aro
                ,0 AS prc_aro
                ,0 AS vlr_op_sem_aro
                ,0 AS prc_op_sem_aro
                ,0 AS vlr_conc_grt
                ,0 AS prc_conc_grt
                ,0 AS vlr_ins_rsp
                ,0 AS vlr_disp_financ
                ,0 AS vlr_rcl
                ,0 AS vlr_rcl_aju 
                ,to_char(oppl.datpubrltlrf, 'DD/MM/YYYY') as dta_pub_rel_lrf
                ,NULL AS dat_publicrgf
                ,CASE WHEN to_number(to_char(oppl.datpubrltlrf, 'YYYYMMDD')) <= to_number((:exercicioSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                      WHEN to_number(to_char(oppl.datpubrltlrf, 'YYYYMMDD')) > to_number((:exercicioSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Intempestivo' 
                      ELSE 'Não Informou' END AS situacaorreo
                ,NULL AS situacaorgf
            FROM bi_sicom.odspubperlrf oppl
              INNER JOIN bi_sicom.tblremhst trh ON trh.codacp = oppl.codacp
              INNER JOIN bi_sicom.odsorg oo      ON trh.seqorg = oo.seqorg
            WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
              AND trh.numanorem || LPAD(trh.nummesrem,2,0) >= :exercicioSelecionado || LPAD(:mesSelecionado, 2, 0)
              AND (oppl.numbim = DECODE(:mesSelecionado, 2, 1, 4, 2, 6, 3, 8, 4, 10, 5, 12, 6))
              AND oppl.numexrtpobim = :exercicioSelecionado
              AND oppl.codmun NOT IN (0, 9999999, 123456, 654321)
              AND oo.codmun = :municipioSelecionado
              AND trh.numanorem IN (:exercicioSelecionado, :exercicioSelecionado + 1)
              
          UNION ALL
              
          -- data e situação da publicação do rgf
          SELECT cod_municipio
                ,to_number(:exercicioSelecionado) AS ano
                ,0 AS vlr_dsp_legislativo
                ,0 AS prc_dps_leg
                ,0 AS vlr_dsp_executivo
                ,0 AS prc_dps_exe
                ,0 AS vlr_dsp_total
                ,0 AS prc_dps_mun
                ,0 AS vlr_div_con
                ,0 AS vlr_div_con_liq
                ,0 AS prc_div_con_liq
                ,0 AS vlr_aro
                ,0 AS prc_aro
                ,0 AS vlr_op_sem_aro
                ,0 AS prc_op_sem_aro
                ,0 AS vlr_conc_grt
                ,0 AS prc_conc_grt
                ,0 AS vlr_ins_rsp
                ,0 AS vlr_disp_financ
                ,0 AS vlr_rcl
                ,0 AS vlr_rcl_aju
                ,NULL AS dta_pub_rel_lrf
                ,NVL(to_char(dat_publicrgf, 'DD/MM/YYYY'),'-') AS dat_publicrgf
                ,NULL AS situacaorreo
                ,CASE WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) <= to_number((:exercicioSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Tempestivo'              
                      WHEN to_number(to_char(dat_publicrgf, 'YYYYMMDD')) > to_number((:exercicioSelecionado +1 || LPAD(01, 2, 0) || 31)) THEN 'Intempestivo' 
                      ELSE 'Não Informou' END AS situacaorgf
           FROM (
                SELECT opprl.codmun AS cod_municipio
                      ,DECODE(:mesSelecionado, 4, '30/04', 6, '30/06', 8, '31/08','31/12') AS num_per_bimestre
                      ,MAX(CASE WHEN opprl.indpubrgf = 1 
                              AND to_number(to_char(opprl.datpubrgf,'YYYYMM')) > to_number(:exercicioSelecionado || LPAD(:mesSelecionado,2,0)) 
                              AND opprl.numexrtpoper = :exercicioSelecionado
                              AND oo.codtpoorg = '2'
                              AND DECODE(opprl.codtpoper,1, 6 -- 1º semestre
                                                        ,2,12 -- 2º semestre
                                                        ,3, 4 -- 1º quadrimestre
                                                        ,4, 8 -- 2º quadrimestre                                     
                                                        ,5,12) IN (:mesSelecionado) THEN opprl.datpubrgf END) AS dat_publicrgf                                                                                         
                 FROM bi_sicom.odspubperrgflrf opprl -- tabela criada para atender leiaute de 2018
                   INNER JOIN bi_sicom.tblremhst trh   ON trh.codacp = opprl.codacp
                   INNER JOIN bi_sicom.odsorg oo       ON oo.seqorg = trh.seqorg
                   INNER JOIN bi_lrf.tblsmtlrfcon tslc ON tslc.codmun = opprl.codmun
                 WHERE :dataSelecionada BETWEEN trh.datini AND trh.datfim
                   AND opprl.codmun NOT IN (0, 9999999, 123456, 654321)
                   AND trh.numanorem || LPAD(trh.nummesrem,2,0) >= :exercicioSelecionado || LPAD(:mesSelecionado, 2, 0)
                   AND oo.codmun = :municipioSelecionado
                   -- regra semestralidade
                   AND tslc.datfotlrf = :dataSelecionada
                   AND tslc.numano = :exercicioSelecionado
                   AND tslc.nummes = :mesSelecionado                   
                 GROUP BY opprl.codmun
                 ORDER by opprl.codmun
                )
      )lrf
)lrf on lrf.cod_municipio = siace.codmunicipio
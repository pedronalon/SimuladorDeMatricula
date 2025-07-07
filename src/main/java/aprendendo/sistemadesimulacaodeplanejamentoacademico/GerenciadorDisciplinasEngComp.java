package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class GerenciadorDisciplinasEngComp {


    public GerenciadorDisciplinasEngComp(){}


    public MatrizCurricular criarCurso(){
        MatrizCurricular matrizEngenhariaComputacinoal = new MatrizCurricular("Engenharia Computacional",65);
        this.disciplinasObrigatoriasEngComp(matrizEngenhariaComputacinoal);

        return  matrizEngenhariaComputacinoal;
    }

    private void disciplinasObrigatoriasEngComp(MatrizCurricular matriz) {
        // 1º Período
        Disciplina calculoI = new DisciplinaObrigatoria("CÁLCULO I", "MAT154", 4);
        Disciplina geometriaAnalitica = new DisciplinaObrigatoria("GEOMETRIA ANALÍTICA E SISTEMAS LINEARES", "MAT156", 4);
        Disciplina labIntroducaoCienciasFisica = new DisciplinaObrigatoria("LABORATÓRIO DE INTRODUÇÃO ÀS CIÊNCIAS FÍSICAS", "FIS122", 2);
        Disciplina quimicaFundamental = new DisciplinaObrigatoria("QUÍMICA FUNDAMENTAL", "QUI125", 4);
        Disciplina labQuimica = new DisciplinaObrigatoria("LABORATÓRIO DE QUÍMICA", "QUI126", 2);
        Disciplina introCienciasExatas = new DisciplinaObrigatoria("INTRODUÇÃO ÀS CIÊNCIAS EXATAS", "ICE001", 2);
        Disciplina algoritmosI = new DisciplinaObrigatoria("ALGORITMOS I", "DCC199", 4);
        Disciplina algoritmosIPratica = new DisciplinaObrigatoria("ALGORITMOS I - PRÁTICA", "DC5199", 2);

        algoritmosI.adicionarCoRequisito(algoritmosIPratica);
        algoritmosIPratica.adicionarCoRequisito(algoritmosI);

        matriz.adicionarDisciplina(calculoI);
        matriz.adicionarDisciplina(geometriaAnalitica);
        matriz.adicionarDisciplina(labIntroducaoCienciasFisica);
        matriz.adicionarDisciplina(quimicaFundamental);
        matriz.adicionarDisciplina(labQuimica);
        matriz.adicionarDisciplina(introCienciasExatas);
        matriz.adicionarDisciplina(algoritmosI);
        matriz.adicionarDisciplina(algoritmosIPratica);

// 2º Período
        Disciplina calculoII = new DisciplinaObrigatoria("CÁLCULO II", "MAT156", 4);
        Disciplina introEstatistica = new DisciplinaObrigatoria("INTRODUÇÃO À ESTATÍSTICA", "EST028", 4);
        Disciplina algoritmosII = new DisciplinaObrigatoria("ALGORITMOS II", "DCCXX1", 4);
        Disciplina algoritmosIIPratica = new DisciplinaObrigatoria("ALGORITMOS II - PRÁTICA", "DCC5X1", 2);
        Disciplina fisicaI = new DisciplinaObrigatoria("FÍSICA I", "FI8073", 4);
        Disciplina labFisicaI = new DisciplinaObrigatoria("LABORATÓRIO DE FÍSICA I", "F15077", 2);
        Disciplina labTransformacoesQuimicas = new DisciplinaObrigatoria("TRANSFORMAÇÕES QUÍMICAS", "QUI168", 2);
        Disciplina introducaoEngComp = new DisciplinaObrigatoria("INTRODUÇÃO À ENGENHARIA COMPUTACIONAL", "MAC011", 2);

        matriz.adicionarDisciplina(calculoII);
        calculoII.adicionarMultiplosPreRequisitos(geometriaAnalitica, calculoI);

        matriz.adicionarDisciplina(introEstatistica);
        introEstatistica.adicionarPreRequisito(new ValidadorSimples(calculoI.getCodigo()));

        matriz.adicionarDisciplina(algoritmosII);
        matriz.adicionarDisciplina(algoritmosIIPratica);

        algoritmosII.adicionarPreRequisito(new ValidadorSimples(algoritmosI.getCodigo()));
        algoritmosIIPratica.adicionarPreRequisito(new ValidadorSimples(algoritmosI.getCodigo()));

        algoritmosII.adicionarCoRequisito(algoritmosIIPratica);
        algoritmosIIPratica.adicionarCoRequisito(algoritmosII);

        matriz.adicionarDisciplina(fisicaI);
        matriz.adicionarDisciplina(labFisicaI);
        labFisicaI.adicionarPreRequisito(new ValidadorSimples(labIntroducaoCienciasFisica.getCodigo()));

        matriz.adicionarDisciplina(labTransformacoesQuimicas);
        labTransformacoesQuimicas.adicionarPreRequisito(new ValidadorSimples(labQuimica.getCodigo()));
        matriz.adicionarDisciplina(introducaoEngComp);

        // 3º Período
        Disciplina calcProbabilidadeI = new DisciplinaObrigatoria("CÁLCULO DE PROBABILIDADE I", "EST029", 4);
        Disciplina orientacaoObjetos = new DisciplinaObrigatoria("ORIENTAÇÃO A OBJETOS", "DCC025", 4);
        Disciplina fisicaII = new DisciplinaObrigatoria("FÍSICA II", "F18074", 4);
        Disciplina representacaoGrafica = new DisciplinaObrigatoria("REPRESENTAÇÃO GRÁFICA E MODELAGEM GEOMÉTRICA", "MAC036", 2);
        Disciplina calculoIII = new DisciplinaObrigatoria("CÁLCULO III", "MAT157", 4);
        Disciplina estruturaDadosI = new DisciplinaObrigatoria("ESTRUTURA DE DADOS", "DCC013", 4);

        matriz.adicionarDisciplina(calcProbabilidadeI);
        calcProbabilidadeI.adicionarPreRequisito(new ValidadorSimples(calculoII.getCodigo()));

        matriz.adicionarDisciplina(orientacaoObjetos);
        orientacaoObjetos.adicionarPreRequisito(new ValidadorSimples(algoritmosII.getCodigo()));

        matriz.adicionarDisciplina(fisicaII);
        fisicaII.adicionarMultiplosPreRequisitos(fisicaI, calculoII);

        matriz.adicionarDisciplina(representacaoGrafica);
        representacaoGrafica.adicionarPreRequisito(new ValidadorSimples(geometriaAnalitica.getCodigo()));

        matriz.adicionarDisciplina(calculoIII);
        calculoIII.adicionarPreRequisito(new ValidadorSimples(calculoII.getCodigo()));

        matriz.adicionarDisciplina(estruturaDadosI);
        estruturaDadosI.adicionarPreRequisito(new ValidadorSimples(algoritmosII.getCodigo()));

        // 4º Período
        Disciplina estruturaDadosII = new DisciplinaObrigatoria("ESTRUTURA DE DADOS II", "DCC012", 4);
        Disciplina calculoNumerico = new DisciplinaObrigatoria("CÁLCULO NUMÉRICO", "DCC008", 4);
        Disciplina equacoesDiferenciaisI = new DisciplinaObrigatoria("EQUAÇÕES DIFERENCIAIS I", "MAT029", 4);
        Disciplina algebraLinear = new DisciplinaObrigatoria("ÁLGEBRA LINEAR", "MAT158", 4);
        Disciplina resistenciaDosMateriais = new DisciplinaObrigatoria("RESISTÊNCIA DOS MATERIAIS", "MAC015", 4);
        Disciplina fisicaIII = new DisciplinaObrigatoria("FÍSICA III", "F18075", 4);

        matriz.adicionarDisciplina(estruturaDadosII);
        estruturaDadosII.adicionarPreRequisito(new ValidadorSimples(estruturaDadosI.getCodigo()));

        matriz.adicionarDisciplina(calculoNumerico);
        calculoNumerico.adicionarMultiplosPreRequisitos(algoritmosI, calculoII);

        matriz.adicionarDisciplina(equacoesDiferenciaisI);
        equacoesDiferenciaisI.adicionarPreRequisito(new ValidadorSimples(calculoII.getCodigo()));

        matriz.adicionarDisciplina(algebraLinear);
        algebraLinear.adicionarPreRequisito(new ValidadorSimples(geometriaAnalitica.getCodigo()));

        matriz.adicionarDisciplina(resistenciaDosMateriais);
        resistenciaDosMateriais.adicionarMultiplosPreRequisitos(fisicaI, calculoIII);

        matriz.adicionarDisciplina(fisicaIII);
        fisicaIII.adicionarMultiplosPreRequisitos(fisicaII, calculoIII);

        // 5º Período
        Disciplina teoriaGrafos = new DisciplinaObrigatoria("TEORIA DOS GRAFOS", "DCC059", 4);
        Disciplina circuitosDigitais = new DisciplinaObrigatoria("CIRCUITOS DIGITAIS", "DCC122", 4);
        Disciplina fenomenosTransporte = new DisciplinaObrigatoria("FENÔMENOS DE TRANSPORTE", "FISDB1", 4);
        Disciplina fundamentosMecanica = new DisciplinaObrigatoria("FUNDAMENTOS DE MECÂNICA DAS ESTRUTURAS", "MAC019", 4);
        Disciplina introModelagemComputacional = new DisciplinaObrigatoria("INTRODUÇÃO À MODELAGEM COMPUTACIONAL", "MAC024", 4);
        Disciplina introMetodosDiscretos = new DisciplinaObrigatoria("INTRODUÇÃO AOS MÉTODOS DISCRETOS", "MAC028", 4);

        matriz.adicionarDisciplina(teoriaGrafos);
        teoriaGrafos.adicionarPreRequisito(new ValidadorSimples(estruturaDadosI.getCodigo()));

        matriz.adicionarDisciplina(circuitosDigitais);

        matriz.adicionarDisciplina(fenomenosTransporte);
        fenomenosTransporte.adicionarPreRequisito(new ValidadorSimples(fisicaII.getCodigo()));

        matriz.adicionarDisciplina(fundamentosMecanica);
        ///fundamentosMecanica.adicionarMultiplosPreRequisitos(calculoNumerico, MAC010 (Mecânica(não achei a equivalência dela)));
        matriz.adicionarDisciplina(introModelagemComputacional);
        introModelagemComputacional.adicionarPreRequisito(new ValidadorSimples(calculoNumerico.getCodigo()));

        matriz.adicionarDisciplina(introMetodosDiscretos);
        introMetodosDiscretos.adicionarMultiplosPreRequisitos(calculoNumerico, equacoesDiferenciaisI);

        // 6º Período
        Disciplina organizacaoDeComputadores = new DisciplinaObrigatoria("ORGANIZAÇÃO DE COMPUTADORES", "DCC870", 4);
        Disciplina modelagemSistemas = new DisciplinaObrigatoria("MODELAGEM DE SISTEMAS", "DCC117", 4);
        Disciplina elementosFinitos = new DisciplinaObrigatoria("INTRODUÇÃO AO MÉTODO DOS ELEMENTOS FINITOS", "MAC008", 4);
        Disciplina mecanicaSolidosI = new DisciplinaObrigatoria("MECÂNICA DOS SÓLIDOS I", "MACOOS", 4);

        matriz.adicionarDisciplina(organizacaoDeComputadores);
        organizacaoDeComputadores.adicionarPreRequisito(new ValidadorSimples(circuitosDigitais.getCodigo()));

        matriz.adicionarDisciplina(modelagemSistemas);
        modelagemSistemas.adicionarPreRequisito(new ValidadorSimples(orientacaoObjetos.getCodigo()));

        matriz.adicionarDisciplina(elementosFinitos);
        elementosFinitos.adicionarPreRequisito(new ValidadorSimples(resistenciaDosMateriais.getCodigo()));

        matriz.adicionarDisciplina(mecanicaSolidosI);
        mecanicaSolidosI.adicionarPreRequisito(new ValidadorSimples(fundamentosMecanica.getCodigo()));

        // 7º Período
        Disciplina analiseAlgoritmos = new DisciplinaObrigatoria("ANÁLISE E PROJETO DE ALGORITMOS", "DCC001", 4);
        Disciplina bancoDeDados = new DisciplinaObrigatoria("BANCO DE DADOS", "DCC060", 4);
        Disciplina sistemasOperacionais = new DisciplinaObrigatoria("SISTEMAS OPERACIONAIS", "DCC662", 4);
        Disciplina topicosModelagem = new DisciplinaObrigatoria("TÓPICOS AVANÇADOS EM MODELAGEM GEOMÉTRICA COMPUTACIONAL", "MAC037", 2);

        matriz.adicionarDisciplina(analiseAlgoritmos);
        analiseAlgoritmos.adicionarPreRequisito(new ValidadorSimples(estruturaDadosI.getCodigo()));

        matriz.adicionarDisciplina(bancoDeDados);
        bancoDeDados.adicionarPreRequisito(new ValidadorSimples(modelagemSistemas.getCodigo()));

        matriz.adicionarDisciplina(sistemasOperacionais);
        sistemasOperacionais.adicionarPreRequisito(new ValidadorSimples(organizacaoDeComputadores.getCodigo()));

        matriz.adicionarDisciplina(topicosModelagem);
        topicosModelagem.adicionarPreRequisito(new ValidadorSimples(representacaoGrafica.getCodigo()));

        // 8º Período
        Disciplina redesDeComputadores = new DisciplinaObrigatoria("REDES DE COMPUTADORES", "DCC042", 4);
        Disciplina metodosComputacionais = new DisciplinaObrigatoria("MÉTODOS COMPUTACIONAIS APLICADOS EM ENGENHARIA", "MAC035", 2);
        Disciplina metodosComputacionaisPratica = new DisciplinaObrigatoria("MÉTODOS COMPUTACIONAIS APLICADOS EM ENGENHARIA PRÁTICA", "MAC534", 0);
        Disciplina pesquisaOperacional = new DisciplinaObrigatoria("PESQUISA OPERACIONAL", "DCC163", 4);
        Disciplina trabalhoMultidisciplinar = new DisciplinaObrigatoria("TRABALHO MULTIDISCIPLINAR", "MAC034", 4);

        matriz.adicionarDisciplina(redesDeComputadores);
        redesDeComputadores.adicionarPreRequisito(new ValidadorSimples(organizacaoDeComputadores.getCodigo()));

        matriz.adicionarDisciplina(metodosComputacionais);
        metodosComputacionais.adicionarMultiplosPreRequisitos(elementosFinitos, introMetodosDiscretos);

        matriz.adicionarDisciplina(metodosComputacionaisPratica);
        metodosComputacionaisPratica.adicionarMultiplosPreRequisitos(elementosFinitos, introMetodosDiscretos);

        matriz.adicionarDisciplina(pesquisaOperacional);
        pesquisaOperacional.adicionarPreRequisito(new ValidadorSimples(algebraLinear.getCodigo()));

        matriz.adicionarDisciplina(trabalhoMultidisciplinar);
        trabalhoMultidisciplinar.adicionarPreRequisito(new ValidadorSimples(calculoNumerico.getCodigo()));

        // 9º Período
        Disciplina programacaoParalela = new DisciplinaObrigatoria("PROGRAMAÇÃO PARALELA", "DCC125", 4);
        Disciplina trabalhoMultidisciplinarAplicado = new DisciplinaObrigatoria("TRABALHO MULTIDISCIPLINAR APLICADO", "OCC156", 2);
        Disciplina ecologia = new DisciplinaObrigatoria("ECOLOGIA E PRESERVAÇÃO DO AMBIENTE", "ESA002", 2);
        Disciplina tccI = new DisciplinaObrigatoria("TRABALHO FINAL DE CURSO I", "MACXX1", 2);

        matriz.adicionarDisciplina(programacaoParalela);
        programacaoParalela.adicionarPreRequisito(new ValidadorSimples(sistemasOperacionais.getCodigo()));

        matriz.adicionarDisciplina(trabalhoMultidisciplinarAplicado);
        trabalhoMultidisciplinarAplicado.adicionarPreRequisito(new ValidadorSimples(trabalhoMultidisciplinar.getCodigo()));

        matriz.adicionarDisciplina(ecologia);
        ecologia.adicionarPreRequisito(new ValidadorSimples(quimicaFundamental.getCodigo()));

        matriz.adicionarDisciplina(tccI);

        // 10º Período
        Disciplina tccII = new DisciplinaObrigatoria("TRABALHO FINAL DE CURSO II", "MACXX2", 2);
        matriz.adicionarDisciplina(tccII);
        tccII.adicionarPreRequisito(new ValidadorSimples(tccI.getCodigo()));

        // eletivas


        Disciplina inteligenciaArtificial = new DisciplinaEletiva("INTELIGÊNCIA ARTIFICIAL", "DCC014", 4);
        Disciplina redesNeuraisArtificiais = new DisciplinaEletiva("REDES NEURAIS ARTIFICIAIS", "DCC068", 4);
        Disciplina mecanicaDosFluidos = new DisciplinaEletiva("MECANICA DOS FLUDOS", "ESA003", 4);
        Disciplina mecanicaDosFluidosPratica = new DisciplinaEletiva("MECÂNICA DOS FLUDOS PRÁTICA", "ESA503", 2);
        Disciplina mineracaoDeDados = new DisciplinaEletiva("MINERAÇÃO DE DADOS", "DCC127", 4);
        Disciplina imunologiaComputacional = new DisciplinaEletiva("IMUNOLOGA COMPUTACIONAL", "DCC211", 4);
        Disciplina processamentoDeImagens = new DisciplinaEletiva("PROCESSAMENTO DE IMAGENS" , "DCC066" , 4) ;


        matriz.adicionarDisciplina(inteligenciaArtificial);
        inteligenciaArtificial.adicionarPreRequisito(new ValidadorSimples(teoriaGrafos.getCodigo()));

        matriz.adicionarDisciplina(redesNeuraisArtificiais);
        redesNeuraisArtificiais.adicionarPreRequisito(new ValidadorSimples(teoriaGrafos.getCodigo()));

        matriz.adicionarDisciplina(mecanicaDosFluidos);
        matriz.adicionarDisciplina(mecanicaDosFluidosPratica);
        mecanicaDosFluidos.adicionarPreRequisito(new ValidadorSimples(fenomenosTransporte.getCodigo()));
        mecanicaDosFluidos.adicionarCoRequisito(mecanicaDosFluidosPratica);
        mecanicaDosFluidosPratica.adicionarCoRequisito(mecanicaDosFluidos);

        matriz.adicionarDisciplina(mineracaoDeDados);


        matriz.adicionarDisciplina(imunologiaComputacional);
        imunologiaComputacional.adicionarPreRequisito(new ValidadorSimples(calculoNumerico.getCodigo()));

        matriz.adicionarDisciplina(processamentoDeImagens);
        processamentoDeImagens.adicionarMultiplosPreRequisitos(algoritmosI,algebraLinear);

        //optativas

        Disciplina inglesInstrumental = new DisciplinaOptativa("INGLÊS INSTRUMENTAL", "EADDCC011", 4) ;
        Disciplina analiseI = new DisciplinaOptativa("ANÁLISE I", "MAT147" , 4) ;
        Disciplina introAsvariaveisComplexas = new DisciplinaOptativa("INTRODUÇÃO ÀS VARIÁVEIS COMPLEXAS" ,"MAT031",4);
        Disciplina fundamentosDaMatElementar = new DisciplinaOptativa("FUNDAMENTOS DA MATEMÁTICA ELEMENTAR","MAT133",4) ;


        matriz.adicionarDisciplina(inglesInstrumental);

        matriz.adicionarDisciplina(fundamentosDaMatElementar);

        matriz.adicionarDisciplina(introAsvariaveisComplexas);
        introAsvariaveisComplexas.adicionarPreRequisito(new ValidadorSimples(equacoesDiferenciaisI.getCodigo()));

        matriz.adicionarDisciplina(analiseI);
        analiseI.adicionarMultiplosPreRequisitos(fundamentosDaMatElementar,calculoII);


    }

}


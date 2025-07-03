package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorCursos {
    private Map<String, MatrizCurricular> cursos;

    public GerenciadorCursos(){
        this.cursos = new HashMap<>();
    }

    public void criarCurso(String nomeDoCurso, int codigoDoCurso){}

    private void disciplinasObrigatoriasEngComp(MatrizCurricular matriz){
        // 1º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("CÁLCULO I", "MAT154", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("GEOMETRIA ANALÍTICA E SISTEMAS LINEARES", "MAT156", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("LABORATÓRIO DE INTRODUÇÃO ÀS CIÊNCIAS FÍSICAS", "FIS122", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("QUÍMICA FUNDAMENTAL", "QUI125", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("LABORATÓRIO DE QUÍMICA", "QUI126", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("INTRODUÇÃO ÀS CIÊNCIAS EXATAS", "ICE001", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ALGORITMOS I", "DCC199", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ALGORITMOS I - PRÁTICA", "DC5199", 2));

// 2º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("CÁLCULO II", "MAT156", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("INTRODUÇÃO À ESTATÍSTICA", "EST028", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ALGORITMOS II", "DCCXX1", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ALGORITMOS II - PRÁTICA", "DCC5X1", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("FÍSICA I", "FI8073", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("LABORATÓRIO DE FÍSICA I", "F15077", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TRANSFORMAÇÕES QUÍMICAS", "QUI168", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("INTRODUÇÃO À ENGENHARIA COMPUTACIONAL", "MAC011", 2));

// 3º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("CÁLCULO DE PROBABILIDADE I", "EST029", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ORIENTAÇÃO A OBJETOS", "DCC025", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("FÍSICA II", "F18074", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("REPRESENTAÇÃO GRÁFICA E MODELAGEM GEOMÉTRICA", "MAC036", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("CÁLCULO III", "MAT157", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ESTRUTURA DE DADOS", "DCC013", 4));

// 4º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ESTRUTURA DE DADOS II", "DCC012", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("CÁLCULO NUMÉRICO", "DCC008", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("EQUAÇÕES DIFERENCIAIS I", "MAT029", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ÁLGEBRA LINEAR", "MAT158", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("RESISTÊNCIA DOS MATERIAIS", "MAC015", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("FÍSICA III", "F18075", 4));

// 5º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TEORIA DOS GRAFOS", "DCC059", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("CIRCUITOS DIGITAIS", "DCC122", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("FENÔMENOS DE TRANSPORTE", "FISDB1", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("FUNDAMENTOS DE MECÂNICA DAS ESTRUTURAS", "MAC019", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("INTRODUÇÃO À MODELAGEM COMPUTACIONAL", "MAC024", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("INTRODUÇÃO AOS MÉTODOS DISCRETOS", "MAC028", 4));

// 6º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ORGANIZAÇÃO DE COMPUTADORES", "DCC870", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("MODELAGEM DE SISTEMAS", "DCC117", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("INTRODUÇÃO AO MÉTODO DOS ELEMENTOS FINITOS", "MAC008", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("MECÂNICA DOS SÓLIDOS I", "MACOOS", 4));

// 7º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ANÁLISE E PROJETO DE ALGORITMOS", "DCC001", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("BANCO DE DADOS", "DCC060", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("SISTEMAS OPERACIONAIS", "DCC662", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TÓPICOS AVANÇADOS EM MODELAGEM GEOMÉTRICA COMPUTACIONAL", "MAC037", 2));

// 8º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("REDES DE COMPUTADORES", "DCC042", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("MÉTODOS COMPUTACIONAIS APLICADOS EM ENGENHARIA", "MAC035", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("PESQUISA OPERACIONAL", "DCC163", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TRABALHO MULTIDISCIPLINAR", "MAC034", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("MÉTODOS COMPUTACIONAIS APLICADOS EM ENGENHARIA PRÁTICA", "MAC534", 0));

// 9º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("PROGRAMAÇÃO PARALELA", "DCC125", 4));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TRABALHO MULTIDISCIPLINAR APLICADO", "OCC156", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("ECOLOGIA E PRESERVAÇÃO DO AMBIENTE", "ESA002", 2));
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TRABALHO FINAL DE CURSO I", "MACXX1", 2));

// 10º Período
        matriz.adicionarDisciplina(new DisciplinaObrigatoria("TRABALHO FINAL DE CURSO II", "MACXX2", 2));

    }

    public MatrizCurricular getCurso(String nomeCurso) {
        return cursos.get(nomeCurso);
    }

    public List<String> listarCursos(){
        return new ArrayList<>(cursos.keySet());
    }
}


package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class GerenciadorSistema {

    public static SistemaAcademico carregarSistema(){
        SistemaAcademico sistema = new SistemaAcademico();
        GerenciadorCursos gerenciadorCursos = new GerenciadorCursos();
        MatrizCurricular ENGENHARIA_COMPUTACIONAL = new MatrizCurricular(65, "Engenharia Computacional");

        gerenciadorCursos.criarCurso("Engenharia Computacional", 65);
        return sistema;
    }
}

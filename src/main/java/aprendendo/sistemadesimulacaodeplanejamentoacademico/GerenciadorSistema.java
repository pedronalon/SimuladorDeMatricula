package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class GerenciadorSistema {

    public static SistemaAcademico carregarSistema(){
        SistemaAcademico sistema = new SistemaAcademico();

        GerenciadorDisciplinasEngComp gerenciadorEngComp = new GerenciadorDisciplinasEngComp();

        MatrizCurricular ENGENHARIA_COMPUTACIONAL = gerenciadorEngComp.criarCurso();
        sistema.adicionarMatrizCurricular(ENGENHARIA_COMPUTACIONAL);

        for(Disciplina disciplinas : ENGENHARIA_COMPUTACIONAL.getCatalogoDisciplinas()){
          //  sistema.adicionar
        }
        return sistema;
    }
}

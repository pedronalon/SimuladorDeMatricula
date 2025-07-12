package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class SetupSistema {

    /**
     * Cria e configura uma instância completa do SistemaAcademico.
     * @return um objeto SistemaAcademico populado com cursos, disciplinas e turmas.
     */
    public static SistemaAcademico carregarSistema() {
        // 1. Cria a instância do sistema
        SistemaAcademico sistema = new SistemaAcademico();

        // 2. Cria a matriz curricular do curso de Engenharia Computacional
        GerenciadorDisciplinasEngComp gerenciador = new GerenciadorDisciplinasEngComp();
        MatrizCurricular engComp = gerenciador.criarCurso();

        // 3. Adiciona a matriz ao sistema (usando o método público)
        sistema.adicionarMatrizCurricular(engComp);

        // 4. Popula o sistema com turmas disponíveis para as disciplinas da matriz
        popularTurmas(sistema, engComp);

        // Retorna o sistema pronto para ser usado
        return sistema;
    }

    /**
     * Método auxiliar privado para criar turmas e adicioná-las ao sistema.
     */
    private static void popularTurmas(SistemaAcademico sistema, MatrizCurricular matriz) {
        // Adicionando turmas usando o método público sistema.adicionarTurma()

        // Disciplina: CÁLCULO II (MAT156)
        sistema.adicionarTurma(new Turma("T1_CALC2", matriz.getDisciplina("MAT156"), 30, "TER 10:00-12:00"));

        // Disciplina: ORIENTAÇÃO A OBJETOS (DCC025)
        sistema.adicionarTurma(new Turma("T1_POO", matriz.getDisciplina("DCC025"), 25, "SEG 08:00-10:00"));

        // Disciplina: ALGORITMOS II (DCCXX1) e sua prática (DCC5X1)
        sistema.adicionarTurma(new Turma("T1_ALGO2", matriz.getDisciplina("DCCXX1"), 2, "QUA 14:00-16:00")); // Turma com poucas vagas para teste
        sistema.adicionarTurma(new Turma("T1_ALGO2P", matriz.getDisciplina("DCC5X1"), 2, "SEX 14:00-16:00")); // Co-requisito de ALGO2
    }
}
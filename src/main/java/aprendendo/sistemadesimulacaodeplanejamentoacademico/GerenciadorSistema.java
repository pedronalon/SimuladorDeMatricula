package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class GerenciadorSistema {

    public static SistemaAcademico carregarSistema(){
        SistemaAcademico sistema = new SistemaAcademico();

        GerenciadorDisciplinasEngComp gerenciadorEngComp = new GerenciadorDisciplinasEngComp();

        MatrizCurricular ENGENHARIA_COMPUTACIONAL = gerenciadorEngComp.criarCurso();
        sistema.adicionarMatrizCurricular(ENGENHARIA_COMPUTACIONAL);

        popularTurmas(sistema, ENGENHARIA_COMPUTACIONAL);
        return sistema;
    }


    private static void popularTurmas(SistemaAcademico sistema, MatrizCurricular matriz) {

        /// Disciplinas primeiro periodo
        Turma mat154_A = new Turma("MAT154-A", matriz.getDisciplina("MAT154"), 2);
        mat154_A.adicionarHorario(DiaDaSemana.QUARTA, "14:00", "16:00");
        mat154_A.adicionarHorario(DiaDaSemana.SEXTA, "14:00", "16:00");
        sistema.adicionarTurma(mat154_A);

        Turma mat155_A = new Turma("MAT155-A", matriz.getDisciplina("MAT155"), 2);
        mat155_A.adicionarHorario(DiaDaSemana.QUARTA, "16:00", "18:00");
        mat155_A.adicionarHorario(DiaDaSemana.SEXTA, "16:00", "18:00");
        sistema.adicionarTurma(mat155_A);

        Turma qui126_A = new Turma("QUI126-A", matriz.getDisciplina("QUI126"), 2);
        qui126_A.adicionarHorario(DiaDaSemana.SEGUNDA, "10:00", "12:00");
        sistema.adicionarTurma(qui126_A);

        Turma qui125_E = new Turma("QUI125-E", matriz.getDisciplina("QUI125"), 2);
        qui125_E.adicionarHorario(DiaDaSemana.SEGUNDA, "16:00", "18:00");
        qui125_E.adicionarHorario(DiaDaSemana.QUINTA, "16:00", "18:00");
        sistema.adicionarTurma(qui125_E);

        Turma ice001_B = new Turma("ICE001-B", matriz.getDisciplina("ICE001"), 2);
        ice001_B.adicionarHorario(DiaDaSemana.TERCA, "14:00", "16:00");
        sistema.adicionarTurma(ice001_B);

        Turma dcc199_X = new Turma("DCC199-X", matriz.getDisciplina("DCC199"), 2);
        dcc199_X.adicionarHorario(DiaDaSemana.SEGUNDA, "14:00", "16:00");
        dcc199_X.adicionarHorario(DiaDaSemana.QUINTA, "14:00", "16:00");
        sistema.adicionarTurma(dcc199_X);

        Turma dc5199_X = new Turma("DC5199-X", matriz.getDisciplina("DC5199"), 2);
        dc5199_X.adicionarHorario(DiaDaSemana.TERCA, "16:00", "18:00");
        sistema.adicionarTurma(dc5199_X);

        Turma fis122_A = new Turma("FIS122-A", matriz.getDisciplina("FIS122"), 2);
        fis122_A.adicionarHorario(DiaDaSemana.TERCA, "10:00", "12:00");
        sistema.adicionarTurma(fis122_A);

        Turma dcc025_A = new Turma("DCC025-A", matriz.getDisciplina("DCC025"), 2);
        dcc025_A.adicionarHorario(DiaDaSemana.SEGUNDA, "14:00", "16:00");
        dcc025_A.adicionarHorario(DiaDaSemana.QUARTA, "16:00", "18:00");
        sistema.adicionarTurma(dcc025_A);

        Turma mat156_A = new Turma("MAT156-A", matriz.getDisciplina("MAT156"), 2);
        mat156_A.adicionarHorario(DiaDaSemana.QUARTA, "14:00", "16:00");
        mat156_A.adicionarHorario(DiaDaSemana.SEXTA, "16:00", "18:00");
        sistema.adicionarTurma(mat156_A);


    }
}

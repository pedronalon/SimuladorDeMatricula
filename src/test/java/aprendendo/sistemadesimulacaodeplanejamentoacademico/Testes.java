package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Testes {

    private SistemaAcademico sistema;
    private MatrizCurricular curso;
    private Aluno alunoTeste;

    @BeforeEach
        /// Este metodo roda antes de cada @Test
    void setUp() {
        /// 1. Crie um sistema limpo
        sistema = GerenciadorSistema.carregarSistema();

        /// 2. Registre um aluno para os testes
        try {
            alunoTeste = sistema.registraAluno("josias", 2024, "65", 20);
        } catch (Exception e) {
            fail("A configuração do teste falhou ao registrar o aluno.");
        }
    }

    @Test
    void testMatriculaComSucesso() {
        // Cenário: Aluno cumpre todos os requisitos para Cálculo II
        curso = alunoTeste.getCurso();
        alunoTeste.adicionarDisciplina(curso.getDisciplina("MAT154"), 80.0); // Aprovado em CÁLCULO I
        alunoTeste.adicionarDisciplina(curso.getDisciplina("MAT155"), 80.0); // Aprovado em GEOMETRIA ANALÍTICA

        Turma turmaCalc2 = sistema.getTurma("MAT156-A"); // Supondo que esta turma exista no setup
        alunoTeste.adicionarTurmaAoPlanejamento(turmaCalc2);

        // Ação
        RelatorioMatricula relatorio = sistema.processarMatricula(alunoTeste);

        // Verificação
        assertTrue(relatorio.getTurmasMatriculadas().contains(turmaCalc2));
        assertTrue(relatorio.getTurmasRejeitadasComMotivo().isEmpty());
    }

    @Test
    void testMatriculaFalhaPorPreRequisito() {
        // Cenário: Aluno tenta cursar POO sem ter feito Algoritmos II
        // O aluno não tem histórico de Algoritmos II

        Turma turmaPOO = sistema.getTurma("DCC025-A");
        alunoTeste.adicionarTurmaAoPlanejamento(turmaPOO);

        // Ação
        RelatorioMatricula relatorio = sistema.processarMatricula(alunoTeste);

        // Verificação
        assertTrue(relatorio.getTurmasMatriculadas().isEmpty());
        assertTrue(relatorio.getTurmasRejeitadasComMotivo().containsKey(turmaPOO));
        assertEquals("Pré-requisito não cumprido para ORIENTAÇÃO A OBJETOS", relatorio.getTurmasRejeitadasComMotivo().get(turmaPOO));
    }
}
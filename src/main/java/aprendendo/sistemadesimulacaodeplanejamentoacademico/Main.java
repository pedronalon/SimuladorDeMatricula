package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class Main {

    public static void main(String[] args) {
        try {
            // --- 1. SETUP ---
            // A inicialização complexa agora está encapsulada em SetupSistema.
            System.out.println("Carregando sistema acadêmico...");
            SistemaAcademico sistema = SetupSistema.carregarSistema();
            System.out.println("Sistema carregado com sucesso.");

            // --- 2. REGISTRO DO ALUNO ---
            System.out.println("\nRegistrando aluno...");
            Aluno meuAluno = sistema.registraAluno("Pedro", 2024, 65, 24); // 65 é o código do curso EngComp
            System.out.println("Aluno registrado: " + meuAluno.getNome() + " | Matrícula: " + meuAluno.getMatricula());

            // --- 3. ADICIONAR HISTÓRICO ---
            System.out.println("\nAdicionando histórico escolar ao aluno...");
            MatrizCurricular curso = meuAluno.getCurso();
            meuAluno.adicionarDisciplina(curso.getDisciplina("DCC199"), 60.0); // Aprovado em ALGORITMOS I
            meuAluno.adicionarDisciplina(curso.getDisciplina("MAT154"), 75.0);// Aprovado em CÁLCULO I
            meuAluno.adicionarDisciplina(curso.getDisciplina("MAT155"), 75.0); // Aprovado em GEOMETRIA ANALITCA
            System.out.println("Histórico adicionado.");

            // --- 4. FASE DE PLANEJAMENTO DO SEMESTRE ---
            System.out.println("\nAluno planejando o próximo semestre...");
            // Cenário 1: Tenta disciplina com pré-requisito não cumprido
            meuAluno.adicionarTurmaAoPlanejamento(sistema.getTurma("T1_POO"));

            // Cenário 2: Tenta disciplina sem matricular seu co-requisito obrigatório
            meuAluno.adicionarTurmaAoPlanejamento(sistema.getTurma("T1_ALGO2"));

            // Cenário 3: Tenta disciplina que ele cumpre os requisitos
            meuAluno.adicionarTurmaAoPlanejamento(sistema.getTurma("T1_CALC2"));
            System.out.println("Planejamento concluído.");

            // --- 5. PROCESSAMENTO DA MATRÍCULA ---
            System.out.println("\nProcessando matrícula...");
            RelatorioMatricula relatorio = sistema.processarMatricula(meuAluno);

            // --- 6. ANÁLISE DO RELATÓRIO ---
            System.out.println("\nProcessamento finalizado. Gerando relatório...");
            relatorio.imprimir();

        } catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO FATAL NO SISTEMA ---");
            e.printStackTrace();
        }
    }
}
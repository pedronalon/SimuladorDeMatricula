package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GerenciaExecucao {

    private final SistemaAcademico sistema;
    private final Scanner scanner;

    public GerenciaExecucao(SistemaAcademico sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Bem-vindo ao Sistema de Simulação de Planejamento Acadêmico!");

        try {
            /// Cada etapa do processo agora é um metodo privado, deixando o 'run' mais limpo
            Aluno aluno = registrarNovoAluno();
            adicionarHistoricoPrimeiroPeriodo(aluno);
            planejarProximoSemestre(aluno);
            processarMatriculaEImprimirRelatorio(aluno);

        } catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO FATAL NO SISTEMA ---");
            e.printStackTrace();
        } finally {
            // Libera os recursos ao final da execução
            scanner.close();
            System.out.println("\nSistema finalizado.");
        }
    }

    // Metodo privado para lidar apenas com o registro do aluno
    private Aluno registrarNovoAluno() throws Exception {
        System.out.println("\n--- Registro de Novo Aluno ---");
        String nomeDoAluno = "Pedro"; // Poderia ser solicitado via scanner
        int anoDeIngresso = 2024;
        MatrizCurricular cursoDoAluno = null;

        do {
            System.out.print("Digite o código do curso para o aluno '" + nomeDoAluno + "' (ex: 65 para Eng. Comp.): ");
            String codigoDoCurso = scanner.nextLine();
            cursoDoAluno = sistema.getMatrizCurricularPorCodigo(codigoDoCurso);

            if (cursoDoAluno == null) {
                System.out.println("ERRO: Curso com código '" + codigoDoCurso + "' não existe no sistema. Tente novamente.");
            }
        } while (cursoDoAluno == null);

        System.out.println("Curso '" + cursoDoAluno.getNomeDoCurso() + "' selecionado.");
        Aluno aluno = sistema.registraAluno(nomeDoAluno, anoDeIngresso, cursoDoAluno.getCodigoDoCurso(), 24);
        System.out.println("Aluno registrado: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
        return aluno;
    }

    // Metodo privado para adicionar o histórico do primeiro período
    private void adicionarHistoricoPrimeiroPeriodo(Aluno aluno) {
        System.out.println("\n--- Lançamento de Notas do 1º Período ---");
        MatrizCurricular curso = aluno.getCurso();
        String[] codigosPrimeiroPeriodo = {
                "MAT154", // CÁLCULO I
                "MAT155", // GEOMETRIA ANALÍTICA E SISTEMAS LINEARES
                "FIS122", // LABORATÓRIO DE INTRODUÇÃO ÀS CIÊNCIAS FÍSICAS
                "QUI125", // QUÍMICA FUNDAMENTAL
                "QUI126", // LABORATÓRIO DE QUÍMICA
                "ICE001", // INTRODUÇÃO ÀS CIÊNCIAS EXATAS
                "DCC199", // ALGORITMOS I
                "DC5199"  // ALGORITMOS I - PRÁTICA
        };

        for (String codigo : codigosPrimeiroPeriodo) {
            Disciplina disciplina = curso.getDisciplina(codigo);
            if (disciplina != null) {
                double nota = -1;
                while (nota < 0 || nota > 100) {
                    System.out.print("Digite a nota para " + disciplina.getNome() + ": ");
                    try {
                        nota = Double.parseDouble(scanner.nextLine());
                        if (nota < 0 || nota > 100) System.out.println("ERRO: Por favor, insira uma nota entre 0 e 100.");
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Entrada inválida. Por favor, digite um número.");
                        nota = -1;
                    }
                }
                aluno.adicionarDisciplina(disciplina, nota);
            }
        }
        System.out.println("Notas do 1º Período lançadas com sucesso.");
    }


    private void planejarProximoSemestre(Aluno aluno) {
        System.out.println("\n--- Planejamento do Próximo Semestre ---");
        aluno.limparPlanejamentoFuturo();

        // Precisamos de um getter público para as turmas em SistemaAcademico
        boolean planejamento = true;
        List<Turma> turmasDisponiveis = new ArrayList<>(sistema.getTurmas());

        while (planejamento) {
            System.out.println("\n--- Turmas Disponíveis ---");
            // Exibe a lista de turmas numeradas
            for (int i = 0; i < turmasDisponiveis.size(); i++) {
                Turma t = turmasDisponiveis.get(i);
                System.out.printf("[%d] %s - %s (Turma: %s)\n", i + 1, t.getDisciplina().getCodigo(), t.getDisciplina().getNome(), t.getIdDaTurma());
            }
            System.out.println("-------------------------");
            System.out.println("Planejamento atual: " + aluno.getPlanejamentoFuturo().size() + " turma(s).");
            System.out.print("Digite o número da turma para adicionar (ou 'fim' para concluir): ");

            String entrada = scanner.nextLine();

            if ("fim".equalsIgnoreCase(entrada)) {
                planejamento = false;
            }else{
                try {
                    int indice = Integer.parseInt(entrada) - 1;
                    if (indice >= 0 && indice < turmasDisponiveis.size()) {
                        Turma turmaEscolhida = turmasDisponiveis.get(indice);
                        aluno.adicionarTurmaAoPlanejamento(turmaEscolhida);
                        System.out.println(">> Turma '" + turmaEscolhida.getDisciplina().getNome() + "' adicionada.");
                    } else {
                        System.out.println("ERRO: Número inválido.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Entrada inválida.");
                }
            }

        }
        System.out.println("Planejamento concluído.");
    }


    private void processarMatriculaEImprimirRelatorio(Aluno aluno) {
        System.out.println("\n--- Processando Matrícula ---");
        RelatorioMatricula relatorio = sistema.processarMatricula(aluno);
        System.out.println("Processamento finalizado. Gerando relatório...");
        relatorio.imprimir();
    }
}


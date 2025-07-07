package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.List;
import java.util.Map;

public class RelatorioMatricula {

    private final Aluno aluno;
    private final List<Turma> turmasMatriculadas;
    // Armazena a turma rejeitada e o motivo (a mensagem da exceção)
    private final Map<Turma, String> turmasRejeitadasComMotivo;

    public RelatorioMatricula(Aluno aluno, List<Turma> turmasMatriculadas, Map<Turma, String> turmasRejeitadasComMotivo) {
        this.aluno = aluno;
        this.turmasMatriculadas = turmasMatriculadas;
        this.turmasRejeitadasComMotivo = turmasRejeitadasComMotivo;
    }

    // Getters para que possamos ler o resultado
    public Aluno getAluno() {
        return aluno;
    }

    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }

    public Map<Turma, String> getTurmasRejeitadasComMotivo() {
        return turmasRejeitadasComMotivo;
    }

    // Metodo para imprimir o relatório de forma legível
    public void imprimir() {
        System.out.println("--- Relatório de Matrícula para: " + aluno.getNome() + " ---");

        System.out.println("\n✅ Turmas Matriculadas com Sucesso:");
        if (turmasMatriculadas.isEmpty()) {
            System.out.println("Nenhuma.");
        } else {
            for (Turma t : turmasMatriculadas) {
                System.out.println("-> " + t.getDisciplina().getNome() + " (Turma: " + t.getIdDaTurma() + ")");
            }
        }

        System.out.println("\n❌ Turmas Rejeitadas:");
        if (turmasRejeitadasComMotivo.isEmpty()) {
            System.out.println("Nenhuma.");
        } else {
            for (Map.Entry<Turma, String> entry : turmasRejeitadasComMotivo.entrySet()) {
                System.out.println("-> " + entry.getKey().getDisciplina().getNome() + " | Motivo: " + entry.getValue());
            }
        }
        System.out.println("-------------------------------------------------");
    }
}
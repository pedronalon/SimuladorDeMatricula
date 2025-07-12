package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.*;

public class Aluno {
    private String nome;
    private String matricula;
    private String anoDeIngresso;
    private int cargaHorariaMaxima;
    private MatrizCurricular curso;
    private Map<String, Double> disciplinasCursadasComNota;
    private List<Turma> planejamentoFuturo;

    public Aluno(String nome, String matricula, int CargaHorariaMaxima, MatrizCurricular curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargaHorariaMaxima = CargaHorariaMaxima;
        this.curso = curso;
        this.disciplinasCursadasComNota = new HashMap<>();
        this.planejamentoFuturo = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina, Double notaFinal){
        this.disciplinasCursadasComNota.put(disciplina.getCodigo(), notaFinal);
    }

    public void adicionarTurmaAoPlanejamento(Turma turma){
        this.planejamentoFuturo.add(turma);
    }

    public List<Turma> getPlanejamentoFuturo() {
        return new ArrayList<>(this.planejamentoFuturo);
    }

    // NOME DO MÉTODO CORRIGIDO PARA COMPATIBILIDADE
    public void limparPlanejamentoFuturo(){
        this.planejamentoFuturo.clear();
    }

    public void consolidarSemestre(List<Turma> turmasMatriculadas, Map<String, Double> notasFinais) {
        for (Turma turma : turmasMatriculadas) {
            String codigoDisciplina = turma.getDisciplina().getCodigo();
            Double nota = notasFinais.get(codigoDisciplina);
            if (nota != null) {
                this.adicionarDisciplina(turma.getDisciplina(), nota);
            }
        }
    }

    public boolean cumpriuDisciplina(String idDaDisciplina){
        final double notaMinima = 60;
        Double notaAtual = disciplinasCursadasComNota.get(idDaDisciplina);
        return notaAtual != null && notaAtual >= notaMinima;
    }

    public int getTotalCreditosCursados() {
        int totalCreditos = 0;
        for(String codigoDaDisciplina : disciplinasCursadasComNota.keySet()) {
            Disciplina disciplina = curso.getDisciplina(codigoDaDisciplina);
            if(disciplina != null){
                totalCreditos += disciplina.getCargaHorariaSemanal();
            }
        }
        return totalCreditos;
    }

    // --- GETTERS CORRIGIDOS E ADICIONADOS ---
    public String getNome() { return nome; }
    public int getCargaHorariaMaxima() { return cargaHorariaMaxima; }
    public MatrizCurricular getCurso() { return curso; }
    public Map<String, Double> getDisciplinasCursadasComNota() { return disciplinasCursadasComNota; }

    // MÉTODO ADICIONADO QUE ESTAVA FALTANDO
    public String getMatricula() { return matricula; }
}
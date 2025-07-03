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

    public MatrizCurricular getCurso() {
        return curso;
    }

    public boolean cumpriuDisciplina(String idDaDisciplina){
        final double notaMinima = 60;
        Double notaAtual = disciplinasCursadasComNota.get(idDaDisciplina);
        if(notaAtual != null)
            return notaAtual >= notaMinima;

        else return false;
    }

    public void setMatricula(String matricula) {this.matricula = matricula;}

    public String getNome() {return nome;}
    public int getCargaHorariaMaxima() {return cargaHorariaMaxima;}
    public MatrizCurricular getcurso() {return curso;}
    public Map<String, Double> getDisciplinasCursadasComNota() {return disciplinasCursadasComNota;}

    public String getAnoDeIngresso() {return anoDeIngresso;}
}

package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private int cargaHorariaMaxima;
    private Map<String, Double> disciplinasCursadasComNota;
    private List<Turma> planejamentoFuturo;

    public Aluno(String nome, String matricula, int CargaHorariaMaxima) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargaHorariaMaxima = CargaHorariaMaxima;
        this.disciplinasCursadasComNota = new HashMap<>();
        this.planejamentoFuturo = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina, Double notaFinal){
        this.disciplinasCursadasComNota.put(disciplina.getCodigo(), notaFinal);
    }


    public boolean cumpriuDisciplina(Disciplina disciplina){
        final double notaMinima = disciplina.getNotaMinima();
        Double notaAtual = disciplinasCursadasComNota.get(disciplina.getCodigo());
        if(notaAtual != null)
            return notaAtual >= notaMinima;

        else return false;
    }

}

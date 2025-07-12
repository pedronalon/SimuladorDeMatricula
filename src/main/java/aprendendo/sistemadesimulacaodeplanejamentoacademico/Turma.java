package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class Turma {
    private String idDaTurma;
    private Disciplina disciplina;
    private int capacidadeMaxima;
    private int alunosMatriculados;
    private final List<Horario> horarios;

    public Turma(String idDaTurma, Disciplina disciplina, int capacidadeMaxima) {
        this.idDaTurma = idDaTurma;
        this.disciplina = disciplina;
        this.capacidadeMaxima = capacidadeMaxima;
        this.horarios = new ArrayList<>();
        this.alunosMatriculados = 0;
    }

    public void adicionarHorario(DiaDaSemana dia, String inicio, String fim) {
        this.horarios.add(new Horario(dia, LocalTime.parse(inicio), LocalTime.parse(fim)));
    }

    public boolean conflitaCom(Turma outraTurma){

        for(Horario meuHorario : this.horarios){
            for(Horario outroHorario : outraTurma.horarios){
                if(meuHorario.sobrepoe(outroHorario)){
                    return true;
                }
            }
        }
        return false;
    }

    public String getIdDaTurma() {return idDaTurma;}
    public Disciplina getDisciplina() {return disciplina;}
    public int getCapacidadeMaxima() {return capacidadeMaxima;}
    public int getAlunosMatriculados() {return alunosMatriculados;}
    public List<Horario> getHorarioDeAula() {return horarios;}
    public boolean estaCheia(){return alunosMatriculados >= capacidadeMaxima;}
}

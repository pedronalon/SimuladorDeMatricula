package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class Turma {
    private String idDaTurma;
    private Disciplina disciplina;
    private int capacidadeMaxima;
    private int alunosMatriculados;
    private String horarioDeAula;

    public Turma(String idDaTurma, Disciplina disciplina, int capacidadeMaxima, String horarioDeAula) {
        this.idDaTurma = idDaTurma;
        this.disciplina = disciplina;
        this.capacidadeMaxima = capacidadeMaxima;
        this.horarioDeAula = horarioDeAula;
        this.alunosMatriculados = 0;
    }


    public String getIdDaTurma() {return idDaTurma;}
    public Disciplina getDisciplina() {return disciplina;}
    public int getCapacidadeMaxima() {return capacidadeMaxima;}
    public int getAlunosMatriculados() {return alunosMatriculados;}
    public String getHorarioDeAula() {return horarioDeAula;}
    public boolean estaCheia(){return alunosMatriculados >= capacidadeMaxima;}
}

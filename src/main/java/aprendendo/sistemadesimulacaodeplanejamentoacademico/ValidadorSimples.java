package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class ValidadorSimples implements ValidadorPreRequisito {
    private String codigoDaDisciplina;

    public ValidadorSimples(String codigoDaDisciplina){
        this.codigoDaDisciplina = codigoDaDisciplina;
    }
    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        return aluno.cumpriuDisciplina(this.codigoDaDisciplina);
    }
}

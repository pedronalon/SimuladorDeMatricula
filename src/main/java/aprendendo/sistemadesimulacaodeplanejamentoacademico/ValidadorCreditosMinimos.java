package aprendendo.sistemadesimulacaodeplanejamentoacademico;

public class ValidadorCreditosMinimos implements ValidadorPreRequisito{
    private int creditosMinimos;

    public ValidadorCreditosMinimos(int creditosMinimos) {
        this.creditosMinimos = creditosMinimos;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        return aluno.getTotalCreditosCursados() >= creditosMinimos;
    }

}

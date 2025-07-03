package aprendendo.sistemadesimulacaodeplanejamentoacademico.TratamentoDeExcecoes;

public class PreRequisitoNaoCumpridoException extends ValidacaoMatriculaException{
    public PreRequisitoNaoCumpridoException(String mensagem) {
        super(mensagem);
    }
}

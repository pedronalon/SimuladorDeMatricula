package aprendendo.sistemadesimulacaodeplanejamentoacademico.TratamentoDeExcecoes;

public class CoRequisitoNaoAtendidoException extends ValidacaoMatriculaException{

    public CoRequisitoNaoAtendidoException(String mensagem) {
        super(mensagem);
    }
}

package aprendendo.sistemadesimulacaodeplanejamentoacademico.TratamentoDeExcecoes;

public class ConflitoDeHorarioException extends ValidacaoMatriculaException{

    public ConflitoDeHorarioException(String mensagem) {
        super(mensagem);
    }
}


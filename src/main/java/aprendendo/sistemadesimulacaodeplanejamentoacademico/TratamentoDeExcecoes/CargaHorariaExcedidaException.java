package aprendendo.sistemadesimulacaodeplanejamentoacademico.TratamentoDeExcecoes;

public class CargaHorariaExcedidaException extends ValidacaoMatriculaException{
    public CargaHorariaExcedidaException(String mensagem){
        super(mensagem);
    }
}

package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.List;

public class ValidadorLogicoAND implements ValidadorPreRequisito{

    public ValidadorLogicoAND() {}

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {
        boolean validou = false;
        List<ValidadorPreRequisito> preRequisitos = disciplina.getValidadoresPreRequisito();
        for(ValidadorPreRequisito preRequisito : preRequisitos ){
            validou = preRequisito.validar(aluno, disciplina);
            if(!validou)
                break;
        }
        return validou;
    }
}

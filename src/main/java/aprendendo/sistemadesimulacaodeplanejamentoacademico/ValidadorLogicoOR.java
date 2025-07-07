package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.List;

public class ValidadorLogicoOR implements ValidadorPreRequisito{
    private final List<ValidadorPreRequisito> preRequisitos;

    public ValidadorLogicoOR(List<ValidadorPreRequisito> validadores) {
        preRequisitos = validadores;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina){

        for(ValidadorPreRequisito preRequisito : preRequisitos){
            if(preRequisito.validar(aluno, disciplina))
                return true;
        }
        return false;
    }
}

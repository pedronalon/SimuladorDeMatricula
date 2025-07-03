package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.List;

public class ValidadorLogicoAND implements ValidadorPreRequisito{
    private final List<ValidadorPreRequisito> preRequisitos;

    public ValidadorLogicoAND(List<ValidadorPreRequisito> validadores) {
        preRequisitos = validadores;
    }

    @Override
    public boolean validar(Aluno aluno, Disciplina disciplina) {

        for(ValidadorPreRequisito preRequisito : preRequisitos)
            if(!preRequisito.validar(aluno, disciplina))
            return false;

        return true;
    }
}

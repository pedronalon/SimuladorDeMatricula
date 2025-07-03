package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.HashMap;
import java.util.Map;

public class SistemaAcademico {

    private Map<String, Integer> gerenciadorDeMatriculas = new HashMap<>();



    public String geraMatricula(int anoDeIngresso, String codigoDoCurso){
        String chave = anoDeIngresso + "-" + codigoDoCurso;
        int ordem = gerenciadorDeMatriculas.getOrDefault(chave, 1);
        gerenciadorDeMatriculas.put(chave, ordem + 1);

        return String.format("%d%s%03d", anoDeIngresso, codigoDoCurso, ordem);
    }

    public Aluno registraAluno(String nome, int anoDeIngresso, String matricula, int capacidadeMaxima, MatrizCurricular curso) {

        String matriculaAluno = geraMatricula(anoDeIngresso, matricula);
        return new Aluno(matriculaAluno, nome, anoDeIngresso, curso);
    }

}

package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.HashMap;
import java.util.Map;

public class MatrizCurricular {

    private final int codigoDoCurso;
    private final String nomeDoCurso;

    private Map<String, Disciplina> disciplinasComCodigo;

    public MatrizCurricular(int codigoDoCurso, String nomeDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
        this.nomeDoCurso = nomeDoCurso;
        this.disciplinasComCodigo = new HashMap<>();
    }


    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinasComCodigo.put(disciplina.getCodigo(), disciplina);
    }

    public Disciplina getDisciplina(String codigoDaDisciplina) {
        return this.disciplinasComCodigo.get(codigoDaDisciplina);
    }

    public int getCodigoDoCurso() {return this.codigoDoCurso;}
    public String getNomeDoCurso() {return nomeDoCurso;}
}

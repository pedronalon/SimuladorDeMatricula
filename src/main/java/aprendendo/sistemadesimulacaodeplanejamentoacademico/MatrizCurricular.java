package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MatrizCurricular {

    private final String codigoDoCurso;
    private final String nomeDoCurso;

    private Map<String, Disciplina> disciplinasComCodigo;

    public MatrizCurricular(String nomeDoCurso, String codigoDoCurso ) {
        this.codigoDoCurso = codigoDoCurso;
        this.nomeDoCurso = nomeDoCurso;
        this.disciplinasComCodigo = new HashMap<>();
    }

    public Collection<Disciplina> getCatalogoDisciplinas() {
        return this.disciplinasComCodigo.values();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinasComCodigo.put(disciplina.getCodigo(), disciplina);
    }

    public Disciplina getDisciplina(String codigoDaDisciplina) {
        return this.disciplinasComCodigo.get(codigoDaDisciplina);
    }

    public String getCodigoDoCurso() {return this.codigoDoCurso;}
    public String getNomeDoCurso() {return nomeDoCurso;}
}

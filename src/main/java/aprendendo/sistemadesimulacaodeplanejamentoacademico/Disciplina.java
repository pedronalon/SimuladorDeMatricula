package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Disciplina {
    private String nomeDaDisciplina;
    private String codigo;
    private int cargaHorariaSemanal;
    private double notaMinima;
    private final List<Disciplina> coRequisitos;
    private final List<ValidadorPreRequisito> preRequisitos;

    public Disciplina(String nome, String codigo, int cargaHorariaSemanal) {
        this.nomeDaDisciplina = nome;
        this.codigo = codigo;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.coRequisitos = new ArrayList<>();
        this.preRequisitos = new ArrayList<>();

    }


    /// adiciona co-requisito
    public void adicionarCoRequisito(Disciplina disciplina) {
        this.coRequisitos.add(disciplina);
    }

    /// adiciona pre-requisito
    public void adicionarPreRequisito(ValidadorPreRequisito validador) {
        this.preRequisitos.add(validador);
    }

    /// retorna os atributos
    public String getNome() {return nomeDaDisciplina;}
    public String getCodigo() {return codigo;}
    public int getCargaHorariaSemanal() {return cargaHorariaSemanal;}
    public double getNotaMinima(){return notaMinima;}

    /// retorna lista imutável de pre-requisitos
    public List<ValidadorPreRequisito> getValidadoresPreRequisito() {return Collections.unmodifiableList(preRequisitos);}

    /// retorna lista imutavel de co-Requisitos
    public List<Disciplina> getCoRequisitos() {return Collections.unmodifiableList(coRequisitos);}


}

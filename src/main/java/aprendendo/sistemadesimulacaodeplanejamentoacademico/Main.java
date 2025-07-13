package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaAcademico sistema = GerenciadorSistema.carregarSistema();
        GerenciaExecucao exe = new GerenciaExecucao(sistema);
        exe.run();
    }
}
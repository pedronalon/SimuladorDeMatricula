package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import aprendendo.sistemadesimulacaodeplanejamentoacademico.TratamentoDeExcecoes.*;

public class SistemaAcademico {

    private Map<String, Aluno> alunos;
    private Map<String, Integer> gerenciadorDeMatriculas = new HashMap<>();

    private Map<Integer, MatrizCurricular> cursos;

    public  SistemaAcademico() {
        this.alunos = new HashMap<>();
        this.gerenciadorDeMatriculas = new HashMap<>();
        this.cursos = new HashMap<>();
    }

    public MatrizCurricular getCurso(int codigoDoCurso) {
        return cursos.get(codigoDoCurso);
    }

    public void adicionarMatrizCurricular(MatrizCurricular matriz) {
        this.cursos.put(matriz.getCodigoDoCurso(), matriz);
    }

    public MatrizCurricular getMatrizCurricular(int codigoDoCurso) {
        return this.cursos.get(codigoDoCurso);
    }

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


    public RelatorioMatricula processarMatricula(Aluno aluno) {
        // Listas para guardar o resultado do processamento
        List<Turma> turmasMatriculadas = new ArrayList<>();
        Map<Turma, String> turmasRejeitadas = new HashMap<>();
        int cargaHorariaAtual = 0;

        // Pega o planejamento do aluno para este semestre
        for (Turma turmaDesejada : aluno.getPlanejamentoFuturo()) {
            Disciplina disciplinaDesejada = turmaDesejada.getDisciplina();

            try {
                // 1. VALIDAÇÃO DE VAGAS
                if (turmaDesejada.estaCheia()) {
                    throw new TurmaCheiaException("Turma sem vagas.");
                }

                // 2. VALIDAÇÃO DE CARGA HORÁRIA
                if (cargaHorariaAtual + disciplinaDesejada.getCargaHorariaSemanal() > aluno.getCargaHorariaMaxima()) {
                    throw new CargaHorariaExcedidaException("Excede a carga horária máxima do aluno.");
                }

                // 3. VALIDAÇÃO DE PRÉ-REQUISITOS
                for (ValidadorPreRequisito validador : disciplinaDesejada.getValidadoresPreRequisito()) {
                    if (!validador.validar(aluno, disciplinaDesejada)) {
                        throw new PreRequisitoNaoCumpridoException("Não cumpre os pré-requisitos necessários.");
                    }
                }

                // ... OUTRAS VALIDAÇÕES (conflito de horário, co-requisitos) IRIAM AQUI ...

                // SE PASSOU EM TUDO: MATRICULA APROVADA
                turmasMatriculadas.add(turmaDesejada);
                cargaHorariaAtual += disciplinaDesejada.getCargaHorariaSemanal();

            } catch (MatriculaException e) {
                // Se qualquer uma das nossas exceções personalizadas for lançada, ela é capturada aqui.
                // Adicionamos a turma à lista de rejeitadas com a mensagem da exceção como motivo.
                turmasRejeitadas.put(turmaDesejada, e.getMessage());
            }
        }

        // Ao final, cria e retorna o objeto de relatório com os resultados
        return new RelatorioMatricula(aluno, turmasMatriculadas, turmasRejeitadas);
    }
}



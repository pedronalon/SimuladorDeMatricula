package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import aprendendo.sistemadesimulacaodeplanejamentoacademico.TratamentoDeExcecoes.*;
import java.util.*;

public class SistemaAcademico {

    private Map<String, Aluno> alunos;
    private Map<Integer, MatrizCurricular> cursos;
    private Map<String, Turma> turmas;
    private Map<String, Integer> gerenciadorDeMatriculas;

    public SistemaAcademico() {
        this.alunos = new HashMap<>();
        this.cursos = new HashMap<>();
        this.turmas = new HashMap<>();
        this.gerenciadorDeMatriculas = new HashMap<>();
    }

    public void adicionarMatrizCurricular(MatrizCurricular matriz) {
        this.cursos.put(matriz.getCodigoDoCurso(), matriz);
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.put(turma.getIdDaTurma(), turma);
    }

    public Turma getTurma(String idTurma) {
        return this.turmas.get(idTurma);
    }

    private String geraMatricula(int anoDeIngresso, int codigoDoCurso) {
        String chave = anoDeIngresso + "-" + codigoDoCurso;
        int ordem = gerenciadorDeMatriculas.getOrDefault(chave, 1);
        gerenciadorDeMatriculas.put(chave, ordem + 1);
        return String.format("%d%s%03d", anoDeIngresso, codigoDoCurso, ordem);
    }

    public Aluno registraAluno(String nome, int anoDeIngresso, int codigoDoCurso, int cargaHorariaMaxima) throws Exception {
        MatrizCurricular curso = this.cursos.get(codigoDoCurso);
        if (curso == null) {
            throw new Exception("Curso com código " + codigoDoCurso + " não existe no sistema.");
        }
        String matriculaGerada = geraMatricula(anoDeIngresso, codigoDoCurso);
        Aluno novoAluno = new Aluno(nome, matriculaGerada, cargaHorariaMaxima, curso);
        this.alunos.put(matriculaGerada, novoAluno);
        return novoAluno;
    }

    public RelatorioMatricula processarMatricula(Aluno aluno) {
        List<Turma> turmasMatriculadas = new ArrayList<>();
        Map<Turma, String> turmasRejeitadas = new HashMap<>();
        int cargaHorariaAtual = 0;

        for (Turma turmaDesejada : aluno.getPlanejamentoFuturo()) {
            Disciplina disciplinaDesejada = turmaDesejada.getDisciplina();

            try {
                // 1. VALIDAÇÃO DE VAGAS
                if (turmaDesejada.estaCheia()) {
                    throw new TurmaCheiaException("Vagas esgotadas.");
                }

                // 2. VALIDAÇÃO DE CARGA HORÁRIA
                if (cargaHorariaAtual + disciplinaDesejada.getCargaHorariaSemanal() > aluno.getCargaHorariaMaxima()) {
                    throw new CargaHorariaExcedidaException("Excede a carga horária máxima do aluno (" + aluno.getCargaHorariaMaxima() + "h).");
                }

                // 3. VALIDAÇÃO DE CONFLITO DE HORÁRIO
                for (Turma jaMatriculada : turmasMatriculadas) {
                    if (jaMatriculada.getHorarioDeAula().equals(turmaDesejada.getHorarioDeAula())) {
                        throw new ConflitoDeHorarioException("Conflito de horário com " + jaMatriculada.getDisciplina().getNome());
                    }
                }

                // 4. VALIDAÇÃO DE PRÉ-REQUISITOS
                for (ValidadorPreRequisito validador : disciplinaDesejada.getValidadoresPreRequisito()) {
                    if (!validador.validar(aluno, disciplinaDesejada)) {
                        throw new PreRequisitoNaoCumpridoException("Pré-requisito não cumprido para " + disciplinaDesejada.getNome());
                    }
                }

                // 5. VALIDAÇÃO DE CO-REQUISITOS (Verificação preliminar)
                // A validação final acontece fora do loop para garantir a consistência do conjunto
                for (Disciplina coReq : disciplinaDesejada.getCoRequisitos()) {
                    boolean coRequisitoPlanejado = false;
                    for(Turma outraTurmaDesejada : aluno.getPlanejamentoFuturo()){
                        if(outraTurmaDesejada.getDisciplina().getCodigo().equals(coReq.getCodigo())){
                            coRequisitoPlanejado = true;
                            break;
                        }
                    }
                    if(!coRequisitoPlanejado){
                        throw new CoRequisitoNaoAtendidoException("Co-requisito " + coReq.getNome() + " não está no planejamento.");
                    }
                }

                // SE PASSOU EM TUDO: MATRICULA APROVADA
                turmasMatriculadas.add(turmaDesejada);
                cargaHorariaAtual += disciplinaDesejada.getCargaHorariaSemanal();

                // TRATAMENTO DAS EXCEÇÕES NOS RESPECTIVOS LUGARES
            } catch (TurmaCheiaException | CargaHorariaExcedidaException | ConflitoDeHorarioException | PreRequisitoNaoCumpridoException | CoRequisitoNaoAtendidoException e) {
                turmasRejeitadas.put(turmaDesejada, e.getMessage());
            }
        }

        return new RelatorioMatricula(aluno, turmasMatriculadas, turmasRejeitadas);
    }
}
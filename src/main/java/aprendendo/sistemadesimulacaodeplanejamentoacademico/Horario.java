package aprendendo.sistemadesimulacaodeplanejamentoacademico;

import java.time.LocalTime;

public class Horario {
    private final DiaDaSemana diaDaSemana;
    private final LocalTime horarioDeInicio;
    private final LocalTime horarioDeFim;

    public Horario(DiaDaSemana dia, LocalTime horarioInicio, LocalTime horarioFim) {
        this.diaDaSemana = dia;
        this.horarioDeInicio = horarioInicio;
        this.horarioDeFim = horarioFim;
    }

    public DiaDaSemana getDiaDaSemana() { return diaDaSemana;}
    public LocalTime getHorarioDeInicio() { return horarioDeInicio;}
    public LocalTime getHorarioDeFim() { return horarioDeFim;}

    public boolean sobrepoe(Horario alvo){

        if(this.diaDaSemana != alvo.diaDaSemana){
            return false;
        }

        return this.horarioDeInicio.isBefore(alvo.horarioDeFim) && alvo.horarioDeInicio.isBefore(this.horarioDeFim);
    }

    @Override
    public String toString() {
        return diaDaSemana + " " + horarioDeInicio + " " + horarioDeFim;
    }
}

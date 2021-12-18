package pt.ubi.di.pdm.adminapp;

public class Event {
    public String name;
    public String dataInicio;
    public String dataFim;
    public String numParticipantes;

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(String numParticipantes) {
        this.numParticipantes = numParticipantes;
    }
}
package org.example.Model;

public class Tarefa {
    private String tarefa;
    private int id;
    private boolean concluida;

    public Tarefa(int i, String texto) {
        this.tarefa = texto;
        this.id = i;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    @Override
    public String toString() {
        return "Tarefa " +
                "tarefa = " + tarefa + '\'' +
                ", id = " + id +
                ", concluida = " + concluida;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}

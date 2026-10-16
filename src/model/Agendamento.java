package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {

    // Atributos privados da classe Agendamento
    private int id;
    private int clienteId; // Chave estrangeira ligando ao Cliente
    private LocalDate dataAgendamento;
    private LocalTime horario;
    private String status;

    public Agendamento() {}

    public Agendamento(int ClienteId, int id, LocalDate dataAgendamento, LocalTime horario, String status) {
        this.clienteId = ClienteId;
        this.status = "PENDENTE!"; // Status inicial do agendamento (PADRÃO)
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

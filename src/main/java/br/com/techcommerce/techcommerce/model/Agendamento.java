package br.com.techcommerce.techcommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime inicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fim;

    @OneToOne
    @NotBlank(message = "Cliente deve ser informado")
    private Cliente cliente;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

}

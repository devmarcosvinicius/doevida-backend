package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "doacoes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoacao;

    @OneToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    private LocalDate dataRealizada;

    private Double volumeMl;

    private String observacoes;
}

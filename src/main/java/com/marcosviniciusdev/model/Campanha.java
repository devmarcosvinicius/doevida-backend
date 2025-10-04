package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "campanhas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCampanha;

    @ManyToOne
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    private String titulo;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;
}

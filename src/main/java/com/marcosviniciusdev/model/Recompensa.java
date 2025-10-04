package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recompensas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecompensa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private Integer pontos;

    private String nivel; // Bronze, Prata, Ouro, Platina

    private String descricao;
}

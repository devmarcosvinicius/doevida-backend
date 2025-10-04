package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "voluntarios_campanha")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VoluntarioCampanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoluntario;

    @ManyToOne
    @JoinColumn(name = "id_campanha")
    private Campanha campanha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}

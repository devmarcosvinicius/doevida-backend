package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compatibilidades")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Compatibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompatibilidade;

    @ManyToOne
    @JoinColumn(name = "id_usuario_doador")
    private Usuario usuarioDoador;

    @ManyToOne
    @JoinColumn(name = "id_usuario_receptor")
    private Usuario usuarioReceptor;

    private String tipoSanguineo;

    private String status; // compatível, incompatível
}

package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "estoques")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;

    @ManyToOne
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    private String tipoSanguineo;

    private String tipoComponente; // sangue total, plaquetas, plasma

    private Integer quantidade;

    private LocalDate dataAtualizacao;
}

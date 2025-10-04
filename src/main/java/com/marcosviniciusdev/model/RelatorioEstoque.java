package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "relatorios_estoque")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RelatorioEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelatorio;

    @ManyToOne
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    private String tipoSanguineo;

    private Integer quantidadeInicial;

    private Integer quantidadeFinal;

    private LocalDate periodoInicio;

    private LocalDate periodoFim;
}

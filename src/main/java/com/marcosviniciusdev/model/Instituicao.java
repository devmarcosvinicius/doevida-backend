package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instituicoes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstituicao;

    private String nome;

    @Column(unique = true)
    private String cnpj;

    private String tipo; // HEMOCENTRO, HOSPITAL

    private String cidade;

    private String estado;

    private String endereco;

    private String telefone;
}

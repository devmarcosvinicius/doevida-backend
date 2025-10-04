package com.marcosviniciusdev.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;

    private String senhaHash;

    private String tipoSanguineo; // A+, A-, O+, etc.

    private LocalDate dataNascimento;

    private String telefone;

    private String endereco;

    private String perfil; // DOADOR, ADMIN, HEMOCENTRO

    private Boolean ativo = true;
}
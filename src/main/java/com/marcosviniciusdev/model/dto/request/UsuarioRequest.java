package com.marcosviniciusdev.model.dto.request;

import com.marcosviniciusdev.model.Usuario;

public record UsuarioRequest(
        String nome,
        String cpf,
        String email,
        String senha,
        String tipoSanguineo,
        String telefone,
        String endereco,
        String perfil
) {
    public Usuario toEntity() {
        return new Usuario(
                null,
                this.nome,
                this.cpf,
                this.email,
                this.senha, // criptografar antes
                this.tipoSanguineo,
                null,
                this.telefone,
                this.endereco,
                this.perfil,
                true
        );
    }
}

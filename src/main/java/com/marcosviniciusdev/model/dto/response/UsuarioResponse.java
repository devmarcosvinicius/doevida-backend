package com.marcosviniciusdev.model.dto.response;

import com.marcosviniciusdev.model.Usuario;

public record UsuarioResponse(
        Long idUsuario,
        String nome,
        String cpf,
        String email,
        String tipoSanguineo,
        String telefone,
        String endereco,
        String perfil,
        Boolean ativo
) {
    public static UsuarioResponse fromEntity(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getTipoSanguineo(),
                usuario.getTelefone(),
                usuario.getEndereco(),
                usuario.getPerfil(),
                usuario.getAtivo()
        );
    }
}



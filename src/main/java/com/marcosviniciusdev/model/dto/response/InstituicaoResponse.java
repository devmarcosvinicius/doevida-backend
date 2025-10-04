package com.marcosviniciusdev.model.dto.response;

import com.marcosviniciusdev.model.Instituicao;

public record InstituicaoResponse(
        Long idInstituicao,
        String nome,
        String cnpj,
        String tipo,
        String cidade,
        String estado,
        String endereco,
        String telefone
) {

    public static InstituicaoResponse fromEntity(Instituicao instituicao) {
        return new InstituicaoResponse(
                instituicao.getIdInstituicao(),
                instituicao.getNome(),
                instituicao.getCnpj(),
                instituicao.getTipo(),
                instituicao.getCidade(),
                instituicao.getEstado(),
                instituicao.getEndereco(),
                instituicao.getTelefone()
        );
    }

}


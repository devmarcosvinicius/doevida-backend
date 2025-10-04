package com.marcosviniciusdev.model.dto.request;

import com.marcosviniciusdev.model.Instituicao;

public record InstituicaoRequest(
        String nome,
        String cnpj,
        String tipo,
        String cidade,
        String estado,
        String endereco,
        String telefone
) {

    public Instituicao toEntity() {
        return new Instituicao(
                null,
                this.nome(),
                this.cnpj(),
                this.tipo(),
                this.cidade(),
                this.estado(),
                this.endereco(),
                this.telefone()
        );
    }
    
}

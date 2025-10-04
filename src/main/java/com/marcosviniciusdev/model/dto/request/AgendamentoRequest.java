package com.marcosviniciusdev.model.dto.request;

import com.marcosviniciusdev.model.Agendamento;
import com.marcosviniciusdev.model.Instituicao;
import com.marcosviniciusdev.model.Usuario;

import java.time.LocalDateTime;

public record AgendamentoRequest(
        Long idUsuario,
        Long idInstituicao,
        LocalDateTime dataHora,
        String tipoDoacao
) {
    public Agendamento toEntity(Usuario usuario, Instituicao instituicao) {
        return new Agendamento(
                null,
                usuario,
                instituicao,
                this.dataHora,
                this.tipoDoacao,
                "PENDENTE"
        );
    }
}


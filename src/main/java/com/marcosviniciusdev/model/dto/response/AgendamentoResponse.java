package com.marcosviniciusdev.model.dto.response;

import com.marcosviniciusdev.model.Agendamento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long idAgendamento,
        String nomeUsuario,
        String nomeInstituicao,
        LocalDateTime dataHora,
        String tipoDoacao,
        String status
) {
    public static AgendamentoResponse fromEntity(Agendamento ag) {
        return new AgendamentoResponse(
                ag.getIdAgendamento(),
                ag.getUsuario().getNome(),
                ag.getInstituicao().getNome(),
                ag.getDataHora(),
                ag.getTipoDoacao(),
                ag.getStatus()
        );
    }
}
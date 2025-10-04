package com.marcosviniciusdev.model.dto.response;

import java.time.LocalDateTime;

public record NotificacaoResponse(
        Long idNotificacao,
        String mensagem,
        String tipo,
        LocalDateTime dataEnvio,
        Boolean lida
) {}
package com.marcosviniciusdev.model.dto.request;

public record NotificacaoRequest(
        Long idUsuario,
        String mensagem,
        String tipo
) {}

package com.marcosviniciusdev.model.dto.response;

public record RecompensaResponse(
        Long idRecompensa,
        Integer pontos,
        String nivel,
        String descricao
) {}


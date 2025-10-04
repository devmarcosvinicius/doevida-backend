package com.marcosviniciusdev.model.dto.request;

public record EstoqueRequest(
        Long idInstituicao,
        String tipoSanguineo,
        String tipoComponente,
        Integer quantidade
) {}

package com.marcosviniciusdev.model.dto.response;

import java.time.LocalDate;

public record EstoqueResponse(
        Long idEstoque,
        String nomeInstituicao,
        String tipoSanguineo,
        String tipoComponente,
        Integer quantidade,
        LocalDate dataAtualizacao
) {}

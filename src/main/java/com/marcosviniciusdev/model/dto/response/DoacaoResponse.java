package com.marcosviniciusdev.model.dto.response;

import java.time.LocalDate;

public record DoacaoResponse(
        Long idDoacao,
        Long idAgendamento,
        LocalDate dataRealizada,
        Double volumeMl,
        String observacoes
) {}


package com.marcosviniciusdev.model.dto.request;

import java.time.LocalDate;

public record DoacaoRequest(
        Long idAgendamento,
        LocalDate dataRealizada,
        Double volumeMl,
        String observacoes
) {}

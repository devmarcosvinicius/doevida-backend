package com.marcosviniciusdev.model.dto.request;

import java.time.LocalDate;

public record UsuarioFiltro(
        String nomeContains,
        String emailContains,
        String role,
        Boolean ativo,
        LocalDate createdFrom,
        LocalDate createdTo
) {}
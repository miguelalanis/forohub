package com.alura.ForoHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record RequestTopicoDTO(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long usuarioId,
        @NotNull
        String curso
) {

}

package com.alura.ForoHub.domain.topico;

public record ActualizarTopicoDTO(
        String titulo,
        String mensaje,
        String status,
        String curso
) {

}

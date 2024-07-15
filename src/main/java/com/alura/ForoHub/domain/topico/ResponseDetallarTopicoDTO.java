package com.alura.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record ResponseDetallarTopicoDTO(
       Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String usuario,
        String curso

) {

    public ResponseDetallarTopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}

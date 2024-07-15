CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(300) NOT NULL,
    topico_id bigint NOT NULL,
    fecha_creacion VARCHAR(100) NOT NULL,
    usuario_id bigint NOT NULL,
    solucion TINYINT,

    PRIMARY KEY (id)
);
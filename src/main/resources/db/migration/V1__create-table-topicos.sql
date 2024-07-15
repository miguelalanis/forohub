CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(300) NOT NULL,
    fecha_creacion VARCHAR(100) NOT NULL,
    status TINYINT,
    usuario_id bigint NOT NULL,
    curso_id bigint NOT NULL,
    activo TINYINT,

    PRIMARY KEY (id)
);
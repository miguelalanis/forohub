package com.alura.ForoHub.domain.topico.validaciones;

import com.alura.ForoHub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidadorDeTopicos{

    @Autowired
    private TopicoRepository repositorio;

    @Override
    public void validarTopico(String titulo, String mensaje) {

        if (repositorio.existsByTituloAndMensaje(titulo, mensaje)){
            throw new ValidationException("Este topico ya existe");
        }

    }

}

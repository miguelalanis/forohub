package com.alura.ForoHub.domain.topico;

import com.alura.ForoHub.domain.curso.Curso;
import com.alura.ForoHub.domain.curso.CursoRepository;
import com.alura.ForoHub.domain.topico.validaciones.ValidadorDeTopicos;
import com.alura.ForoHub.domain.usuario.Usuario;
import com.alura.ForoHub.domain.usuario.UsuarioRepository;
import com.alura.ForoHub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicoService {


    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    List<ValidadorDeTopicos> validaciones;

    public Topico registrarTopico(RequestTopicoDTO datos){

        if(!usuarioRepository.findById(datos.usuarioId()).isPresent()){
            throw new ValidacionDeIntegridad("este id para el usuario no fue encontrado");
        }
        if(!cursoRepository.existsByNombre(datos.curso())){
            throw new ValidacionDeIntegridad("este curso no fue encontrado");
        }

        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }

        Curso curso = cursoRepository.findByNombre(datos.curso());
        Usuario usuario = usuarioRepository.getReferenceById(datos.usuarioId());
        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                usuario,
                curso
        );
        topicoRepository.save(topico);

        return topico;
    }

    public Topico actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datos){
        Topico topico = topicoRepository.getReferenceById(id);
        if(!cursoRepository.existsByNombre(datos.curso())){
            throw new ValidacionDeIntegridad("este curso no fue encontrado");
        }
        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }
        Curso curso = cursoRepository.findByNombre(datos.curso());
        topico.actualizarTopico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                curso
        );
        return topico;
    }

}

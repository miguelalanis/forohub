package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoService service;

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<ResponseTopicoDTO>>  listarTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion"})Pageable paginacion){
        var page = repository.findByActivoTrue(paginacion).map(ResponseTopicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid RequestTopicoDTO datos){
      var topico = service.registrarTopico(datos);
      return ResponseEntity.ok(new ResponseDetallarTopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        if (repository.existsById(id) && repository.findActivoById(id)){
            var topico = repository.getReferenceById(id);
            return ResponseEntity.ok(new ResponseDetallarTopicoDTO(topico));
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el tópico solicitado o fue borrado");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datosActualizarTopico) {
        Topico topico = service.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok(new ResponseTopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (repository.existsById(id) && repository.findActivoById(id)){
            //Delete logico
            Topico topico = repository.getReferenceById(id);
            topico.desactivarTopico();
            return ResponseEntity.noContent().build();
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el tópico solicitado o fue borrado");
    }

}

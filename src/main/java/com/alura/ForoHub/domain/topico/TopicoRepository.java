package com.alura.ForoHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository <Topico, Long>{
    Page<Topico> findByActivoTrue(Pageable paginacion);

    @Query("""
            select t.activo
            from topico t
            where t.id=:idTopico
            """)
    Boolean findActivoById(Long idTopico);

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

}

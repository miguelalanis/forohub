package com.alura.ForoHub.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Page<Usuario> findByActivoTrue(Pageable paginacion);

    UserDetails findByCorreoElectronico(String correoElectronico);
}
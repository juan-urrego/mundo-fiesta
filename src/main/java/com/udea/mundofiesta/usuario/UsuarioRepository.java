package com.udea.mundofiesta.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    boolean existsByIdentificacion(int identificacion);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAllByRoles_Nombre(RolNombre rolNombre);
}
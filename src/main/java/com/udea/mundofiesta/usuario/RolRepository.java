package com.udea.mundofiesta.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombre(RolNombre rolNombre);
    boolean existsByNombre(RolNombre rolNombre);
}
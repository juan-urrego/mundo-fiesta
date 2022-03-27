package com.udea.mundofiesta.tipoProducto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
    Optional<TipoProducto> findByNombre(String nombre);
}
package com.udea.mundofiesta.producto;

import com.udea.mundofiesta.tipoProducto.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByDetalle_TipoProducto(TipoProducto tipoProducto);
}
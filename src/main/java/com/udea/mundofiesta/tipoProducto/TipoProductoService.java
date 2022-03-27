package com.udea.mundofiesta.tipoProducto;

import java.util.List;

public interface TipoProductoService {
    List<TipoProducto> getAll();
    TipoProducto getById(Integer id);
    TipoProducto getByNombre(String nombre);
    TipoProducto save(TipoProducto tipoProducto);
    TipoProducto update(Integer id, TipoProducto tipoProducto);
    void delete(Integer id);
}

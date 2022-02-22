package com.udea.mundofiesta.producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAll();
    Producto getById(Integer id);
    Producto save(Producto producto);
    Producto update(Integer id, Producto producto);
    void delete(Integer id);
}

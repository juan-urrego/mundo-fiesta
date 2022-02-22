package com.udea.mundofiesta.galeria;


import com.udea.mundofiesta.producto.Producto;

import java.util.List;

public interface ImagenService {
    List<Imagen> getAll();
    List<Imagen> getAllByIdCategoria(Integer idCategoria);
    Imagen save(Imagen imagen);
    void delete(Integer id);
}

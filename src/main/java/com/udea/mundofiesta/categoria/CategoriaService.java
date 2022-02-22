package com.udea.mundofiesta.categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getAll();
    Categoria getById(Integer id);
    Categoria save(Categoria categoria);
    Categoria update(Integer id, Categoria categoria);
    void delete(Integer id);
}

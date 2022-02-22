package com.udea.mundofiesta.detalle;

import java.util.List;

public interface DetalleService {

    List<Detalle> getAll();
    Detalle getById(Integer id);
    Detalle save(Detalle detalle);
    Detalle update(Integer id, Detalle detalle);
    void delete(Integer id);
}

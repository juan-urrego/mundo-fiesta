package com.udea.mundofiesta.caracteristica;

import java.util.List;

public interface CaracteristicaService {

    List<Caracteristica> getAll();
    Caracteristica getById(Integer id);
    Caracteristica save(Caracteristica caracteristica);
    Caracteristica update(Integer id, Caracteristica caracteristica);
    void delete(Integer id);
}

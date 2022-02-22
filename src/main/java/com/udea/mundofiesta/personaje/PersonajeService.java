package com.udea.mundofiesta.personaje;

import java.util.List;

public interface PersonajeService {

    List<Personaje> getAll();
    Personaje getById(Integer id);
    Personaje save(Personaje personaje);
    Personaje update(Integer id, Personaje personaje);
    void delete(Integer id);
}

package com.udea.mundofiesta.personaje;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonajeServiceImpl implements PersonajeService {

    final private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> getAll() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje getById(Integer id) {
        return personajeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @Override
    public Personaje save(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public Personaje update(Integer id, Personaje newPersonaje) {
        Personaje personaje = getById(id);
        personaje.setNombre(newPersonaje.getNombre());
        return save(personaje);
    }

    @Override
    public void delete(Integer id) {
        Personaje personaje = getById(id);
        personajeRepository.delete(personaje);
    }
}

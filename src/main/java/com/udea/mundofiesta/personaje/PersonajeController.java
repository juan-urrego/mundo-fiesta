package com.udea.mundofiesta.personaje;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
@AllArgsConstructor
@CrossOrigin
public class PersonajeController {

    final private PersonajeService personajeService;


    @GetMapping()
    public ResponseEntity<List<Personaje>> getAll() {
        List<Personaje> list = personajeService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaje> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personajeService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Personaje> save(@RequestBody Personaje personaje) {
        return new ResponseEntity<>(personajeService.save(personaje), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> update(@PathVariable("id")Integer id, @RequestBody Personaje personaje) {
        return new ResponseEntity<>(personajeService.update(id, personaje), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        personajeService.delete(id);
        return new ResponseEntity<>("Personaje eliminado", HttpStatus.OK);
    }
}

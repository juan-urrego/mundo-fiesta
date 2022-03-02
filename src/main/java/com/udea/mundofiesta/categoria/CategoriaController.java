package com.udea.mundofiesta.categoria;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
@CrossOrigin
public class CategoriaController {

    final private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<Categoria>> getAll() {
        List<Categoria> list = categoriaService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(categoriaService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(categoriaService.save(categoria), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable("id")Integer id, @RequestBody Categoria categoria) {
        return new ResponseEntity<>(categoriaService.update(id, categoria), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        categoriaService.delete(id);
        return new ResponseEntity<>("Categoria eliminado", HttpStatus.OK);
    }
}

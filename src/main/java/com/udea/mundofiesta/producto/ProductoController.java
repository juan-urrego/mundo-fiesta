package com.udea.mundofiesta.producto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
@CrossOrigin
public class ProductoController {

    final private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> list = productoService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/tipoProducto/{nombreTipoProducto}")
    public ResponseEntity<List<Producto>> getAllByTipoProducto(@PathVariable("nombreTipoProducto") String nombre) {
        List<Producto> list = productoService.getAllProductsByTipoProducto(nombre);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productoService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable("id")Integer id, @RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.update(id, producto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>("Producto eliminada", HttpStatus.OK);
    }
}

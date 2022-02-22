package com.udea.mundofiesta.tipoProducto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposProductos")
@AllArgsConstructor
public class TipoProductoController {

    final private TipoProductoService tipoProductoService;

    @GetMapping()
    public ResponseEntity<List<TipoProducto>> getAll() {
        List<TipoProducto> list = tipoProductoService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(tipoProductoService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TipoProducto> save(@RequestBody TipoProducto tipoProducto) {
        return new ResponseEntity<>(tipoProductoService.save(tipoProducto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> update(@PathVariable("id")Integer id, @RequestBody TipoProducto tipoProducto) {
        return new ResponseEntity<>(tipoProductoService.update(id, tipoProducto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        tipoProductoService.delete(id);
        return new ResponseEntity<>("TipoProducto eliminada", HttpStatus.OK);
    }
}

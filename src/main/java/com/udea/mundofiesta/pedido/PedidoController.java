package com.udea.mundofiesta.pedido;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
@CrossOrigin
public class PedidoController {

    final private PedidoService pedidoService;

    @GetMapping()
    public ResponseEntity<List<Pedido>> getAll() {
        List<Pedido> list = pedidoService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(pedidoService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id")Integer id, @RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoService.update(id, pedido), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        pedidoService.delete(id);
        return new ResponseEntity<>("Factura eliminada", HttpStatus.OK);
    }
}

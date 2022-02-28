package com.udea.mundofiesta.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
@AllArgsConstructor
public class UsuarioController {
    
    final private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> list = usuarioService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(usuarioService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id")Integer id, @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.update(id, usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
    }
}

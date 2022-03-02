package com.udea.mundofiesta.galeria;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/imagenes")
@AllArgsConstructor
@CrossOrigin
public class ImagenController {

    final private ImagenService imagenService;

    @GetMapping()
    public ResponseEntity<List<Imagen>> getAll() {
        List<Imagen> list = imagenService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Imagen>> getAllByCategoria(@PathVariable(value = "id") Integer id) {
        List<Imagen> list = imagenService.getAllByIdCategoria(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Imagen> save(@RequestParam MultipartFile multipartFile, @RequestParam Integer categoriaId) throws IOException {
        return new ResponseEntity<>(imagenService.save(multipartFile, categoriaId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws IOException {
        imagenService.delete(id);
        return new ResponseEntity<>("Imagen eliminada", HttpStatus.OK);
    }
}

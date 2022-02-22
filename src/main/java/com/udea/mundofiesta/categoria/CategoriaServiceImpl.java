package com.udea.mundofiesta.categoria;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    final private CategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getById(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }


    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Integer id, Categoria newCategoria) {
        Categoria categoria = getById(id);
        categoria.setNombre(newCategoria.getNombre());
        return save(categoria);
    }

    @Override
    public void delete(Integer id) {
        Categoria categoria = getById(id);
        categoriaRepository.delete(categoria);
    }
}

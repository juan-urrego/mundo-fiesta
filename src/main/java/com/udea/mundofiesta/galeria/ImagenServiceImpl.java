package com.udea.mundofiesta.galeria;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImagenServiceImpl implements ImagenService {

    final private ImagenRepository imagenRepository;

    @Override
    public List<Imagen> getAll() {
        return imagenRepository.findAll();
    }

    @Override
    public List<Imagen> getAllByIdCategoria(Integer idCategoria) {
        return imagenRepository.getAllByCategoria_Id(idCategoria);
    }

    @Override
    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    @Override
    public void delete(Integer id) {
        imagenRepository.deleteById(id);
    }
}

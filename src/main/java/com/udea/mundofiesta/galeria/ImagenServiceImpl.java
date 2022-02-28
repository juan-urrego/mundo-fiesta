package com.udea.mundofiesta.galeria;

import com.udea.mundofiesta.categoria.Categoria;
import com.udea.mundofiesta.categoria.CategoriaService;
import com.udea.mundofiesta.utils.CloudinaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ImagenServiceImpl implements ImagenService {

    final private ImagenRepository imagenRepository;
    final private CloudinaryService cloudinaryService;
    final private CategoriaService categoriaService;

    @Override
    public List<Imagen> getAll() {
        return imagenRepository.findByOrderById();
    }

    @Override
    public List<Imagen> getAllByIdCategoria(Integer idCategoria) {
        return imagenRepository.getAllByCategoria_Id(idCategoria);
    }

    @Override
    public Imagen getById(Integer id) {
        return imagenRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "imagen no encontrada"));
    }

    @Override
    public Imagen save(MultipartFile multipartFile, Integer idCategoria) throws IOException {
        Map result = cloudinaryService.upload(multipartFile);
        Categoria categoria = categoriaService.getById(idCategoria);
        Imagen imagen = new Imagen(
                (String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"),
                categoria
        );
        return imagenRepository.save(imagen);
    }

    @Override
    public void delete(Integer id) throws IOException {
        Imagen imagen = getById(id);
        Map result = cloudinaryService.delete(imagen.getCloudId());
        String respuesta = (String) result.get("result");
        if (!respuesta.equals("ok")) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "no se puedo eliminar");
        }
        imagenRepository.deleteById(id);
    }
}

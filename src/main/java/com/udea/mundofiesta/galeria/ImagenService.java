package com.udea.mundofiesta.galeria;


import com.udea.mundofiesta.producto.Producto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImagenService {
    List<Imagen> getAll();
    List<Imagen> getAllByIdCategoria(Integer idCategoria);
    Imagen getById(Integer id);
    Imagen save(MultipartFile multipartFile, Integer idCategoria) throws IOException;
    void delete(Integer id) throws IOException;
}

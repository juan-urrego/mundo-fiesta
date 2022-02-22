package com.udea.mundofiesta.galeria;

import com.udea.mundofiesta.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    List<Imagen> getAllByCategoria_Id(Integer idCategoria);
}
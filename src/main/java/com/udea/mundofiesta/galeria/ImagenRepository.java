package com.udea.mundofiesta.galeria;

import com.udea.mundofiesta.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    List<Imagen> getAllByCategoria_Id(Integer idCategoria);
    List<Imagen> findByOrderById();
}
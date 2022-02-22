package com.udea.mundofiesta.producto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    final private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getById(Integer id) {
        return productoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Integer id, Producto newProducto) {
        Producto producto = getById(id);
        producto.setNombre(newProducto.getNombre());
        producto.setDescripcion(newProducto.getDescripcion());
        producto.setImagen(newProducto.getImagen());
        producto.setPrecio(newProducto.getPrecio());
        producto.setDetalle(newProducto.getDetalle());
        producto.setCaracteristica(newProducto.getCaracteristica());
        return save(producto);
    }

    @Override
    public void delete(Integer id) {
        Producto producto = getById(id);
        productoRepository.delete(producto);
    }
}

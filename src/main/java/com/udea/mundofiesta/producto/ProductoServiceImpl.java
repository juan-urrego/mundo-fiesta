package com.udea.mundofiesta.producto;

import com.udea.mundofiesta.tipoProducto.TipoProducto;
import com.udea.mundofiesta.tipoProducto.TipoProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    final private ProductoRepository productoRepository;
    final private TipoProductoService tipoProductoService;
    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> getAllProductsByTipoProducto(String nombre) {
        TipoProducto tipoProducto = tipoProductoService.getByNombre(nombre);
        return productoRepository.findAllByDetalle_TipoProducto(tipoProducto);
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

package com.udea.mundofiesta.tipoProducto;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    final TipoProductoRepository tipoProductoRepository;

    public TipoProductoServiceImpl(TipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }

    @Override
    public List<TipoProducto> getAll() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public TipoProducto getById(Integer id) {
        return tipoProductoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @Override
    public TipoProducto save(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public TipoProducto update(Integer id, TipoProducto newTipoProducto) {
        TipoProducto tipoProducto = getById(id);
        tipoProducto.setNombre(newTipoProducto.getNombre());
        return save(tipoProducto);
    }

    @Override
    public void delete(Integer id) {
        TipoProducto tipoProducto = getById(id);
        tipoProductoRepository.delete(tipoProducto);
    }
}

package com.udea.mundofiesta.detalle;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleServiceImpl implements DetalleService {

    final private DetalleRepository detalleRepository;

    @Override
    public List<Detalle> getAll() {
        return detalleRepository.findAll();
    }

    @Override
    public Detalle getById(Integer id) {
        return detalleRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @Override
    public Detalle save(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public Detalle update(Integer id, Detalle newDetalle) {
        Detalle detalle = getById(id);
        detalle.setCategoria(newDetalle.getCategoria());
        detalle.setTipoProducto(newDetalle.getTipoProducto());
        return save(detalle);
    }

    @Override
    public void delete(Integer id) {
        Detalle detalle = getById(id);
        detalleRepository.delete(detalle);
    }
}

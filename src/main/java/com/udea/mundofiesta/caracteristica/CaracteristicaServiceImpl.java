package com.udea.mundofiesta.caracteristica;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CaracteristicaServiceImpl implements CaracteristicaService {

    final private CaracteristicaRepository caracteristicaRepository;

    @Override
    public List<Caracteristica> getAll() {
        return caracteristicaRepository.findAll();
    }

    @Override
    public Caracteristica getById(Integer id) {
        return caracteristicaRepository.getById(id);
    }

    @Override
    public Caracteristica save(Caracteristica caracteristica) {
        return caracteristicaRepository.save(caracteristica);
    }

    @Override
    public Caracteristica update(Integer id, Caracteristica caracteristica) {
        return caracteristicaRepository.save(caracteristica);
    }

    @Override
    public void delete(Integer id) {
        caracteristicaRepository.deleteById(id);
    }
}

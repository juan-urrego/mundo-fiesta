package com.udea.mundofiesta.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public boolean existsAdmin() {
        return rolRepository.existsByNombre(RolNombre.ROLE_ADMIN);
    }

    @Override
    public Rol getRolAdmin() {
        return rolRepository.findByNombre(RolNombre.ROLE_ADMIN).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado"));
    }

    @Override
    public Rol getRolById(Integer id) {
        return rolRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado"));
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
}

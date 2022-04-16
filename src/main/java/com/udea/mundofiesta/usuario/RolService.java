package com.udea.mundofiesta.usuario;


public interface RolService {
    boolean existsAdmin();
    Rol getRolAdmin();
    Rol getRolById(Integer id);
    Rol save(Rol rol);
}

package com.udea.mundofiesta.usuario;


public interface RolService {
    boolean existsAdmin();
    Rol getRolAdmin();
    Rol save(Rol rol);
}

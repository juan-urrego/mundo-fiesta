package com.udea.mundofiesta.usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAll();
    List<Usuario> getAllAdmins();
    Usuario getById(Integer id);
    Usuario getByEmail(String email);
    boolean existByIdentificacion(int identificacion);
    boolean existByEmail(String email);
    Usuario save(Usuario usuario);
    Usuario update(int id, Usuario usuario);
    void delete(int id);
}

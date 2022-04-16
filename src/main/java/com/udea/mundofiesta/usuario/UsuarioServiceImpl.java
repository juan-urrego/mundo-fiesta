package com.udea.mundofiesta.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolService rolService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = getByEmail(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(rol -> authorities.add(new SimpleGrantedAuthority(rol.getNombre().name())));
        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getAllAdmins() {
        return usuarioRepository.findAllByRoles_Nombre(RolNombre.ROLE_ADMIN);
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado"));
    }

    @Override
    public Usuario getByTelefono(String telefono) {
        return usuarioRepository.findByTelefono(telefono).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado"));
    }

    @Override
    public Usuario getByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "no encontrado"));
    }

    @Override
    public boolean existByIdentificacion(int identificacion) {
        return usuarioRepository.existsByIdentificacion(identificacion);
    }

    @Override
    public boolean existByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public Usuario save(Usuario usuario) {
        Rol rol = rolService.getRolById(usuario.getRoles().iterator().next().getId());
        if (existByIdentificacion(usuario.getIdentificacion()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "identificacion ya registrada");
        if (existByEmail(usuario.getEmail()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email ya registrado");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        if (rol.getNombre().equals(RolNombre.ROLE_USER))
            usuario.setPassword(passwordEncoder.encode("@fhjq7cbjv4@^mqUHr4Qum6"));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(int id, Usuario usuario) {
        Usuario usuarioExistente = getById(id);
        if (existByIdentificacion(usuario.getIdentificacion()) &&
                usuarioExistente.getIdentificacion() != usuario.getIdentificacion())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario con esa identificación ya existe");
        if (existByEmail(usuario.getEmail()) &&
                !(usuarioExistente.getEmail().equals(usuario.getEmail())))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuario con ese email ya existe");
        usuarioExistente.setTipoIdentificacion(usuario.getTipoIdentificacion());
        usuarioExistente.setIdentificacion(usuario.getIdentificacion());
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setDireccion(usuario.getDireccion());
        usuarioExistente.setTipoCliente(usuario.getTipoIdentificacion());
        usuarioExistente.setRoles(usuario.getRoles());
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void delete(int id) {
        Usuario usuario = getById(id);
        usuarioRepository.delete(usuario);
    }
}

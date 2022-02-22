package com.udea.mundofiesta.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id", nullable = false)
    private Integer id;

    @Column(name = "usr_nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "usr_telefono", nullable = false)
    private int telefono;

    @Column(name = "usr_direccion", nullable = false)
    private String direccion;

    @Column(name = "usr_tipo_identificacion", nullable = false, length = 2)
    private String tipoIdentificacion;

    @Column(name = "usr_identificacion", nullable = false, unique = true)
    private int identificacion;

    @Column(name = "usr_tipo_cliente", length = 20)
    private String tipoCliente;

    @ManyToMany
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new LinkedHashSet<>();

}
package com.udea.mundofiesta.tipoProducto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipos_productos")
@Getter
@Setter
@NoArgsConstructor
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_id", nullable = false)
    private Integer id;

    @Column(name = "tipo_nombre", nullable = false)
    private String nombre;

}
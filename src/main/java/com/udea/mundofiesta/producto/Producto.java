package com.udea.mundofiesta.producto;

import com.udea.mundofiesta.caracteristica.Caracteristica;
import com.udea.mundofiesta.detalle.Detalle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id", nullable = false)
    private Integer id;

    @Column(name = "pro_nombre", nullable = false)
    private String nombre;

    @Column(name = "pro_descripcion", nullable = false)
    private String descripcion;

    @Column(name = "pro_precio", nullable = false)
    private double precio;

    @Column(name = "pro_imagen", nullable = false)
    private String imagen;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pro_detalle_id")
    private Detalle detalle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pro_caracteristica_id")
    private Caracteristica caracteristica;

}
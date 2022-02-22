package com.udea.mundofiesta.detalle;

import com.udea.mundofiesta.categoria.Categoria;
import com.udea.mundofiesta.tipoProducto.TipoProducto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalles")
@Getter
@Setter
@NoArgsConstructor
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "det_categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "det_tipo_producto_id", nullable = false)
    private TipoProducto tipoProducto;
}
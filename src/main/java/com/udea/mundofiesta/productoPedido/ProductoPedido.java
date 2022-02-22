package com.udea.mundofiesta.productoPedido;

import com.udea.mundofiesta.producto.Producto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productos_pedidos")
@Getter
@Setter
@NoArgsConstructor
public class ProductoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_ped_id", nullable = false)
    private Integer id;

    @Column(name = "pro_ped_cantidad", nullable = false)
    private int cantidad;

    @Transient
    private double subTotal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pro_ped_producto_id", nullable = false)
    private Producto producto;

    public double getSubTotal() {
        return this.cantidad * this.producto.getPrecio();
    }
}
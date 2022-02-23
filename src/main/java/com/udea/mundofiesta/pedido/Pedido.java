package com.udea.mundofiesta.pedido;

import com.udea.mundofiesta.productoPedido.ProductoPedido;
import com.udea.mundofiesta.usuario.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id", nullable = false)
    private Integer id;

    @Column(name = "ped_date_stamp", nullable = false)
    private String dateStamp;

    @Column(name = "ped_domicilio", nullable = false)
    private boolean domicilio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FK_ped_usr_id", nullable = false)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pro_ped_pedido_id")
    private List<ProductoPedido> productoPedidos = new ArrayList<>();

    public void setProductoPedidos(List<ProductoPedido> productoPedidos) {
        this.productoPedidos.clear();
        if (!productoPedidos.isEmpty()) {
            this.productoPedidos.addAll(productoPedidos);
        }
    }

}
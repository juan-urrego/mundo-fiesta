package com.udea.mundofiesta.productoPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Integer> {
}
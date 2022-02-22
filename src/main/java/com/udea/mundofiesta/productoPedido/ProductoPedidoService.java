package com.udea.mundofiesta.productoPedido;

import java.util.List;

public interface ProductoPedidoService {

    List<ProductoPedido> getAll();
    ProductoPedido getById(Integer id);
    ProductoPedido save(ProductoPedido productoPedido);
    ProductoPedido update(Integer id, ProductoPedido productoPedido);
    void delete(Integer id);
}

package com.udea.mundofiesta.pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> getAll();
    Pedido getById(Integer id);
    Pedido save(Pedido pedido);
    Pedido update(Integer id, Pedido pedido);
    void delete(Integer id);
}

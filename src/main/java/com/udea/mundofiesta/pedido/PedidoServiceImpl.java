package com.udea.mundofiesta.pedido;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    final private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getById(Integer id) {
        return pedidoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Integer id, Pedido newPedido) {
        Pedido pedido = getById(id);
        pedido.setDateStamp(newPedido.getDateStamp());
        pedido.setDomicilio(newPedido.isDomicilio());
        pedido.setProductoPedidos(newPedido.getProductoPedidos());
        return save(pedido);
    }

    @Override
    public void delete(Integer id) {
        Pedido pedido = getById(id);
        pedidoRepository.delete(pedido);
    }
}

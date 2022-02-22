package com.udea.mundofiesta.productoPedido;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoPedidoServiceImpl implements ProductoPedidoService {

    final private ProductoPedidoRepository productoPedidoRepository;

    @Override
    public List<ProductoPedido> getAll() {
        return productoPedidoRepository.findAll();
    }

    @Override
    public ProductoPedido getById(Integer id) {
        return productoPedidoRepository.getById(id);
    }

    @Override
    public ProductoPedido save(ProductoPedido productoPedido) {
        return productoPedidoRepository.save(productoPedido);
    }

    @Override
    public ProductoPedido update(Integer id, ProductoPedido productoPedido) {
        return productoPedidoRepository.save(productoPedido);
    }

    @Override
    public void delete(Integer id) {
        productoPedidoRepository.deleteById(id);
    }
}

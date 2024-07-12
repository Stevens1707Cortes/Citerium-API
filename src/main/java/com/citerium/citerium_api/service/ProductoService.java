
package com.citerium.citerium_api.service;

import com.citerium.citerium_api.model.Producto;
import com.citerium.citerium_api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public int save(Producto producto) {
        return productoRepository.save(producto);
    }

    public int deleteById(int id) {
        return productoRepository.deleteById(id);
    }
}

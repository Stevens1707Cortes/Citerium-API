package com.citerium.citerium_api.controller;

import com.citerium.citerium_api.model.Producto;
import com.citerium.citerium_api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @PostMapping
    public int createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public int deleteProducto(@PathVariable int id) {
        return productoService.deleteById(id);
    }
}

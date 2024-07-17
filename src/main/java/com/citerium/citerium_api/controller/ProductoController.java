package com.citerium.citerium_api.controller;

import com.citerium.citerium_api.model.Producto;
import com.citerium.citerium_api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citerium/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }
    
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable int id) {
        return productoService.findById(id);
    }

    @PostMapping
    public int createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }
    
     @PutMapping("/{id}")
    public int updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.update(producto);
    }

    @DeleteMapping("/{id}")
    public int deleteProducto(@PathVariable int id) {
        return productoService.deleteById(id);
    }
}

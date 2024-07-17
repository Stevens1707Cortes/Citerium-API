
package com.citerium.citerium_api.controller;

import com.citerium.citerium_api.model.Usuario;
import com.citerium.citerium_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citerium/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }
    
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable int id) {
        return usuarioService.findById(id);
    }
    
    @PostMapping
    public int createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    
    @PutMapping("/{id}")
    public int updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public int deleteUsuario(@PathVariable int id) {
        return usuarioService.deleteById(id);
    }
}

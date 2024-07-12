/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citerium.citerium_api.service;

import com.citerium.citerium_api.model.Usuario;
import com.citerium.citerium_api.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public int save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public int deleteById(int id) {
        return usuarioRepository.deleteById(id);
    }
}

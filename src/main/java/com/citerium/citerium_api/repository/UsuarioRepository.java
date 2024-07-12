package com.citerium.citerium_api.repository;

import com.citerium.citerium_api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Usuario> rowMapper = new RowMapper<Usuario>() {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setIdentificacion(rs.getInt("identificacion"));
            usuario.setEmail(rs.getString("email"));
            usuario.setContrasena(rs.getString("contrasena"));
            return usuario;
        }
    };

    public List<Usuario> findAll() {
        return jdbcTemplate.query("SELECT * FROM usuario", rowMapper);
    }

    public int save(Usuario usuario) {
        return jdbcTemplate.update(
                "INSERT INTO usuario (nombre, apellido, identificacion, email, contrasena) VALUES (?, ?, ?, ?, ?)",
                usuario.getNombre(), usuario.getApellido(), usuario.getIdentificacion(), usuario.getEmail(),
                usuario.getContrasena());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM usuario WHERE id_usuario = ?", id);
    }
}

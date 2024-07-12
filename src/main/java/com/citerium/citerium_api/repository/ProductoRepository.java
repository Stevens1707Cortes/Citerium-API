package com.citerium.citerium_api.repository;

import com.citerium.citerium_api.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Producto> rowMapper = new RowMapper<Producto>() {
        @Override
        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Producto producto = new Producto();
            producto.setId(rs.getInt("id_producto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setCodigo(rs.getInt("codigo"));
            producto.setCategoria(rs.getString("categoria"));
            producto.setFecha(rs.getString("fecha"));
            producto.setUnidades(rs.getInt("unidades"));
            producto.setPrecio(rs.getDouble("precio"));
            return producto;
        }
    };

    public List<Producto> findAll() {
        return jdbcTemplate.query("SELECT * FROM producto", rowMapper);
    }

    public int save(Producto producto) {
        return jdbcTemplate.update(
                "INSERT INTO producto (nombre, codigo, categoria, fecha, unidades, precio) VALUES (?, ?, ?, ?, ?, ?)",
                producto.getNombre(), producto.getCodigo(), producto.getCategoria(), producto.getFecha(),
                producto.getUnidades(), producto.getPrecio());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM producto WHERE id_producto = ?", id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caleb
 */
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into Producto(nombreProducto, descripcionProducto, precio, existencia, claveCategoria) values(?,?,?,?,?)";
    public static final String SQL_UPDATE = "update Producto set nombreProducto = ?, descripcionProducto = ?, precio = ?, existencia = ?, claveCategoria = ? where idProducto = ?";
    public static final String SQL_DELETE = "delete from Producto where idProducto = ?";
    public static final String SQL_READ = "select idProducto, nombreProducto, descripcionProducto, precio, existencia, claveCategoria from Producto where idProducto = ?";
    public static final String SQL_READ_ALL = "select idProducto,  nombreProducto, descripcionProducto, precio, existencia, stockMinimo, claveCategoria from Producto";

    private Connection conexion;

    private void conectar() {
        String user = "postgres";
        String pwd = "n0m3l0s3";
        String url = "jdbc:postgresql://localhost:5432/Base3CM13";
        String pgDriver = "org.postgresql.Driver";

        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List readAll() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
        return null;
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            ProductoDTO p = new ProductoDTO();
            p.getEntidad().setIdProducto(rs.getInt("idProducto"));
            p.getEntidad().setIdProducto(rs.getInt("idProducto"));
        }
        return resultados;
    }

}

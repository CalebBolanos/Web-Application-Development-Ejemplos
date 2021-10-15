/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.CallableStatement;
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
public class CategoriaDAO {//data access object, encapsular la logica de datos

//    private static final String SQL_INSERT = "insert into categoria (nombreCategoria, descripcionCategoria) values (?, ?)";
//    public static final String SQL_UPDATE = "update Categoria set nombreCategoria = ?, descripcionCategoria = ? where idCategoria = ?";
//    public static final String SQL_DELETE = "delete from Categoria where idCategoria = ?";
//    public static final String SQL_READ = "select idCategoria, nombreCategoria, descripcionCategoria from Categoria where idCategoria = ?";
//    public static final String SQL_READ_ALL = "select idCategoria, nombreCategoria, descripcionCategoria from Categoria";
    
    private static final String SQL_INSERT = "";
    public static final String SQL_UPDATE = "";
    public static final String SQL_DELETE = "";
    public static final String SQL_READ = "";
    public static final String SQL_READ_ALL = "select * from seleccionaTodoCategoria()";

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
    

    public void create(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCategoria());//primer signo de interrogacion
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.executeUpdate();//consulta de actualizacion
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.setInt(3, dto.getEntidad().getIdCategoria());
            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public void delete(CategoriaDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public CategoriaDTO read(CategoriaDTO dto)throws SQLException{
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return (CategoriaDTO)resultados.get(0);
            }else{
                return null;
            }
            
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while(rs.next()){
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    public List readAll()throws SQLException{
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.prepareCall(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return resultados;
            }else{
                return null;
            }
            
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conexion != null) conexion.close();
        }
    }
    
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoria(1);
        //dto.getEntidadad().setNombreCategoria("computo");
        //dto.getEntidadad().setDescripcionCategoria("Cosas para el escuela");
        
        try {
            //dao.create(dto);
            //dao.update(dto);
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

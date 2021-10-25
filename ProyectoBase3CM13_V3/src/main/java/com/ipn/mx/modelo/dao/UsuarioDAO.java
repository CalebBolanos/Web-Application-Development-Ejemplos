/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
drop table usuario;

create table usuario(
	idUsuario serial not null primary key,
	nombre varchar(100) not null,
	paterno varchar(100) not null,
	materno varchar(100) not null,
	email varchar(100) not null,
	nombreUsuario varchar(100) not null,
	claveUsuario varchar(100) not null,
	tipoUsuario varchar(100) not null
);

select * from usuario;

CREATE OR REPLACE PROCEDURE spInsertarUsuario(nom character varying, pat character varying,
											mat character varying, mail character varying,
											nombreUsr character varying, clave character varying, tipo character varying)
 LANGUAGE sql
AS $procedure$
	insert into usuario (nombre, paterno, materno, email, nombreUsuario, claveUsuario, tipoUsuario) 
	values (nom, pat, mat, mail, nombreUsr, clave, tipo);
$procedure$
;

call spInsertarUsuario('nombre', 'pater', 'mat', 'mail@mail.com', 'usr1', 'si', '1');

CREATE OR REPLACE PROCEDURE spActualizarUsuario(nom character varying, pat character varying,
											mat character varying, mail character varying,
											nombreUsr character varying, clave character varying, tipo character varying, id int)
 LANGUAGE sql
AS $procedure$
	update  usuario set nombre = nombre, 
						paterno = pat,
						materno = mat,
						email = mail,
						nombreUsuario = nombreUsr,
						claveUsuario = clave,
						tipoUsuario = tipo			
	where idUsuario = id;
$procedure$
;
call spActualizarUsuario('nombre2', 'pater2', 'mat', 'mail@mail.com', 'usr2', 'si', '1', 1);

drop function seleccionarUsuario(in id int);
CREATE OR REPLACE FUNCTION seleccionarUsuario(in id int)
 RETURNS TABLE(idUsuario int,
	nombre varchar(100),
	paterno varchar(100),
	materno varchar(100),
	email varchar(100),
	nombreUsuario varchar(100),
	claveUsuario varchar(100),
	tipoUsuario varchar(100))
 LANGUAGE sql
AS $function$
    SELECT * FROM usuario where idUsuario = id;
$function$
;
select * from seleccionarUsuario(1);

drop function seleccionarTodoUsuario();
CREATE OR REPLACE FUNCTION seleccionarTodoUsuario()
 RETURNS TABLE(idUsuario int,
	nombre varchar(100),
	paterno varchar(100),
	materno varchar(100),
	email varchar(100),
	nombreUsuario varchar(100),
	claveUsuario varchar(100),
	tipoUsuario varchar(100))
 LANGUAGE sql
AS $function$
    SELECT * FROM usuario;
$function$
;
select * from seleccionarTodoUsuario();


create or replace procedure spEliminarUsuario(in id int)
language sql 
as $$
	delete from usuario where idUsuario=id;
$$
;

call spEliminarUsuario(1);


 **/

public class UsuarioDAO {
    private static final String SQL_INSERT = "call spInsertarUsuario(?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE = "call spActualizarUsuario(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "call spEliminarUsuario(?)";
    public static final String SQL_READ = "select * from seleccionarUsuario(?)";
    public static final String SQL_READ_ALL = "select * from seleccionarTodoUsuario()";

    private Connection conexion;

    public Connection conectar() {
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
        return conexion;
    }
    
    public void create(UsuarioDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombre());//primer signo de interrogacion
            ps.setString(2, dto.getEntidad().getPaterno());
            ps.setString(3, dto.getEntidad().getMaterno());
            ps.setString(4, dto.getEntidad().getEmail());
            ps.setString(5, dto.getEntidad().getNombreUsuario());
            ps.setString(6, dto.getEntidad().getClaveUsuario());
            ps.setString(7, dto.getEntidad().getTipoUsuario());
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
    
    public void update(UsuarioDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombre());//primer signo de interrogacion
            ps.setString(2, dto.getEntidad().getPaterno());
            ps.setString(3, dto.getEntidad().getMaterno());
            ps.setString(4, dto.getEntidad().getEmail());
            ps.setString(5, dto.getEntidad().getNombreUsuario());
            ps.setString(6, dto.getEntidad().getClaveUsuario());
            ps.setString(7, dto.getEntidad().getTipoUsuario());
            ps.setInt(8, dto.getEntidad().getIdUsuario());
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
    
    public void delete(UsuarioDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
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
    
    public UsuarioDTO read(UsuarioDTO dto)throws SQLException{
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return (UsuarioDTO)resultados.get(0);
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
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsuario(rs.getInt("idUsuario"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setNombreUsuario(rs.getString("nombreUsuario"));
            dto.getEntidad().setClaveUsuario(rs.getString("claveUsuario"));
            dto.getEntidad().setTipoUsuario(rs.getString("tipoUsuario"));
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
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(2);
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

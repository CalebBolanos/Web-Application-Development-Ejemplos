/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;

/**
 *
 * @author caleb
 */
public class CategoriaDTO implements Serializable{//transfer object
    private Categoria entidadad;

    public CategoriaDTO() {
        entidadad = new Categoria();
    }

    public Categoria getEntidadad() {
        return entidadad;
    }

    public void setEntidadad(Categoria entidadad) {
        this.entidadad = entidadad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("clave: ").append(getEntidadad().getIdCategoria()).append("\n");
        sb.append("nombre: ").append(getEntidadad().getNombreCategoria()).append("\n");
        sb.append("descripcion: ").append(getEntidadad().getDescripcionCategoria()).append("\n");
        return sb.toString();
    }
    
    
}

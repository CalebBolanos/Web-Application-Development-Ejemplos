/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web.producto;

import com.ipn.mx.controlador.web.categoria.VerCategoria;
import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caleb
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("listaDeProductos")) {
            listaDeProductos(request, response);
        } else {
            if (accion.equals("nuevo")) {
                nuevoProducto(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarProducto(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarProducto(request, response);
                    } else {
                        if (accion.equals("ver")) {
                            verProducto(request, response);
                        } else {
                            if (accion.equals("guardar")) {
                                almacenarProducto(request, response);
                            }
                        }
                    }
                }
            }
        }

        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("<title>Ver Categoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n"
                    + "                <div class=\"container-fluid\">\n"
                    + "                    <a class=\"navbar-brand\" href=\"#\">Demo</a>\n"
                    + "                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "                        <span class=\"navbar-toggler-icon\"></span>\n"
                    + "                    </button>\n"
                    + "                    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n"
                    + "                        <ul class=\"navbar-nav\">\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"TablasDeMultiplicar\">Tablas de Multiplicar</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"MostrarDatosCategoria\">Listado de Categorias</a>\n"
                    + "                            </li>\n"
                    + "                            <li class=\"nav-item\">\n"
                    + "                                <a class=\"nav-link\" href=\"categoriaForm.html\">Nuevo</a>\n"
                    + "                            </li>\n"
                    + "                        </ul>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </nav>");
            out.println("<table class ='table table-striped'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<td>Clave del producto</td>");
            out.println("<td>Nombre del producto</td>");
            out.println("<td>Descripcion del producto</td>");
            out.println("<td>Precio del producto</td>");
            out.println("<td>Existencia del producto</td>");
            out.println("<td>Stock</td>");
            out.println("<td>Categoria</td>");
            out.println("<td>Eliminar</td>");
            out.println("<td>Actualizar</td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("</table>");
            out.println("<tbody>");
            ProductoDAO dao = new ProductoDAO();
            List lista;
            try {
                lista = dao.readAll();
            } catch (SQLException ex) {
                lista = new ArrayList();
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < lista.size(); i++) {
                ProductoDTO dto = (ProductoDTO) lista.get(i);
                out.println("<td><a href='ProductoController?accion=ver&id="+dto.getEntidad().getIdProducto()+"' class='btn btn-warning'>Actualizar</a></td>");
                out.println("<td>"+dto.getEntidad().getNombreProducto()+"</td>");
                out.println("<td>"+dto.getEntidad().getDescripcionProducto()+"</td>");
                out.println("<td>"+dto.getEntidad().getExistencia()+"</td>");
                out.println("<td>"+dto.getEntidad().getStockMinimo()+"</td>");
                out.println("<td>"+dto.getEntidad().getClaveCategoria()+"</td>");
                out.println("<td><a href='ProductoController?accion=eliminar&id="+dto.getEntidad().getIdProducto()+"' class='btn btn-danger'>Eliminar</a></td>");
                out.println("<td><a href='ProductoController?accion=actualizar&id="+dto.getEntidad().getIdProducto()+"' class='btn btn-succes'>Actualizar</a></td>");
                out.println("");
                
            }
            
            out.println("</tbody>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listaDeProductos(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void verProducto(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void almacenarProducto(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

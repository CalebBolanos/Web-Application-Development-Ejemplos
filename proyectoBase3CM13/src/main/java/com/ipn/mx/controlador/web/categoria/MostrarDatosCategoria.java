/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web.categoria;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "MostrarDatosCategoria", urlPatterns = {"/MostrarDatosCategoria"})
public class MostrarDatosCategoria extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" \n"
                    + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
            out.println("<title>Lista de categorias</title>");
            out.println("<script>\n"
                    + "function llenarForm(id, nombre, descripcion){\n"
                    + "    document.getElementById(\"nombre\").value = nombre;\n"
                    + "    document.getElementById(\"descripcion\").value = descripcion;\n"
                    + "    document.getElementById(\"id\").value = id;\n"
                    + "}\n"
                    + "\n"
                    + "</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1>Lista de Categorias</h1>");
            out.println("<table class=\"table table-bordered\">");
            out.print("<tr>");
            out.println("<th>Clave</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Descripcion</th>");
            out.println("<th>Eliminar</th>");
            out.println("<th>Actualizar</th>");
            out.print("</tr>");
            CategoriaDAO dao = new CategoriaDAO();
            try {
                List lista = dao.readAll();
                for (int i = 0; i < lista.size(); i++) {
                    CategoriaDTO dto = (CategoriaDTO) lista.get(i);
                    out.println("<tr>");
                    out.println("<td><a href='VerCategoria?id=" + dto.getEntidadad().getIdCategoria() + "' class='btn btn-warning'>" + dto.getEntidadad().getIdCategoria() + "</a></td>");

                    out.println("<td>" + dto.getEntidadad().getNombreCategoria() + "</td>");
                    out.println("<td>" + dto.getEntidadad().getDescripcionCategoria() + "</td>");
                    out.println("<td><a href='EliminarCategoria?id=" + dto.getEntidadad().getIdCategoria() + "' class='btn btn-danger' >Eliminar</a></td>");
                    out.println("<td><button onclick=\"llenarForm(" + dto.getEntidadad().getIdCategoria() + ", '" + dto.getEntidadad().getNombreCategoria() + "', '" + dto.getEntidadad().getDescripcionCategoria() + "');\" class='btn btn-success' data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Actualizar</a></td>");
                    //href='ActualizarCategoria?id=" + dto.getEntidadad().getIdCategoria() + "
                    out.println("<tr>");
                }

            } catch (SQLException ex) {
                Logger.getLogger(MostrarDatosCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("</table>");
            out.println("<a href='categoriaForm.html'class='btn btn-primary'>Agregar categoria</a>");
            out.print("<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                    + "    <div class=\"modal-dialog\">\n"
                    + "        <div class=\"modal-content\">\n"
                    + "            <div class=\"modal-header\">\n"
                    + "                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Actualizar Datos</h5>\n"
                    + "                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                    + "            </div>\n"
                    + "            <form name=\"frmActualizar\" method=\"get\" action=\"ActualizarCategoria\">\n"
                    + "                <div class=\"modal-body\">\n"
                    + "                    <div class=\"mb-3\">\n"
                    + "                        <label for=\"nombre\" class=\"form-label\">Nombre</label>\n"
                    + "                        <input type=\"text\" class=\"form-control\" id=\"nombre\" name=\"nombreActualizado\" aria-describedby=\"emailHelp\">\n"
                    + "                    </div>\n"
                    + "                    <div class=\"mb-3\">\n"
                    + "                        <label for=\"descripcion\" class=\"form-label\">Descripción</label>\n"
                    + "                        <input type=\"text\" class=\"form-control\" id=\"descripcion\" name=\"descripcionActualizada\">\n"
                    + "                    </div>\n"
                    + "                    <div class=\"mb-3 form-check\">\n"
                    + "                        <input type=\"hidden\" class=\"form-check-input\" id=\"id\" name = \"id\">\n"
                    + "                    </div>\n"
                    + "                    \n"
                    + "                </div>\n"
                    + "                <div class=\"modal-footer\">\n"
                    + "                    <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Cerrar</button>\n"
                    + "                    <button type=\"submit\" class=\"btn btn-primary\">Actualizar</button>\n"
                    + "                </div>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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

}

<%-- 
    Document   : agregarCategoria
    Created on : 7 oct. 2021, 07:30:21
    Author     : caleb
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            
            dto.getEntidad().setNombreCategoria(request.getParameter("txtNombre"));
            dto.getEntidad().setDescripcionCategoria(request.getParameter("txtDecripcion"));

            dao.create(dto);
            
            response.sendRedirect("listaDeCategorias.jsp");
        %>
    </body>
</html>

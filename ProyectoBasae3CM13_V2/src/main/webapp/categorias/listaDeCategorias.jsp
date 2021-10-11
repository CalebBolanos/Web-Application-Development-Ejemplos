<%-- 
    Document   : listaDeCategorias
    Created on : 4 oct. 2021, 07:16:12
    Author     : caleb
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Demo</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../TablasDeMultiplicar.jsp">Tablas de Multiplicar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">listado de Categorias</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="card border-primary">
                <div class="card-header">
                    <h1>Lista de categorias</h1>
                    <div class="card-body text-primary">
                        <table class="table table-stripped">
                            <tr>
                                <th>Clave categoria</th>
                                <th>Nombre categoria</th>
                                <th>Descripcion categoria</th>
                                <th>Eliminar categoria</th>
                                <th>Actualizar categoria</th>
                            </tr>
                            <%
                                CategoriaDAO dao = new CategoriaDAO();
                                List lista = dao.readAll();
                                if(lista.size() == 0){}
                                for (int i = 0; i < lista.size(); i++) {
                                    CategoriaDTO cat = (CategoriaDTO) lista.get(i);
                            %>
                            <tr>
                                <td>
                                    <a href="verDatos.jsp?id=<%=cat.getEntidad().getIdCategoria()%>" class="btn btn-warning">
                                        <%=cat.getEntidad().getIdCategoria()%>
                                    </a>
                                </td>
                                <td><%=cat.getEntidad().getNombreCategoria()%></td>
                                <td><%=cat.getEntidad().getDescripcionCategoria()%></td>
                                <td><a href="eliminar.jsp?id=<%=cat.getEntidad().getIdCategoria()%>" class="btn btn-danger">Eliminar</a></td>
                                <td><a href="actualizar.jsp?id=<%=cat.getEntidad().getIdCategoria()%>" class="btn btn-success">Actualizar</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        
                        <a href="nuevaCategoria.jsp" class="btn btn-primary">Nueva</a><!-- comment -->
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


<%-- 
    Document   : verDatos
    Created on : 4 oct. 2021, 07:51:52
    Author     : caleb
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
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
                    <%
                        CategoriaDAO dao = new CategoriaDAO();
                        CategoriaDTO dto = new CategoriaDTO();
                        dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));

                        dto = dao.read(dto);

                        if(dto != null){
                    %>
                    <div class="card-body text-primary">
                        <table class="table table-stripped">
                            <tr>
                                <th>Clave categoria</th>
                                <td><%=dto.getEntidad().getIdCategoria()%></td>
                            </tr>
                            <tr>
                                <th>Nombre categoria</th>
                                <td><%=dto.getEntidad().getNombreCategoria()%></td>
                            </tr>
                            <tr>
                                <th>Descripcion categoria</th>
                                <td><%=dto.getEntidad().getDescripcionCategoria()%></td>
                            </tr>
                        </table>

                        <a href="listaDeCategorias.jsp" class="btn btn-warning">Regresar</a><!-- comment -->
                    </div>  
                    <%
                        }else{
                            out.println("Sin valores a mostrar");
                        }
                    %>

                    
                </div>
            </div>
        </div>

    </body>
</html>

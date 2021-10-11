<%-- 
    Document   : actualizar
    Created on : 7 oct. 2021, 08:01:31
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
                                <a class="nav-link active" aria-current="page" href="../inicio.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../TablasDeMultiplicar.jsp">Tablas de Multiplicar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listaDeCategorias.jsp">listado de Categorias</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            
            <%
                CategoriaDAO dao = new CategoriaDAO();
                CategoriaDTO dto = new CategoriaDTO();
                dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));

                dto = dao.read(dto);

                if(dto != null){
            %>
            <div class="mb-3"></div>
            <div class="card border-success">
                <h1 class="text-primary text_center">Actualizar categoria</h1>
                <div class="card-body">
                    <form method="POST" action="almacenarCambios.jsp">
                        <div class="mb-3">
                            <label class="form-label">Clave</label>
                            <input type="text" name="txtClave" id="txtClave" placeholder=">Clave Categoria" 
                                   required="required" maxlength="50" class="form-control"
                                   value="<%=dto.getEntidad().getIdCategoria()%>" readonly=""/>

                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nombre de Categoria</label>
                            <input type="text" name="txtNombre" id="txtNombre" placeholder="Nombre Categoria" 
                                   required="required" maxlength="50" class="form-control"
                                   value="<%=dto.getEntidad().getNombreCategoria()%>"/>

                        </div>
                        <div class="mb-3">
                            <label class="form-label">Descripción de Categoria</label>
                            <input type="text" name="txtDecripcion" id="txtDecripcion" placeholder="Descripcion de Categoria" 
                                   required="required" maxlength="100" class="form-control"
                                   value="<%=dto.getEntidad().getDescripcionCategoria()%>"/>

                        </div>

                        <button type="submit" class="btn btn-success">Actualizar categoria</button>
                    </form>
                </div>
            </div>
            <%}%>
        </div>
    </body>
</html>

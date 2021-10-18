<%-- 
    Document   : listaCategorias
    Created on : 11 oct. 2021, 08:28:51
    Author     : caleb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>

        <title>Lista de categorias</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Proyecto Base v3
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Listado De Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=nuevo">Nueva Categoria</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Listado de Productos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Nuevo Producto</a>
                            </li>
                            <!--        <li class="nav-item dropdown">
                                      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Dropdown link
                                      </a>
                                      <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        <li><a class="dropdown-item" href="#">Action</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                      </ul>
                                    </li>-->
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

        <div class="card border-primary">
            <div class="card-header text-center">
                Categorias
            </div>
            <div class="card-body">
                <h4 class="card-title">
                    <a href="CategoriaServlet?accion=nuevo" class="btn btn-outline-success">Crear Categoria</a>
                </h4>
                <h4 class="card-title">
                    <a href="CategoriaServlet?accion=graficar" class="btn btn-outline-primary" target="_blank">Mostrar Gráfica</a>
                </h4>
                <c:if test="${mensaje != null}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <strong>${mensaje}</strong>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" arial-label="Close"></button>
                    </div>
                </c:if>
                
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Clave Categoria</th>
                            <th>Nombre Categoria</th>
                            <th>Descripción Categoria</th>
                            <th>Eliminar</th>
                            <th>Actualizar</th>
                            <th>Reporte</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${listaDeCategorias}">
                        <tbody>
                            <tr>
                                <td><a href="CategoriaServlet?accion=ver&id=<c:out value="${dto.entidad.idCategoria}" />" class="btn btn-outline-warning"><c:out value="${dto.entidad.idCategoria}" /></a></td>
                                <td><c:out value="${dto.entidad.nombreCategoria}" /></td>
                                <td><c:out value="${dto.entidad.descripcionCategoria}" /></td>
                                <td>
                                    <a href="CategoriaServlet?accion=eliminar&id=<c:out value="${dto.entidad.idCategoria}" />" class="btn btn-outline-danger">Eliminar</a>
                                </td>
                                <td>
                                    <a href="CategoriaServlet?accion=actualizar&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-success">Actualizar</a>
                                </td>
                                <td>
                                    <a href="CategoriaServlet?accion=verReporte&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-info">Reporte</a>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>

                    </table>

                </div>
            </div>
        </body>
    </html>

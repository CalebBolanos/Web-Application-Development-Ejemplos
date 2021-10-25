<%-- 
    Document   : usuariosForm
    Created on : 24 oct. 2021, 20:28:24
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

        <title>Categorias Form</title>
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
            
            <div class="card card-border-primary">
                <div class="card-header">
                    <h1>Datos del usuario</h1>
                </div>
                <div class="card-body">
                    <form method="POST" action="UsuarioServlet?accion=guardar">
                        <div class="nb-3">
                            <label class="form-label">Nombre</label>
                            <input class="form-control" type="text" name="txtNombre" id="txtNombre"
                                   placeholder="Nombre"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.nombre}" />" />
                        </div>
                        <div class="nb-3">
                            <label class="form-label">Paterno</label>
                            <input class="form-control" type="text" name="txtPaterno" id="txtPaterno"
                                   placeholder="Paterno"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.paterno}" />" />
                        </div>
                        <div class="nb-3">
                            <label class="form-label">Materno</label>
                            <input class="form-control" type="text" name="txtMaterno" id="txtMaterno"
                                   placeholder="Materno"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.materno}" />" />
                        </div>
                        <div class="nb-3">
                            <label class="form-label">Email</label>
                            <input class="form-control" type="mail" name="txtEmail" id="txtEmail"
                                   placeholder="Email"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.email}" />" />
                        </div>
                        <div class="nb-3">
                            <label class="form-label">Nombre de Usuario</label>
                            <input class="form-control" type="mail" name="txtNombreUsuario" id="txtNombreUsuario"
                                   placeholder="Nombre de Usuario"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.nombreUsuario}" />" />
                        </div>
                        <div class="nb-3">
                            <label class="form-label">Clave de Usuario</label>
                            <input class="form-control" type="password" name="txtClaveUsuario" id="txtClaveUsuario"
                                   placeholder="Nombre de Usuario"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.claveUsuario}" />" />
                        </div>
                        <div class="nb-3">
                            <label class="form-label">Tipo de Usuario</label>
                            <input class="form-control" type="text" name="txtTipoUsuario" id="txtTipoUsuario"
                                   placeholder="Tipo de Usuario"
                                   required="required"
                                   maxlength="50"
                                   value="<c:out value="${usuario.entidad.tipoUsuario}" />" />
                        </div>
                            <button type="submit" class="btn btn-outline-primary">Guardar Usuario</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

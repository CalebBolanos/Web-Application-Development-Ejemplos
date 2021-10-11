<%-- 
    Document   : nuevaCategoria
    Created on : 7 oct. 2021, 07:24:00
    Author     : caleb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina de Inicio</title>
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
                                <a class="nav-link" href="TablasDeMultiplicar.jsp">Tablas de Multiplicar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="categorias/listaDeCategorias.jsp">listado de Categorias</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <div class="card border-success">
                <h1 class="text-primary text_center">Datos de la categoria</h1>
                <div class="card-body">
                    <form method="POST" action="agregarCategoria.jsp">
                        <div class="mb-3">
                            <label class="form-label">Nombre de Categoria</label>
                            <input type="text" name="txtNombre" id="txtNombre" placeholder="Nombre Categoria" 
                                   required="required" maxlength="50" class="form-control"/>

                        </div>
                        <div class="mb-3">
                            <label class="form-label">Descripción de Categoria</label>
                            <input type="text" name="txtDecripcion" id="txtDecripcion" placeholder="Descripcion de Categoria" 
                                   required="required" maxlength="100" class="form-control"/>

                        </div>

                        <button type="submit" class="btn btn-primary">Registrar categoria</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : TareasApp
    Created on : 6/10/2023, 11:09:58 a. m.
    Author     : Juan Goyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String nombreUsuario = request.getParameter("nombreUsuario");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tareas App</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="../css/style.css"/>
    </head>
    <body>


        <h1 class="display-3 fw-bold">Bienvenido <%= nombreUsuario%> </h1>
        <div class="container p-4">
            <div class="row">
                <div class="col-md-4">
                    <div class="card card-body">

                        <form action="SvPerro" method="POST" enctype="multipart/form-data">
                            <!--Entrada nombre perro-->
                            <div class="mb-3">
                                <label for="nombre" class="form-label">id:</label>
                                <input type="text" name="nombre" class="form-control">
                            </div>

                            <div class="mb-3">
                                <label for="raza" class="form-label">Titulo:</label>
                                <input type="text" name="raza" class="form-control">
                            </div>

                            <div class="mb-3">
                                <label for="raza" class="form-label">Descripcion:</label>
                                <input type="text" name="raza" class="form-control">
                            </div>


                            <input class="btn btn-success" type="submit" value="Agregar Tarea">
                        </form>
                        <br>
                        <!--Boton volver-->
                        <a href="index.jsp">Volver a la página principal</a>
                    </div>
                </div>
                <!--Encabezado de tabla-->
                <div class="col-md-8">
                    <h1>Listado de Perros</h1>
                    <table class="table table-bordered table-dark">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>Titulo</th>
                                <th>Descripcion</th>
                                <th>Fecha</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <!--Iconos-->
                                    <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-nombre=""><i class="fas fa-eye"></i></a> <!--ver -->
                                    <i class="ti ti-pencil"></i> <!--editar -->
                                    <i class="ti ti-trash"></i> <!--borrar -->
                                </td>



                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>


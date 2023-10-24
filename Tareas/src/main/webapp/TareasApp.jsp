<%-- Document : TareasApp Created on : 6/10/2023, 11:09:58 a. m. Author : Juan Goyes --%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.umariana.tareas.Tarea" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    String nombreUsuario = request.getParameter("nombreUsuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tareas App</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="../css/style.css" />
    </head>

    <body style="background-color: #cccccc">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ganador.jsp">Ganador</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="perdedor.jsp">Perdedor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="perroMasViejo.jsp">Perro mas viejo</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Ordenamiento
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="SvPerro?ordenar=nombre">Nombre</a></li>
                                <li><a class="dropdown-item" href="SvPerro?ordenar=puntos">Puntos</a></li>
                                <li><a class="dropdown-item" href="SvPerro?ordenar=edad">Edad</a></li>
                            </ul>
                        </li>
                    </ul>
                    <<form class="d-flex" action="searchPerro.jsp" method="GET">
                        <input class="form-control me-2" type="search" name="nombre" placeholder="De el nombre de perro" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Buscar</button>
                    </form>
                </div>
            </div>
        </nav>
        <p>Bienvenido <%= nombreUsuario%> <p>
        <div class="container p-4">
            <div class="row">
                <div class="col-md-4">
                    <div class="card card-body">
                        <form action="SvNuevaTarea" method="POST">
                            <!-- Entrada para la id de la tarea -->
                            <div class="mb-3">
                                <label class="form-label">id:</label>
                                <input type="text" class="form-control" name="id" required>
                            </div>
                            <!-- Entrada para el titulo de la tarea -->
                            <div class="mb-3">
                                <label class="form-label">Titulo:</label>
                                <input type="text" class="form-control" name="titulo" required>
                            </div>
                            <!-- Entrada para la descripcion de la tarea -->
                            <div class="mb-3">
                                <label class="form-label">Descripcion:</label>
                                <textarea rows="2" cols="5" class="form-control" name="descripcion"></textarea>
                            </div>
                            <!-- Entrada para la fecha de la actividad -->
                            <div class="mb-3">
                                <label class="form-label">Fecha:</label>
                                <input type="date" name="fecha" required>
                            </div>
                            <!--Opciones para agregar al principio o al final -->
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="opcion" value="inicio">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    Agregar Tarea al Inicio
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="opcion" value="final" checked>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Agregar Tarea al Final
                                </label>
                            </div>
                            <br>
                            <button class="btn btn-success" type="submit">Agregar tarea</button>
                        </form>
                        <br>
                        <!-- Botón volver -->
                        <a href="index.jsp">Cerrar Sesion</a>
                    </div>
                </div>
                <!-- Encabezado de tabla -->
                <div class="col-md-8">
                    <h1>Listado de Tareas</h1>
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
                            <%
                                // Obtener la lista enlazada de listaEnlazadas
                                List<Tarea> listaE = (LinkedList<Tarea>) request.getAttribute("listaEnlazada");
                                if (listaE != null) {
                                    for (Tarea tarea : listaE) {
                            %>
                            <tr>
                                <td><%= tarea.getId()%></td>
                                <td><%= tarea.getTitulo()%></td>
                                <td><%= tarea.getDescripcion()%></td>
                                <td><%= tarea.getFecha()%></td>
                                <td>
                                    <!-- Iconos -->
                                    <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"><i
                                            class="fas fa-eye"></i></a>
                                    <!-- Icono para vista -->
                                    <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editarModal"><i
                                            class="fas fa-pencil-alt"></i></a>
                                    <a href="#" class="btn btn-danger" onclick=""><i class="fas fa-trash-alt"></i></a>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

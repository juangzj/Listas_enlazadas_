package Servlets;

import com.umariana.tareas.ControlanrUsuario;
import com.umariana.tareas.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Goyes
 */

@WebServlet(name = "SvTarea", urlPatterns = {"/SvTarea"})
public class SvTarea extends HttpServlet {

    private ArrayList<Usuario> usuarios= new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Verifica si el usuario está autenticado o registrado
    String nombreUsuario = request.getParameter("nombreUsuario"); // Suponiendo que este sea el parámetro que identifica al usuario
    String contrasenia=  request.getParameter("contra"); 
    
    System.out.println("nombre usuairo "+nombreUsuario);
    System.out.println("nombre constraseña "+contrasenia);
    try {
        if (ControlanrUsuario.verificarUsuarioCreado(nombreUsuario,contrasenia)) {
            // Usuario autenticado, redirige a TareasApp.jsp
            response.sendRedirect("TareasApp.jsp?nombreUsuario=" + nombreUsuario);
        } else {
            // Usuario no autenticado, redirige a index.jsp con un mensaje de alerta
            String errorMessage = "Por favor, inicie sesión o regístrese.";
            String script = "<script>alert('" + errorMessage + "'); window.location.href = 'index.jsp';</script>";
            response.setContentType("text/html");
            response.getWriter().write(script);
        }
    } catch (IOException e) {
        // Maneja las excepciones si es necesario
        e.printStackTrace();
    }
}


    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    // Obtener los parámetros para el registro de un nuevo usuario
    String nombre = request.getParameter("nombre");
    String cedula = request.getParameter("cedula");
    String contrasenia = request.getParameter("contrasenia");

    System.out.println("Nombre: " + nombre);
    System.out.println("Cedula: " + cedula);
    System.out.println("Contraseña: " + contrasenia);

    // Verificar si el usuario ya existe
    if (ControlanrUsuario.verificarUsuarioCreado(nombre, contrasenia)) {
        // El usuario ya existe, muestra un mensaje de error y redirige
        String errorMessage = "El usuario ya está registrado.";

        // Utiliza JavaScript para mostrar la alerta de error y redirigir después de hacer clic en "Aceptar"
        String script = "<script>alert('" + errorMessage + "'); window.location.href = 'index.jsp';</script>";
        response.setContentType("text/html");
        response.getWriter().write(script);
    } else {
        // El usuario no existe, crea un nuevo usuario y guárdalo
        Usuario nuevoUsuario = new Usuario(nombre, cedula, contrasenia);
        usuarios.add(nuevoUsuario);
        ControlanrUsuario.guardarUsuario(usuarios); // Agrega el usuario a la lista
        

        String nombreUsuario = nuevoUsuario.getNomUsuario();
        String script = "<script>alert('Se ha registrado exitosamente.'); window.location.href = 'index.jsp?nombreUsuario=" + nombreUsuario + "';</script>";
        response.setContentType("text/html");
        response.getWriter().write(script);
    }
    
    System.out.println("Antes de redireccionar ");
    // Redirecciona a la página de tareas
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

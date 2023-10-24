package Servlets;

import com.umariana.tareas.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvNuevaTarea", urlPatterns = {"/SvNuevaTarea"})
public class SvNuevaTarea extends HttpServlet {

    List<Tarea> listaEnlazada = new LinkedList<Tarea>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //LLamar a los daros que se escribieropn en el formulario
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        String opcion = request.getParameter("opcion");

        System.out.println("Id: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("fecha: " + fecha);
        System.out.println("opcion: " + opcion);

        if ("inicio".equals(opcion)) {//si la opcion es inicio, la tarea se inserta al inicio de la lista enlazada
            listaEnlazada.add(0, new Tarea(Integer.parseInt(id), titulo, descripcion, fecha));
        } else if ("final".equals(opcion)) {//si la opcion es final, la tarea se inserta al final de la lista enlazada
            listaEnlazada.add(new Tarea(Integer.parseInt(id), titulo, descripcion, fecha));

        }
        //enviar atributos a jsp
        request.setAttribute("listaEnlazada", listaEnlazada);
        //redireccionar la pagina a jsp
        request.getRequestDispatcher("TareasApp.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}


package com.umariana.tareas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;


public class ControlanrUsuario {
     private static ArrayList<Usuario> usuarios= new ArrayList<>();
    
    
    
    
public static void guardarUsuario(ArrayList<Usuario> nuevosUsuarios) throws IOException {
    // Obtén la ubicación del directorio "data" dentro de tu proyecto usando getResource()
    URL resourceUrl = ControlanrUsuario.class.getResource("../../../../../data");

    System.out.println("ruta : "+resourceUrl);
    // Comprueba si se encontró la ubicación del directorio "data"
    if (resourceUrl != null) {
        String ruta = resourceUrl.getPath() + "/usuarios.txt";

        File archivo = new File(ruta);
        String rutaAbsoluta = archivo.getAbsolutePath();
        System.out.println("Ruta donde se guarda la información: " + rutaAbsoluta);
        PrintWriter lapiz = new PrintWriter(new FileWriter(archivo, true));

        if (nuevosUsuarios.isEmpty()) {
            lapiz.close();
            return;
        }

        for (Usuario usuario : nuevosUsuarios) {
            lapiz.print(usuario.getNomUsuario());
            lapiz.print(",");
            lapiz.print(usuario.getCedula());
            lapiz.print(",");
            lapiz.print(usuario.getContraseña());
            lapiz.println();
        }

        lapiz.close();
    } else {
        System.out.println("No se encontró el directorio 'data'");
    }
}



    
    
  public static void cargarUsuarios() throws FileNotFoundException, IOException {
    URL resourceUrl = ControlanrUsuario.class.getResource("../../../../../data/usuarios.txt");

    if (resourceUrl != null) {
        File archivoACargar = new File(resourceUrl.getPath());
        usuarios = new ArrayList<>(); // Inicializa la lista de usuarios

        if (archivoACargar.exists() && archivoACargar.isFile()) {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoACargar))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] datosUsuario = linea.split(",");

                    Usuario nuevoUsuario = new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2]);
                    usuarios.add(nuevoUsuario);
                }
            }
        }
    } else {
        System.out.println("No se encontró el archivo 'usuarios.txt'");
    }
}



    public static void crearUsuario(){
        
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        ControlanrUsuario.usuarios = usuarios;
    }
    
    
    public static boolean verificarUsuarioCreado(String nombre, String contrasenia) throws IOException {
        
        cargarUsuarios();
    
        for (Usuario usuario : usuarios) {
        
        if (usuario.getNomUsuario().equals(nombre)  && usuario.getContraseña().equals(contrasenia)) {
            
            return true; // El usuario existe en la lista
            
        }
    }
 
    return false; // El usuario no se encuentra en la lista
}
}

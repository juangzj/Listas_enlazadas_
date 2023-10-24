package com.umariana.tareas;

public class Nodo {

    private Tarea tarea;
    private Nodo siguiente;

    public Nodo(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
    }

    /**
     * metodo para enlazar al siguiente nodo
     *
     * @param n
     */
    public void enlazarSiguiente(Nodo n) {
        siguiente = n;
    }

    /**
     * metodo para obtener el siguiente nodo
     *
     * @return
     */

    public Nodo obtnerSiguiente() {
        return siguiente;
    }

    /**
     * Metodo para obtener el valor del Nodo
     *
     * @return
     */

    public Tarea obtenerValor() {
        return tarea;
    }
}

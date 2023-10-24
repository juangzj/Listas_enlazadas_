
package com.umariana.tareas;

/**
 *
 * @author Usuario 1
 */
public class ListaEnlazadaIns {

    Nodo cabeza;
    int size;

    public ListaEnlazadaIns() {
        cabeza = null;
        size = 0;
    }

    public boolean estaVacia() {
        return (cabeza == null);
    }

    /**
     * Merodo para agregar una nueva tarea al iniicio de la lista enlazada
     *
     * @param tarea
     */
    public void añadirTareaInicio(Tarea tarea) {
        // comprobamos si la lista es null y si lo es, agregarmos la tarea en la cabeza
        if (cabeza == null) {
            cabeza = new Nodo(tarea);
        } else {//si la cabeza no es nula, creamos un nodo y la enlazamos
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(tarea);
            nuevo.enlazarSiguiente(temp);
        }
        size++;
    }

    /**
     * metodo para obtener el tamano de la lista enlazada
     *
     * @return
     */
    public int tamanio() {
        return size;
    }

    public Tarea tarea(int index) {
        int contador = 0;
        Nodo temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtnerSiguiente();
        }
        return (Tarea) temporal.obtenerValor();
    }
}

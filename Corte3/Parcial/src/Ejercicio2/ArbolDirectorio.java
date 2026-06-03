package Ejercicio2;

import Ejercicio4.Jugador;

public class ArbolDirectorio {

    private Contacto raiz;

    public ArbolDirectorio() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Contacto insertar(Contacto nodo, int id, String nombre, String telefono, String ciudad) {
        if (nodo == null)
            return new Contacto(id, nombre, telefono, ciudad);
        if (id < nodo.id)
            nodo.izquierdo = insertar(nodo.izquierdo, id, nombre, telefono, ciudad);
        else if (id > nodo.id)
            nodo.derecho = insertar(nodo.derecho, id, nombre, telefono, ciudad);
        else
            System.out.println("Ya existe un contacto con id " + id + " - no se insertó");
        return nodo;
    }

    public void insertar(int id, String nombre, String telefono, String ciudad) {
        raiz = insertar(raiz, id, nombre, telefono, ciudad);
    }

    private Contacto buscar(Contacto nodo, int id) {
        if (nodo == null)
            return null;
        if (id == nodo.id)
            return nodo;
        if (id < nodo.id)
            return buscar(nodo.izquierdo, id);
        else
            return buscar(nodo.derecho, id);
    }

    public Contacto buscar(int id) {
        return buscar(raiz, id);
    }

    private void inOrden(Contacto nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println("  " + nodo);
            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {
        if (isEmpty()) {
            System.out.println("[Arbol Vacio]");
            return;
        }
        System.out.println("    inOrden (Id ascendente:");
        inOrden(raiz);
    }

    private void preOrden(Contacto nodo) {
        if (nodo != null) {
            System.out.println("  " + nodo);
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void preOrden() {
        if (isEmpty()) {
            System.out.println("  [ Árbol vacío ]");
            return;
        }
        System.out.println("  PreOrden (raíz primero):");
        preOrden(raiz);
    }

    private int altura(Contacto nodo) {
        if (nodo == null)
            return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Contacto nodo) {
        if (nodo == null)
            return 0;
        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

}

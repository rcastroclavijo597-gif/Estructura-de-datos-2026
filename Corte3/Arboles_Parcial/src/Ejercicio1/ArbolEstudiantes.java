package Ejercicio1;

public class ArbolEstudiantes {
    private Estudiante raiz;

    public ArbolEstudiantes() { this.raiz = null; }
    public boolean isEmpty()  { return raiz == null; }

    private Estudiante insertar(Estudiante nodo, double promedio, String nombre, String codigo, String carrera) {
        if (nodo == null) return new Estudiante(promedio, nombre, codigo, carrera);
        if (promedio < nodo.promedio)
            nodo.izquierdo = insertar(nodo.izquierdo, promedio, nombre, codigo, carrera);
        else if (promedio > nodo.promedio)
            nodo.derecho = insertar(nodo.derecho, promedio, nombre, codigo, carrera);
        else
            System.out.println("Ya existe un estudiante con promedio " + promedio + " — no se insertó.");
        return nodo;
    }

    public void insertar(double promedio, String nombre, String codigo, String carrera) {
        raiz = insertar(raiz, promedio, nombre, codigo, carrera);
    }

    private Estudiante buscar(Estudiante nodo, double promedio) {
        if (nodo == null) return null;
        if (promedio == nodo.promedio) return nodo;
        if (promedio < nodo.promedio)  return buscar(nodo.izquierdo, promedio);
        else                           return buscar(nodo.derecho,   promedio);
    }

    public Estudiante buscar(double promedio) { return buscar(raiz, promedio); }

    private void inOrden(Estudiante nodo) {
        if (nodo != null) { inOrden(nodo.izquierdo); System.out.println("  " + nodo); inOrden(nodo.derecho); }
    }

    public void inOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  InOrden (promedio ascendente):"); inOrden(raiz);
    }

    private void preOrden(Estudiante nodo) {
        if (nodo != null) { System.out.println("  " + nodo); preOrden(nodo.izquierdo); preOrden(nodo.derecho); }
    }

    public void preOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  PreOrden (raíz primero):"); preOrden(raiz);
    }

    private int altura(Estudiante nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }
    public int altura() { return altura(raiz); }

    private int contarHojas(Estudiante nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }
    public int contarHojas() { return contarHojas(raiz); }

    // MÉTODO RETO: contar estudiantes con promedio > umbral (aprovecha propiedad BST)
    private int contarSobre(Estudiante nodo, double umbral) {
        if (nodo == null) return 0;
        if (nodo.promedio <= umbral)
            return contarSobre(nodo.derecho, umbral);
        else
            return 1 + contarSobre(nodo.derecho, umbral) + contarSobre(nodo.izquierdo, umbral);
    }
    public int contarSobre(double umbral) { return contarSobre(raiz, umbral); }

    // EXTRA PARCIAL: contar estudiantes en un rango de promedios [min, max]
    private int contarEnRango(Estudiante nodo, double min, double max) {
        if (nodo == null) return 0;
        int count = (nodo.promedio >= min && nodo.promedio <= max) ? 1 : 0;
        if (nodo.promedio > min) count += contarEnRango(nodo.izquierdo, min, max);
        if (nodo.promedio < max) count += contarEnRango(nodo.derecho,   min, max);
        return count;
    }
    public int contarEnRango(double min, double max) { return contarEnRango(raiz, min, max); }
}
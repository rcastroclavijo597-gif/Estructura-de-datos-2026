package Ejercicio5;

public class ArbolInventario {
    private Repuesto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Repuesto insertar(Repuesto nodo, int codigoRef, String descripcion, String marca, int stock) {
        if (nodo == null)
            return new Repuesto(codigoRef, descripcion, marca, stock);
        if (codigoRef < nodo.codigoRef)
            nodo.izquierdo = insertar(nodo.izquierdo, codigoRef, descripcion, marca, stock);
        else if (codigoRef > nodo.codigoRef)
            nodo.derecho = insertar(nodo.derecho, codigoRef, descripcion, marca, stock);
        else
            System.out.println("Ya existe un repuesto con código " + codigoRef + " — no se insertó.");
        return nodo;
    }

    public void insertar(int codigoRef, String descripcion, String marca, int stock) {
        raiz = insertar(raiz, codigoRef, descripcion, marca, stock);
    }

    private Repuesto buscar(Repuesto nodo, int codigoRef) {
        if (nodo == null)
            return null;
        if (codigoRef == nodo.codigoRef)
            return nodo;
        if (codigoRef < nodo.codigoRef)
            return buscar(nodo.izquierdo, codigoRef);
        else
            return buscar(nodo.derecho, codigoRef);
    }

    public Repuesto buscar(int codigoRef) {
        return buscar(raiz, codigoRef);
    }

    private void inOrden(Repuesto nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println("  " + nodo);
            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {
        if (isEmpty()) {
            System.out.println("  [ Árbol vacío ]");
            return;
        }
        System.out.println("  InOrden (código ascendente):");
        inOrden(raiz);
    }

    private void preOrden(Repuesto nodo) {
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

    private int altura(Repuesto nodo) {
        if (nodo == null)
            return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Repuesto nodo) {
        if (nodo == null)
            return 0;
        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private void backupPreOrden(Repuesto nodo) {
        if (nodo != null) {
            System.out.println("  [" + nodo.codigoRef + "] " + nodo.descripcion + " - " + nodo.marca + " (" + nodo.stock
                    + " uds)");
            backupPreOrden(nodo.izquierdo);
            backupPreOrden(nodo.derecho);
        }
    }

    public void backupPreOrden() {
        if (isEmpty()) {
            System.out.println("  [ Árbol vacío ]");
            return;
        }
        System.out.println("  Backup PreOrden (orden de reconstrucción):");
        backupPreOrden(raiz);
    }

    public void reporteRepuestosUnicos() {
        if (isEmpty()) {
            System.out.println("  [ Árbol vacío ]");
            return;
        }
        int unicos = contarHojas();
        System.out.println("  Repuestos únicos sin variantes relacionadas: " + unicos);
        if (unicos == 1)
            System.out.println("  Solo 1 repuesto no tiene variantes en el catálogo.");
        else
            System.out.println("  Estos " + unicos + " repuestos no tienen variantes asociadas en el catálogo.");
    }
}

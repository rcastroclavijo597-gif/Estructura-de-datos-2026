package Ejercicio2;

public class ArbolProductos {
    private Producto raiz;

    public ArbolProductos() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Producto insertar(Producto nodo, int codigo, String nombre, double precio, int stock) {
        if (nodo == null)
            return new Producto(codigo, nombre, precio, stock);
        if (codigo < nodo.codigoBarras)
            nodo.izquierdo = insertar(nodo.izquierdo, codigo, nombre, precio, stock);
        else if (codigo > nodo.codigoBarras)
            nodo.derecho = insertar(nodo.derecho, codigo, nombre, precio, stock);
        else
            System.out.println("Ya existe un producto con código " + codigo + " — no se insertó.");
        return nodo;
    }

    public void insertar(int codigo, String nombre, double precio, int stock) {
        raiz = insertar(raiz, codigo, nombre, precio, stock);
    }

    private Producto buscar(Producto nodo, int codigo) {
        if (nodo == null)
            return null;
        if (codigo == nodo.codigoBarras)
            return nodo;
        if (codigo < nodo.codigoBarras)
            return buscar(nodo.izquierdo, codigo);
        else
            return buscar(nodo.derecho, codigo);
    }

    public Producto buscar(int codigo) {
        return buscar(raiz, codigo);
    }

    private void inOrden(Producto nodo) {
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

    private void preOrden(Producto nodo) {
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

    private int altura(Producto nodo) {
        if (nodo == null)
            return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Producto nodo) {
        if (nodo == null)
            return 0;
        if (nodo.izquierdo == null && nodo.derecho == null)
            return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    // MÉTODO RETO: contar productos con stock < umbral (genera orden de compra)
    private int contarStockBajo(Producto nodo, int umbral) {
        if (nodo == null)
            return 0;
        int count = (nodo.stock < umbral) ? 1 : 0;
        return count + contarStockBajo(nodo.izquierdo, umbral) + contarStockBajo(nodo.derecho, umbral);
    }

    public int contarStockBajo(int umbral) {
        return contarStockBajo(raiz, umbral);
    }

    // EXTRA PARCIAL: calcular el valor total del inventario (precio * stock)
    private double calcularValorInventario(Producto nodo) {
        if (nodo == null)
            return 0;
        return (nodo.precio * nodo.stock)
                + calcularValorInventario(nodo.izquierdo)
                + calcularValorInventario(nodo.derecho);
    }

    public double calcularValorInventario() {
        return calcularValorInventario(raiz);
    }
}
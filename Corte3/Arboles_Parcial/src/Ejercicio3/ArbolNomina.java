package Ejercicio3;

public class ArbolNomina {
    private Empleado raiz;

    public ArbolNomina() { this.raiz = null; }
    public boolean isEmpty()  { return raiz == null; }

    private Empleado insertar(Empleado nodo, int cedula, String nombre, String departamento, double salario) {
        if (nodo == null) return new Empleado(cedula, nombre, departamento, salario);
        if (cedula < nodo.cedula)
            nodo.izquierdo = insertar(nodo.izquierdo, cedula, nombre, departamento, salario);
        else if (cedula > nodo.cedula)
            nodo.derecho = insertar(nodo.derecho, cedula, nombre, departamento, salario);
        else
            System.out.println("Ya existe un empleado con cédula " + cedula + " — no se insertó.");
        return nodo;
    }

    public void insertar(int cedula, String nombre, String departamento, double salario) {
        raiz = insertar(raiz, cedula, nombre, departamento, salario);
    }

    private Empleado buscar(Empleado nodo, int cedula) {
        if (nodo == null) return null;
        if (cedula == nodo.cedula) return nodo;
        if (cedula < nodo.cedula)  return buscar(nodo.izquierdo, cedula);
        else                       return buscar(nodo.derecho,   cedula);
    }

    public Empleado buscar(int cedula) { return buscar(raiz, cedula); }

    private void inOrden(Empleado nodo) {
        if (nodo != null) { inOrden(nodo.izquierdo); System.out.println("  " + nodo); inOrden(nodo.derecho); }
    }

    public void inOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  InOrden (cédula ascendente):"); inOrden(raiz);
    }

    private void preOrden(Empleado nodo) {
        if (nodo != null) { System.out.println("  " + nodo); preOrden(nodo.izquierdo); preOrden(nodo.derecho); }
    }

    public void preOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  PreOrden (raíz primero):"); preOrden(raiz);
    }

    private int altura(Empleado nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }
    public int altura() { return altura(raiz); }

    private int contarHojas(Empleado nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izAquierdo) + contarHojas(nodo.derecho);
    }
    public int contarHojas() { return contarHojas(raiz); }

    // MÉTODO RETO: calcular la nómina total (suma de todos los salarios)
    private double calcularNominaTotal(Empleado nodo) {
        if (nodo == null) return 0;
        return nodo.salario
            + calcularNominaTotal(nodo.izquierdo)
            + calcularNominaTotal(nodo.derecho);
    }
    public double calcularNominaTotal() { return calcularNominaTotal(raiz); }

    // EXTRA PARCIAL: contar empleados con salario mayor a un umbral
    private int contarSalarioMayorA(Empleado nodo, double umbral) {
        if (nodo == null) return 0;
        int count = (nodo.salario > umbral) ? 1 : 0;
        return count
            + contarSalarioMayorA(nodo.izquierdo, umbral)
            + contarSalarioMayorA(nodo.derecho,   umbral);
    }
    public int contarSalarioMayorA(double umbral) { return contarSalarioMayorA(raiz, umbral); }
}
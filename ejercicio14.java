// clase NodoEmpleado
class NodoEmpleado {
    String cargo;
    NodoEmpleado izquierdo;
    NodoEmpleado derecho;

    public NodoEmpleado(String cargo) {
        this.cargo = cargo;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ejercicio14 {

    public static void main(String[] args) {

        // crear nodos
        NodoEmpleado gerente = new NodoEmpleado("Gerente");

        NodoEmpleado supervisor1 = new NodoEmpleado("Supervisor1");
        NodoEmpleado supervisor2 = new NodoEmpleado("Supervisor2");

        NodoEmpleado analista1 = new NodoEmpleado("Analista1");
        NodoEmpleado analista2 = new NodoEmpleado("Analista2");

        // construir el arbol
        gerente.izquierdo = supervisor1;
        gerente.derecho = supervisor2;

        supervisor1.izquierdo = analista1;
        supervisor1.derecho = analista2;

        // imprimir como el mapa de referencia
        System.out.println("         " + gerente.cargo);
        System.out.println("        /       \\");
        System.out.println("   " + supervisor1.cargo + "  " + supervisor2.cargo);
        System.out.println("    /      \\");
        System.out.println(analista1.cargo + "  " + analista2.cargo);
    }
}
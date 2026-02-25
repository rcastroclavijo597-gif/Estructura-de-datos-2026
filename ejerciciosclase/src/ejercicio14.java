/* Una empresa tiene la siguiente jerarquía:

         Gerente
        /       \
   Supervisor1  Supervisor2
    /      \
 Analista1 Analista2
Modela la jerarquía con nodos que tengan el campo cargo.
Imprime el árbol recorriéndolo nivel por nivel. */

package ejerciciosclase.src;

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

        NodoEmpleado gerente = new NodoEmpleado("Gerente");

        NodoEmpleado supervisor1 = new NodoEmpleado("Supervisor1");
        NodoEmpleado supervisor2 = new NodoEmpleado("Supervisor2");

        NodoEmpleado analista1 = new NodoEmpleado("Analista1");
        NodoEmpleado analista2 = new NodoEmpleado("Analista2");

        gerente.izquierdo = supervisor1;
        gerente.derecho = supervisor2;

        supervisor1.izquierdo = analista1;
        supervisor1.derecho = analista2;

        System.out.println("         " + gerente.cargo);
        System.out.println("        /       \\");
        System.out.println("   " + supervisor1.cargo + "  " + supervisor2.cargo);
        System.out.println("    /      \\");
        System.out.println(analista1.cargo + "  " + analista2.cargo);
    }
}
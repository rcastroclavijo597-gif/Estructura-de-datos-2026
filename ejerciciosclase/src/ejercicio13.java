package ejerciciosclase.src;

class NodoResiduo {
    String nombre;
    NodoResiduo izquierdo;
    NodoResiduo derecho;

    public NodoResiduo(String nombre) {
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ejercicio13 {

    public static void main(String[] args) {

        NodoResiduo residuos = new NodoResiduo("Residuos");

        NodoResiduo organicos = new NodoResiduo("Organicos");
        NodoResiduo inorganicos = new NodoResiduo("Inorganicos");

        NodoResiduo comida = new NodoResiduo("Comida");
        NodoResiduo jardin = new NodoResiduo("Jardin");
        NodoResiduo plastico = new NodoResiduo("Plastico");
        NodoResiduo papel = new NodoResiduo("Papel");

        residuos.izquierdo = organicos;
        residuos.derecho = inorganicos;

        organicos.izquierdo = comida;
        organicos.derecho = jardin;

        inorganicos.izquierdo = plastico;
        inorganicos.derecho = papel;

        System.out.println("        " + residuos.nombre);
        System.out.println("       /        \\");
        System.out.println("  " + organicos.nombre + "      " + inorganicos.nombre);
        System.out.println("   /    \\       /      \\");
        System.out.println(comida.nombre + "  " + jardin.nombre + "   " + plastico.nombre + "   " + papel.nombre);
    }
}
Un sistema universitario necesita registrar la información básica de un estudiante:nombre completo,código(número entero),semestre actual,promedio acumulado y si está matriculado o no.Declara las variables con los tipos de datos apropiados.Asigna valores de ejemplo.Imprime un reporte por consola con el siguiente formato:===Ficha del Estudiante===Nombre:Ana Torres Código:20241001 Semestre:3 Promedio:3.85 Matriculado:true
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
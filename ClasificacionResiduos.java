// Clase Nodo para el árbol
class Nodo {
    String nombre;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ClasificacionResiduos {
    public static void main(String[] args) {

        // Crear nodos del árbol
        Nodo raiz = new Nodo("Residuos");

        Nodo organicos = new Nodo("Orgánicos");
        Nodo inorganicos = new Nodo("Inorgánicos");

        Nodo comida = new Nodo("Comida");
        Nodo jardin = new Nodo("Jardín");
        Nodo plastico = new Nodo("Plástico");
        Nodo papel = new Nodo("Papel");

        // Construir el árbol
        raiz.izquierda = organicos;
        raiz.derecha = inorganicos;

        organicos.izquierda = comida;
        organicos.derecha = jardin;

        inorganicos.izquierda = plastico;
        inorganicos.derecha = papel;

        // Mostrar árbol en recorrido preorden
        System.out.println("Clasificación de residuos (recorrido preorden):");
        preorden(raiz);
    }

    // Recorrido preorden del árbol
    public static void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.nombre);
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }
}

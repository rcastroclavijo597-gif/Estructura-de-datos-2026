package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio2;

public class Galeria {
    Fotografia cabeza;
    Fotografia cola;

    public Galeria() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarFoto(Fotografia foto) {

        if (cabeza == null) {
            cabeza = foto;
            cola = foto;
        } else {
            cola.siguiente = foto;
            foto.anterior = cola;
            cola = foto;
        }
    }

    public Fotografia fotoAnterior(Fotografia actual) {

        if (actual.anterior == null) {
            System.out.println("No hay foto anterior.");
            return actual;
        }

        return actual.anterior;
    }

    // Ir a la siguiente foto
    public Fotografia siguienteFoto(Fotografia actual) {

        if (actual.siguiente == null) {
            System.out.println("No hay siguiente foto.");
            return actual;
        }

        return actual.siguiente;
    }

    public void reproducirGaleria() {

        Fotografia aux = cabeza;

        System.out.println("Hacia adelante:");

        while (aux != null) {
            System.out.println(aux.nombre);

            if (aux.siguiente == null) {
                break;
            }

            aux = aux.siguiente;
        }

        System.out.println("Hacia atrás:");

        while (aux != null) {
            System.out.println(aux.nombre);
            aux = aux.anterior;
        }
    }
}

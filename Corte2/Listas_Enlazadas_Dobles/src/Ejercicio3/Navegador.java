package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio3;

public class Navegador {
    Pestana cabeza;
    Pestana cola;

    public Navegador() {
        cabeza = null;
        cola = null;
    }

    public void abrirPestana(Pestana nueva) {
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    public void cerrarPestanaActual(String url) {
        if (cabeza == null) {
            System.out.println("No hay pestañas abiertas.");
            return;
        }

        Pestana actual = cabeza;
        while (actual != null) {
            if (actual.url.equals(url)) {
                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    } else {
                        cola = null;
                    }
                }

                else if (actual == cola) {
                    cola = actual.anterior;
                    if (cola != null) {
                        cola.siguiente = null;
                    } else {
                        cabeza = null;
                    }
                }

                else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }

                System.out.println("Pestaña cerrada: " + actual.tituloPagina);
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("No se encontró la pestaña con URL: " + url);
    }

    public void mostrarPestanas() {
        if (cabeza == null) {
            System.out.println("No hay pestañas abiertas.");
            return;
        }
        Pestana temp = cabeza;
        System.out.println("\n--- Pestañas abiertas ---");
        while (temp != null) {
            System.out
                    .println("Título: " + temp.tituloPagina + " | URL: " + temp.url + " | Hora: " + temp.horaApertura);
            temp = temp.siguiente;
        }
    }
}

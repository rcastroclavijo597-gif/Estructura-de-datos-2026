package Corte2.Listas_Circulares.src.Ejercicio5;

public class Torneo {
    Equipo cabeza;
    Equipo cola;

    public void agregarEquipo(Equipo equipo) {
        if (cabeza == null) {
            cabeza = equipo;
            cola = equipo;
            equipo.siguiente = cabeza;
        } else {
            cola.siguiente = equipo;
            equipo.siguiente = cabeza;
            cola = equipo;
        }
    }

    public void mostrarEquipos() {
        if (cabeza == null) {
            System.out.println("No hay equipos registrados.");
            return;
        }
        Equipo actual = cabeza;
        do {
            System.out.println("Equipo: " + actual.nombre + ", Ciudad: " + actual.ciudad + ", Puntos: " + actual.puntos
                    + ", Goles: " + actual.golesFavor);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void generarFixture() {
        if (cabeza == null) {
            System.out.println("No hay equipos para generar fixture.");
            return;
        }

        Equipo[] equipos = new Equipo[6];
        Equipo actual = cabeza;
        for (int i = 0; i < 6; i++) {
            equipos[i] = actual;
            actual = actual.siguiente;
        }

        for (int ronda = 0; ronda < 5; ronda++) {
            System.out.println("\nJornada " + (ronda + 1));
            for (int i = 0; i < 3; i++) {
                Equipo e1 = equipos[i];
                Equipo e2 = equipos[5 - i];
                System.out.println(e1.nombre + " vs " + e2.nombre);
                asignarResultados(e1, e2);
            }
            Equipo temp = equipos[1];
            for (int i = 1; i < 5; i++) {
                equipos[i] = equipos[i + 1];
            }
            equipos[5] = temp;
        }

        mostrarTabla();
    }

    private void asignarResultados(Equipo e1, Equipo e2) {
        int goles1 = (int) (Math.random() * 5);
        int goles2 = (int) (Math.random() * 5);
        e1.golesFavor += goles1;
        e2.golesFavor += goles2;

        if (goles1 > goles2) {
            e1.puntos += 3;
        } else if (goles2 > goles1) {
            e2.puntos += 3;
        } else {
            e1.puntos += 1;
            e2.puntos += 1;
        }
    }

    private void mostrarTabla() {
        Equipo[] equipos = new Equipo[6];
        Equipo actual = cabeza;
        for (int i = 0; i < 6; i++) {
            equipos[i] = actual;
            actual = actual.siguiente;
        }

        // Ordenamiento burbuja por puntos
        for (int i = 0; i < equipos.length - 1; i++) {
            for (int j = 0; j < equipos.length - i - 1; j++) {
                if (equipos[j].puntos < equipos[j + 1].puntos) {
                    Equipo temp = equipos[j];
                    equipos[j] = equipos[j + 1];
                    equipos[j + 1] = temp;
                }
            }
        }

        System.out.println("\nTabla de posiciones:");
        for (int i = 0; i < equipos.length; i++) {
            System.out.println((i + 1) + ". " + equipos[i].nombre + " - Puntos: " + equipos[i].puntos + ", Goles: "
                    + equipos[i].golesFavor);
        }
    }
}

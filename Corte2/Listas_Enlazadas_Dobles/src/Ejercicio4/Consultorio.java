package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio4;

public class Consultorio {
    Paciente cabeza;
    Paciente cola;

    public Consultorio() {
        cabeza = null;
        cola = null;
    }

    public void agregarPaciente(Paciente nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            if (nuevo.nivelUrgencia == 5) {
                nuevo.siguiente = cabeza.siguiente;
                nuevo.anterior = cabeza;
                if (cabeza.siguiente != null) {
                    cabeza.siguiente.anterior = nuevo;
                } else {
                    cola = nuevo;
                }
                cabeza.siguiente = nuevo;
            } else {
                cola.siguiente = nuevo;
                nuevo.anterior = cola;
                cola = nuevo;
            }
        }
    }

    public void mostrarPacientes() {
        if (cabeza == null) {
            System.out.println("No hay pacientes en la fila.");
            return;
        }
        Paciente temp = cabeza;
        System.out.println("\n--- Lista de Pacientes ---");
        while (temp != null) {
            System.out
                    .println("Nombre: " + temp.nombre + " | Edad: " + temp.edad + " | Urgencia: " + temp.nivelUrgencia);
            temp = temp.siguiente;
        }
    }

    public void pacienteMayorEdad() {
        if (cola == null) {
            System.out.println("No hay pacientes en la fila.");
            return;
        }
        Paciente temp = cola;
        Paciente mayor = cola;
        while (temp != null) {
            if (temp.edad > mayor.edad) {
                mayor = temp;
            }
            temp = temp.anterior;
        }
        System.out.println("\nPaciente de mayor edad:");
        System.out
                .println("Nombre: " + mayor.nombre + " | Edad: " + mayor.edad + " | Urgencia: " + mayor.nivelUrgencia);
    }
}

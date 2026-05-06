package Corte2.Listas_Enlazadas_Simples.src.Estudio;

public class Lista_Pacientes {

    Paciente cabeza;

    public Lista_Pacientes() {
        this.cabeza = null;
    }

    public void agregarPaciente(Paciente nuevo) {

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Paciente actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public double calcularTotalConsultas() {
        double total = 0;
        Paciente actual = cabeza;

        while (actual != null) {
            total += actual.costoConsulta;
            actual = actual.siguiente;
        }

        return total;
    }
}

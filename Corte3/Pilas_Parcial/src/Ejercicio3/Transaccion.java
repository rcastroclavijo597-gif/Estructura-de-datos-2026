package Ejercicio3;

public class Transaccion {
    String idTransaccion;
    String tipo; // "CREDITO" o "DEBITO"
    double monto;
    String descripcion;
    Transaccion siguiente;

    public Transaccion(String idTransaccion, String tipo, double monto, String descripcion) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[" + idTransaccion + " | " + tipo + " | $" + monto + " | " + descripcion + "]";
    }
}
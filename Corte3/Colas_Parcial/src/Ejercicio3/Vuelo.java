package Ejercicio3;

public class Vuelo {
    String codigoVuelo;
    String destino;
    String aerolinea;
    int pasajeros;
    Vuelo siguiente;

    public Vuelo(String codigoVuelo, String destino, String aerolinea, int pasajeros) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.aerolinea = aerolinea;
        this.pasajeros = pasajeros;
        this.siguiente = null;
    }
}
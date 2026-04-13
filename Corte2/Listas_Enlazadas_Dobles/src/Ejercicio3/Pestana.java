package Corte2.Listas_Enlazadas_Dobles.src.Ejercicio3;

public class Pestana {
    String tituloPagina;
    String url;
    String horaApertura;

    Pestana siguiente;
    Pestana anterior;

    public Pestana(String tituloPagina, String url, String horaApertura) {
        this.tituloPagina = tituloPagina;
        this.url = url;
        this.horaApertura = horaApertura;
        this.siguiente = null;
        this.anterior = null;
    }
}

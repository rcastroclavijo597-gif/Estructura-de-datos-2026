package Ejercicio2;

public class Contacto {

    int id;
    String nombre;
    String telefono;
    String ciudad;
    Contacto izquierdo;
    Contacto derecho;

    public Contacto(int id, String nombre, String telefono, String ciudad) {

        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override

    public String toString() {
        return " [ " + id + " | " + nombre + " | " + telefono + " | " + ciudad + " ] ";
    }

}

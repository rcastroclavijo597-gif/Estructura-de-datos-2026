/* 1. El Cajero del Supermercado (Inventario)
Un cajero escanea un producto con el código de barras 770123. El sistema tiene un arreglo desordenado con los códigos de los 
productos disponibles en la estantería actual.

El Problema: Debes recorrer la lista para verificar si el producto existe y en qué posición de la estantería se encuentra.
Algoritmo a usar: Búsqueda Lineal. Es el ideal porque los productos en la estantería no tienen un orden numérico específico. */

import java.util.ArrayList;

public class Ejercicio_1 {
    public static void main(String[] args) {

        ArrayList<String> codigo = new ArrayList<>();

        codigo.add("347119");
        codigo.add("901817");
        codigo.add("770123");
        codigo.add("567126");

        String buscar = "770123";
        boolean encontrado = false;

        for (int i = 0; i < codigo.size(); i++) {

            if (codigo.get(i).equals(buscar)) {
                System.out.println(" Encontrado, esta en la posicion " + i);
                encontrado = true;
                break;
            }

            if (!encontrado) {
                System.out.println(" No encontrado ");
            }

        }

    }

}

/* 3. Editor de Capas (Diseño Gráfico)
Los editores gráficos organizan el diseño en capas. El usuario navega a la capa superior (siguiente) o inferior (anterior) 
y puede ocultar o mostrar cada capa. La estructura es circular: después de la capa más alta vuelve a la más baja.

La Clase Capa (Nodo): Debe contener nombre (String), visible (boolean) y tipo (String — "fondo", "objeto", "texto").
El Problema: El editor mantiene un puntero capaActiva a la capa seleccionada. El usuario puede moverse entre capas, 
alternar la visibilidad de la activa y eliminarla (el foco pasa a la siguiente).
Reto: Implementa los métodos subirCapa(), bajarCapa(), toggleVisibilidad(), eliminarActiva() y mostrarCapas(). 
mostrarCapas() imprime todas las capas marcando la activa con [✓] e indicando si cada una es visible. Simula: 
crea 4 capas, activa la del medio, sube una vez, oculta la activa, elimínala y muestra el estado final. */

package Corte2.Listas_Circulares_Dobles.src.Ejercicio3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EditorCapas editor = new EditorCapas();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("   Editor de Capas — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar capa");
            System.out.println("2. Mostrar capas");
            System.out.println("3. Subir capa (siguiente)");
            System.out.println("4. Bajar capa (anterior)");
            System.out.println("5. Alternar visibilidad");
            System.out.println("6. Eliminar capa activa");
            System.out.println("7. Cargar ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la capa: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo (fondo/objeto/texto): ");
                    String tipo = sc.nextLine();
                    editor.agregarCapa(nombre, true, tipo);
                    System.out.println("Capa agregada.");
                    break;

                case 2:
                    editor.mostrarCapas();
                    break;

                case 3:
                    editor.subirCapa();
                    editor.mostrarCapas();
                    break;

                case 4:
                    editor.bajarCapa();
                    editor.mostrarCapas();
                    break;

                case 5:
                    editor.toggleVisibilidad();
                    System.out.println("Visibilidad cambiada.");
                    break;

                case 6:
                    editor.eliminarActiva();
                    System.out.println("Capa eliminada.");
                    break;

                case 7:
                    editor = new EditorCapas();
                    editor.agregarCapa("Fondo", true, "fondo");
                    editor.agregarCapa("Personaje", true, "objeto");
                    editor.agregarCapa("Texto titulo", true, "texto");
                    editor.agregarCapa("Sombra", true, "objeto");

                    editor.subirCapa();
                    editor.subirCapa();
                    editor.subirCapa();

                    editor.subirCapa();
                    editor.toggleVisibilidad();
                    editor.eliminarActiva();

                    System.out.println("Estado final:");
                    editor.mostrarCapas();
                    break;

                case 0:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}

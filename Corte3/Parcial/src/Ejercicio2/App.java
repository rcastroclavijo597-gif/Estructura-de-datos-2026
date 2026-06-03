package Ejercicio2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArbolDirectorio arbol = new ArbolDirectorio();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(1, "Sofia Ramirez", "3182373002", "aguachica");
        arbol.insertar(2, "Andres Torres", "3272272829", "gamarra");
        arbol.insertar(3, "Camila Perez", "39828292229", "medellin");
        arbol.insertar(4, "Luis Gomez", "329298271223", "bucaramanga");
        arbol.insertar(5, "Maria Diaz", "229877997", "bogota");
        arbol.insertar(6, "Carlos Ruiz", "28292727", "lima");
        arbol.insertar(7, "Valentina Cruz", "29202928", "barranquilla");
        arbol.insertar(8, "Felipe Mora", "292028277", "santa marta");

        int opcion;
        do {
            System.out.println("\n--- SISTEMA ACADÉMICO UNIVERSITARIO (BST) ---");
            System.out.println("1. Vercontactos ordenados por id (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo contacto");
            System.out.println("4. Buscar estudiante por id");
            System.out.println("5. Propiedades del árbol (altura y hojas)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println();
                    arbol.inOrden();
                    break;
                case 2:
                    System.out.println();
                    arbol.preOrden();
                    break;
                case 3:
                    System.out.print("id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciu = scanner.nextLine();
                    arbol.insertar(id, nom, tel, ciu);
                    System.out.println("Contacto insertado correctamente.");
                    break;
                case 4:
                    System.out.print("Contacto a buscar: ");
                    int busq = scanner.nextInt();
                    scanner.nextLine();
                    Contacto enc = arbol.buscar(busq);
                    if (enc != null)
                        System.out.println("Encontrado: " + enc);
                    else
                        System.out.println("No se encontró Contacto con ese id.");
                    break;
                case 5:
                    System.out.println("Altura del árbol: " + arbol.altura());
                    System.out.println("Nodos hoja:       " + arbol.contarHojas());
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");

            }
        } while (opcion != 6);
        scanner.close();
    }
}

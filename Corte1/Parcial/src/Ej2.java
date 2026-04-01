
import java.util.Scanner;

class Estudiante {
    private int codigo;
    private String nombre;
    private double nota;

    public Estudiante(int codigo, String nombre, double nota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public void mostrar() {
        System.out.println("Código=" + codigo + ", Nombre=" + nombre + ", Nota=" + nota);
    }
}

class GestorEstudiantes {
    private Estudiante[] estudiantes;
    private int cantidad;

    public GestorEstudiantes(int tamaño) {
        this.estudiantes = new Estudiante[tamaño];
        this.cantidad = 0;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (cantidad < estudiantes.length) {
            estudiantes[cantidad] = estudiante;
            cantidad++;
        } else {
            System.out.println("No hay espacio para más estudiantes");
        }
    }

    public void ordenarPorCodigo() {
        for (int i = 1; i < cantidad; i++) {
            Estudiante code = estudiantes[i];
            int j = i - 1;

            while (j >= 0 && estudiantes[j].getCodigo() > code.getCodigo()) {
                estudiantes[j + 1] = estudiantes[j];
                j--;
            }
            estudiantes[j + 1] = code;
        }
        System.out.println("Estudiantes ordenados por código (ascendente)");
    }

    public Estudiante buscarPorCodigoBinario(int codigoBuscado) {
        int izquierda = 0;
        int derecha = cantidad - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int codigoMedio = estudiantes[medio].getCodigo();

            if (codigoMedio == codigoBuscado) {
                return estudiantes[medio];
            } else if (codigoMedio < codigoBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    public int contarAprobados() {
        int aprobados = 0;
        for (int i = 0; i < cantidad; i++) {
            if (estudiantes[i].getNota() >= 3.0) {
                aprobados++;
            }
        }
        return aprobados;
    }

    public void mostrarTodos() {
        System.out.println("--- ESTUDIANTES GUARDADOS ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Estudiante " + (i + 1) + ": ");
            estudiantes[i].mostrar();
        }
    }

    public int obtenerCantidad() {
        return cantidad;
    }
}

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GestorEstudiantes gestor = new GestorEstudiantes(6);

        System.out.println("=== INGRESO DE ESTUDIANTES ===");
        for (int i = 0; i < 6; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");

            System.out.print("Ingrese el código: ");
            int codigo = sc.nextInt();

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.next();

            System.out.print("Ingrese la nota: ");
            double nota = sc.nextDouble();

            Estudiante estudiante = new Estudiante(codigo, nombre, nota);
            gestor.agregarEstudiante(estudiante);
        }

        gestor.mostrarTodos();

        System.out.println("=== ORDENAMIENTO POR INSERTION SORT ===");
        gestor.ordenarPorCodigo();
        gestor.mostrarTodos();

        System.out.println("=== BÚSQUEDA BINARIA ===");
        System.out.print("Ingrese el código a buscar: ");
        int codigoBuscado = sc.nextInt();

        Estudiante encontrado = gestor.buscarPorCodigoBinario(codigoBuscado);
        if (encontrado != null) {
            System.out.println("Estudiante encontrado:");
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Nota: " + encontrado.getNota());
        } else {
            System.out.println("No se encontró estudiante con código: " + codigoBuscado);
        }

        System.out.println("=== Aprobados ===");
        int aprobados = gestor.contarAprobados();
        System.out.println("Total de estudiantes: " + gestor.obtenerCantidad());
        System.out.println("Estudiantes aprobados (nota >= 3.0): " + aprobados);

        sc.close();
    }
}

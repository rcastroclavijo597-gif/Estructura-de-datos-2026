public class ej4 {
    public static void main(String[] args) {
        double[] NotasEstudiantes = { 3.5, 4.3, 3, 5 };
        double[] Correccion = NotasEstudiantes;

        Correccion[1] = 5;

        System.out.println(NotasEstudiantes[1]);
        System.out.println(Correccion[1]);

    }

}

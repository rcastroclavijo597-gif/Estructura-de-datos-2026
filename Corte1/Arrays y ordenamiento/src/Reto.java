import java.util.Scanner;

public class Reto {
    public static void main(String[] args) {
        int [] Lista_Negra  = {50,78,189,567,986,154,782,675,452,647};
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Los 8 intentos de acceso reciente al servidor");
        int Lista = sc.nextInt();


        int inicio = 0;
        int fin = Lista_Negra.length-1;
        boolean encontrado = false;
        while (inicio<=fin) {
            int medio = (inicio+fin)/2;
            if(Lista_Negra[medio] == Lista){
                encontrado = true;
            
                if(Lista_Negra<Lista)
            
        }

        

        


    }

}

public class ej3 {
    public static void main(String[] args) {
        double TempAct;
        String NombreSensor;
        int NumeroLectura;
        double LimiteTemp;
        boolean EnAlarma;

        TempAct = 70;
        NombreSensor = "Marcopolo";
        NumeroLectura = 20;
        LimiteTemp = 80;

        if (TempAct > LimiteTemp) {
            EnAlarma = true;
            System.out.println(" Temperatura actual " + TempAct);
            System.out.println(" Nombre del sensor " + NombreSensor);
            System.out.println(" Numero de Lectura " + NumeroLectura);
            System.out.println(" Limite de Temperatura " + LimiteTemp);
            System.out.println(" La temperatura es muy alta ten mucha precaucion" + EnAlarma);
        } else {
            EnAlarma = false;
            System.out.println(" Temperatura actual " + TempAct);
            System.out.println(" Nombre del sensor " + NombreSensor);
            System.out.println(" Numero de Lectura " + NumeroLectura);
            System.out.println(" Limite de Temperatura " + LimiteTemp);
            System.out.println(" La temperatura es normal no hay problema " + EnAlarma);

        }

    }

}

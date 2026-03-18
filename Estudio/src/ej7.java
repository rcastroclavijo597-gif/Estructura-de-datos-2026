class Vehiculo {
    private String Marca;
    private double VelocidadMaxima;

    public Vehiculo(String marca, double velocidadmaxima) {
        this.Marca = marca;
        this.VelocidadMaxima = velocidadmaxima;

    }

    public void Describir() {
        System.out.println("Marca" + Marca);
        System.out.println("Velocidad Maxima" + VelocidadMaxima);

    }

}

class Moto extends Vehiculo {
    private String TipoMoto;

    public Moto(String Marca, double VelocidadMaxima, String tipomoto) {
        super(Marca, VelocidadMaxima);
        this.TipoMoto = tipomoto;
    }

    @Override
    public void Describir() {
        super.Describir();
        System.out.println("Tipo de Moto: " + TipoMoto);
    }
}

class Carro extends Vehiculo {
    private int NumeroPuertas;

    public Carro(String Marca, double VelocidadMaxima, int numeropuertas) {
        super(Marca, VelocidadMaxima);
        this.NumeroPuertas = numeropuertas;

    }

    @Override
    public void Describir() {
        super.Describir();
        System.out.println("Numero de Puertas: " + NumeroPuertas);
    }

}

public class ej7 {

    public static void main(String[] args) {
        Moto moto1 = new Moto("Yamaha", 180, "Deportiva");
        Carro carro1 = new Carro("Toyota", 200, 4);

        System.out.println("Descripcion de la Moto:");
        moto1.Describir();

        System.out.println("\nDescripcion del Carro:");
        carro1.Describir();

    }

}

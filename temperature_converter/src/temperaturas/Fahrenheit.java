package temperaturas;

public class Fahrenheit extends Temperatura{

    //Métodos

    public double toCelsius(double valor) {
        return (valor - 32) / 1.8;
    }

    public double toKelvin(double valor){
        return ((valor - 32) / 1.8) + 273.15;
    }

}

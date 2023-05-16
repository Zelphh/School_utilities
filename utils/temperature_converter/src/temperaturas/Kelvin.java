package temperaturas;

public class Kelvin extends Temperatura {


    //Métodos

    public double toCelsius(double valor) {
        return valor - 273.15;
    }

    public double toFahrenheit(double valor) {
        return ((valor - 273.15) * 1.8) + 32;
    }
}

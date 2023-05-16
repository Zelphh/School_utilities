package temperaturas;

public class Celsius extends Temperatura {

    //Métodos

   public double toFahrenheit(double valor) {
       return (valor * 1.8) + 32;
   }

   public double toKelvin(double valor) {
       return valor + 273.15;
   }

}

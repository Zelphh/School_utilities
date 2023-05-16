import temperaturas.Celsius;
import temperaturas.Fahrenheit;
import temperaturas.Kelvin;
import temperaturas.Sistema;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Inicia o Scanner como "sc"
        Sistema sys = new Sistema(); // O objeto "Sistema" contem métodos uteis para compactar a Main

        Dictionary<Integer, String> dic = new Hashtable<>(); //Inicia um dicionaria contendo as temperaturas e seus respectivos indentificadores

        dic.put(1, "Celsius");
        dic.put(2, "Fahrenheit");
        dic.put(3, "Kelvin");

        int[] escolhas = new int[2]; // Cria um Array que armazenara as 2 escolhas que o usuario fará

        Fahrenheit fahrenheit = new Fahrenheit();        // -|
        Celsius celsius = new Celsius();                 //  |Inicia os objetos de teperatura para obter seus métodos
        Kelvin kelvin = new Kelvin();                    // _|

        while(true) {
            sys.imprimeMensagem1();
            sys.imprimeOpcoes();
            escolhas[0] = sys.recebeEscolha();

            sys.imprimeMensagem2();
            sys.imprimeOpcoes();
            escolhas[1] = sys.recebeEscolha();

            escolhas[1] = sys.verificaEscolhasIguais(escolhas);

            int yesNo = sys.mensagemConfirmacao(escolhas, dic);
            if(yesNo == 1) {
                break;
            }
        }

        double valor = sys.recebeValor(escolhas);

        sc.close(); // Fecha o scanner("sc")

        // Define valor final convertido
        double finalValue = sys.setValorFinal(valor, escolhas, celsius, fahrenheit, kelvin);

        sys.imprimeValorFinal(finalValue);
    }
}

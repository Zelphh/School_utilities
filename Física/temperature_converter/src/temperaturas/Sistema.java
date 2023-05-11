package temperaturas;

import java.util.Scanner;
import java.util.Dictionary;

public class Sistema {

    Scanner sc = new Scanner(System.in);

                                // Métodos

    //Imprime a mensagem que pede a medida que será convertida
    public void imprimeMensagem1() {
        System.out.print("\nQual medida será convertida?\n");
    }

    //Imprime mensagem que pede a media para qual o valor dado sera convertido
    public void imprimeMensagem2() {
        System.out.print("\nPara qual medida?\n");
    }

    public void imprimeOpcoes() {
        System.out.print("  [1] Celsius\n" +
                         "  [2] Fahrenheit\n" +
                         "  [3] Kelvin\n");
    }

    // Recebe a escolha do usuário e chama o método "verificaEscolha"
    public int recebeEscolha() {
        System.out.print(" >");
        int escolha = sc.nextInt();

        escolha = verificaEscolha(escolha);

        return escolha;
    }

    //Verifica se a escolha do usuario esta dentro dos padrões esperados
    public int verificaEscolha(int escolha) {
        while (escolha < 1 || escolha > 3) {
            System.err.print("ERRO! Alternativa inválida, tente novamente: ");
            escolha = sc.nextInt();
        }

        return escolha;
    }

    // Imprime mensagem das medidas a serem convertidas na ordem que o usuario digitou e pede um confirmação
    public int mensagemConfirmacao(int[] escolhas, Dictionary<Integer, String> dic) {
        System.out.print("Gotaria de converter de ");
        switch (escolhas[0]) {
            case 1:
                System.out.print(dic.get(1));
                break;
            case 2:
                System.out.print(dic.get(2));
                break;
            case 3:
                System.out.print(dic.get(3));
                break;
        }

        System.out.print(" para ");
        switch (escolhas[1]) {
            case 1:
                System.out.print(dic.get(1));
                break;
            case 2:
                System.out.print(dic.get(2));
                break;
            case 3:
                System.out.print(dic.get(3));
                break;
        }
        System.out.print("?\n");

        System.out.print("  [1] Yes   [2] No\n > ");
        int yesNo = sc.nextInt(); // Pede a confirmação

        yesNo = verificaConfirmacao(yesNo); // Verifica a confirmação

        if(yesNo == 1) { // Se ela for 1(Yes) ela retorna 1 e quabra o loop(while), caso contrário, retorna 2(No) e recomeça o looping
            return 1;
        } else {
            return 2;
        }
    }

    //Verifica se a escolha do usuario esta dentro dos padrões esperados
    private int verificaConfirmacao(int yesNo) {
        while (yesNo < 1 || yesNo > 2) {
            System.err.print("ERRO! Alternativa inválida, tente novamente: ");
            yesNo = sc.nextInt();
        }

        return yesNo;
    }

    public int verificaEscolhasIguais(int[] escolhas) {
        while(escolhas[0] == escolhas[1]) {
            System.err.print("ERRO! Escolhas iguais, tente novamente: ");
            escolhas[1] = recebeEscolha();
        }

        return escolhas[1];
    }

    // Recebe valor a ser convertido
    public double recebeValor(int[] escolhas) {
        System.out.print("Valor a converter > ");
        double valor = sc.nextDouble();

        valor = verificaValor(valor, escolhas);

        return valor;
    }

    //Verifica se o valor digitado está dentro dos padroes da física
    public double verificaValor(double valor, int[] escolhas) {
        switch (escolhas[0]) {
            case 1:
                while (valor < -273.15) {
                    System.err.print("ERRO! Esse valor não existe na fisica, tente novamente: ");
                    valor = sc.nextDouble();
                }
                break;
            case 2:
                while (valor < -459.67) {
                    System.err.print("ERRO! Esse valor não existe na fisica, tente novamente: ");
                    valor = sc.nextDouble();
                }
                break;
            case 3:
                while (valor < 0) {
                    System.err.print("ERRO! Esse valor não existe na fisica, tente novamente: ");
                    valor = sc.nextDouble();
                }
                break;
        }
        return valor;
    }

    // Converte o valor recebido para a medida desejada
    public double setValorFinal(double valor, int[] escolhas, Celsius celsius, Fahrenheit fahrenheit, Kelvin kelvin) {
        double finalValue; //Valor final da converção

        switch (escolhas[0]) {
            case 1:
                if(escolhas[1] == 2) {finalValue = celsius.toFahrenheit(valor);}
                else {finalValue = celsius.toKelvin(valor);}
                break;

            case 2:
                if(escolhas[1] == 1) {finalValue = fahrenheit.toCelsius(valor);}
                else {finalValue = fahrenheit.toKelvin(valor);}
                break;

            case 3:
                if(escolhas[1] == 1) {finalValue = kelvin.toCelsius(valor);}
                else {finalValue = kelvin.toFahrenheit(valor);}
                break;
            default:
                System.err.println("ERRO! Não foi possivel converter o valor");
                finalValue = 0;
        }

        return finalValue;
    }

    // Imprime o valor convertido
    public void imprimeValorFinal(double finalValue) {
        System.out.printf("Valor convertido > %.2f\n", finalValue);
    }
}

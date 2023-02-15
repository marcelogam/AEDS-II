import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Crio um objeto leitor para ler valores digitados no teclado
        Scanner leitor = new Scanner(System.in);
        // Configurando(definindo que os separadoes e' ; OU \r OU \n)
        leitor.useDelimiter("[;\r\n]+");

        /*
        *********ler numero inteiro:*********
        int numero;
        System.out.println("Digite um nuemro: ");
        numero = leitor.nextInt();
        System.out.println("Numero e: "+numero);
        */

        /* 
        *********ler numero flutuante*********
        float numero2;
        System.out.println("Digite um nuemro: ");
        numero2 = leitor.nextFloat();
        System.out.println("Numero e: "+numero2);
        */

        String jogo;
        System.out.println("Qual o seu jogo do momento?");
        jogo = leitor.next();
        System.out.println("Jogo e " +jogo);

    }
}

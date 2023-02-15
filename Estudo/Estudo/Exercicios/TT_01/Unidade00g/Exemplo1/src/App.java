import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        int numero;
        System.out.println("Digite um numero: ");
        numero = leitor.nextInt();
        System.out.println("Numero e: "+numero);
    }
}

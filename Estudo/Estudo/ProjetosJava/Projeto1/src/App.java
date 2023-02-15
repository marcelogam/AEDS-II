import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int contador = 0; 
        int n;
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o numero de vezes:");
        n = leitor.nextInt();
        for(int i = 0; i < n;i++){
            contador ++;
            System.out.println(contador);
        }

    }
}

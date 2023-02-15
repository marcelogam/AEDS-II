import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();
        int[] elementos = new int [n];

        int i = 0;
        elementos[0] = 1;
        System.out.println(elementos[0]);
        while(i < n-1){
            elementos[i+1] = (elementos[i] +2);
            System.out.println(elementos[i+1] );
            i++;
        }
    }
}

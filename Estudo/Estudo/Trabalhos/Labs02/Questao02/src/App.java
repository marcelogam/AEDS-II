import java.util.Scanner;

/* Sequência Espelho em Java - Imprimir números em sequência é uma tarefa relativamente
simples. Mas, e quando se trata de uma sequência espelho? Trata-se de uma sequência que
possui um número de inı́cio e um número de fim, e todos os números entre estes, inclusive estes,
são dispostos em uma sequência crescente, sem espaços e, em seguida, esta sequência é projetada
de forma invertida, como um reflexo no espelho. Por exemplo, se a sequência for de 7 a 12, o
resultado ficaria 789101112211101987
Escreva um programa que, dados dois números inteiros, imprima a respectiva sequência espelho. */

public class App {
    public static void inverte(String str){
        for(int i = str.length() - 1 ; i >= 0;i--){
            System.out.print(str.charAt(i));
        }
    }
    public static void sequenciaEspelho(int x, int y ){
        String espelho = "";
        for(int i = x; i <= y; i++){
            System.out.print(i);
            espelho += i;
        }
        inverte(espelho);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int array[] = new int[10];
        int i = 0;

        while (sc.hasNext()) {
            array[i] = sc.nextInt();
            i++;
        }
        int j = 0;
        while( j < i){
            sequenciaEspelho(array[j], array[j+1]);
            j = j + 2;
        }
        String str;
        str.charAt(i)


        sc.close(); // Encerra o programa
    }
}

import java.util.Random;

public class App {
    public static void mostrarMaioreMenor(int[] array, int n){
        int menor = array[0];
        int maior = array[0];
        for(int i = 1;i < n; i++){
            if(array[i] < menor){
                menor = array[i];
            }
            if(array[i] > maior){
                maior = array[i];
            }
        }
        MyIO.println("Maior: "+maior+" e Menor:"+menor);

    }
    public static void  lerArray(int[] array, int n){
        Random gerador = new Random();
        for(int i = 0; i < n; i++){
            array[i] = (gerador.nextInt(9) + 1) * (gerador.nextInt(9) + 1);
        }
    }
    public static void escreveArray(int[] array, int n){
        for(int i = 0; i < n; i++){
            MyIO.println(array[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        MyIO.println("Digite o tamanho do array: ");
        int n = MyIO.readInt();
        int[] array = new int[n];
        MyIO.println("----------------");
        lerArray(array, n);
        escreveArray(array, n);
        mostrarMaioreMenor(array, n);
    }
}

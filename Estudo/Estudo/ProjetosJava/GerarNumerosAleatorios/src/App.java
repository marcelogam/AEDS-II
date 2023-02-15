import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        double dado6Faces = 1 + Math.random() * 2; // Um numero entre 1 e 2
        System.out.println(dado6Faces);

        Random gerador = new Random();
        int numero = gerador.nextInt(6) + 1; // 6 e o maior numero e o 1 e o valor minimo.
        System.out.println(numero);

        Random gerador2 = new Random(5);
        int numero2= gerador2.nextInt(6) + 1; 
        System.out.println(numero2);
    }
}

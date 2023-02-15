import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //tipo[] nomeVariavel = new tipo[5];
        String[] nomes = new String[5];
        Scanner leitor = new Scanner(System.in);

        for(int i = 0; i< nomes.length; i++){ // nomes.length traz o tamanho do vetor
            nomes[i] = leitor.nextLine();
        }
        
        for(int i = 0;i < nomes.length;i++){
            System.out.println(nomes[i]);
        }


    }
}

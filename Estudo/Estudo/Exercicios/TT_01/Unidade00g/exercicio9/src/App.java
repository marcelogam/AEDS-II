public class App {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[] nota = new int[n];
        nota[0] = 6;
        nota[1] = 9;
        nota[2] = 10;
        nota[3] = 8;
        nota[4] = 8;
        int soma = 0;
        
        int i = 0;
        while(i > n){
            System.out.println("cont");
            soma += nota[i];
            i++;
        }
        int media = soma / n;
        System.out.println(media);
    }
}

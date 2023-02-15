/*
• Faça um método que receba um array de inteiros e um
número inteiro x e retorne um valor booleano informando se o
elemento x está contido no array */
public class App {
    
    public static boolean existeX (int[] array, int n, int x){
        boolean resp = false;
        for(int i = 0; i < n; i++){
            if(array[i] == x){
                resp = true;
                i = n;
            }
        }
        return resp;
    }
    public static void escreveArray(int[] array, int n ){
        for(int i = 0; i < n; i++){
            array[i] = (i * 4);
        }
    }
    public static void leArray(int[] array, int n ){
        for(int i = 0; i < n; i++){
            MyIO.println(array[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        int n = 10;
        int[] array = new int[n];
        int x = 5;
        escreveArray(array, n);
        leArray(array, n);
        MyIO.println(existeX(array, n, x));
    }
}

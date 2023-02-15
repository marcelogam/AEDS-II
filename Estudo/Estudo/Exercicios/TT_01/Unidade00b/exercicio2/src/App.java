/*
Repita o exercício acima considerando que os elementos do
array estão ordenados de forma crescente. Uma sugestão
seria começar a pesquisa pelo meio do array
 */
public class App {
    public static boolean existeX (int[] array, int n, int x){
        boolean resp = false;
        int esq = 0, dir = n-1, meio;
        while(esq <= dir){
            meio = (esq + dir) / 2;
            MyIO.println(meio);
            if(array[meio] == x){
                resp = true;
                esq = n;
            }else if(array[meio] > x){
                dir = meio - 1;
            }else{
                esq = meio + 1;
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
        int x = 8;
        escreveArray(array, n);
        leArray(array, n);
        MyIO.println(existeX(array, n, x));
    }
}

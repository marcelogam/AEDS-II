public class App {
    public static void main(String[] args) throws Exception {
        boolean resp = false;
        int n = 16;
        int[] array = new int[n];
        int x = 9;
        int temp = 0;
        

        for(int i = 0; i < n; i++){
            array[i] = i;
        }

        int dir = n-1, esq = 0, meio;

        while(esq <= dir){
            meio = (esq+dir)/2;
            if(x <= array[meio]){
                dir = meio -1 ;
            }else {
                esq = meio + 1;
            }
            MyIO.print(array[meio]);
            temp = array[meio];
        }
        if(x == temp){
            resp = true;
        }
        MyIO.println(resp);
    }
}

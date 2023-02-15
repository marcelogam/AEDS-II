public class App {
    public static void swap(int a, int b){


    }
    public static void main(String[] args) throws Exception {
        int n = 4; //10 = 45: (n-1) + (n-2) + (n-3) + (n-4) + (n-5) + ... + 
        int[] array = new int[n];
        int cont = 0;

        array[0] = 68;
        array[1] = 45; 
        array[2] = 10;
        array[3] = 58;
        
        

        for(int i = 0; i < (n-1); i++){
            int menor = i;
            for(int j = (i+1);j < n;j++){
                cont ++;
                if(array[menor] > array[j]){
                    menor = j;
                }
            }
            swap(menor, i);
        }
        MyIO.println(cont);
    }
}

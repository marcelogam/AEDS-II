public class App {
    public static int maior(int vet[],int n){
        return maior(vet, n, 0);
    }
    public static int maior(int vet[],int n,int i){
        int resp;
        if(i == n-1){
            resp = vet[n-1];
        }else{
            resp = maior(vet, n, i+1);
            if(resp < vet[i]){
                resp = vet[i];
            }
        }
        return resp;
    }

    public static void main(String[] args) throws Exception {
        int n = 5;
        int[] vetor = new int[n];
        vetor[0] = 32;
        vetor[1] = 27;
        vetor[2] = 68;
        vetor[3] = 16;
        vetor[4] = 3;
        System.out.println(maior(vetor, n)); 
    }
}

public class App {
    public static int fatorial(int i){
        int valor = 0;
        if(i == 1){
            valor = 1;
        }else{
            valor = i * fatorial(i -1);
        }
        return valor;
    }
    public static void main(String[] args) throws Exception {
       System.out.println(fatorial(5)); 
    }
}

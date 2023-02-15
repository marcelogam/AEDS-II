public class App {
    public static int fibonacci(int n){
        int resp;
        if(n == 0 || n == 1){
            resp = 1;
        }else{
            resp = fibonacci(n-1) + fibonacci(n-2);
        }
        return resp;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(fibonacci(4));
    }
}

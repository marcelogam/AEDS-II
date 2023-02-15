public class App {
    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void isPalindromo(String str, int n) {
        if (n < str.length()/2) {
            if (str.charAt(str.length() - n - 1) != str.charAt(n)) {
                MyIO.println("NAO");
            }else{
                isPalindromo(str, ++n);
            }
        }else{
            MyIO.println("SIM");
        }
        
    }

    public static void main(String[] args) throws Exception {
        String entrada = MyIO.readLine();
        while (isFim(entrada) == false){
            isPalindromo(entrada, 0);
            entrada = MyIO.readLine();
        }
    }
}

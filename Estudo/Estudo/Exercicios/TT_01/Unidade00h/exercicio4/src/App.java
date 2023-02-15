

public class App {
    public static boolean isPalindromo(String s){
        return isPalindromo(s,0);
    }
    public static boolean isPalindromo(String s,int i) {
        boolean resp = false;
        if(i >= s.length()/2){
            resp = true;
        }else if(s.charAt(i) != s.charAt(s.length()-1-i)){
            resp = false;
        }else {
            resp = isPalindromo(s, i+1);
        }
        return resp;
    }
    public static void main(String[] args) throws Exception {
        String str = "AMOR";
        System.out.println(isPalindromo(str));
    }
}

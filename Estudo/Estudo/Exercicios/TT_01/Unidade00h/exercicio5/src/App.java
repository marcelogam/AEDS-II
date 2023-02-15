public class App {
    public static char toUpper(char c) {
        return (c >= 'a' && c <='z' ) ? (char)(c-32) : c;
    }
    public static int contMaiusculo(String s) {
        return contMaiusculo(s,0);
    }
    private static int contMaiusculo(String s,int i) {
        int cont = 0;
        if(i < s.length()){
            if(toUpper(s.charAt(i)) == true){
                cont ++;
            }
            cont += contMaiusculo(s, i+1);
        }
        return cont;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

public class App {
    public static char toUpper(char c){
        return (c >= 'a' && c <= 'z') ? ((char)(c - 32)) : c;
    }
    public static String tranformaMaiusculo(String s){
        for(int i = 0; i < s.length(); i++){
            MyIO.println(s.charAt(i));
            MyIO.println(toUpper(s.charAt(i))); 
        }
        return s;
    }
    public static void main(String[] args) throws Exception {
        Arq.openWrite("teste.txt");
        Arq.println("Chocolate");
        Arq.close();

        Arq.openRead("teste.txt");
        String str = Arq.readString();
        Arq.close();
        MyIO.println(str.toUpperCase());

        tranformaMaiusculo(str);

        char c = 'b';
        MyIO.println(toUpper(c)); 
    }
}

public class App {
    public static String inverteCaracteres(String s){
        String str = "";
        for(int i = s.length(); i > 0;i--){
            str += s.charAt(i - 1);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        Arq.openWrite("exemplo.txt");
        Arq.println("Chocolate");
        Arq.println("Cafe");
        Arq.close();

        Arq.openRead("exemplo.txt");
        String str = Arq.readAll();
        Arq.close();

        String string = inverteCaracteres(str);

        Arq.openWrite("lista.txt");
        Arq.println(string);
        Arq.close();
    }
}

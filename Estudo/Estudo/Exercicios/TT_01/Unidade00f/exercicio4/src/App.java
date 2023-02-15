public class App {
    public static void main(String[] args) throws Exception {
        Arq.openWrite("exemplo.txt");
        Arq.println("Chocolate");
        Arq.println("Cafe");
        Arq.close();

        Arq.openRead("exemplo.txt");
        String str = Arq.readAll();
        Arq.close();

        Arq.openWrite("lista.txt");
        Arq.println(str);
        Arq.close();

    }
}

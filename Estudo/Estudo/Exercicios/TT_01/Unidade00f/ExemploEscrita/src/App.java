
public class App {

    public static void main(String[] args) throws Exception {
        Arq.openWrite("exemplo.txt");

        Arq.println(1);
        Arq.println(5.3);
        Arq.println('X');
        Arq.println(true);
        Arq.println("Algoritmos");

        Arq.close();
    }
}

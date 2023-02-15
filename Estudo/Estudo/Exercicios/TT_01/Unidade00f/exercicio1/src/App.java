
// Leia o nome de um arquivo e uma frase e salve essa frase nesse arquivo

public class App {
    public static void main(String[] args) throws Exception {
        Arq.openWrite(MyIO.readString());

        Arq.println(MyIO.readString());

        Arq.close();
    }
}

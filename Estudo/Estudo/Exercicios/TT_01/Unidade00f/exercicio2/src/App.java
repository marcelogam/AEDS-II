public class App {
    public static void main(String[] args) throws Exception {
        Arq.openWrite(MyIO.readString());

        Arq.println(450);

        Arq.close();
    }
}

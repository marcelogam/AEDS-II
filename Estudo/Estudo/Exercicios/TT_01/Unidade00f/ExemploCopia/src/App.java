public class App {
    public static void main(String[] args) throws Exception {
        Arq.openRead("exemplo.txt");

        String str = "";
        while(Arq.hasNext() == true){
            str += Arq.readChar();
        }

        Arq.close();

        Arq.openWrite("copia.txt");
        Arq.print(str);
        Arq.close();
    }
}

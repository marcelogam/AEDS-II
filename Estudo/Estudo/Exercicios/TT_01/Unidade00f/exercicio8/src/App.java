public class App {
    public static void decodificar(String str){
        String string = "";
        for(int i = 0; i < str.length();i++){
            string += ((char) (str.charAt(i) - 3));
        }
        MyIO.println(string);
    }
    public static void main(String[] args) throws Exception {
        Arq.openWrite("exemplo.txt");
        Arq.println("Hvwxgduu");
        Arq.println("ler");
        Arq.println("Estudar");
        Arq.close();

        Arq.openRead("exemplo.txt");
        String str = "";
        str = Arq.readAll();
        Arq.close();

        MyIO.println(str);
        MyIO.println(str.length());
        decodificar(str);
    }
}

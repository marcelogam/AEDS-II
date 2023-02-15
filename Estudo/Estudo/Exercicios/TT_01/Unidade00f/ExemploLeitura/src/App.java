public class App {
    public static void main(String[] args) throws Exception {
        Arq.openRead("exemplo.txt");

        int inteiro = Arq.readInt();
        double real = Arq.readDouble();
        char caractere = Arq.readChar();
        boolean booleano = Arq.readBoolean();
        String str = Arq.readString();

        Arq.close();

        System.out.println("inteiro: "+inteiro);
        System.out.println("real: "+real);
        System.out.println("caractere: "+caractere);
        System.out.println("boleano: "+booleano);
        System.out.println("str: "+str);
    }
}

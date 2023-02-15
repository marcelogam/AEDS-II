public class App2{
    public static void main(String[] args) throws Exception{
        Arq.openRead(MyIO.readString());
        
        double real = Arq.readDouble();

        MyIO.println(real);
    }
}
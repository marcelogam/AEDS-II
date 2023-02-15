public class App {
    private static void passagemDeTipoPrimitivo(int a) {
        System.out.println("a: "+a);
        a = 10;
        System.out.println("a: "+a);
    }
    public static void main(String[] args) throws Exception {
        int x = 5;
        System.out.println(x);
        passagemDeTipoPrimitivo(x);
        System.out.println("X: "+x);
    }
}

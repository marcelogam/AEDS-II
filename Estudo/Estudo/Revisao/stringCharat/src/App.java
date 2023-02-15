public class App {
    public static void main(String[] args) throws Exception {
        String string = "Adam Eve Smith";
        
        char let1 = string.charAt(0); // A == 65
        char let2 = string.charAt(5); // E == 69 Tabela ASCII
        char let3 = string.charAt(9); // S == 83

        MyIO.println(let1); // A
        MyIO.println(let1+let2+let3); // (65 + 69 + 83 )
        MyIO.println("" + let1 + let2 + let3);
    }
}

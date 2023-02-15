/*Palindromo em Java - Crie um método iterativo que recebe uma string como parâmetro e
retorna true se essa é um palı́ndromo. Na saı́da padrão, para cada linha de entrada, escreva
uma linha de saı́da com SIM/NÃO indicando se a linha é um palı́ndromo. Destaca-se que uma
linha de entrada pode ter caracteres não letras. A entrada termina com a leitura de FIM.
*/
public class App {
    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void isPalindromo(String str) {
        boolean resp = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length()- 1 - i)) {
                resp = false;
                 i = str.length();
            }
        }
        if(resp){
            MyIO.println("SIM");
        }else{
            MyIO.println("NAO");
        }
    }

    public static void main(String[] args) throws Exception {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        for (int i = 0; i < numEntrada; i++) {
            isPalindromo(entrada[i]);
        }
    }
}

public class RecursCifra {
    public static boolean isFim(String str){
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    public static String fazerCiframento(String str, int n){
        String resp = "";
        
        int tamanho = str.length();
        if(n < tamanho){
            resp += (char)(str.charAt(n) + 3);
            resp += fazerCiframento(str, ++n);
        }
        return resp;
    }
    public static String ciframentoDeCesar(String str){
        
        return fazerCiframento(str, 0);
    }
    public static void main(String[] args) throws Exception {
        String entrada = MyIO.readLine();
        while(!isFim(entrada)){
            MyIO.println(ciframentoDeCesar(entrada));
            entrada = MyIO.readLine();
        }
    }
}

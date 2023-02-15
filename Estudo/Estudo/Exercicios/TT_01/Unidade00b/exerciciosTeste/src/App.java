public class App {
    public static boolean doidao(char c) {
        boolean resp = false;
        int v = (int) c;
        if (v == 65 || v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v == 105 ||
                v == 111 || v == 117) {
            resp = true;
        }
        return resp;
    }

    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
    }

    public static boolean isVogal(char c) {
        c = toUpper(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static boolean isConsoante(String s,int n) {
        boolean resp= true;
        
        if (n != s.length()){
            if (s.charAt(n)<'0' || s.charAt(n)>'9'){
                if (isVogal(s.charAt(n)) == true){
                    resp= false;
                } else {
                    resp= isConsoante(s, n + 1);
                }
            } else {
                resp=false;
            }
        }
        return resp;
    }

    public static void main(String[] args) throws Exception {
        /* 
        char c = 'a';
        int n = 0;
        MyIO.println(doidao(c));
        MyIO.println(c);
        MyIO.println(toUpper(c));
        MyIO.println(isVogal(c));
        String str = "Chclyr";
        MyIO.println(str.length()); // Tamanho da string
        MyIO.println(isConsoante(str,n));
        byte b = 0;
        short s = 0;
        int i = 0;
        long l = 0;
        while(s < 1){
            b++; s++; i ++; l++;
            MyIO.println(b+" "+s+" "+i+" "+l);
        }
        */
        int x = 23;
        int y = 23;
        x = x << 2; //
        y = y >> 2;
        MyIO.println("["+x+"-"+y+"]");



    }
}

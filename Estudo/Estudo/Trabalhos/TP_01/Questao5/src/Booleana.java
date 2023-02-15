import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.IOException;


public class Booleana {
    public static BufferedReader reader = new BufferedReader (new InputStreamReader ( System.in , Charset.forName("ISO-8859-1")));

    
    public static String replaceString (String s, String find, String c) {
        String r = s;
        int j = 0;
        int k = 0;
        if (find != "") {
            r = "";
            for(int i = 0; i < s.length(); i++) {
                if(find.charAt(0) == s.charAt(i)) {
                    j = 1;
                    k = i + 1;
                    while ( j < find.length() && find.charAt(j) == s.charAt(k)) {
                        k++;
                        j++;
                    } 
                    if (j == find.length()) {
                        r += c;
                        i += find.length() - 1;
                    } else {
                        r += s.charAt(i);
                    } 
                } else {
                    r += s.charAt(i);
                } 
            }
        } 
        return r;
    } 

    public static String replaceString (String s, String find, String c, int start) {
        String r = s;
        int j = 0;
        int k = 0;
        if (find != "") {
            r = "";
            for(int i = 0; i < start; i++) {
                r += s.charAt(i);
            } 
            for(int i = start; i < s.length(); i++) {
                if(find.charAt(0) == s.charAt(i)) {
                    j = 1;
                    k = i + 1;
                    while ( j < find.length() && find.charAt(j) == s.charAt(k)) {
                        k++;
                        j++;
                    } 
                    if (j == find.length()) {
                        r += c;
                        i += find.length() - 1;
                    } else {
                        r += s.charAt(i);
                    } 
                } else {
                    r += s.charAt(i);
                } 
            } 
        } 
        return r;
    } 

    
    public static int parse (char c) {
        int result = (int) c;
        if( '0' <= c && c <= '9')
            result = (int) c - 48;
        return result;
    } 
    public static char intToChar (int x) {
        char result = (char) x;
        if( 0 <= x && x <= 9)
            result = (char) (x + 48);
        return result;
    } 
    public static String replaceVar (String s, int n, int [] vars) throws IOException {
        String result = s;
        String x = "";
        if (n >= 0) {
            for(int i = 1; i <= n; i++) {
                x += intToChar(vars[i]);
                if(i == 1) {
                    result = replaceString(result, "A", x);
                } else if(i == 2) {
                    result = replaceString(result, "B", x);
                } else if(i == 3) {
                    result = replaceString(result, "C", x);
                } 
                x = "";
            } 
        } else {
            result = "0";
        } 
        return result;
    } 

    
    public static String removeWhiteSpaces (String s) {
        return replaceString(s, " ", "");
    } 
    public static int [] lerExpressao(String [] str) throws IOException {
        int [] vars = new int [4];
        str[0] = "";
        String s = reader.readLine();
        vars[0] = parse(s.charAt(0));
        int j = 1;
        int i;
        for(i = 2; i <= 2*(vars[0]); i+=2) {
            vars[j] = parse(s.charAt(i));
            j++;
        } // end for
        while( i < s.length()){
            str[0] += s.charAt(i);
            i++;
        }
        return vars;
    } 
    public static int posicaoUltimoOperadorLogico (String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == 'a' && s.charAt(i + 1) == 'n' && s.charAt(i + 2) == 'd'
             || s.charAt(i) == 'o' && s.charAt(i + 1) == 'r'
             || s.charAt(i) == 'n' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 't') {
                result = i;
            } 
        } 
        return result;
    } 
    public static String slice (String s, int start, int end) {
        String result = "";
        for(int i = start; i <= end; i++) {
            result += s.charAt(i);
        } 
        return result;
    } 

    
    public static String slice (String s, int start, char end) {
        String result = "";
        result += s.charAt(start);
        for(int i = start + 1; s.charAt(i - 1) != end && i < s.length(); i++) {
            result += s.charAt(i);
        } 
        return result;
    }
    public static String and(String s, int iStart) { 
        String result = s;
        String sliced = slice(s, iStart, ')');
        if(sliced.length() == 8) {
            if(sliced.charAt(4) == '1' && sliced.charAt(6) == '1') {
                result = replaceString(result, sliced, "1", iStart);
            } else {
                result = replaceString(result, sliced, "0", iStart);
            } 
        } else if(sliced.length() == 10) {
            if(sliced.charAt(4) == '1' && sliced.charAt(6) == '1' && sliced.charAt(8) == '1') {
                result = replaceString(result, sliced, "1", iStart);
            } else {
                result = replaceString(result, sliced, "0", iStart);
            } 
        } 
        return result;
    } 

    
    public static String or(String s, int iStart) { // repensar
        String result = s;
        String sliced = slice(s, iStart, ')');
        if(sliced.length() == 7) {
            if(sliced.charAt(3) == '1' || sliced.charAt(5) == '1') {
                result = replaceString(result, sliced, "1", iStart);
            } else {
                result = replaceString(result, sliced, "0", iStart);
            } 
        } 
        if(sliced.length() == 9) {
            if(sliced.charAt(3) == '1' || sliced.charAt(5) == '1' || sliced.charAt(7) == '1') {
                result = replaceString(result, sliced, "1", iStart);
            } else {
                result = replaceString(result, sliced, "0", iStart);
            } 
        } 
        if(sliced.length() == 11) {
            if(sliced.charAt(3) == '1' || sliced.charAt(5) == '1' || sliced.charAt(7) == '1' || sliced.charAt(9) == '1') {
                result = replaceString(result, sliced, "1", iStart);
            } else {
                result = replaceString(result, sliced, "0", iStart);
            } 
        } 
        return result;
    } 

    
    public static String not(String s, int iStart) { 
        String result = s;
        String sliced = slice(s, iStart, iStart + 5);
        if(sliced.charAt(4) == '1') {
            result = replaceString(result, sliced, "0", iStart);
        } else {
            result = replaceString(result, sliced, "1", iStart);
        } 
        return result;
    } 

    
    public static String replaceExpressao (String s) {
        String result = s;
        int index = 0;
        while(result.length() != 1) {
            index = posicaoUltimoOperadorLogico(result);
            if(result.charAt(index) == 'a') {
                result = and(result, index);
            } else if (result.charAt(index) == 'o') {
                result = or(result, index);
            } else if (result.charAt(index) == 'n') {
                result = not(result, index);
            } 
        } 
        return result;
    } 

    public static void main (String [] args) throws IOException{
        int [] vars;
        String [] s = new String[1];
        s[0] = "";
        do {
            vars = lerExpressao( s );
            if(vars[0] != 0) {
                s[0] = replaceVar(s[0], vars[0], vars);
                s[0] = removeWhiteSpaces(s[0]);
                s[0] = replaceExpressao(s[0]);
                System.out.println(s[0]);

                
                
            } 
        } while(vars[0] != 0);
    } 
}


/*Is em Java - Crie um método iterativo que recebe uma string e retorna true se a mesma é
composta somente por vogais. Crie outro método iterativo que recebe uma string e retorna
true se a mesma é composta somente por consoantes. Crie um terceiro método iterativo que
recebe uma string e retorna true se a mesma corresponde a um número inteiro. Crie um quarto
método iterativo que recebe uma string e retorna true se a mesma corresponde a um número
real. Na saı́da padrão, para cada linha de entrada, escreva outra de saı́da da seguinte forma X1
X2 X3 X4 onde cada Xi é um booleano indicando se a é entrada é: composta somente por vogais
(X1); composta somente somente por consoantes (X2); um número inteiro (X3); um número real
(X4). Se Xi for verdadeiro, seu valor será SIM, caso contrário, NÃO. */

public class RecursIsJava {
    public static boolean isReal(String str) {
        return verificaReal(str, 0);
    }

    public static boolean verificaReal(String str, int n) {
        boolean resp = true;
        int tamanho = str.length() - 1;
        if (n <= tamanho - 1) {
            if (str.charAt(n) == 1 || str.charAt(n) == 2 || str.charAt(n) == 3
                    || str.charAt(n) == 4
                    || str.charAt(n) == 5 || str.charAt(n) == 6 || str.charAt(n) == 7 || str.charAt(n) == 8
                    || str.charAt(n) == 9 || str.charAt(n) == 0) {
                        verificaReal(str, ++n);

            } else if(str.charAt(n) == '.'){
                verificaReal(str, ++n);
            }else{
                resp = false;
                n = tamanho - 1;
            }
        }
        return resp;
    }

    public static boolean isInteiro(String str) {
        return verificaInteiro(str, 0);
    }

    public static boolean verificaInteiro(String str, int n) {
        boolean resp = true;
        int tamanho = str.length() - 1;
        if (n <= tamanho - 1) {
            if (str.charAt(n) == 1 || str.charAt(n) == 2 || str.charAt(n) == 3 || str.charAt(n) == 4
                    || str.charAt(n) == 5 || str.charAt(n) == 6 || str.charAt(n) == 7 || str.charAt(n) == 8
                    || str.charAt(n) == 9 || str.charAt(n) == 0) {
                verificaInteiro(str, ++n);
            } else {
                resp = false;
                n = tamanho - 1;
            }
        }

        return resp;
    }
    public static boolean isLetra(char c){
	
		boolean resp = false;
		if(c >= 65 && c <= 90 || c >= 97 && c <= 122){
			resp = true;
		}

		return resp;
	
	}

    public static boolean isConsoante(String str) {
        return verificaConsoante(str, 0);
    }

    public static boolean verificaConsoante(String str, int n) {
        boolean resp = true;
        int tamanho = str.length() - 1;
        if (n <= tamanho - 1) {
            if (str.charAt(n) == 'A' || str.charAt(n) == 'E' || str.charAt(n) == 'I' || str.charAt(n)== 'O'
                    || str.charAt(n) == 'U' && (!isLetra(str.charAt(n)))) {
                resp = false;
                n = tamanho - 1;
            } else {
                verificaConsoante(str, ++n);
            }
        }
        return resp;
    }

    public static boolean isVogal(String str) {
        return verificarVogal(str, 0);
    }

    public static boolean verificarVogal(String str, int n) {
        boolean resp = true;
        int tamanho = str.length() - 1;
        if (n <= tamanho - 1) {
            if (str.charAt(n) == 'A' || str.charAt(n) == 'E' || str.charAt(n) == 'I' || str.charAt(n) == 'O'
                    || str.charAt(n) == 'U' && isLetra(str.charAt(n))) {
                verificarVogal(str, ++n);
            } else {
                resp = false;
                n = tamanho - 1;
            }
        }
        return resp;
    }

    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        String entrada[] = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readString();

        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;

        for (int i = 0; i < numEntrada; i++) {
            MyIO.print(isVogal(entrada[i]) ? "SIM" : "NAO");
            MyIO.print(isConsoante(entrada[i]) ? " SIM" : " NAO");
            MyIO.print(isInteiro(entrada[i]) ? " SIM" : " NAO");
            MyIO.println(isReal(entrada[i]) ? " SIM" : " NAO");
        }

    }
}

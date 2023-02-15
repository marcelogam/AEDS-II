import java.util.Scanner;

class No {
    char elemento;
    No esq, dir;

    public No(char elemento) {
        this(elemento, null, null);
    }

    public No(char elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

}

public class OperacoesABP {
    No raiz;

    public OperacoesABP() {
        raiz = null;
    }

    public void inserir(char elemento) {
        raiz = inserir(elemento, raiz);
    }

    private No inserir(char elemento, No i) {
        if (i == null) {
            i = new No(elemento);
        } else if (elemento < i.elemento) {
            i.esq = inserir(elemento, i.esq);
        } else if (elemento > i.elemento) {
            i.dir = inserir(elemento, i.dir);
        } else {
            System.out.println("Erro ao inserir!");
        }
        return i;
    }

    public boolean pesquisar(char elemento) {
        return pesquisar(elemento, raiz);
    }

    private boolean pesquisar(char elemento, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (elemento == i.elemento) {
            resp = true;
        } else if (elemento > i.elemento) {
            resp = pesquisar(elemento, i.dir);
        } else {
            resp = pesquisar(elemento, i.esq);
        }
        return resp;
    }

    public void mostrarPRE() {
        mostrarPRE(raiz);
        System.out.println();
    }

    private void mostrarPRE(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            mostrarPRE(i.esq);
            mostrarPRE(i.dir);
        }
    }

    public void mostrarIN() {
        mostrarIN(raiz);
        System.out.println();
    }

    private void mostrarIN(No i) {
        if (i != null) {
            mostrarIN(i.esq);
            System.out.print(i.elemento + " ");
            mostrarIN(i.dir);
        }

    }

    public void mostrarPOST() {
        mostrarPOST(raiz);
        System.out.println();
    }

    private void mostrarPOST(No i) {
        if (i != null) {
            mostrarPOST(i.esq);
            mostrarPOST(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    public static void findOper(String operacao, OperacoesABP arvore) {
        if (operacao.charAt(0) == 'I' && operacao.charAt(1) == ' ') {
            char elemento = operacao.charAt(2);
            arvore.inserir(elemento);
        } else if (operacao.charAt(0) == 'P' && operacao.charAt(1) == ' ') {
            char elemento = operacao.charAt(2);
            Boolean resp;
            resp = arvore.pesquisar(elemento);
            if(resp){
                System.out.println(elemento + " existe");
            }else{
                System.out.println("nao existe");
            }
        } else if (operacao.charAt(0) == 'I' && operacao.charAt(1) == 'N' ) {
            arvore.mostrarIN();
        } else if (operacao.charAt(0) == 'P' && operacao.charAt(1) == 'R') {
            arvore.mostrarPRE();
        } else if (operacao.charAt(0) == 'P' && operacao.charAt(1) == 'O') {
            arvore.mostrarPOST();
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        OperacoesABP arvore = new OperacoesABP();
        while (sc.hasNextLine()) {
            String operacao = sc.nextLine();
            findOper(operacao, arvore);
        }
        sc.close();
    }
}

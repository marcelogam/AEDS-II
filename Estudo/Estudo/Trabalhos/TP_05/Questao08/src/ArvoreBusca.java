import java.util.Scanner;

class No{
    int elemento;
    No esq,dir;

    public No (int elemento){
        this(elemento,null,null);
    }

    public No(int elemento,No esq, No dir){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

}

public class ArvoreBusca {
    No raiz;

    public ArvoreBusca(){
        raiz = null;
    }


    public void inserir(int elemento){
        raiz = inserir(elemento,raiz);
    }
    
    private No inserir(int elemento, No i){
        if(i == null){
            i = new No(elemento);
        }else if (elemento < i.elemento){
            i.esq = inserir(elemento,i.esq);
        }else if(elemento > i.elemento){
            i.dir = inserir(elemento,i.dir);
        }else{
            System.out.println("Erro ao inserir!");
        }
        return i;
    }

    public void mostrarPRE(){
        mostrarPRE(raiz);
    }
    
    private void mostrarPRE(No i){
        if(i != null){
            System.out.print(i.elemento + " ");
            mostrarPRE(i.esq);
            mostrarPRE(i.dir);
        }
    }

    public void mostrarIN(){
        mostrarIN(raiz);
    }

    private void mostrarIN(No i){
        if(i != null){
            mostrarIN(i.esq);
            System.out.print(i.elemento + " " );
            mostrarIN(i.dir);
        }

    }

    public void mostrarPOST(){
        mostrarPOST(raiz);
    }

    private void mostrarPOST(No i){
        if(i != null){
            mostrarPOST(i.esq);
            mostrarPOST(i.dir);
            System.out.print(i.elemento + " ");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int casosTeste = sc.nextInt();
        for(int i = 0; i < casosTeste;i++){
            ArvoreBusca arvore = new ArvoreBusca();
            int num = sc.nextInt();
            for(int j = 0; j < num;j++){
                int termo = sc.nextInt();
                arvore.inserir(termo);
            }
            System.out.println("Case " + (i + 1) + ":");
            System.out.print("Pre.: ");
            arvore.mostrarPRE();

            System.out.println();
            System.out.print("In..: ");
            arvore.mostrarIN();

            System.out.println();
            System.out.print("Post: ");
            arvore.mostrarPOST();

            System.out.println();
            System.out.println();
        }
        sc.close();
      
    }
}

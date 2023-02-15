import javax.lang.model.util.ElementScanner14;

class Fila {
    int[] array;
    int primeiro, ultimo;

    Fila() {
        this(5);
    }

    Fila(int tamanho) {
        array = new int[tamanho + 1];
        primeiro = ultimo = 0;
    }

    void inserir(int x) throws Exception {
        if (((ultimo + 1) % array.length) == primeiro)
            throw new Exception("Erro! Tamanho excedido");

        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
    }

    int remover() throws Exception {
        if (primeiro == ultimo)
            throw new Exception("Erro! nao tem argumentos na fila");
        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length;
        return resp;
    }

    void mostrar() {
        int i = primeiro;
        System.out.print("[");

        while (i != ultimo) {
            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;
        }
        System.out.println("]");
    }

    boolean isVazio() {
        boolean vazio = false;
        if (primeiro == ultimo) {
            vazio = true;
        }
        return vazio;
    }

    void fazerRecursao(int i) {
        if (i == ultimo) {
        } else {
            System.out.print(array[i] + " ");
            fazerRecursao((i = (i + 1) % array.length));
        }
    }

    void mostrarRec() {
        System.out.print("[");
        fazerRecursao(primeiro);
        System.out.println("]");
    }

    // boolean fazerpesquisa(int i,int elemento){
    // boolean existe;
    //
    // if(i == ultimo){
    // existe = false;
    // }else if(array[i] == elemento){
    // existe = true;
    // i = ultimo;
    // }else{
    // fazerpesquisa((i = (i+1) % array.length) , elemento);
    // }
    //
    // return existe;
    // }

    boolean pesquisar(int elemento) {
        boolean existe = false;
        int i = primeiro;
        while (i != ultimo) {
            if (array[i] == elemento) {
                existe = true;
                i = ultimo;
            }
            i = ((i + 1) % array.length);
        }
        return existe;
    }

    int retornaPos(int posicao) {
        if (posicao > (array.length - 1)){
            System.out.println("ERRO");
        }

        int valor;
        valor = array[posicao];
        return valor;
    }

    public static void main(String[] args) throws Exception {
        Fila fila = new Fila(5);
        System.out.println(fila.isVazio());
        fila.inserir(3);
        fila.inserir(4);
        fila.inserir(10);
        System.out.println(fila.isVazio());
        fila.mostrar();
        fila.mostrarRec();
        fila.inserir(6);
        fila.inserir(18);
        fila.mostrar();
        fila.mostrarRec();
        fila.remover();
        fila.remover();
        fila.inserir(24);
        fila.inserir(3);
        fila.mostrar();
        fila.mostrarRec();
        System.out.println(fila.pesquisar(4));
        System.out.println(fila.retornaPos(0));
    }

}

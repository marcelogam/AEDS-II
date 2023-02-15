class Lista {
   public Games array[];
   private int n;

   /**
    * Construtor da classe.
    */
   public Lista() {
      this(6);
   }

   /**
    * Construtor da classe.
    * 
    * @param tamanho Tamanho da lista.
    */
   public Lista(int tamanho) {
      array = new Games[tamanho];
      n = 0;
   }

   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * 
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Games game) throws Exception {

      // validar insercao
      if (n >= array.length) {
         throw new Exception("Erro ao inserir!");
      }

      // levar elementos para o fim do array
      for (int i = n; i > 0; i--) {
         array[i] = array[i - 1];
      }

      array[0] = game;
      n++;
   }

   /**
    * Insere um elemento na ultima posicao da lista.
    * 
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Games game) throws Exception {

      // validar insercao
      if (n >= array.length) {
         throw new Exception("Erro ao inserir!");
      }

      array[n] = game;
      n++;
   }

   /**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * 
    * @param x   int elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Games game, int pos) throws Exception {

      // validar insercao
      if (n >= array.length || pos < 0 || pos > n) {
         throw new Exception("Erro ao inserir!");
      }

      // levar elementos para o fim do array
      for (int i = n; i > pos; i--) {
         array[i] = array[i - 1];
      }

      array[pos] = game;
      n++;
   }

   /**
    * Remove um elemento da primeira posicao da lista e movimenta
    * os demais elementos para o inicio da mesma.
    * 
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Games removerInicio() throws Exception {

      // validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      Games game = array[0];
      n--;

      for (int i = 0; i < n; i++) {
         array[i] = array[i + 1];
      }

      return game;
   }

   /**
    * Remove um elemento da ultima posicao da lista.
    * 
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Games removerFim() throws Exception {

      // validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--n];
   }

   /**
    * Remove um elemento de uma posicao especifica da lista e
    * movimenta os demais elementos para o inicio da mesma.
    * 
    * @param pos Posicao de remocao.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public Games remover(int pos) throws Exception {

      // validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      Games game = array[pos];
      n--;

      for (int i = pos; i < n; i++) {
         array[i] = array[i + 1];
      }

      return game;
   }

   /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar() {
      System.out.print("[ ");
      for (int i = 0; i < n; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.println("]");
   }

   /**
    * Procura um elemento e retorna se ele existe.
    * 
    * @param x int elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    *         <code>false</code> em caso contrario.
    */
   public void pesquisar(int id) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i].getApp_id() == id);
      }

      if (retorno) {
         System.out.println("SIM");
      } else {
         System.out.println("NAO");
      }

   }

   public static void main(String[] args) throws Exception {

   }
}
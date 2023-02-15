public class App {
  public static void main(String[] args) throws Exception {
    int n = 32;
    int cont = 0;
    for (int i = n; i > 1; i /= 2){
      cont++;
    }
    System.out.println(cont);
  }
}

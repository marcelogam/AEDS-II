public class App {
    public static void main(String[] args) throws Exception {
        double salarioBruto = 1100;
        double prestacao = 250;

        double valorMaximo = 0.4 * salarioBruto;
        if(prestacao > valorMaximo){
            System.out.println("emprestimo nao concedido");
        }else{
            System.out.println("emprestimo concedido");
        }
    }
}

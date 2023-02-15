public class App {
    public static void main(String[] args) throws Exception {
        double lado1 = 5.3;
        double lado2 = 6.5;
        double lado3 = 7.0;

        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("Equilatero");
        }else if(lado1 == lado2 || lado2 == lado3 || lado3 == lado1){
            System.out.println("Isosceles");
            } else{
                System.out.println("Escaleno");
            }
    }
}

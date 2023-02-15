public class App {
    public static void main(String[] args) throws Exception {
        int num1 = 5;
        int num2 = 3;
        int num3 = 11;

        int maior = num1;
        int menor = num1;

        if(maior < num2){
            maior = num2;
        }else if(maior < num3){
            maior = num3;
        }
        if(menor > num2){
            menor = num2;
        }else if(menor > num3){
            menor = num3;
        }
        System.out.println("Menor: "+menor+" Maior: "+maior);


    }
}

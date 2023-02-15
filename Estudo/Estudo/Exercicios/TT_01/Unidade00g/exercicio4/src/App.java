public class App {
    public static void main(String[] args) throws Exception {
        int num1 = 25;
        int num2 = 47;
        int num3 ;
        
        if(num1 > 45 || num2 > 45){
            num3 = num1 + num2;
            System.out.println(num3);
        }else if(num1 > 20 && num2 > 20){
            if(num1 > num2){
                num3 = num1 - num2;
                System.out.println(num3);
            }else{
                num3 = num2 - num1;
                System.out.println(num3);
            }
        }else if((num1 < 10 || num2 < 10) && (num1 != 0 || num2 != 0)){
            num3 = num1 / num2;
            System.out.println(num3);
        }else{
            System.out.println("Marcelo");
        }
    }
}

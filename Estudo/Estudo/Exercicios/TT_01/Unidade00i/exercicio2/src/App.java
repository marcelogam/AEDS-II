public class App {
    public static void passagemDeArray(int[]b) {
        for(int i = 0; i < 5; i++){
            b[i] *= 5;
            System.out.println("b["+i+"]: "+b[i]);
        }
        b = new int[5];
        for(int i = 0; i < 5; i++){
            b[i] = i;
            System.out.println("b["+i+"]: "+b[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        int[] y = new int[5];
        for(int i = 0; i< 5; i++){
            y[i] = i;
            System.out.println("y["+i+"]: "+y[i]);
        }
        passagemDeArray(y);
        for(int i = 0; i < 5; i++){
            System.out.println("y["+i+"]: "+y[i]);
        }
    }
}
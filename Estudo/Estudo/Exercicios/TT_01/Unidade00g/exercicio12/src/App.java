public class App {
    public static void main(String[] args) throws Exception {
        int n = MyIO.readInt();
        int i = 0;
        int num = 1;
        n = n/2;
        while(i<n){
            MyIO.println(num);
            num += 4;
            MyIO.println(num);
            num +=7;
            i++;
        }
        //1,5,12,16,23,27,34

    }
}


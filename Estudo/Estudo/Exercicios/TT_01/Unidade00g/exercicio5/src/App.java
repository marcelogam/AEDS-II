public class App {
    public static void main(String[] args) throws Exception {
        int golsMan = 3;
        int golsVis = 0;

        if(golsMan > golsVis){
            System.out.println("O time mandante venceu a partida");
        }else if(golsVis > golsMan){
            System.out.println("O time visitante venceu a partida");
        }else{
            System.out.println("A partida ficou empatada");
        }
    }
}

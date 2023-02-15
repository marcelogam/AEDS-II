public class Ponto {
    private double x, y;
    private int id, nextID;

    public Ponto(int id,int nextID){
        this.id = id;
        this.nextID = nextID;
    }
    public Ponto(){
        this.x = 0;
        this.y = 0;
    }
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return this.y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public static void main(String[] args)throws Exception {

        
    }
}

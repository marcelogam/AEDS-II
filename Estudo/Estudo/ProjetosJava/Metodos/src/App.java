public class App {
    public static void main(String[] args) throws Exception {
        Personagem heroi = new Personagem();
        heroi.nome = "Hercoles";
        heroi.nivel = 2;
        heroi.forca = 16;

        // "Personagem: <nome> (lvl <nivel>) com <forca> de forca."
        heroi.mostrarStatus();
        heroi.atacar("Hydra","Golpe duplo");
    }
}

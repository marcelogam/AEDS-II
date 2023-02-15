import java.util.Random;

public class Personagem {
    String nome;
    int nivel;
    int forca;

    // void -> siginifca que nao esta retornanado
    void mostrarStatus() {
        System.out.println("Personagem: " + nome + "(lvl: " + nivel + ") com " + forca + " de forca");
    }

    int calcularDano(){
        Random gerador = new Random();
        int dado20Faces = 1 + gerador.nextInt(19);
        int dano = forca + dado20Faces;
        return dano;
    }

    void atacar(String alvo, String habilidade){
        int danoCausado = calcularDano();
        if(habilidade.length() == 0){
            System.out.println(nome+" atacou "+alvo+" e deu "+danoCausado+" de dano");
        } else {
            System.out.println(nome+" atacou com "+habilidade+" o personagem "+alvo+" e deu "+danoCausado+" de dano");
        }
    }
}

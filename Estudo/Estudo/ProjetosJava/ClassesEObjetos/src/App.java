public class App {
    public static void main(String[] args) throws Exception {
        // Declarando um objeto do tipo celular = Instanciando um novo objeto
        Celular celularA = new Celular();
        celularA.nome = MyIO.readLine();
        celularA.tamanhoTela = MyIO.readDouble();
        celularA.sistemaOperacional = "iOS";
        celularA.espacoArmanezamento = 256;

        MyIO.println("O celular "+celularA.nome+" tem um tamanho de "+celularA.tamanhoTela);

    }
}

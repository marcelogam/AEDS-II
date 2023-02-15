public class App {
    public static void main(String[] args) throws Exception {
        
        String filme = "Vingadores"; //%s
        int anoLancamento = 2015; //%d
        int duracao = 120;
        double nota = 8.7;//%f
        char  letraInicial = 'c';//%c
        boolean jaLancou = true;//%b

        System.err.println("O filme "+filme); //.err vai mostrar a mesnagem em forma de erro .out mostra da maneira normal
        System.out.println("Ano de lancamento: "+anoLancamento);
        System.err.println("Nota media: "+nota);
        System.out.println("Letra inicial: "+letraInicial);
        System.err.println("Ja lancou? "+jaLancou);
        System.out.println("Duracao do filme[em mimutos]: "+duracao);

        System.out.println("1- O filme "+filme+" lancado em "+anoLancamento+" tem uma duracao de "+duracao);
        
        System.out.format("2- O filme %s lancado em %d tem uma duracao de %d minutos \n", filme,anoLancamento,duracao); // \n avanca uma linha
        
        String texto = "3- O filme "+filme+" lancado em "+anoLancamento+" tem uma duracao de "+duracao;
        System.out.println(texto);

        String texto2 = String.format("4- O filme %s lancado em %d tem uma duracao de %d minutos \n", filme,anoLancamento,duracao);
        System.out.println(texto2);

        String canal = "Academia dos Devs ";
        String mensagem = "Se inscreva no canal ";
        String mensagem2 = "Obrigado o/";

        String mensagemFinal = mensagem + canal + mensagem2;
        System.out.println(mensagemFinal);

    }
}

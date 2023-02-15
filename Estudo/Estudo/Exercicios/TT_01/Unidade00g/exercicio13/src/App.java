public class App {
    public static void main(String[] args) throws Exception {
        MyIO.println("Digite a nota maxima: ");
        double notaMaxima = MyIO.readInt();
        int n = 20,
            i = 0,
            abaixo = 0,
            acima = 0;
        double nota,
               soma = 0,
               media,
               mediaUni = notaMaxima * 0.6,
               mediaAcima = notaMaxima * 0.9;

        while (i < n) {
            System.out.println("Digite a nota");
            nota = MyIO.readInt();
            soma = soma + nota;
            if(nota < mediaUni){
                abaixo ++;
            }
            if(nota >= mediaAcima){
                acima ++;
            }
            i++;
        }
        media = soma / n;
        MyIO.println("Media da turma: "+media);
        MyIO.println("Notas abaixo da media: "+abaixo);
        MyIO.println("Notas com conceito A: "+acima);
    
    }
}

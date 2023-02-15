public class App {
    public static void main(String[] args) throws Exception {
        
        //****************soma****************
        int numeroA = 5;
        int numeroB = 6;
        int resultado = numeroA + numeroB;
        int resultado2 = 8 + 2;
        System.out.println(resultado);
        System.out.println(resultado2);

        //****************subtracao****************
        int subtracao = 1 - 2;
        System.out.println(subtracao);

        //****************multiplicacao****************

        int multiplicacao = 2 * 4;
        System.out.println(multiplicacao);

        //****************Divisao****************

        int divisao = 10  / 5;
        System.out.println(divisao);

        double divisao2 = (double)5 / 2;
        System.out.println(divisao2);

        int resto = 11 % 2;
        System.out.println(resto);

        //****************Incremento****************
        
        int contador = 0;
        System.out.println(contador);
        contador --;
        System.out.println(contador);
        contador ++;
        System.out.println(contador);
        contador += 2; // += OU -= OU /= OU *= OU %=
        System.out.println(contador);
        // contador ++ mostra o valor depois soma
        System.out.println(contador++);
        System.out.println(contador);
        // ++ contador soma depois mostra o valor
        System.out.println(++contador);
        System.out.println(contador);
        

        // ****************Biblioteca Math****************

        int X = -5,
            Y = 6;
        int absoluto = Math.abs(X); // Essa funcao retorna sempre um valor absoluto entao se passar um valor negativo ela tranforma em positivo.
        System.out.println(absoluto);

        int potencia =(int) Math.pow(10,2); //10^2
        System.out.println(potencia);

        int raizQuadrada = (int) Math.sqrt(4); //raiz quadrada
        System.out.println(raizQuadrada);

        double arredondarParaCima = Math.ceil(10.54); // Arredonda o numero para cima
        System.out.println(arredondarParaCima);

        double arredondarParaBaixo = Math.floor(2.59); // Arredonda para baixo
        System.out.println(arredondarParaBaixo);
        
        double maior = Math.max(5, 9); // Encontra o  maior numero entre os dois
        System.out.println(maior);

        double menor = Math.min(X, Y); // Encontra o menor entre os dois
        System.out.println(menor);
        
        

    }
}

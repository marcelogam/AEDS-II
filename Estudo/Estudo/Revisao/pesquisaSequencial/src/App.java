package pesquisaSequencial.src;

public class App {
    boolean pesquisa = false;
    int n = 5;
    int x = 6;
    int[] numeros = new int[n];

    numeros[0]=1;numeros[1]=2;numeros[2]=3;numeros[3]=4;numeros[4]=5;

    for(int i = 0;i<n;i++)
    {
        if (numeros[i] == x) {
            pesquisa = true;
            i = n;
        }
    }
    MyIO.println(pesquisa);

}
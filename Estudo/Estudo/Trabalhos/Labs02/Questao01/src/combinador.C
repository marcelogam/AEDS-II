/*Combinador em C - Implemente um programa em Java denominado combinador, que recebe
duas strings e deve combin ́a-las, alternando as letras de cada string, come ̧cando com a primeira
letra da primeira string, seguido pela primeira letra da segunda string, em seguida pela segunda
letra da primeira string, e assim sucessivamente. As letras restantes da cadeia mais longa devem
ser adicionadas ao fim da string resultante e retornada.*/

#include <stdio.h>

int descobrirTamanho1(char palavra[])
{
    int tamanho = 0;
    while (palavra[tamanho] != ' ')
    {
        tamanho++;
    }
    return tamanho;
}

int descobrirTamanho2(char palavra[], int tamanho)
{
    int tamanhoPalavra = 0;
    while (palavra[tamanho + 1] != '\n')
    {
        tamanho++;
        tamanhoPalavra++;
    }
    return tamanhoPalavra;
}

void combinador(char palavra[])
{
    int tamanhoPalavra1 = descobrirTamanho1(palavra);
    int tamanhoPalavra2 = descobrirTamanho2(palavra, tamanhoPalavra1);
    char novaPalavra[1000] = " ";
    int i = 0;
    int j = 0;
    if (tamanhoPalavra2 > tamanhoPalavra1){
        while (palavra[j] != ' '){
            novaPalavra[i] =  palavra[j];
            novaPalavra[i+1] = palavra[tamanhoPalavra1 + 1 + j];
            i = i +2;
            j++;
        }
        while (palavra[tamanhoPalavra1 + 1 + j] != '\n'){
            novaPalavra[i] = palavra [tamanhoPalavra1 +1 + j];
            i++;
            j++;
        }
        printf("%s\n",novaPalavra);
    } 
    if (tamanhoPalavra1 > tamanhoPalavra2){
        while (palavra[tamanhoPalavra1 + 1 + j] != '\n'){
            novaPalavra[i] =  palavra[j];
            novaPalavra[i+1] = palavra[tamanhoPalavra1 + 1 + j];
            i = i +2;
            j++;
        }
        while (palavra[j] != ' '){
            novaPalavra[i] = palavra[j];
            i++;
            j++;
        }
        printf("%s\n",novaPalavra);
    } 
}

int main()
{
    char entrada[1000] = " ";
    while (fgets(entrada, 1000, stdin) != NULL )
    {
        combinador(entrada);
    }

    return 0;
}
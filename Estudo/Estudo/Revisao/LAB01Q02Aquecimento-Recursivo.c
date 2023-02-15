#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool Maiuscula(char s)
{
    return (s >= 'A' && s <= 'Z');
}

bool Fim(char frase[])
{
    return (strlen(frase) == 3 && frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M');
}

int Ler(char frase[80])
{
    int y = 0;
    int count = 0;

    for (y = 0; y < strlen(frase); y++)
    {
        if (Maiuscula(frase[y]) == true)
        {
            count++;
        }
    }

    return (count);
}

int main()
{
    char frase[80];

    do
    {
        printf("\nEntrada: ");
        getw(frase);
        printf("%d", Ler(frase));
    }

    while (Fim(frase) == false);

    getchar();
    return 0;
}
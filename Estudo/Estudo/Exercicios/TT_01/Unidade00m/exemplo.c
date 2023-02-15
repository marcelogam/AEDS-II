#include <stdio.h>
#include <stdlib.h>

int main(){

    printf("Ola pessoal \n");
    char s[100];
    printf("\n Entre com uma palavara: ");
    scanf("%s\n",s);
    printf("s(%s)\n ",s);

    int a = sizeof(char),
        b = sizeof(int),
        c = sizeof(double),
        d = sizeof(float);
    printf("tamanhos: %i --- %i --- %i --- %i\n",a,b,c,d);
    
    return 0;
}
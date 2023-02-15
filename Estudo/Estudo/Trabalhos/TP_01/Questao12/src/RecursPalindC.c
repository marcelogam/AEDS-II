#include <stdio.h>
#include <stdbool.h>

int tamanhoString(char str[]){
    int cont = 0;
    while (str[cont] != '\0')
    {
        cont ++;
    }
    return cont - 1;
}

bool isFim(char str[]){
    return(str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}
bool isPalindromo(char str[],int n){
    int tamanho = tamanhoString(str);
    bool resp = true;
    if(n < tamanho/2){
        if (str[n] != str[tamanho - 1 - n])
        {
            resp = false;
        }else{
            isPalindromo(str,++n);
        }
    }
    return resp;
}

int main(void){
    char string[1000][1000];
    int numEntrada = 0;

    do{
        fgets(string[numEntrada],1000,stdin);
    }while(!isFim(string[numEntrada++]));
    numEntrada --;
    
    for (int i = 0; i < numEntrada; i++)
    {
       if(isPalindromo(string[i],0)){
        printf("SIM\n");
       }else{
        printf("NAO\n");
        }
    }
    

    return 0;
}
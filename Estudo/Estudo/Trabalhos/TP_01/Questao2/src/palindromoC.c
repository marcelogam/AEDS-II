#include <stdio.h>
#include <stdbool.h>

int tamahoString(char string[]){
    int total=0;
    while( string[total] != '\0'){
        total++;
    }
    return total;
}

bool isFIM(char entrada[]){
    return(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M');
}
void isPalindromo(char str[]){
    bool resp = true;
    int tamanho = tamahoString(str) - 1;
    for(int i = 0; i < tamanho/2; i++){
        if(str[i] != str[tamanho - i - 1]){
            resp = false;
            i = tamanho;
        }
    }
    if(resp){
        printf("SIM\n");
    }else{
        printf("NAO\n");
    }

}

int main(void){
    char entrada[1000][1000]; // criando uma string com indice 
    int numEntrada = 0;
    do{
        fgets(entrada[numEntrada],1000,stdin);
    }while (isFIM(entrada[numEntrada++])== false);
    
    numEntrada--; // Descomsiderar o FIM.
    
    for(int i = 0; i < numEntrada; i++){
        isPalindromo(entrada[i]);
    }
    return 0;
    
}
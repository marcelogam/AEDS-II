#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int tamahoString(char string[]){
    int total=0;
    while( string[total] != '\0'){
        total++;
    }
    return total;
}

bool isFim(char str[]){
	return (str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}

bool isLetra(char str){


	return(str >= 65 && str <= 90 || str >= 97 && str <= 122);

}

bool isVogal(char str[]){
	bool resp = true;
	int tamanho = tamahoString(str) - 1;

	for(int i = 0; i < tamanho; i++){
		if (str[i] != 'a' && str[i] != 'e' && str[i] != 'i' && str[i] != 'o' && str[i] != 'u' && str[i] != 'A' && str[i] != 'E' && str[i] != 'I' && str[i] != 'O' && str[i] != 'U'){
			
			resp = false;
			i = tamanho;
		}
	}

	return resp;
}

bool isConsoante(char str[]){
	bool resp = true;
	int tamanho = tamahoString(str) - 1;
	
	for(int i = 0; i < tamanho; i++){
		if(str[i]  == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' || (!isLetra(str[i]))){	
	   		resp = false;
                        i = tamanho;
                }
        }
		return resp;

}

bool isInteiro(char str[]){

                bool resp = true;
		int tamanho = tamahoString(str) - 1;
                for(int i = 0; i < tamanho; i++){
                        if(str[i] >= 48 && str[i] <=57){
                                resp = true;
                        }else{
                                resp = false;
                                i = tamanho;
                        }
                }

                return resp;

        }

bool isReal(char str[]){

                bool resp = true;
		int tamanho = tamahoString(str) - 1;

                for(int i = 0; i < tamanho; i++){

                        if(str[i] == '1' || str[i] == '2' || str[i] == '3' || str[i] == '4' || str[i] == '5' || str[i] == '6' || str[i] == '7' || str[i] == '8' || str[i] == '9' || str[i] == '0' || str[i] == '.' || str[i] == ','){
                                resp = true;

                        }else{
                                resp = false;
                                i = tamanho;
                        }

                }

                return resp;
        }


int main(){
	char palavra[1000][1000];
	int entrada = 0;

	do{
		fgets(palavra[entrada], 1000, stdin);

	}while(!isFim(palavra[entrada++]));

	entrada--;


	for(int i = 0; i < entrada; i++){
		printf(isVogal(palavra[i])     == true    ? "SIM " : "NAO ");
		printf(isConsoante(palavra[i]) == true    ? "SIM " : "NAO ");
		printf(isInteiro(palavra[i])   == true    ? "SIM " : "NAO ");
		printf(isReal(palavra[i])      == true    ? "SIM\n" : "NAO\n");
	}


	return 0;

}
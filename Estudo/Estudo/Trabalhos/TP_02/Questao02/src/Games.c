#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX_SIZE 1000
#define MAX_COL 40

typedef struct S_Game{
    int     app_id;
    char    name [MAX_SIZE];
    char    release_date [MAX_SIZE];
    char    owners [MAX_SIZE];
    int     age;
    float   price;
    int     dlcs;
    char**  languages;
    char    website [MAX_SIZE];
    bool    windows;
    bool    mac;
    bool    linux_;
    float   upvotes;
    int     avg_pt;
    char    developers [MAX_SIZE];
    char**  genres;
} Game;

double meuPow (int x, int y) {
    double num = 1.0;
    if(y > 0) {
        for (int i = 0; i < y; i++) {
            num = num * x;
        }   
    } else if (y < 0) {
        for (int i = 0; i > y; i--) {
            num = num / x;
        } 
    } 
    return num;
} 

void tabelaInit(char*** t) {
    char** p = (char**) malloc (MAX_COL * sizeof(char*));
    for(int i = 0; i < MAX_COL; i++){
        p[i] = (char*) malloc (MAX_SIZE * sizeof(char));
        p[0][i] = '\0';
    }
    *t = p;
} 

char** tabelaClone(char** old_table) {
    char** new_table; tabelaInit(&new_table);
    for(int i = 0; i < MAX_COL; i++) {
        strcpy(new_table[i], old_table[i]);
    } 
    return new_table;
}

Game inicioGame() {
    Game game;
    game.app_id = 0;
    game.name[0] = '\0';
    game.release_date[0] = '\0';
    game.owners[0] = '\0';
    game.age = 0;
    game.price = 0.0;
    game.dlcs = 0;
    tabelaInit(&game.languages);
    game.website[0] = '\0';
    game.windows = false;
    game.mac = false;
    game.linux_ = false;
    game.upvotes = 0.0;
    game.avg_pt = 0;
    game.developers[0] = '\0';
    tabelaInit(&game.genres);
    return game;
} 

Game construct(int app_id, char name[], char release_date [], char owners[], int age, float price, int dlcs, char** languages, char website[], bool windows, bool mac, bool linux_, float upvotes, int avg_pt, char developers[], char** genres) {
    Game game;
    game.app_id = app_id;
    strcpy(game.name, name);
    strcpy(game.release_date, release_date);
    strcpy(game.owners, owners);
    game.age = age;
    game.price = price;
    game.dlcs = dlcs;
    game.languages= tabelaClone(languages);
    strcpy(game.website, website);
    game.windows = windows;
    game.mac = mac;
    game.linux_ = linux_;
    game.upvotes = upvotes;
    game.avg_pt = avg_pt;
    strcpy(game.developers, developers);
    game.genres = tabelaClone(genres);
    return game;
} 

int lerArquivo(FILE* arq, char* raw ) {
    int eof = 0;
    raw[0] = '\0';
    char aux;
    int n = 0;
    if(arq != NULL) {
        for(int i = 0; aux != '\n';i++) {
            aux = getc(arq);
            raw[n] = aux;
            n++;
            if(aux==EOF) {
                eof = EOF;
                raw[n] = '\0';
                break;
            } 
        } 
        raw[n-2] = '\0';
    } else {
            printf("\n[readFile]: NAO FOI POSSIVEL LER O ARQUIVO!\n");
    } 
    return eof;
} 

void espelho (char* str) {
    int n = (int) strlen(str);
    char aux;
    for(int i = 0; i < (int) (n/2); i++) {
        aux = str[i];
        str[i] = str[n-i-1];
        str[n-i-1] = aux;
    } 
    str[n] = '\0';
} 

char* nextText (char* raw) {
    char* result = (char*)malloc(MAX_SIZE*sizeof(char));
    result[0] = '\0';
    int i = strlen(raw) - 1;
    int n = 0;
    if (raw[i] != '"') {
        if(raw[i] != ',') {
            while( raw[i] != ',' && i < strlen(raw)) {
                result[n] = raw[i];
                n++;
                i--;
            }
        } 
        result[n] = '\0';
        raw[i] = '\0';
    } else {
        i = i - 1;
        while (raw[i] != '"' && i < strlen(raw)) {
            result[n] = raw[i];
            n++;
            i--;
        } 
        result[n] = '\0';
        raw[i-1] = '\0';
    } 
    espelho(result);
    return result;
} 

void nextTextTable (char** table, char* raw) {
    int i = strlen(raw) - 1;
    int j = 0;
    int n = 0;
    if( raw[i] == '"' && raw[i-1] == ']' ) {
        i = i - 3;
        while(raw[i-1] != '[' ||  raw[i-1] == '[' && (raw[i] == 'b' || raw[i] == '/')) {
            if(raw[i] == '\'' && raw[i-1] != '['){
                table[j][n] = '\0';
                espelho(table[j]);
                n = 0;
                j++;
                i-=4;
            } else {
                table[j][n] = raw[i];
                n++;
                i--;
            } 
        } 
        table[j][n] = '\0';
        table[j+1][0] = '\0';
        espelho(table[j]);
        raw[i-3] = '\0';
    } else if( raw[i] == '"') {
        raw[i] = '\0';
        i = i - 1;
        while(raw[i] != '"') {
            if(raw[i] == ','){
                table[j][n] = '\0';
                espelho(table[j]);
                n = 0;
                j++;
            } else {
                table[j][n] = raw[i];
                n++;
            } 
            i--;
        } 
        table[j][n] = '\0';
        table[j+1][0] = '\0';
        espelho(table[j]);
        raw[i-1] = '\0';
    } else if (raw[i] == ']') {
        i = i - 2;
        if(raw[i] != ',') {
        while(raw[i] != '\''){
                table[0][n] = raw[i];
                n++;
                i--;
            }
            table[0][n] = '\0';
            espelho(table[0]);
        } else {
            table[0][0] = '\0';
        } 
        table[1][0] = '\0';
        raw[i-2] = '\0';
    } else {
        table[1][0] = '\0';
        strcpy(table[0], nextText(raw));
    } 
} 

int stringParaInteiro(char* str) {
    int integer = 0;
    int i = 0;
    int n = strlen(str)-1;
    while( i < strlen(str) ) {
        integer = integer + ((int) (str[i]) - 48) * (meuPow(10,n));
        n--;
        i++;
    } 
    return integer;
} 

int indexOff(char* str, char c) {
    int resp = -1;
    for(int i = 0; i < strlen(str); i++){
        if(str[i] == c) {
            resp = i;
            i = strlen(str);
        } 
    } 
    return resp;
} 

float stringParaFloat(char* str) {
    float f = 0;
    int i = 0;
    int n = 0;
    if(strlen(str) > 1) {
        n = indexOff(str, '.') - 1;
    } 
    while(str[i] != '.' && i < strlen(str)) {
        f = f + ((int) (str[i]) - 48) * (int)(meuPow(10,n));
        n--;
        i++;
    } 
    n = 1;
    i++;
    while( i < strlen(str) ) {
        f = f + ((int) (str[i]) - 48) * (meuPow(10,-n));
        n++;
        i++;
    } 
    return f;
} 

bool stringParaBool(char* str) {
    bool boolean = true;
    if(strlen(str) > 4) {
        boolean = false;
    } 
    return boolean;
} 

char* stringParaData (char* str) {
    char* date = (char*)malloc(MAX_SIZE*sizeof(char));
    int i = 0;
    int j = 3;
    bool temVirgula = true;
    while (i<3) {
        date[i] = str[i];
        i++;
    } 
    while (str[i] != ',' && temVirgula) {
        if(i == 7) {
            temVirgula = false;
        } 
        i++;
    } 
    if(temVirgula) {
        date[j++] = '/';
        i+=2;
        while(i < strlen(str)){
            date[j++] = str[i++];
        } 
    } else {
        j = 3;
        date[j++] = '/';
        while(j < 8){
            date[j] = str[j];
            j++;
        } 
    } 
    date[j] = '\0';
    return date;
} 

char* tabelaParaString(char** lang) {
    int col = 0, n = 0;
    int i = 0;
    while(lang[col+1][0] != '\0'){
        col++;
    } 
    char* str = (char*)malloc(MAX_SIZE*sizeof(char));
    str[0] = '['; str[1] = '\0';
    while(0 <= col) {
        strcat(str, lang[col]);
        n = strlen(str);
        if( 0 < col) {
            str[n++] = ',';
            str[n++] = ' ';
        } 
        str[n] = '\0';
        col--;
    } 
    n = strlen(str);
    str[n++] = ']';
    str[n] = '\0';
    return str;
} 


char* int_toString(int integer) {
    char* str = (char*)malloc(MAX_SIZE*sizeof(char));
    int aux = integer;
    int aux2 = integer;
    int i = 1, j = 0;
    int index = 0;
    while(aux2 > 0) {
        aux = aux2 - (int)(aux2/meuPow(10, i))*meuPow(10, i);
        aux2/=10;
        str[index++] = (char)(aux+48);
    } 
    str[index] = '\0';
    espelho(str);
    return str;
} 

void printar (Game game) {
    printf("%d %s %s %s %d %.2f %d ", game.app_id, game.name, game.release_date, game.owners, game.age, game.price, game.dlcs);
    printf("%s ", tabelaParaString(game.languages));
    if(game.website[0] != '\0') {
        printf("%s ", game.website);
    } else {
        printf("null ");
    } 
    printf("%s ", game.mac? "true" : "false");
    printf("%s ", game.windows? "true" : "false");
    printf("%s ", game.linux_? "true" : "false");
    printf("%.0f%c ",game.upvotes, '%');

    char* avg = (char*)malloc(MAX_SIZE*sizeof(char));
    int horas = 0;
    int min = 0;
    if (game.avg_pt != 0) {
        horas = (int) (game.avg_pt/60);
        min = game.avg_pt*1 - horas*60;
        if(horas == 0) {
            strcpy(avg, int_toString(min)); strcat(avg,"m");
        } else {
            strcpy(avg, int_toString(horas));
            strcat(avg,"h ");
            if(min != 0) {
                strcat(avg,int_toString(min));
                strcat(avg,"m");
            } 
        } 
    } else {
        strcpy(avg,"null");
    } 

    printf("%s ", avg);
    printf("%s ", game.developers);
    printf("%s\n", tabelaParaString(game.genres));
} 

Game lerGame (char* raw) {
    Game newgame = inicioGame();
    nextTextTable(newgame.genres, raw);
    strcpy(newgame.developers, nextText(raw));
    newgame.avg_pt = stringParaInteiro(nextText(raw));
    int neg = stringParaInteiro(nextText(raw));
    int pos = stringParaInteiro(nextText(raw));
    newgame.upvotes = (pos/(float)( pos + neg ))*100;
    newgame.linux_ = stringParaBool(nextText(raw));
    newgame.windows = stringParaBool(nextText(raw));
    newgame.mac = stringParaBool(nextText(raw));
    strcpy(newgame.website, nextText(raw));
    nextTextTable(newgame.languages, raw);
    newgame.dlcs = stringParaInteiro(nextText(raw));
    newgame.price = stringParaFloat(nextText(raw));
    newgame.age = stringParaInteiro(nextText(raw));
    strcpy(newgame.owners, nextText(raw));
    strcpy(newgame.release_date, stringParaData(nextText(raw)));
    strcpy(newgame.name, nextText(raw));
    newgame.app_id = stringParaInteiro(nextText(raw));
    return newgame;
} 

void vizualizarId(int id, Game* lista) {
    int col = 0;
    while(lista[col].app_id != id && lista[col].app_id != 0) {
        col++;
    } 
    if (lista[col].app_id != 0) {
        printar(lista[col]);
    } 
} 

bool isFim(char* str) {
    return(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
} 

int main(int argc, char *argv[]) {
    FILE* arq = fopen("/tmp/games.csv", "r");
    char* raw = (char*)malloc(MAX_SIZE * sizeof(char));
    Game jogo;
    Game* lista = (Game*)malloc(5000*sizeof(Game));
    int i = 0;
    do {
        fflush(stdin);
        lerArquivo(arq, raw);
        jogo = lerGame(raw);
        lista[i++] = jogo;
    } while (!feof(arq));
    fclose(arq);
    char* entrada = (char*)malloc(MAX_SIZE * sizeof(char));
    scanf("%s", entrada);
    while(!isFim(entrada)){
        vizualizarId(stringParaInteiro(entrada), lista);
        scanf("%s", entrada);
    } 
    return 0;
} 
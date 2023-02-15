#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <sys/time.h>

#define MAX_SIZE 1000
#define MAX_COL 40

int comparacoes, movimentacoes;

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

double meupwo (int x, int y) {
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

void init_table(char*** t) {
    char** p = (char**) malloc (MAX_COL * sizeof(char*));
    for(int i = 0; i < MAX_COL; i++){
        p[i] = (char*) malloc (MAX_SIZE * sizeof(char));
        p[0][i] = '\0';
    } 
    *t = p;
} 

char** clone_table(char** old_table) {
    char** new_table; init_table(&new_table);
    for(int i = 0; i < MAX_COL; i++) {
        strcpy(new_table[i], old_table[i]);
    } 
    return new_table;
} 

Game startGame() {
    Game game;
    game.app_id = 0;
    game.name[0] = '\0';
    game.release_date[0] = '\0';
    game.owners[0] = '\0';
    game.age = 0;
    game.price = 0.0;
    game.dlcs = 0;
    init_table(&game.languages);
    game.website[0] = '\0';
    game.windows = false;
    game.mac = false;
    game.linux_ = false;
    game.upvotes = 0.0;
    game.avg_pt = 0;
    game.developers[0] = '\0';
    init_table(&game.genres);
    return game;
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

Game constructGame(int app_id, char name[], char release_date [], char owners[], int age, float price, int dlcs, char** languages, char website[], bool windows, bool mac, bool linux_, float upvotes, int avg_pt, char developers[], char** genres) {
    Game game;
    game.app_id = app_id;
    strcpy(game.name, name);
    strcpy(game.release_date, release_date);
    strcpy(game.owners, owners);
    game.age = age;
    game.price = price;
    game.dlcs = dlcs;
    game.languages= clone_table(languages);
    strcpy(game.website, website);
    game.windows = windows;
    game.mac = mac;
    game.linux_ = linux_;
    game.upvotes = upvotes;
    game.avg_pt = avg_pt;
    strcpy(game.developers, developers);
    game.genres = clone_table(genres);
    return game;
} 

Game cloneGame (Game jogo) {
    return constructGame(jogo.app_id, jogo.name, jogo.release_date, jogo.owners, jogo.age, jogo.price, jogo.dlcs, jogo.languages, jogo.website, jogo.windows, jogo.mac, jogo.linux_, jogo.upvotes, jogo.avg_pt, jogo.developers, jogo.genres);
} 

int readFile(FILE* arq, char* raw ) {
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

int strToInt(char* str) {
    int integer = 0;
    int i = 0;
    int n = strlen(str)-1;
    while( i < strlen(str) ) {
        integer = integer + ((int) (str[i]) - 48) * (meupwo(10,n));
        n--;
        i++;
    } 
    return integer;
} 

int indexOf(char* str, char c) {
    int resp = -1;
    for(int i = 0; i < strlen(str); i++){
        if(str[i] == c) {
            resp = i;
            i = strlen(str);
        } 
    } 
    return resp;
} 

char* table_toString(char** lang) {
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

float strToFloat(char* str) {
    float f;
    sscanf(str, "%f", &f);
    return f;
} 

bool strToBool(char* str) {
    bool boolean = true;
    if(strlen(str) > 4) {
        boolean = false;
    } 
    return boolean;
} 

char* toDate (char* str) {
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

char* int_toString(int integer) {
    char* str = (char*)malloc(MAX_SIZE*sizeof(char));
    int aux = integer;
    int aux2 = integer;
    int i = 1, j = 0;
    int index = 0;
    while(aux2 > 0) {
        aux = aux2 - (int)(aux2/meupwo(10, i))*meupwo(10, i);
        aux2/=10;
        str[index++] = (char)(aux+48);
    } 
    str[index] = '\0';
    espelho(str);
    return str;
} 

bool isFim(char* str) {
    return(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
} 

void imprimir (Game game) {
    printf("%d %s %s %s %d %.2f %d ", game.app_id, game.name, game.release_date, game.owners, game.age, game.price, game.dlcs);
    printf("%s ", table_toString(game.languages));
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
    printf("%s\n", table_toString(game.genres));
} 
Game readGame (char* raw) {
    Game newgame = startGame();
    nextTextTable(newgame.genres, raw);
    strcpy(newgame.developers, nextText(raw));
    newgame.avg_pt = strToInt(nextText(raw));
    int neg = strToInt(nextText(raw));
    int pos = strToInt(nextText(raw));
    newgame.upvotes = (pos/(float)( pos + neg ))*100;
    newgame.linux_ = strToBool(nextText(raw));
    newgame.windows = strToBool(nextText(raw));
    newgame.mac = strToBool(nextText(raw));
    strcpy(newgame.website, nextText(raw));
    nextTextTable(newgame.languages, raw);
    newgame.dlcs = strToInt(nextText(raw));
    newgame.price = strToFloat(nextText(raw));
    newgame.age = strToInt(nextText(raw));
    strcpy(newgame.owners, nextText(raw));
    strcpy(newgame.release_date, toDate(nextText(raw)));
    strcpy(newgame.name, nextText(raw));
    newgame.app_id = strToInt(nextText(raw));
    return newgame;
}


void mostrarPorId(int id, Game* lista) {
    int col = 0;
    while(lista[col].app_id != id && lista[col].app_id != 0) {
        col++;
    } 
    if (lista[col].app_id != 0) {
        imprimir(lista[col]);
    } 
} 

typedef struct s_list {
    Game* gameArray;
    int n;
    int length;
} gameList;

typedef gameList* ref_gameList;

gameList constructList(int tamanho) {
    gameList lista;
    lista.gameArray = (Game*)malloc(tamanho*sizeof(Game));
    lista.n = 0;
    lista.length = tamanho;
    return lista;
} 

void cutString (char** str, int begin){
    char* aux = NULL;
    int ctrl = 0;
    strcpy(aux, *str);
    for(int i = begin; i < strlen(aux); i++) {
        *str[i] = aux[i];
        ctrl++;
    } 
    str[++ctrl] = '\0';
} 

void inserirFim( ref_gameList lista, Game jogo ) {
    if(lista->n < lista->length) {
        lista->gameArray[lista->n] = jogo;
        lista->n++;
    } else {
        printf("\n[inserirFim] Nao foi possivel inserir, lista cheia.\n");
    } 
} 


void mostrar (gameList lista) {
    for (int i = 0; i < lista.n; i++) {
        imprimir(lista.gameArray[i]);
    } 
} 

Game pesquisar(ref_gameList lista, int id) {
    Game pesquisado = startGame();
    bool found = false;
    for(int i = 0; i < lista->n; i++) {
        if (lista->gameArray[i].app_id == id) {
            pesquisado = cloneGame(lista->gameArray[i]);
            found = true;
            i = lista->n;
        } 
    } 
    if(!found) {
        printf("\n[pesquisar] Nao foi possivel encontrar esse jogo.\n");
    } 
    return pesquisado;
} 



char* subString (char* str, int begin, int end){
    char* result = NULL;
    int ctrl = 0;
    if(begin > 0 && end <= strlen(str)) {
        for(int i = begin; i < end; i++) {
            result[i] = str[i];
        } 
    } else {
        printf("[subString] posicoes invalidas.");
    } 
    return result;
} 

long long current_timestamp() {
    struct timeval te; 
    gettimeofday(&te, NULL); 
    long long milliseconds = te.tv_sec*1000LL + te.tv_usec/1000;
    return milliseconds;
}

int indexOfLast(char* str, char c) {
    int index = -1;
    for(int i = 0; i < strlen(str);i++) {
        if ( str[i] == c) {
            index = i;
        } 
    } 
    return index;
} 

void swap(ref_gameList lista,int pos1, int pos2) {
    Game aux = lista->gameArray[pos1];
    lista->gameArray[pos1] = lista->gameArray[pos2];
    lista->gameArray[pos2] = aux;
} 

void selecaoRec (ref_gameList lista, int i) {
    if ( i < (lista -> n - 1)) {
        int menor = i;
        for (int j = (i + 1); j < lista->n; j++) {
            comparacoes++;
            if (strcmp(lista->gameArray[menor].name, lista->gameArray[j].name) > 0){
                menor = j;
            } 
        } 
        movimentacoes+=3;
        swap(lista, menor, i);
        selecaoRec(lista, i + 1);
    } 
} 



int main(int argc, char *argv[]) {
    FILE* arq = fopen("/tmp/games.csv", "r"); 
    char* raw = (char*)malloc(MAX_SIZE * sizeof(char));
    Game jogo;
    gameList listaCheia = constructList(5000);
    gameList lista = constructList(100);
    int id = -1, pos = -1;

    do {
        fflush(stdin);
        readFile(arq, raw);
        jogo = readGame(raw);
        inserirFim(&listaCheia, jogo);
    } while (!feof(arq));
    fclose(arq);


    char* entrada = (char*)malloc(MAX_SIZE * sizeof(char));
    scanf("%s", entrada);
    while(!isFim(entrada)){
        inserirFim(&lista, pesquisar(&listaCheia, strToInt(entrada)));
        scanf("%s", entrada);
    } 


    long inicio = current_timestamp();
    selecaoRec(&lista, 0);
    long fim = current_timestamp() - inicio;
    mostrar(lista);

    FILE * log = fopen("matrícula_selecaoRecursiva.txt","w");
    fprintf(log, "775119\t%d\t%d\t%ldms", comparacoes, movimentacoes, fim);
    fclose(log);
    return 0;
} 
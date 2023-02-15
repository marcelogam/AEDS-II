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

double mypow (int x, int y) {
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

int readFile(FILE* arq, char* war ) {
    int eof = 0;
    war[0] = '\0';
    char aux;
    int n = 0;
    if(arq != NULL) {
        for(int i = 0; aux != '\n';i++) {
            aux = getc(arq);
            war[n] = aux;
            n++;
            if(aux==EOF) {
                eof = EOF;
                war[n] = '\0';
                break;
            }
        } 
        war[n-2] = '\0';
    } else {
            printf("\n[readFile]: NAO FOI POSSIVEL LER O ARQUIVO!\n");
    }
    return eof;
} 


char* nextText (char* war) {
    char* result = (char*)malloc(MAX_SIZE*sizeof(char));
    result[0] = '\0';
    int i = strlen(war) - 1;
    int n = 0;
    if (war[i] != '"') {
        if(war[i] != ',') {
            while( war[i] != ',' && i < strlen(war)) {
                result[n] = war[i];
                n++;
                i--;
            } 
        }
        result[n] = '\0';
        war[i] = '\0';
    } else {
        i = i - 1;
        while (war[i] != '"' && i < strlen(war)) {
            result[n] = war[i];
            n++;
            i--;
        } 
        result[n] = '\0';
        war[i-1] = '\0';
    }
    espelho(result);
    return result;
} // end nextText ()

void nextTextTable (char** table, char* war) {
    int i = strlen(war) - 1;
    int j = 0;
    int n = 0;
    if( war[i] == '"' && war[i-1] == ']' ) {
        i = i - 3;
        while(war[i-1] != '[' ||  war[i-1] == '[' && (war[i] == 'b' || war[i] == '/')) {
            if(war[i] == '\'' && war[i-1] != '['){
                table[j][n] = '\0';
                espelho(table[j]);
                n = 0;
                j++;
                i-=4;
            } else {
                table[j][n] = war[i];
                n++;
                i--;
            } 
        } 
        table[j][n] = '\0';
        table[j+1][0] = '\0';
        espelho(table[j]);
        war[i-3] = '\0';
    } else if( war[i] == '"') {
        war[i] = '\0';
        i = i - 1;
        while(war[i] != '"') {
            if(war[i] == ','){
                table[j][n] = '\0';
                espelho(table[j]);
                n = 0;
                j++;
            } else {
                table[j][n] = war[i];
                n++;
            } 
            i--;
        } 
        table[j][n] = '\0';
        table[j+1][0] = '\0';
        espelho(table[j]);
        war[i-1] = '\0';
    } else if (war[i] == ']') {
        i = i - 2;
        if(war[i] != ',') {
        while(war[i] != '\''){
                table[0][n] = war[i];
                n++;
                i--;
            } 
            table[0][n] = '\0';
            espelho(table[0]);
        } else {
            table[0][0] = '\0';
        }
        table[1][0] = '\0';
        war[i-2] = '\0';
    } else {
        table[1][0] = '\0';
        strcpy(table[0], nextText(war));
    }
} 

int stringInt(char* str) {
    int integer = 0;
    int i = 0;
    int n = strlen(str)-1;
    while( i < strlen(str) ) {
        integer = integer + ((int) (str[i]) - 48) * (mypow(10,n));
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

float strToFloat(char* str) {
    float f;
    sscanf(str, "%f", &f);
    return f;
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

char* int_toString(int integer) {
    char* str = (char*)malloc(MAX_SIZE*sizeof(char));
    int aux = integer;
    int aux2 = integer;
    int i = 1, j = 0;
    int index = 0;
    while(aux2 > 0) {
        aux = aux2 - (int)(aux2/mypow(10, i))*mypow(10, i);
        aux2/=10;
        str[index++] = (char)(aux+48);
    } 
    str[index] = '\0';
    espelho(str);
    return str;
} 

bool strToBool(char* str) {
    bool boolean = true;
    if(strlen(str) > 4) {
        boolean = false;
    }
    return boolean;
} 

void printar (Game game) {
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

Game lerGame (char* war) {
    Game newgame = startGame();
    nextTextTable(newgame.genres, war);
    strcpy(newgame.developers, nextText(war));
    newgame.avg_pt = stringInt(nextText(war));
    int neg = stringInt(nextText(war));
    int pos = stringInt(nextText(war));
    newgame.upvotes = (pos/(float)( pos + neg ))*100;
    newgame.linux_ = strToBool(nextText(war));
    newgame.windows = strToBool(nextText(war));
    newgame.mac = strToBool(nextText(war));
    strcpy(newgame.website, nextText(war));
    nextTextTable(newgame.languages, war);
    newgame.dlcs = stringInt(nextText(war));
    newgame.price = strToFloat(nextText(war));
    newgame.age = stringInt(nextText(war));
    strcpy(newgame.owners, nextText(war));
    strcpy(newgame.release_date, toDate(nextText(war)));
    strcpy(newgame.name, nextText(war));
    newgame.app_id = stringInt(nextText(war));
    return newgame;
} 

bool isFim(char* str) {
    return(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
} 

void mostrarPorId(int id, Game* lista) {
    int col = 0;
    while(lista[col].app_id != id && lista[col].app_id != 0) {
        col++;
    } 
    if (lista[col].app_id != 0) {
        printar(lista[col]);
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


void inserir ( ref_gameList lista, Game jogo, int pos ) {
    if(lista->n < lista->length) {
        if(0 <= pos && pos <= lista->n) {
            for(int i = lista->n; pos < i; i--) {
                lista->gameArray[i] = lista->gameArray[i-1];
            } 
            lista->gameArray[pos] = jogo;
            lista->n++;
        } else {
            printf("\n[inserir] Nao foi possivel inserir, posicao invalida.\n");
        }
    } else {
        printf("\n[inserir] Nao foi possivel inserir, lista cheia.\n");
    }
} 


void inserirFim( ref_gameList lista, Game jogo ) {
    if(lista->n < lista->length) {
        lista->gameArray[lista->n] = jogo;
        lista->n++;
    } 
} 

void inserirInicio (ref_gameList lista, Game jogo) {
    if(lista->n < lista->length) {
        for(int i = lista->n; i > 0; i--) {
            lista->gameArray[i] = lista->gameArray[i-1];
        } 
        lista->gameArray[0] = jogo;
        lista->n++;
    } 
} 

Game removerInicio ( ref_gameList lista ) {
    Game removido = startGame();
    if(lista->n > 0) {
        removido = cloneGame(lista->gameArray[0]);
        for(int i = 0; i < lista->n; i++) {
                lista->gameArray[i] = lista->gameArray[i+1];
        } 
        lista->n--;
    } 
    return removido;
} 

Game removerFim ( ref_gameList lista ) {
    Game removido = startGame();
    if(lista->n > 0) {
        removido = cloneGame(lista->gameArray[lista->n-1]);
        lista->n--;
    } 
    return removido;
} 

void mostrar (gameList lista) {
    fflush(stdin);
    for (int i = 0; i < lista.n; i++) {
        printf("[%d] ",i);
        printar(lista.gameArray[i]);
    } 
} 

Game remover ( ref_gameList lista, int pos ) {
    Game removido;
    if(lista->n > 0) {
        if(0 <= pos && pos <= lista->n) {
            removido = cloneGame(lista->gameArray[pos]);
            for(int i = pos; i < lista->n - 1; i++) {
                lista->gameArray[i] = lista->gameArray[i+1];
            } 
            lista->n--;
        } 
    } 
    return removido;
} 

char* subString (char* str, int begin, int end){
    char* result = NULL;
    int ctrl = 0;
    if(begin > 0 && end <= strlen(str)) {
        for(int i = begin; i < end; i++) {
            result[i] = str[i];
        } 
    }
    return result;
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

int indexOfLast(char* str, char c) {
    int index = -1;
    for(int i = 0; i < strlen(str);i++) {
        if ( str[i] == c) {
            index = i;
        } 
    } 
    return index;
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

int main(int argc, char *argv[]) {
    FILE* arq = fopen("/tmp/games.csv", "r");
    char* war = (char*)malloc(MAX_SIZE * sizeof(char));
    Game jogo;
    gameList listaCheia = constructList(5000);
    gameList lista = constructList(100);
    int id = -1, pos = -1;
    do {
        fflush(stdin);
        readFile(arq, war);
        jogo = lerGame(war);
        inserirFim(&listaCheia, jogo);
    } while (!feof(arq));
    fclose(arq);
    char* entrada = (char*)malloc(MAX_SIZE * sizeof(char));
    scanf("%s", entrada);
    while(!isFim(entrada)){
        inserirFim(&lista, pesquisar(&listaCheia, stringInt(entrada)));
        scanf("%s", entrada);
    } 
    scanf("%s", entrada);
    int tamn = stringInt(entrada);
    for(int i = 0; i < tamn; i++) {
        fflush(stdin);
        scanf("%s", entrada);
        if (entrada[0] == 'I') { 
            switch (entrada[1]) {
            case 'I':
                scanf("%s", entrada);
                id = stringInt(entrada);
                inserirInicio(&lista, pesquisar(&listaCheia, id));
                break;
            case 'F':
                scanf("%s", entrada);
                id = stringInt(entrada);
                inserirFim(&lista, pesquisar(&listaCheia, id));
                break;
            case '*':
                scanf("%s", entrada);
                pos = stringInt(entrada);
                scanf("%s", entrada);
                id =  stringInt(entrada);
                inserir(&lista, pesquisar(&listaCheia, id), pos);
                break;
            default:
                printf("[main, insercao, switch] entrada invalida.");
                break;
            } 
        } else if (entrada[0] == 'R') { 
            switch (entrada[1]) {
                case 'I':
                    printf("(R) %s\n", removerInicio(&lista).name);
                    break;
                case 'F':
                    printf("(R) %s\n", removerFim(&lista).name);
                    break;
                case '*':
                    scanf("%s", entrada);
                    pos = stringInt(entrada);
                    printf("(R) %s\n", remover(&lista, pos).name);
                    break;
                default:
                    printf("[main, remocao, switch] entrada invalida.");
                    break;
            } 
        } 
    } 
    
    mostrar(lista);
    return 0;
} 
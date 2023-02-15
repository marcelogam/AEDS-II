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

void init_table(char*** t) {
    char** p = (char**) malloc (MAX_COL * sizeof(char*));
    for(int i = 0; i < MAX_COL; i++){
        p[i] = (char*) malloc (MAX_SIZE * sizeof(char));
        p[0][i] = '\0';
    } 
    *t = p;
} 

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

char** clone_table(char** old_table) {
    char** new_table; init_table(&new_table);
    for(int i = 0; i < MAX_COL; i++) {
        strcpy(new_table[i], old_table[i]);
    } 
    return new_table;
} 

Game new_Game() {
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

Game cloneGame (Game game) {
    return constructGame(game.app_id, game.name, game.release_date, game.owners, game.age, game.price, game.dlcs, game.languages, game.website, game.windows, game.mac, game.linux_, game.upvotes, game.avg_pt, game.developers, game.genres);
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

int lerArquivo (FILE* file, char* war ) {
    int eof = 0;
    war[0] = '\0';
    char aux;
    int n = 0;
    if(file != NULL) {
        for(int i = 0; aux != '\n';i++) {
            aux = getc(file);
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
            printf("\n[lerArquivo ]: NAO FOI posicaoSIVEL LER O fileUIVO!\n");
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
} 

char* table_toString(char** lang) {
    int col = 0, n = 0;
    int i = 0;
    if(lang[0][0] == '\0') {
        return "[ ]";
    } 
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

int stringParaInt (char* str) {
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

float stringParaFloat(char* str) {
    float f;
    sscanf(str, "%f", &f);
    return f;
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

bool stringParaBool (char* str) {
    bool boolean = true;
    if(strlen(str) > 4) {
        boolean = false;
    } 
    return boolean;
} 



char* paraData (char* str) {
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
        aux = aux2 - (int)(aux2/mypow(10, i))*mypow(10, i);
        aux2/=10;
        str[index++] = (char)(aux+48);
    } 
    str[index] = '\0';
    espelho(str);
    return str;
} 

Game lerJogo (char* war) {
    Game newgame = new_Game();
    nextTextTable(newgame.genres, war);
    strcpy(newgame.developers, nextText(war));
    newgame.avg_pt = stringParaInt (nextText(war));
    int neg = stringParaInt (nextText(war));
    int posicao = stringParaInt (nextText(war));
    newgame.upvotes = (posicao/(float)( posicao + neg ))*100;
    newgame.linux_ = stringParaBool (nextText(war));
    newgame.windows = stringParaBool (nextText(war));
    newgame.mac = stringParaBool (nextText(war));
    strcpy(newgame.website, nextText(war));
    nextTextTable(newgame.languages, war);
    newgame.dlcs = stringParaInt (nextText(war));
    newgame.price = stringParaFloat(nextText(war));
    newgame.age = stringParaInt (nextText(war));
    strcpy(newgame.owners, nextText(war));
    strcpy(newgame.release_date, paraData(nextText(war)));
    strcpy(newgame.name, nextText(war));
    newgame.app_id = stringParaInt (nextText(war));
    return newgame;
} 

void printar (Game* game) {
    printf("%d ",   game->app_id      );
    printf("%s ",   game->name        );
    printf("%s ",   game->release_date);
    printf("%s ",   game->owners      );
    printf("%d ",   game->age         );
    printf("%.1f ", game->price       );
    printf("%d ",   game->dlcs        );
    printf("%s ", table_toString(game->languages));
    if(game->website[0] != '\0') {
        printf("%s ", game->website);
    } else {
        printf("null ");
    } 
    printf("%s ", game->mac? "true" : "false");
    printf("%s ", game->windows? "true" : "false");
    printf("%s ", game->linux_? "true" : "false");
    printf("%.0f%c ",game->upvotes, '%');

    char* avg = (char*)malloc(MAX_SIZE*sizeof(char));
    int horas = 0;
    int min = 0;
    if (game->avg_pt != 0) {
        horas = (int) (game->avg_pt/60);
        min = game->avg_pt*1 - horas*60;
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
    printf("%s ", game->developers);
    printf("%s\n", table_toString(game->genres));
} 



void mostrarPorId(int id, Game* lista) {
    int col = 0;
    while(lista[col].app_id != id && lista[col].app_id != 0) {
        col++;
    } 
    if (lista[col].app_id != 0) {
        printar(&lista[col]);
    } 
} 


bool isFim(char* str) {
    return(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}


typedef struct s_Cell {
    Game game;
    struct s_Cell * prox;
} Cell;

Cell* new_Cell (Game game) {
    Cell* cell = (Cell*) malloc( sizeof(Cell) );
    cell->game = game;
    cell->prox = NULL;
    return cell;
} 

typedef struct s_list {
    Cell* primeiro;
} gameList;

typedef gameList* ref_gameList;

gameList new_List(ref_gameList this) {
    Cell* newCell = new_Cell(new_Game());
    this->primeiro = newCell;
}

void mostrarRec (ref_gameList this, Cell* i, int cont) {
    if (i != NULL) {
        fflush(stdin);
        mostrarRec(this, i->prox, cont - 1);
        printf("[%d] ", cont);
        printar(&i->game);
     } 
}

int tamanho(ref_gameList this) {
    Cell* i = this->primeiro;
    int cont = 0;
    while (i->prox != NULL) {
        cont++;
        i = i->prox;
    } 
    return cont;
} 

bool isVazia(ref_gameList this) {
    return this->primeiro->prox == NULL;
} 
void inserir ( ref_gameList this, Game game ) {
     
        Cell* cell = new_Cell(game);
    
        cell->prox = this->primeiro->prox;
        this->primeiro->prox = cell;
        cell = NULL;
}

Game pesquisar(ref_gameList this, int id) {
    Game pesquisado = new_Game();
    bool found = false;
    for (Cell* i = this->primeiro->prox; !found && i != NULL; i = i->prox) {
        if(i->game.app_id == id) {
            pesquisado = i->game;
            found = true;
        } 
    } 
    if(!found) {
        printf("\n[pesquisar] Nao foi posicaosivel encontrar esse game.\n");
    } 
    return pesquisado;
} 

Game remover ( ref_gameList this) {
    Game removido;
    Cell* tmp = NULL;
        if(!isVazia(this)) {
            removido = this->primeiro->prox->game;
            tmp = this->primeiro->prox;
            this->primeiro->prox = this->primeiro->prox->prox;
            tmp->prox = NULL;
            free(tmp);
            tmp = NULL;
        } else {
            printf("[remover] Não foi posicaosivel remover, lista vazia.");
        } 
    return removido;
}



void mostrar (ref_gameList this) {
    mostrarRec(this, this->primeiro->prox, tamanho(this)-1);
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

char* subString (char* str, int begin, int end){
    char* result = NULL;
    int ctrl = 0;
    if(begin > 0 && end <= strlen(str)) {
        for(int i = begin; i < end; i++) {
            result[i] = str[i];
        } 
    } else {
        printf("[subString] posicaoicoes invalidas.");
    } 
    return result;
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
    FILE* file = fopen("/tmp/games.csv", "r");
    char* war = (char*)malloc(MAX_SIZE * sizeof(char));
    Game game;
    gameList listaCheia;
    new_List(&listaCheia);
    gameList lista;
    new_List(&lista);
    int id = -1, posicao = -1;

    do {
        fflush(stdin);
        lerArquivo (file, war);
        game = lerJogo(war);
        inserir(&listaCheia, game);
    } while (!feof(file));
    fclose(file);


    char* palavra = (char*)malloc(MAX_SIZE * sizeof(char));
    scanf("%s", palavra);
    while(!isFim(palavra)){
        inserir(&lista, pesquisar(&listaCheia, stringParaInt (palavra)));
        scanf("%s", palavra);
    } 

    scanf("%s", palavra);
    int linha = stringParaInt (palavra);
    for(int i = 0; i < linha; i++) {
        scanf("%s", palavra);
        if (palavra[0] == 'I') {
                scanf("%s", palavra);
                id = stringParaInt (palavra);
                inserir(&lista, pesquisar(&listaCheia, id));
        } else if (palavra[0] == 'R') {
                printf("(R) %s\n", remover(&lista).name);
        } 
    } 
    mostrar(&lista);
    return 0;
}
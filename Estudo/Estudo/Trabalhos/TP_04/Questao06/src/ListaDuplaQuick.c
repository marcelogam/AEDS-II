#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <sys/time.h>
#include <time.h>

#define MAX_SIZE 1000
#define MAX_COL 40

int comparacoes, movimentacoes;

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

typedef struct S_Date {
    int dia;
    int mes;
    int ano;
} Date;

char* mesToString (int mes) {
        char* result = (char*) calloc(3, sizeof(char));
         if (mes == 1 ) { result = "Jan"; }
    else if (mes == 2 ) { result = "Feb"; }
    else if (mes == 3 ) { result = "Mar"; }
    else if (mes == 4 ) { result = "Apr"; }
    else if (mes == 5 ) { result = "May"; }
    else if (mes == 6 ) { result = "Jun"; }
    else if (mes == 7 ) { result = "Jul"; }
    else if (mes == 8 ) { result = "Aug"; }
    else if (mes == 9 ) { result = "Sep"; }
    else if (mes == 10) { result = "Oct"; }
    else if (mes == 11) { result = "Nov"; }
    else if (mes == 12) { result = "Dec"; }
    return result;
}

int parseMonth (char* mes) {
    int result = -1;
         if (strcmp(mes, "Jan") == 0) { result = 1;  }
    else if (strcmp(mes, "Feb") == 0) { result = 2;  }
    else if (strcmp(mes, "Mar") == 0) { result = 3;  }
    else if (strcmp(mes, "Apr") == 0) { result = 4;  }
    else if (strcmp(mes, "May") == 0) { result = 5;  }
    else if (strcmp(mes, "Jun") == 0) { result = 6;  }
    else if (strcmp(mes, "Jul") == 0) { result = 7;  }
    else if (strcmp(mes, "Aug") == 0) { result = 8;  }
    else if (strcmp(mes, "Sep") == 0) { result = 9;  }
    else if (strcmp(mes, "Oct") == 0) { result = 10; }
    else if (strcmp(mes, "Nov") == 0) { result = 11; }
    else if (strcmp(mes, "Dec") == 0) { result = 12; }
    return result;
}

char* dataParaString (Date this) {
    char* resp = (char*) calloc(9, sizeof(char));
    strcat(resp, mesToString(this.mes));
    resp[3] = '/';
    resp[4] = '\0';
    strcat(resp, int_toString(this.ano));
    return resp;
} 

void init_Date (Date *this) {
    this->ano = -1;
    this->mes = -1;
    this->dia = -1;
}
void novaData (Date *this, int ano, int mes, int dia) {
    this->ano = ano;
    this->mes = mes;
    this->dia = dia;
} 

typedef struct S_Game{
    int     app_id;
    char    name [MAX_SIZE];
    Date    release_date;
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
    init_Date(&game.release_date);
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
Game constructGame(int app_id, char name[], Date release_date, char owners[], int age, float price, int dlcs, char** languages, char website[], bool windows, bool mac, bool linux_, float upvotes, int avg_pt, char developers[], char** genres) {
    Game game;
    game.app_id = app_id;
    strcpy(game.name, name);
    novaData(&game.release_date, release_date.ano, release_date.mes, release_date.dia);
    strcpy(game.owners, owners);
    game.age = age;
    game.price = price;
    game.dlcs = dlcs;
    game.languages = clone_table(languages);
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

int lerArquivo(FILE* file, char* war ) {
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
            printf("\n[lerArquivo]: NAO FOI POSSIVEL LER O fileUIVO!\n");
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

int stringParaInt(char* str) {
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

float stringParaFloat(char* str) {
    float f;
    sscanf(str, "%f", &f);
    return f;
}

bool stringParaBool(char* str) {
    bool boolean = true;
    if(strlen(str) > 4) {
        boolean = false;
    }
    return boolean;
}
Date paraData (char* str) {
    char* c_mes = (char*)calloc(5, sizeof(char));
    char* c_dia = (char*)calloc(5, sizeof(char));
    char* c_ano = (char*)calloc(10, sizeof(char));
    Date date;
    init_Date(&date);
    int i = 0;
    int j = 3;
    bool temVirgula = false;

    while (i<3) {
        c_mes[i] = str[i];
        date.mes = parseMonth(c_mes);
        i++;
    } 

    if(str[5] == ','){

        c_dia[0] = str[4];
        c_dia[1] = '\0';
        date.dia = stringParaInt(c_dia);

        c_ano[0] = str[7];
        c_ano[1] = str[8];
        c_ano[2] = str[9];
        c_ano[3] = str[10];
    } else if(str[6] == ',') {

        c_dia[0] = str[4];
        c_dia[1] = str[4];
        c_dia[2] = '\0';
        date.dia = stringParaInt(c_dia);

        c_ano[0] = str[8];
        c_ano[1] = str[9];
        c_ano[2] = str[10];
        c_ano[3] = str[11];

    } else {

        c_ano[0] = str[4];
        c_ano[1] = str[5];
        c_ano[2] = str[6];
        c_ano[3] = str[7];

    } 
    c_ano[4] = '\0';
    date.ano = stringParaInt(c_ano);
    return date;
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

void printar (Game* game) {
    printf("%d ",   game->app_id      );
    printf("%s ",   game->name        );
    printf("%s ",   dataParaString(game->release_date));
    printf("%s ",   game->owners      );
    printf("%d ",   game->age         );
    printf("%.2f ", game->price       );
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

Game readGame (char* war) {
    Game newgame = new_Game();
    nextTextTable(newgame.genres, war);
    strcpy(newgame.developers, nextText(war));
    newgame.avg_pt = stringParaInt(nextText(war));
    int neg = stringParaInt(nextText(war));
    int pos = stringParaInt(nextText(war));
    newgame.upvotes = (pos/(float)( pos + neg ))*100;
    newgame.linux_ = stringParaBool(nextText(war));
    newgame.windows = stringParaBool(nextText(war));
    newgame.mac = stringParaBool(nextText(war));
    strcpy(newgame.website, nextText(war));
    nextTextTable(newgame.languages, war);
    newgame.dlcs = stringParaInt(nextText(war));
    newgame.price = stringParaFloat(nextText(war));
    newgame.age = stringParaInt(nextText(war));
    strcpy(newgame.owners, nextText(war));
    newgame.release_date = paraData(nextText(war));
    strcpy(newgame.name, nextText(war));
    newgame.app_id = stringParaInt(nextText(war));
    return newgame;
}

bool isFim(char* str) {
    return(strlen(str) == 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M');
}
void mostrarPorId(int id, Game* list) {
    int col = 0;
    while(list[col].app_id != id && list[col].app_id != 0) {
        col++;
    } 
    if (list[col].app_id != 0) {
        printar(&list[col]);
    }
} 


typedef struct s_Cell {
    Game game;
    struct s_Cell * prox;
    struct s_Cell * ant ;
} Cell;

Cell* new_Cell (Game game) {
    Cell* cell = (Cell*) malloc( sizeof(Cell) );
    cell->game = game;
    cell->prox = NULL;
    cell->ant  = NULL;
    return cell;
} 
typedef struct s_list {
    Cell* primeiro;
    Cell* ultimo;
} gameList;

typedef gameList* ref_gameList;

void new_List(ref_gameList this) {
    Cell* newCell = new_Cell(new_Game());
    this->primeiro = newCell;
    this->ultimo = this->primeiro;
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
    
        cell->ant = this->ultimo;
        this->ultimo->prox = cell;
        this->ultimo = cell;
        cell = NULL;
}

Game removimentacoeser ( ref_gameList this) {
    Game removimentacoesido;
    Cell* tmp = NULL;
     
        if(!isVazia(this)) {
            removimentacoesido = this->ultimo->game;
            tmp = this->ultimo;
            tmp->ant->prox = NULL;
            this->ultimo = this->ultimo->ant;
            tmp->ant = NULL;
            free(tmp);
            tmp = NULL;
        } else {
            printf("[removimentacoeser] Não foi possivel removimentacoeser, list vazia.");
        }
    return removimentacoesido;
}

void mostrarRec (ref_gameList this, Cell* i, int cont) {
    if (i != NULL) {
        fflush(stdin);
        mostrarRec(this, i->prox, cont - 1);

     }
} 

void mostrar (ref_gameList this) {
    Cell* i = this->primeiro->prox;
    int cont = 0;
    while (i != NULL) {
        printar(&i->game);
        i = i->prox;
    } 
}

void mostrarData (ref_gameList this) {
    Cell* i = this->primeiro->prox;
    int cont = 0;
    while (i != NULL) {
        printf("[%d] %s\n", cont++, dataParaString(i->game.release_date));
        i = i->prox;
    } 
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
        printf("\n[pesquisar] Nao foi possivel encontrar esse game.\n");
    }
    return pesquisado;
} 

void cutString (char** str, int begin){
    char* aux;
    int ctrl = 0;
    strcpy(aux, *str);
    for(int i = begin; i < strlen(aux); i++) {
        *str[i] = aux[i];
        ctrl++;
    } 
    str[++ctrl] = '\0';
}

long long current_timestamp() {
    struct timeval te; 
    gettimeofday(&te, NULL); 
    long long milliseconds = te.tv_sec*1000LL + te.tv_usec/1000; 
    return milliseconds;
} 

char* subString (char* str, int begin, int fim){
    char* result = (char*) calloc(80, sizeof(char));
    int ctrl = 0;
    if(begin >= 0 && fim <= strlen(str)) {
        for(int i = begin; i < fim; i++) {
            result[ctrl] = str[i];
            ctrl++;
        } 
        result[ctrl+1] = '\0';
    } else {
        printf("[subString] posicoes invalidas.");
    }
    return result;
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



Cell* meio (Cell *esq, Cell *dir) {
    Cell* i = esq, *j = dir;
    while (i != j && i->prox != j) {
        j = j->ant;
        i = i->prox;
    }  
    return i;
}

void troca(Cell *c1, Cell *c2) {
    Game aux = c1->game;
    c1->game = c2->game;
    c2->game = aux;
    movimentacoes += 3;
}

int comparacoesararDatas (Date data1, Date data2) {
    int resp = 0;
    if (data1.ano > data2.ano) {
        resp = 1;
    } else if (data1.ano < data2.ano){
        resp = -1;
    } else {
        if ( data1.mes > data2.mes){
            resp = 1;
        } else if ( data1.mes < data2.mes) {
            resp = -1;
        } else {
            if ( data1.dia == data2.dia) {
                resp = 0;
            } else if ( data1.dia > data2.dia){
                resp = 1;
            } else if ( data1.dia < data2.dia) {
                resp = -1;
            }
        } 
    } 
    return resp;
} 

void quicksortRec(Cell* esq, Cell* dir) {
    Cell *x = esq, *y = dir;
    Game h = meio(esq, dir)->game;
    while( x != y && x != y->prox ) {
        comparacoes++;
        while(comparacoesararDatas(h.release_date, x->game.release_date) > 0) {
            comparacoes++;
            x = x->prox;
        } 

        comparacoes++;
        while(comparacoesararDatas(h.release_date, y->game.release_date) < 0) {
            comparacoes++;
            y = y->ant;
        } 

        if ( x != y && x != y->prox ) {
            troca( x, y );
            x = x->prox;
            y = y->ant;
        }
    } 

     if( esq != y ) {
         quicksortRec(esq, y);
     }

     if( dir != x && dir->ant != x ) {
         quicksortRec(x, dir);
     }
} 

void quicksort(ref_gameList this) {
    quicksortRec(this->primeiro->prox, this->ultimo);
} 

int main(int argc, char *argv[]) {
    FILE* file = fopen("/tmp/games.csv", "r"); 
    char* war = (char*)malloc(MAX_SIZE * sizeof(char));
    Game game;
    gameList listCheia;
    new_List(&listCheia);
    gameList list;
    new_List(&list);
    int id = -1, pos = -1;

    
    do {
        fflush(stdin);
        lerArquivo(file, war);
        game = readGame(war);
        inserir(&listCheia, game);
    } while (!feof(file));
    fclose(file);


    char* palavra = (char*)malloc(MAX_SIZE * sizeof(char));
    scanf("%s", palavra);
    while(!isFim(palavra)){
        inserir(&list, pesquisar(&listCheia, stringParaInt(palavra)));
        scanf("%s", palavra);
    } 
    long inicio = current_timestamp();
    quicksort(&list);    
    long fim = current_timestamp() - inicio;
    mostrar(&list);

    FILE * log = fopen("matrícula_quicksort.txt","w");
    fprintf(log, "775119\t%d\t%d\t%ldms", comparacoes, movimentacoes, fim);
    fclose(log);
    return 0;
} 



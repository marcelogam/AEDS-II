import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class No {
    public char elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public No2 outro;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    No(char elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
        this.outro = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    No(char elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;
    }
}

class No2 {
    public String elemento; // Conteudo do no.
    public No2 esq; // No da esquerda.
    public No2 dir; // No da direita.

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    No2(String elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No2 da esquerda.
     * @param dir      No2 da direita.
     */
    No2(String elemento, No2 esq, No2 dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreArvore {
    private No raiz; // Raiz da arvore.
    public int numComparacoes;

    /**
     * Construtor da classe.
     */
    public ArvoreArvore() {
        raiz = null;
        inserir('D');
        inserir('R');
        inserir('Z');
        inserir('X');
        inserir('V');
        inserir('B');
        inserir('F');
        inserir('P');
        inserir('U');
        inserir('I');
        inserir('G');
        inserir('E');
        inserir('J');
        inserir('L');
        inserir('H');
        inserir('T');
        inserir('A');
        inserir('W');
        inserir('S');
        inserir('O');
        inserir('M');
        inserir('N');
        inserir('K');
        inserir('C');
        inserir('Y');
        inserir('Q');

    }
    // D, R, Z, X, V, B, F, P, U, I, G, E, J, L, H, T, A, W, S, O, M, N, K, C, Y, Q

    public void inserir(char letra) {
        raiz = inserir(letra, raiz);
    }

    private No inserir(char letra, No i) {
        if (i == null) {
            i = new No(letra);
        } else if (letra < i.elemento) {
            i.esq = inserir(letra, i.esq);
        } else if (letra > i.elemento) {
            i.dir = inserir(letra, i.dir);
        } else {
            System.out.println("ERRO");
        }
        return i;
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz);
    }

    public void inserir(String s, No i) throws Exception {
        if (i == null) {
            throw new Exception("ERRO " + s.charAt(0));

        } else if (s.charAt(0) < i.elemento) {
            // System.out.println(i.elemento);
            inserir(s, i.esq);

        } else if (s.charAt(0) > i.elemento) {
            // System.out.println(i.elemento);
            inserir(s, i.dir);

        } else if (s.charAt(0) == i.elemento) {
            i.outro = inserir(s, i.outro);
        }
    }

    private No2 inserir(String s, No2 i) throws Exception {
        if (i == null) {
            i = new No2(s);

        } else if (s.compareTo(i.elemento) < 0) {
            i.esq = inserir(s, i.esq);

        } else if (s.compareTo(i.elemento) > 0) {
            i.dir = inserir(s, i.dir);

        } else {
            throw new Exception("Erro ao inserir: elemento existente!");
        }

        return i;
    }

    public void mostrar() {
        mostrar(raiz);
    }

    public void mostrar(No i) {
        if (i != null) {
            mostrar(i.esq);
            // System.out.println("Letra: " + i.elemento);
            mostrar(i.outro);
            mostrar(i.dir);
        }
    }

    public void mostrar(No2 i) {
        if (i != null) {
            mostrar(i.esq);
            System.out.println(i.elemento);
            mostrar(i.dir);
        }
    }

    public boolean pesquisarMos(String s) {
        System.out.println(s);
        System.out.print("raiz ");
        return pesquisarMos(raiz, s);
    }

    private boolean pesquisarMos (No no, String chave) {
        boolean resp = false;
        numComparacoes++;
        if(no != null) {
            resp = pesquisarSegundaArvore(no.outro, chave);
            numComparacoes++;
            if(!resp) {
                System.out.print("ESQ ");
                resp = resp || pesquisarMos(no.esq, chave);
            } 
            numComparacoes++;
            if(!resp) {
                System.out.print("DIR ");
                resp = resp || pesquisarMos(no.dir, chave);
            } 
        } 
        return resp;
    } 

    public boolean hasStringTam10() {
        return hasStringTam10(raiz);
    }

    public boolean hasStringTam10(No i) {
        boolean resp = false;
        if (i != null) {
            resp = hasStringTam10(i.outro) ||  hasStringTam10(i.esq) || hasStringTam10(i.dir);
        }
        return resp;
    }

    public boolean hasStringTam10(No2 i) {
        boolean resp = false;
        if (i != null) {
            resp = i.elemento.length() == 10 || hasStringTam10(i.esq) || hasStringTam10(i.dir);
        }
        return resp;
    }

    public boolean hasStringTam10(char c) {
        return hasStringTam10(raiz, c);
    }

    public boolean hasStringTam10(No i, char c) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (c < i.elemento) {
            resp = hasStringTam10(i.esq, c);

        } else if (c > i.elemento) {
            resp = hasStringTam10(i.dir, c);

        } else {
            resp = hasStringTam10(i.outro);
        }
        return resp;
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String elemento) {
        System.out.println(elemento);
        System.out.print("raiz ");
        return pesquisar(raiz, elemento);
    }

    private boolean pesquisar(No no, String x) {
        boolean resp;
        if (no == null) {
            numComparacoes++;
            resp = false;

        } else if (x.charAt(0) < no.elemento) {
            System.out.print("esq ");
            numComparacoes++;
            resp = pesquisar(no.esq, x);

        } else if (x.charAt(0) > no.elemento) {
            System.out.print("dir ");
            numComparacoes++;
            resp = pesquisar(no.dir, x);

        } else {
            numComparacoes++;
            resp = pesquisarSegundaArvore(no.outro, x);
        }
        return resp;
    }

    private boolean pesquisarSegundaArvore(No2 no, String x) {
        boolean resp;
        if (no == null) {
            resp = false;

        } else if (x.compareTo(no.elemento) < 0) {
            System.out.print("esq ");
            numComparacoes++;
            resp = pesquisarSegundaArvore(no.esq, x);

        } else if (x.compareTo(no.elemento) > 0) {
            System.out.print("dir ");
            numComparacoes++;
            resp = pesquisarSegundaArvore(no.dir, x);

        } else {
            numComparacoes++;
            resp = true;
        }
        return resp;
    }

    public void remover(String s) throws Exception {
        remover(s, raiz);
    }

    public void remover(String s, No i) throws Exception {
        if (i == null) {
            throw new Exception("Erro ao inserir: caractere invalido!");

        } else if (s.charAt(0) < i.elemento) {
            remover(s, i.esq);

        } else if (s.charAt(0) > i.elemento) {
            remover(s, i.dir);

        } else {
            i.outro = removerSegundaArvore(i.outro, s);
        }
    }

    private No2 removerSegundaArvore(No2 i, String x) throws Exception {
        if (i == null) {
            throw new Exception("Erro ao remover!");

        } else if (x.compareTo(i.elemento) < 0) {
            i.esq = removerSegundaArvore(i.esq, x);

        } else if (x.compareTo(i.elemento) > 0) {
            i.dir = removerSegundaArvore(i.dir, x);

            // Sem no a direita.
        } else if (i.dir == null) {
            i = i.esq;

            // Sem no a esquerda.
        } else if (i.esq == null) {
            i = i.dir;

            // No a esquerda e no a direita.
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    private No2 maiorEsq(No2 i, No2 j) {

        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.

            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }
}

public class ArvArvore {

    private int app_id;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String languages[];
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String genres[];

    public int cont1;
    public int cont2;

    // metodos sets e gets

    /************** ID jogo **************/

    public int getApp_id() {
        return this.app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    /************** NOME jogo **************/

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /************** Data jogo **************/

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    /************** Proprietarios jogo **************/

    public String getOwners() {
        return this.owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    /************** Idade jogo **************/

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /************** Preco jogo **************/

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /************** DLC's jogo **************/

    public int getDlcs() {
        return dlcs;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    /************** Linguagens jogo **************/

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String languages[]) {
        this.languages = languages;
    }

    /************** Website jogo **************/

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    /************** Windos **************/

    public boolean getWindows() {
        return this.windows;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    /************** mac **************/

    public boolean getMac() {
        return this.mac;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    /************** Linux **************/

    public boolean getLinux() {
        return this.linux;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    /************** Upvotes jogo **************/

    public float getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    /************** Avg_pt jogo **************/

    public int getAvg_pt() {
        return this.avg_pt;
    }

    public void setAvg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }

    /************** Desenvolvedores jogo **************/

    public String getDevelopers() {
        return this.developers;

    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    /************** Windos **************/

    public String[] getGenres() {
        return this.genres;
    }

    public void setGenres(String genres[]) {
        this.genres = genres;
    }

    // Fim sets e gets

    // Construtor
    public ArvArvore() {
        this.app_id = 0;
        this.name = "";
        this.release_date = new Date();
        this.owners = "";
        this.age = 0;
        this.price = 0;
        this.dlcs = 0;
        this.languages = new String[100];
        this.website = "";
        this.windows = true;
        this.mac = true;
        this.linux = true;
        this.upvotes = 0;
        this.avg_pt = 0;
        this.developers = "";
        this.genres = new String[100];
    }

    public ArvArvore(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs,
            String languages[], String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt,
            String developers, String genres[]) {
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.genres = genres;
    }

    // Metodo escrever

    public void printGame() {
        int horas, minutos;
        horas = avg_pt / 60;
        minutos = avg_pt % 60;
        SimpleDateFormat newFomart = new SimpleDateFormat("MMM/yyyy", Locale.US);

        MyIO.print(
                app_id + " " + name + " " + newFomart.format(release_date) + " " + owners + " " + age + " " + price
                        + " " + dlcs
                        + " [");
        if (cont1 == 0) {
            MyIO.print(languages[0]);
        } else {
            for (int i = 0; i <= cont1; i++) {
                if (i == cont1) {
                    MyIO.print(languages[i]);

                } else
                    MyIO.print(languages[i] + ", ");
            }
        }
        MyIO.print(" " + website + " " + windows + " " + mac + " " + linux + " " + ((int) upvotes) + "% ");
        if (horas == 0) {
            MyIO.print("null ");
        } else {
            MyIO.print(+horas + "h " + minutos + "m ");
        }
        MyIO.print(developers + " [");
        if (cont2 == 0) {
            MyIO.print(genres[0]);
        } else {
            for (int j = 0; j <= cont2; j++) {
                if (j == cont2) {
                    MyIO.print(genres[j]);

                } else
                    MyIO.print(genres[j] + ", ");
            }
        }
        MyIO.println("]");
    }

    // Metodo read string
    public void read(String str, ArvArvore jogos[], int cont) throws Exception {
        int i = 0;
        String atributos[] = new String[17];
        int j = 0;
        while (j < 17) {
            atributos[j] = "";
            if (i < str.length()) {
                if (str.charAt(i) == '"') {
                    ++i;
                    while (str.charAt(i) != '"') {
                        atributos[j] += str.charAt(i);
                        i++;
                    }
                    j++;
                    i = i + 2;
                } else if (str.charAt(i) == ',') {
                    atributos[j] = null;
                    j++;
                    i++;
                } else if (str.charAt(i) != ',' && str.charAt(i) != '"') {
                    while (i < str.length() && str.charAt(i) != ',') {
                        atributos[j] += str.charAt(i);
                        i++;
                    }
                    j++;
                    i++;
                }
            } else {
                atributos[j] = null;
                j++;
            }
        }

        setApp_id(converterStringParaInt((atributos[0])));
        // MyIO.print(converterStringParaInt(atributos[0]));
        setName(atributos[1]);
        // MyIO.print(atributos[1]);
        setRelease_date(tranformarData(atributos[2]));
        // MyIO.print(atributos[2]);
        setOwners(atributos[3]);
        // MyIO.print(atributos[3]);
        setAge(converterStringParaInt(atributos[4]));
        // MyIO.print(converterStringParaInt(atributos[4]));
        setPrice(converterStringParafloat(atributos[5]));
        // MyIO.print(converterStringParafloat(atributos[5]));
        setDlcs(converterStringParaInt(atributos[6]));
        // MyIO.print(converterStringParaInt(atributos[6]));
        setLanguages(converterStringParaArray1(atributos[7], jogos, cont));
        // MyIO.print(atributos[7]);
        setWebsite(atributos[8]);
        // MyIO.print(atributos[8]);
        setWindows(converterStringParaBoolean(atributos[9]));
        // MyIO.print(converterStringParaBoolean(atributos[9]));
        setMac(converterStringParaBoolean(atributos[10]));
        // MyIO.print(converterStringParaBoolean(atributos[10]));
        setLinux(converterStringParaBoolean(atributos[11]));
        // MyIO.print(converterStringParaBoolean(atributos[11]));
        setUpvotes(findUpvotes(converterStringParafloat(atributos[12]), converterStringParafloat(atributos[13])));
        // MyIO.print("a"+converterStringParaInt(atributos[12]));
        // MyIO.print("b"+converterStringParaInt(atributos[13]));
        setAvg_pt(converterStringParaInt(atributos[14]));
        // MyIO.print(converterStringParaInt(atributos[14]));
        setDevelopers(atributos[15]);
        // MyIO.print(atributos[15]);
        setGenres(converterStringParaArray2(atributos[16], jogos, cont));
        // MyIO.println(atributos[16]);
    }

    // Metodo para transformar a data
    public static Date tranformarData(String str) throws ParseException {
        boolean dataDiferente = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                dataDiferente = false;
                i = str.length();
            }
        }
        Date data;
        if (dataDiferente) {
            SimpleDateFormat format = new SimpleDateFormat("MMM yyyy", Locale.US);
            data = format.parse(str);

        } else {
            SimpleDateFormat formato = new SimpleDateFormat("MMM dd,yyyy", Locale.US);
            data = formato.parse(str);
        }

        return data;
    }

    // Metodo para tranformar em um array

    public static String[] converterStringParaArray1(String str, ArvArvore jogos[], int cont) {
        String array[] = new String[50];
        int j = 0;
        if (str == null) {
            array[0] = "null";
            return array;
        }
        array[j] = "";
        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i) == '\'') {
                i++;
            }
            if (str.charAt(i) == ',') {
                j++;
                array[j] = "";
                i = i + 3;
            }

            array[j] += str.charAt(i);

        }
        jogos[cont].cont1 = j;
        return array;
    }

    // Metodo para tranformar a segunda string em array
    public static String[] converterStringParaArray2(String str, ArvArvore jogos[], int cont) {
        String array[] = new String[50];
        int j = 0;
        if (str == null) {
            array[0] = "null";
            return array;
        }
        array[j] = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                j++;
                array[j] = "";
                i++;
            }
            array[j] += str.charAt(i);
        }
        jogos[cont].cont2 = j;
        return array;
    }

    // Metodo para descobrir o Upvotes
    public static float findUpvotes(float valor1, float valor2) {
        float total;
        if ((valor1 + valor2) != 0) {
            total = ((valor1 / (valor1 + valor2)) * 100);
        } else {
            total = 0;
        }
        return (total + 1);
    }

    // Metodo tranformar string em boolean
    public static boolean converterStringParaBoolean(String str) {
        boolean valor = false;
        if (str.charAt(0) == 'T' && str.charAt(1) == 'r' && str.charAt(2) == 'u' && str.charAt(3) == 'e') {
            valor = true;
        }
        return valor;
    }

    // Metodo transformar string em float
    public static float converterStringParafloat(String str) {
        float valor = Float.parseFloat(str);
        return valor;
    }

    // Metodo tranformar string em int

    public static int converterStringParaInt(String str) {
        int valor = Integer.parseInt(str);
        return valor;
    }

    // Metodo isFim

    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static ArvArvore descobrirJogoID(int id, ArvArvore jogos[], int contJogos) {
        ArvArvore game = new ArvArvore();

        for (int l = 0; l < contJogos; l++) {
            if (id == jogos[l].getApp_id()) {
                game = jogos[l];
                l = contJogos;
            }
        }
        return game;
    }

    public static ArvArvore descobrirJogoString(String id, ArvArvore jogos[], int contJogos) {
        ArvArvore game = new ArvArvore();

        for (int l = 0; l < contJogos; l++) {
            if (id.compareTo(jogos[l].getName()) == 0) {
                game = jogos[l];
                l = contJogos;
            }

        }
        return game;
    }

    // Metodo para indicar os metodos
    public static void indicarMet(String str, ArvoreArvore arvore, ArvArvore jogos[], int contJogos)
            throws Exception {
        int tamanho = str.length();
        String id = "";
        ArvArvore jogo;
        if (str.charAt(0) == 'I') {
            for (int i = 2; i < tamanho; i++) {
                id += str.charAt(i);
            }
            jogo = descobrirJogoID(converterStringParaInt(id), jogos, contJogos);
            arvore.inserir(jogo.getName());
        } else if (str.charAt(0) == 'R') {
            for (int i = 2; i < tamanho; i++) {
                id += str.charAt(i);
            }

            arvore.remover(id);
        }
    }

    public static void main(String[] args) throws Exception {

        // Variaveis usadas durante o metodo
        int i = 0;
        int contJogos;
        BufferedReader br = new BufferedReader(new FileReader("games.csv"));
        BufferedWriter arq = new BufferedWriter(new FileWriter("775119 arvoreArvore.txt"));

        // Pegar todos os dados do arquivo csv
        ArvArvore jogos[] = new ArvArvore[4500];
        String line = "";
        line = br.readLine();
        while (line != null) {
            jogos[i] = new ArvArvore();
            jogos[i].read(line, jogos, i);
            line = br.readLine();
            i++;
        }

        // Guardar a quantidade de jogos
        contJogos = i;

        // Ler da entrada padrao
        i = 0;
        String val[] = new String[100];
        val[i] = MyIO.readLine();
        while (!isFim(val[i])) {
            i++;
            val[i] = MyIO.readLine();
        }

        long start = System.currentTimeMillis();
        long end;

        // Instanciar uma arvorea de Games e iniciar um arvorea de games
        ArvoreArvore arvore = new ArvoreArvore();
        for (int j = 0; j < i; j++) {
            for (int l = 0; l < contJogos; l++) {
                if (converterStringParaInt(val[j]) == jogos[l].getApp_id()) {
                    arvore.inserir(jogos[l].getName());
                    l = contJogos;
                }
            }
        }

        // Ler metodos a serem feitos
        i = 0;
        String entrada[] = new String[100];
        entrada[i] = MyIO.readLine();
        int contMetodos = converterStringParaInt(entrada[i]);
        for (int j = 0; j < contMetodos; j++) {
            entrada[i] = MyIO.readLine();
            indicarMet(entrada[i], arvore, jogos, contJogos);
        }

        String pesquisa = MyIO.readLine();
        while (!isFim(pesquisa)) {

            if (arvore.pesquisarMos(pesquisa)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            pesquisa = MyIO.readLine();

        }
        String log;
        end = System.currentTimeMillis() - start;
        log = "775119 " + end + "ms / Comparacoes: " + arvore.numComparacoes;
        arq.write(log);
        arq.close();

        br.close();
    }
}

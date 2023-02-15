import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * NoAN da arvore binaria
 * 
 * @author Max do Val Machado
 */
class NoAN {
    public boolean cor;
    public String elemento;
    public NoAN esq, dir;
  
    public NoAN() {
      this("");
    }
  
    public NoAN(String elemento) {
      this(elemento, false, null, null);
    }
  
    public NoAN(String elemento, boolean cor) {
      this(elemento, cor, null, null);
    }
  
    public NoAN(String elemento, boolean cor, NoAN esq, NoAN dir) {
      this.cor = cor;
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
    }
}

class Alvinegra {
    private NoAN raiz; // Raiz da arvore.
    public int numComparacoes;
 
    /**
     * Construtor da classe.
     */
    public Alvinegra() {
       raiz = null;
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
       return pesquisar(elemento, raiz);
    }
 
    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @param i        NoAN em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(String elemento, NoAN i) {
       boolean resp;
       if (i == null) {
        numComparacoes++;
          resp = false;
       } else if (elemento.compareTo(i.elemento) == 0) {
        numComparacoes++;
          resp = true;
       } else if (elemento.compareTo(i.elemento) < 0) {
        System.out.print("esq ");
        numComparacoes++;
          resp = pesquisar(elemento, i.esq);
       } else {
        System.out.print("dir ");
        numComparacoes++;
          resp = pesquisar(elemento, i.dir);
       }
       return resp;
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharCentral() {
       System.out.print("[ ");
       caminharCentral(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharCentral(NoAN i) {
       if (i != null) {
          caminharCentral(i.esq); // Elementos da esquerda.
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
          caminharCentral(i.dir); // Elementos da direita.
       }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPre() {
       System.out.print("[ ");
       caminharPre(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharPre(NoAN i) {
       if (i != null) {
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
          caminharPre(i.esq); // Elementos da esquerda.
          caminharPre(i.dir); // Elementos da direita.
       }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPos() {
       System.out.print("[ ");
       caminharPos(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharPos(NoAN i) {
       if (i != null) {
          caminharPos(i.esq); // Elementos da esquerda.
          caminharPos(i.dir); // Elementos da direita.
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
       }
    }
 
    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(String elemento) throws Exception {
       // Se a arvore estiver vazia
       if (raiz == null) {
          raiz = new NoAN(elemento);
 
       // Senao, se a arvore tiver um elemento
       } else if (raiz.esq == null && raiz.dir == null) {
          if (elemento.compareTo(raiz.elemento) < 0) {
             raiz.esq = new NoAN(elemento);
          } else {
             raiz.dir = new NoAN(elemento);
          }
 
       // Senao, se a arvore tiver dois elementos (raiz e dir)
       } else if (raiz.esq == null) {
          if (elemento.compareTo(raiz.elemento) < 0) {
             raiz.esq = new NoAN(elemento);
 
          } else if (elemento.compareTo(raiz.dir.elemento) < 0) {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
 
          } else {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = raiz.dir.elemento;
             raiz.dir.elemento = elemento;
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, se a arvore tiver dois elementos (raiz e esq)
       } else if (raiz.dir == null) {
          if (elemento.compareTo(raiz.elemento) > 0) {
             raiz.dir = new NoAN(elemento);
 
          } else if (elemento.compareTo(raiz.esq.elemento) > 0) {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
 
          } else {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = raiz.esq.elemento;
             raiz.esq.elemento = elemento;
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, a arvore tem tres ou mais elementos
       } else {
          inserir(elemento, null, null, null, raiz);
       }
       raiz.cor = false;
    }
 
    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
       // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
       if (pai.cor == true) {
          // 4 tipos de reequilibrios e acoplamento
          if (pai.elemento.compareTo(avo.elemento) > 0) { // rotacao a esquerda ou direita-esquerda
             if (i.elemento.compareTo(pai.elemento) > 0) {
                avo = rotacaoEsq(avo);
             } else {
                avo = rotacaoDirEsq(avo);
             }
          } else { // rotacao a direita ou esquerda-direita
             if (i.elemento.compareTo(pai.elemento) < 0) {
                avo = rotacaoDir(avo);
             } else {
                avo = rotacaoEsqDir(avo);
             }
          }
          if (bisavo == null) {
             raiz = avo;
          } else if (avo.elemento.compareTo(bisavo.elemento) < 0) {
             bisavo.esq = avo;
          } else {
             bisavo.dir = avo;
          }
          // reestabelecer as cores apos a rotacao
          avo.cor = false;
          avo.esq.cor = avo.dir.cor = true;
       } // if(pai.cor == true)
    }
 
    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @param avo      NoAN em analise.
     * @param pai      NoAN em analise.
     * @param i        NoAN em analise.
     * @throws Exception Se o elemento existir.
     */
    private void inserir(String elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
       if (i == null) {
          if (elemento.compareTo(pai.elemento) < 0) {
             i = pai.esq = new NoAN(elemento, true);
          } else {
             i = pai.dir = new NoAN(elemento, true);
          }
          if (pai.cor == true) {
             balancear(bisavo, avo, pai, i);
          }
       } else {
          // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
          if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
             i.cor = true;
             i.esq.cor = i.dir.cor = false;
             if (i == raiz) {
                i.cor = false;
             } else if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
             }
          }
          if (elemento.compareTo(i.elemento) < 0 ) {
             inserir(elemento, avo, pai, i, i.esq);
          } else if (elemento.compareTo(i.elemento) > 0) {
             inserir(elemento, avo, pai, i, i.dir);
          } else {
             throw new Exception("Erro inserir (elemento repetido)!");
          }
       }
    }
 
    private NoAN rotacaoDir(NoAN no) {
       NoAN noEsq = no.esq;
       NoAN noEsqDir = noEsq.dir;
 
       noEsq.dir = no;
       no.esq = noEsqDir;
 
       return noEsq;
    }
 
    private NoAN rotacaoEsq(NoAN no) {
       NoAN noDir = no.dir;
       NoAN noDirEsq = noDir.esq;
 
       noDir.esq = no;
       no.dir = noDirEsq;
       return noDir;
    }
 
    private NoAN rotacaoDirEsq(NoAN no) {
       no.dir = rotacaoDir(no.dir);
       return rotacaoEsq(no);
    }
 
    private NoAN rotacaoEsqDir(NoAN no) {
       no.esq = rotacaoEsq(no.esq);
       return rotacaoDir(no);
    }
 }
public class ArvAlvinegra {

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
    public ArvAlvinegra() {
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

    public ArvAlvinegra(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs,
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
    public void read(String str, ArvAlvinegra jogos[], int cont) throws Exception {
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

    public static String[] converterStringParaArray1(String str, ArvAlvinegra jogos[], int cont) {
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
    public static String[] converterStringParaArray2(String str, ArvAlvinegra jogos[], int cont) {
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

    public static ArvAlvinegra descobrirJogoID(int id, ArvAlvinegra jogos[], int contJogos) {
        ArvAlvinegra game = new ArvAlvinegra();

        for (int l = 0; l < contJogos; l++) {
            if (id == jogos[l].getApp_id()) {
                game = jogos[l];
                l = contJogos;
            }
        }
        return game;
    }

    public static ArvAlvinegra descobrirJogoString(String id, ArvAlvinegra jogos[], int contJogos) {
        ArvAlvinegra game = new ArvAlvinegra();

        for (int l = 0; l < contJogos; l++) {
            if (id.compareTo(jogos[l].getName()) == 0) {
                game = jogos[l];
                l = contJogos;
            }
            
        }     
        return game;
    }

    // Metodo para indicar os metodos
    public static void indicarMet(String str, Alvinegra arvore, ArvAlvinegra jogos[], int contJogos) throws Exception {
        int tamanho = str.length();
        String id = "";
        ArvAlvinegra jogo;
        if (str.charAt(0) == 'I') {
            for (int i = 2; i < tamanho; i++) {
                id += str.charAt(i);
            }
            jogo = descobrirJogoID(converterStringParaInt(id), jogos, contJogos);
            arvore.inserir(jogo.getName());
        }
   }

    public static void main(String[] args) throws Exception {

        // Variaveis usadas durante o metodo
        int i = 0;
        int contJogos;
        BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));
        BufferedWriter arq = new BufferedWriter(new FileWriter("775119 arvoreAlvinegra.txt"));

        // Pegar todos os dados do arquivo csv
        ArvAlvinegra jogos[] = new ArvAlvinegra[4500];
        String line = "";
        line = br.readLine();
        while (line != null) {
            jogos[i] = new ArvAlvinegra();
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
        Alvinegra arvore = new Alvinegra();
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
        while(!isFim(pesquisa)){

            if(arvore.pesquisar(pesquisa)){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
            pesquisa = MyIO.readLine();
            
        }
        String log;
        end = System.currentTimeMillis() - start;
        log = "775119 " + end + "ms / Comparacoes: " + arvore.numComparacoes ;
        arq.write(log);
        arq.close();

        br.close();
     }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Celula {
	public ListaFlex list; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

    public Celula(){
        ListaFlex list = new ListaFlex();
        this.list = list;
        this.prox = null;
    }

	public Celula(ListaFlex list) {
      this.list = list;
      this.prox = null;
	}
}


class Lista {
	private Celula primeiro;
	private Celula ultimo;

	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public void inserirInicio(ListaFlex game) {
		Celula tmp = new Celula(game);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
	}
    
	public void inserirFim(ListaFlex game) {
		ultimo.prox = new Celula(game);
		ultimo = ultimo.prox;
	}

	public ListaFlex removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      Celula tmp = primeiro;
		primeiro = primeiro.prox;
		ListaFlex resp = primeiro.list;
      tmp.prox = null;
      tmp = null;
		return resp;
	}
	public ListaFlex removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      ListaFlex resp = ultimo.list; 
      ultimo = i; 
      i = ultimo.prox = null;
      
		return resp;
	}

   public void inserir(ListaFlex game, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(game);
      } else if (pos == tamanho){
         inserirFim(game);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = new Celula(game);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }

	public ListaFlex remover(int pos) throws Exception {
      ListaFlex resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = i.prox;
         resp = tmp.list;
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }

		return resp;
	}

	public void mostrar() {
        int j = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox, j++) {
            System.out.print("[" + j+ "] ");
			i.list.printGame();
		}
	}

	public boolean pesquisar(int x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.list.getApp_id() == x){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}
    
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}

public class ListaFlex {

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
    public ListaFlex() {
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

    public ListaFlex(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs,
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
    public void read(String str, ListaFlex jogos[], int cont) throws Exception {
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

    public static String[] converterStringParaArray1(String str, ListaFlex jogos[], int cont) {
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
    public static String[] converterStringParaArray2(String str, ListaFlex jogos[], int cont) {
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

    public static ListaFlex descobrirJogo(int id, ListaFlex jogos[], int contJogos) {
        ListaFlex game = new ListaFlex();

        for (int l = 0; l < contJogos; l++) {
            if (id == jogos[l].getApp_id()) {
                game = jogos[l];
                l = contJogos;
            }
        }
        return game;
    }

    // Metodo para indicar os metodos
    public static void indicarMet(String str, Lista list, ListaFlex jogos[], int contJogos) throws Exception {
        int tamanho = str.length();
        String id = "";
        String posicao = "";
        ListaFlex game;
        if (str.charAt(0) == 'I' && str.charAt(1) == 'I') {
            for (int i = 3; i < tamanho; i++) {
                id += str.charAt(i);
            }
            list.inserirInicio(descobrirJogo(converterStringParaInt(id), jogos, contJogos));
        } else if (str.charAt(0) == 'I' && str.charAt(1) == 'F') {
            for (int i = 3; i < tamanho; i++) {
                id += str.charAt(i);
            }
            list.inserirFim(descobrirJogo(converterStringParaInt(id), jogos, contJogos));

        } else if (str.charAt(0) == 'I' && str.charAt(1) == '*') {
            posicao += str.charAt(3);
            posicao += str.charAt(4);
            for (int i = 6; i < tamanho; i++) {
                id += str.charAt(i);
            }
            list.inserir(descobrirJogo(converterStringParaInt(id), jogos, contJogos), converterStringParaInt(posicao));

        } else if (str.charAt(0) == 'R' && str.charAt(1) == 'F') {
            game = list.removerFim();
            System.out.println("(R) " + game.getName());

        } else if (str.charAt(0) == 'R' && str.charAt(1) == 'I') {
            game = list.removerInicio();
            System.out.println("(R) " + game.getName());

        } else if (str.charAt(0) == 'R' && str.charAt(1) == '*') {
            for (int i = 3; i < tamanho; i++) {
                posicao += str.charAt(i);
            }
            game = list.remover(converterStringParaInt(posicao));
            System.out.println("(R) " + game.getName());
        }
   }

    public static void main(String[] args) throws Exception {

        // Variaveis usadas durante o metodo
        int i = 0;
        int contJogos;
        BufferedReader br = new BufferedReader(new FileReader("games.csv"));

        // Pegar todos os dados do arquivo csv
        ListaFlex jogos[] = new ListaFlex[4500];
        String line = "";
        line = br.readLine();
        while (line != null) {
            jogos[i] = new ListaFlex();
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

        // Instanciar uma lista de Games e iniciar um lista de games
        Lista list = new Lista();
        for (int j = 0; j < i; j++) {
            for (int l = 0; l < contJogos; l++) {
                if (converterStringParaInt(val[j]) == jogos[l].getApp_id()) {
                    list.inserirFim(jogos[l]);
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
            indicarMet(entrada[i], list, jogos, contJogos);
        }
        
        //Printar o array de jogos
        list.mostrar();
        br.close();
     }
}

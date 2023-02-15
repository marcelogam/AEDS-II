import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


class Lista {
    private ListaMergesort array[]; 
    private int n;

    public Lista() {
        this(6);
    }

    public Lista(int tamanho) {
        array = new ListaMergesort[tamanho];
        n = 0;
    }


    public void inserirInicio(ListaMergesort game) throws Exception {

     

        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1].clone();
        }

        array[0] = game.clone();
        n++;
    }

    public void inserirFim(ListaMergesort game) throws Exception {

        
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[n] = game.clone();
        n++;
    }
    
  
    public void merge() {
        merge(0, n-1);
     }
  
     
     private void merge(int esq, int dir) {
        if (esq < dir){
           int meio = (esq + dir) / 2;
           merge(esq, meio);
           merge(meio + 1, dir);
           intercalar(esq, meio, dir);
        }
     }

     public void intercalar(int esq, int meio, int dir){
         
        int i, j, k; 
        int n1 = meio - esq + 1; 
        int n2 =  dir - meio; 
         ListaMergesort[] L, R;
        L = new ListaMergesort[n1];
        R = new ListaMergesort[n2];
        for (i = 0; i < n1; i++) 
            L[i] = array[esq + i].clone(); 
        for (j = 0; j < n2; j++) 
            R[j] = array[meio + 1+ j].clone(); 
        i = 0;  
        j = 0; 
        k = esq; 
        while (i < n1 && j < n2) 
        { 
            if (L[i].get_upvotes()<=(R[j].get_upvotes())) 
            { 
                array[k] = L[i].clone(); 
                i++; 
            } 
            else
            { 
                array[k] = R[j].clone(); 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            array[k] = L[i].clone(); 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            array[k] = R[j].clone(); 
            j++; 
            k++; 

        }
    }
    
    public void mostrar() {
        for (int i = 0; i < n; i++) {
            array[i].imprimir();
        }
    }

    public void swap(int i, int j) {
        ListaMergesort temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class ListaMergesort {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);
    public static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("UTF-8")));
    private int app_id;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    public ListaMergesort() {
        app_id = 0;
        name = "";
        release_date = new Date(0);
        owners = "";
        age = 0;
        price = 0.0f;
        dlcs = 0;
        languages = new String[1];
        website = "";
        windows = false;
        mac = false;
        linux = false;
        upvotes = 0.0f;
        avg_pt = 0;
        developers = "";
        genres = new String[1];
    } 
    public ListaMergesort(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs,
            String[] languages, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt,
            String developers, String[] genres) {
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

    public int get_app_id() {
        return this.app_id;
    } 

    public void set_app_id(int app_id) {
        this.app_id = app_id;
    } 

    public String get_name() {
        return this.name;
    } 
    public void set_name(String name) {
        this.name = name;
    }

    public Date get_release_date() {
        return this.release_date;
    } 

    public void set_release_date(Date release_date) {
        this.release_date = release_date;
    } 

    public String get_owners() {
        return this.owners;
    } 

    public void set_owners(String owners) {
        this.owners = owners;
    } 

    public int get_age() {
        return this.age;
    } 

    public void set_age(int age) {
        this.age = age;
    } 

    public float get_price() {
        return this.price;
    } 

    public void set_price(float price) {
        this.price = price;
    } 

    public int get_dlcs() {
        return this.dlcs;
    } 

    public void set_dlcs(int dlcs) {
        this.dlcs = dlcs;
    } 

    public String[] get_languages() {
        return this.languages;
    } 

    public void set_languages(String[] languages) {
        this.languages = languages;
    } 

    public String get_website() {
        return this.website;
    } 

    public void set_website(String website) {
        this.website = website;
    } 

    public boolean get_windows() {
        return this.windows;
    } 

    public void set_windows(boolean windows) {
        this.windows = windows;
    } 

    public boolean get_mac() {
        return this.mac;
    } 

    public void set_mac(boolean mac) {
        this.mac = mac;
    } 

    public boolean get_linux() {
        return this.linux;
    } 

    public void set_linux(boolean linux) {
        this.linux = linux;
    } 

    public float get_upvotes() {
        return this.upvotes;
    } 

    public void set_upvotes(float upvotes) {
        this.upvotes = upvotes;
    } 
    public int get_avg_pt() {
        return this.avg_pt;
    } 

    public void set_avg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    } 

    public String get_developers() {
        return this.developers;
    } 

    public void set_developers(String developers) {
        this.developers = developers;
    } 

    public String[] get_genres() {
        return this.genres;
    } 

    public void set_genres(String[] genres) {
        this.genres = genres;
    } 

    public Date cloneData() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(release_date);
        return cal.getTime();
    } 

    public String[] cloneLanguages() {
        String[] cloned = new String[languages.length];
        for (int i = 0; i < languages.length; i++) {
            cloned[i] = languages[i];
        } 
        for (int i = 0; i < genres.length; i++) {
            cloned[i] = genres[i];
        } 
        return cloned;
    } 

    public ListaMergesort clone() {
        ListaMergesort clonar = new ListaMergesort();
        clonar.app_id = this.app_id;
        clonar.name = this.name;
        clonar.release_date = this.release_date;
        clonar.owners = this.owners;
        clonar.age = this.age;
        clonar.price = this.price;
        clonar.dlcs = this.dlcs;
        clonar.languages = this.languages;
        clonar.website = this.website;
        clonar.windows = this.windows;
        clonar.mac = this.mac;
        clonar.linux = this.linux;
        clonar.upvotes = this.upvotes;
        clonar.avg_pt = this.avg_pt;
        clonar.developers = this.developers;
        clonar.genres = this.genres;
        return clonar;

    }

    public static String Update2(String raw) {
        int i = 0;
        String result = "";
        if (raw.charAt(0) != '"') {
            i = raw.indexOf(',') + 1;
            while (i < raw.length()) {
                result += raw.charAt(i);
                i++;
            } 
        } else {
            raw = raw.substring(1);
            i = raw.indexOf('"') + 2;
            while (i < raw.length()) {
                result += raw.charAt(i);
                i++;
            } 
        } 
        return result;
    } 

    public static String proximo(String raw) {
        String result = "";
        int i = 0;
        if (raw.charAt(0) != '"') {
            if (raw.charAt(0) != ',') {
                while (raw.charAt(i) != ',') {
                    result += raw.charAt(i);
                    i++;
                } 
            } 
        } else {
            i = 1;
            while (raw.charAt(i) != '"') {
                result += raw.charAt(i);
                i++;
            } 
        } 
        return result;
    }

    public static String Update(String raw) {
        int i = raw.indexOf(',') + 1;
        String result = "";
        while (i < raw.length()) {
            result += raw.charAt(i);
            i++;
        } 
        return result;
    } 

    

    public static int parseMonth(String mes) {

        int result = 0;
        switch (mes) {
            case "Jan":
                result = 1;
                break;
            case "Feb":
                result = 2;
                break;
            case "Mar":
                result = 3;
                break;
            case "Apr":
                result = 4;
                break;
            case "May":
                result = 5;
                break;
            case "Jun":
                result = 6;
                break;
            case "Jul":
                result = 7;
                break;
            case "Aug":
                result = 8;
                break;
            case "Sep":
                result = 9;
                break;
            case "Oct":
                result = 10;
                break;
            case "Nov":
                result = 11;
                break;
            case "Dec":
                result = 12;
                break;
        } 
        return result;
    } 

    public static Date proximaData(String raw) throws ParseException {
        String ano = "";
        String mes = "";
        String result = "";
        int i = 0;
        if (raw.charAt(0) == '"') {
            i = 1;
            while (i < 4) {
                mes += raw.charAt(i);
                i++;
            } 
            i++;
            while (raw.charAt(i) != ',') {
                i++;
            } 
            i += 2;
            while (raw.charAt(i) != '"') {
                ano += raw.charAt(i);
                i++;
            } 
            result += parseMonth(mes) + "/" + ano;
        } else {
            while (i < 3) {
                mes += raw.charAt(i);
                i++;
            } 
            i++;
            while (i < 8) {
                ano += raw.charAt(i);
                i++;
            } 
            result += parseMonth(mes) + "/" + ano;
        } 
        String pattern = "MM/yyyy";
        Date date = new SimpleDateFormat(pattern).parse(result);

        return date;
    } 

    public static String monthToString(int mes) {
        String result = "";
        switch (mes) {
            case 1:
                result = "Jan";
                break;
            case 2:
                result = "Feb";
                break;
            case 3:
                result = "Mar";
                break;
            case 4:
                result = "Apr";
                break;
            case 5:
                result = "May";
                break;
            case 6:
                result = "Jun";
                break;
            case 7:
                result = "Jul";
                break;
            case 8:
                result = "Aug";
                break;
            case 9:
                result = "Sep";
                break;
            case 10:
                result = "Oct";
                break;
            case 11:
                result = "Nov";
                break;
            case 12:
                result = "Dec";
                break;
        } 
        return result;
    } 

    

    public static String[] nextLanguages(String raw) {
        int length = 0;
        int i = 0;
        String result = "";
        String[] languages;

        while (!(raw.charAt(i) == ']' && raw.charAt(i + 1) == ',')
                && !(raw.charAt(i) == ']' && raw.charAt(i + 1) == '"')) {
            if (raw.charAt(i) == ',') {
                length++;
            } 
            i++;
        } 

        if (raw.charAt(1) != ']') {
            length++;

            languages = new String[length];

            int x = 0, y;
            y = (raw.charAt(0) == '"') ? 3 : 2;

            while (x < length) {
                while (raw.charAt(y) != '\'') {
                    result += raw.charAt(y);
                    y++;
                } 
                languages[x] = result;
                result = "";
                y += 4;
                x++;
            } 

        } else {
            languages = new String[1];
            languages[0] = result;
        } 
        return languages;
    } 

    public static String DevNext(String raw) {
        String dev = "";
        if (raw.charAt(0) == '"') {
            for (int i = 1; raw.charAt(i) != '"'; i++) {
                dev += raw.charAt(i);
            } 
        } 
        else {
            for (int i = 0; raw.charAt(i) != ','; i++) {
                dev += raw.charAt(i);
            } 
        } 
        return dev;
    } 

    public static String atualizarAspas(String raw) {
        raw = raw.substring(1);
        int i = raw.indexOf('"') + 2;
        String result = "";
        while (i < raw.length()) {
            result += raw.charAt(i);
            i++;
        } 
        return result;
    } 

    public static String[] ProximoGenres(String raw) {
        String result = "";
        int length = 0;
        String[] gen;
        if (raw.charAt(0) == '"') {
            for (int i = 1; raw.charAt(i) != '"' && i < raw.length() - 1; i++) {
                if (raw.charAt(i) == ',') {
                    length++;
                } 
            } 
            length++;

            gen = new String[length];

            int y;
            for (int x = 0; x < length; x++) {
                for (y = 1; raw.charAt(y) != ',' && y < raw.length() - 1; y++) {
                    result += raw.charAt(y);
                } 
                y--;
                gen[x] = result;
                raw = raw.substring(result.length() + 1);
                result = "";
            } 
        } else {
            gen = new String[1];
            gen[0] = raw;
        } 
        return gen;
    } 

    public static String VerifiqueSite(String website) {
        if (website == "") {
            website = null;
        }
        return website;
    } 

    public static String jogo_ToString(String[] str) {
        String result = "[";
        for (int i = 0; i < str.length; i++) {
            result += str[i];
            if (i != str.length - 1) {
                result += ", ";
            } 
        } 
        return result += "]";
    } 
    
    public void imprimir() {
        String avg_pt = null;
        if (this.avg_pt == 0)
            avg_pt = "null ";
        else if (this.avg_pt < 60)
            avg_pt = this.avg_pt + "m ";
        else {
            if (this.avg_pt % 60 == 0)
                avg_pt = this.avg_pt / 60 + "h ";
            else
                avg_pt = (this.avg_pt / 60) + "h " + (this.avg_pt % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");
        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format("%.2f", this.price) + " " + this.dlcs + " "
                + jogo_ToString(this.languages) + " " + VerifiqueSite(this.website) + " " + this.windows + " "
                + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + jogo_ToString(this.genres));
    }

    public static String priceToString(float price) {
        String resp = Float.toString(price);
        if (price - (int) price == 0) {
            resp += "0";
        } 
        return resp;
    } 

    

    public static ListaMergesort LerJogo(String raw) throws IOException, ParseException {

        int app_id = Integer.parseInt(proximo(raw));
        raw = Update(raw);
        String name = proximo(raw);
        raw = Update2(raw);
        Date release_date = proximaData(raw);
        if (raw.charAt(0) == '"') {
            raw = Update(raw);
            raw = Update(raw);
        } else {
            raw = Update(raw);
        } 
        String owners = proximo(raw);
        raw = Update(raw);
        int age = -1, dlcs = -1;
        float price = -1.0f;
        if (proximo(raw) != "") {
            age = Integer.parseInt(proximo(raw));
        } 
        raw = Update(raw);
        if (proximo(raw) != "") {
            price = Float.parseFloat(proximo(raw));
        } 
        raw = Update(raw);
        if (proximo(raw) != "") {
            dlcs = Integer.parseInt(proximo(raw));
        } 
        raw = Update(raw);
        String[] languages = nextLanguages(raw);
        for (int i = 0; i < languages.length; i++) {
            raw = Update(raw);
        } 
        String website = "";
        if (proximo(raw) != "") {
            website = proximo(raw);
        } 
        raw = Update2(raw);
        boolean windows = Boolean.parseBoolean(proximo(raw));
        raw = Update(raw);
        boolean mac = Boolean.parseBoolean(proximo(raw));
        raw = Update(raw);
        boolean linux = Boolean.parseBoolean(proximo(raw));
        raw = Update(raw);
        int pos = Integer.parseInt(proximo(raw));
        raw = Update(raw);
        int neg = Integer.parseInt(proximo(raw));
        raw = Update(raw);
        float upvotes = (pos / (float) (pos + neg)) * 100;
        int avg_pt = Integer.parseInt(proximo(raw));
        raw = Update(raw);
        String developers = DevNext(raw);
        if (raw.charAt(0) == '"') {
            raw = atualizarAspas(raw);
        } else {
            raw = Update(raw);
        } 
        String[] genres = new String[0];
        if (raw.length() != 0) {
            genres = ProximoGenres(raw);
        } 
        return new ListaMergesort(app_id, name, release_date, owners, age, price, dlcs, languages, website,
                windows, mac, linux, upvotes, avg_pt, developers, genres);
    }

    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    } 

    public static String findGameById(String id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));
        

        String line = "";

        while ((line = br.readLine()) != null) {

            String app_id = line.substring(0, line.indexOf(","));

            if (app_id.equals(id)) {

                br.close();
                return line;
            }
        }
        br.close();
        return line;

    }
    
    public static ListaMergesort findId(int id, ArrayList<ListaMergesort> list) {
        ListaMergesort name = null;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).app_id) {
                name = list.get(i);
                i = list.size();
            } 
        } 
        if (name == null) {
            System.out.println("[findId] Jogo nao encontrado.");
        } 
        return name;
    } 

    public static void main(String[] args) throws Exception {
        Lista lista = new Lista(200);
        String str = reader.readLine();
        while (!str.contains("FIM")) {
            String s = findGameById(str);
            ListaMergesort p = LerJogo(s);
            if (p != null) {
                
                lista.inserirFim(p);
            } 
            str = reader.readLine();
        }
        BufferedWriter arq = new BufferedWriter(new FileWriter("matrícula_selecao.txt"));
        long start = System.currentTimeMillis();
        long end;
        lista.merge();
        String log;
        end = System.currentTimeMillis() - start;
        log = "775119 " + end + " ms ";
        arq.write(log);
        arq.close();

        lista.mostrar();
    }
}

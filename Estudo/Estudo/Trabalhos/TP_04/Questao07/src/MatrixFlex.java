import java.util.Scanner;

class CelulaM {
    public CelulaM baixo, cima, esq, dir;
    public int elemento;

    public CelulaM() {
        this(0);
    }

    public CelulaM(int elemento, CelulaM baixo, CelulaM cima, CelulaM esq, CelulaM dir) {
        this.elemento = elemento;
        this.baixo = baixo;
        this.cima = cima;
        this.esq = esq;
        this.dir = dir;
    }

    public CelulaM(int elemento) {
        this(elemento, null, null, null, null);
    }


}

class Matrix {
    private CelulaM inicio;
    private int linha;
    private int coluna;

    public Matrix() {
        this(3, 3);
    }

    public Matrix(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        inicio = new CelulaM();
        CelulaM tmp = inicio;

        for (int i = 1; i < coluna; i++) {
            tmp.dir = new CelulaM();
            tmp.dir.esq = tmp;
            tmp = tmp.dir;
        }

        tmp = inicio;
        for (int l = 1; l < linha; l++, tmp = tmp.baixo) {
            CelulaM i = tmp;

            i.baixo = new CelulaM();
            i.baixo.cima = i;
            
            CelulaM j = i.baixo;
            for (int c = 1; c < coluna; c++, j = j.dir) {
                i = i.dir;
                i.baixo = new CelulaM();
                i.baixo.cima = i;
                i.baixo.esq = j;
                j.dir = i.baixo;
            }
        }
    }
    
    //Imprimi Matrix
    void printar() {

        CelulaM tmp = inicio;
        CelulaM col1 = inicio;

        Scanner sc = new Scanner(System.in);
        for (int l = 0; l < linha; l++) {

            for (int c = 0; c < coluna; c++) {
                System.out.print(tmp.elemento + " ");
                tmp = tmp.dir;
            }

            System.out.println("");
            col1 = col1.baixo;
            tmp = col1;

        }

        sc.close();

    }

    // Ler matrix
    public void read(Scanner sc) {

        CelulaM tmp = inicio;
        CelulaM col1 = inicio;

        for (int l = 0; l < linha; l++) {

            for (int c = 0; c < coluna; c++) {
                tmp.elemento = sc.nextInt();
                tmp = tmp.dir;
            }

            col1 = col1.baixo;
            tmp = col1;
        }
    }
    
    // Printa diagonal secundaria
    void diagonalSecundaria() {

        CelulaM tmp = inicio;

        for (int c = 0; c < coluna - 1; c++) tmp = tmp.dir;
        

        System.out.print(tmp.elemento + " ");

        for (int c = 0; c < coluna - 1; c++, tmp = tmp.esq.baixo) {
            System.out.print(tmp.esq.baixo.elemento + " ");
        }

        System.out.println();
    }

    //printa diagonal principal
    void diagonalPrincipal() {

        CelulaM tmp = inicio;

        System.out.print(tmp.elemento + " ");

        for (int c = 0; c < coluna - 1; c++, tmp = tmp.dir.baixo) {
            System.out.print(tmp.dir.baixo.elemento + " ");
        }

        System.out.println();
    }

    // Retorna uma matrix multiplicada
    Matrix multipMatrix(Matrix MatrixDois) {

        Matrix resp = new Matrix(linha, coluna);
        CelulaM tmpR = resp.inicio;
        
        CelulaM tmpM1 = this.inicio;
        CelulaM tmpM2 = MatrixDois.inicio;
        
        CelulaM mat1 = this.inicio;
        CelulaM mat2 = MatrixDois.inicio;
        
        CelulaM matResult = resp.inicio;
        
        int lr = 0;
        while (lr < linha) {

            int l1 = 0; 
            while(l1 < linha) {

                int c = 0;
                while(c < coluna) {

                    tmpR.elemento += tmpM1.elemento * tmpM2.elemento;

                    tmpM1 = tmpM1.dir;

                    tmpM2 = tmpM2.baixo;

                    c++;
                }

                tmpR = tmpR.dir;

                tmpM1 = mat1;
                
                tmpM2 = mat2.dir;
                l1++;

            }
            
            matResult = matResult.baixo;
            tmpR = matResult;

            mat1 = mat1.baixo;
            tmpM1 = mat1;

            tmpM2 = mat2;
            lr++;
        }

        return resp;
    }

    //retorna uma matrix que e a soma de outras duas
    Matrix somaMatrix(Matrix MatrixDois) {

        Matrix resp = new Matrix(linha, coluna);
        CelulaM tmpR = resp.inicio;
        CelulaM tmpM1 = this.inicio;
        CelulaM tmpM2 = MatrixDois.inicio;
        CelulaM mat1 = this.inicio;
        CelulaM mat2 = MatrixDois.inicio;
        CelulaM matResult = resp.inicio;
        
        int i = 0;
        while (i < linha) {

            for (int j = 0; j < coluna; j++){
                tmpR.elemento = tmpM1.elemento + tmpM2.elemento;
                tmpR = tmpR.dir;
                tmpM1 = tmpM1.dir;
                tmpM2 = tmpM2.dir;
            }

            mat1 = tmpM1 = mat1.baixo;
            mat2 = tmpM2 = mat2.baixo;
            matResult = tmpR = matResult.baixo;
            i++;
        }

        return resp;
    }


}

class MatrixFlex {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int linha = 0;
        int colunauna = 0;

        for (int i = 0; i < n; i++) {


            Matrix matrix[] = new Matrix[2];

            for (int j = 0; j < 2; j++) {

                linha = scan.nextInt();
                colunauna = scan.nextInt();
                //cria as 2 matrizes 
                Matrix tmp = new Matrix(linha, colunauna);
                tmp.read(scan);
                matrix[j] = tmp;

            }

            matrix[0].diagonalPrincipal();

            matrix[0].diagonalSecundaria();

            matrix[0].somaMatrix(matrix[1]).printar();

            matrix[0].multipMatrix(matrix[1]).printar();
        }

        scan.close();
    }
}
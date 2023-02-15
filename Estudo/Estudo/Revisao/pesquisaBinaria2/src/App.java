public class App {
    public static void main(String[] args) throws Exception {
        boolean resp = false;
        int n = 16;
        int[] array = new int[n];
        int x = 4;

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        int dir = n - 1, esq = 0, meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (x == array[meio]) {
                resp = true;
                esq = n;
            } else if (x > array[meio]) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
            MyIO.print(array[meio]);
        }
        MyIO.println(resp);
    }
}

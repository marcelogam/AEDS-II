import java.io.RandomAccessFile;


public class App {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

        raf.writeInt(1);
        raf.writeDouble(5.3);
        raf.writeChar('X');
        raf.writeBoolean(true);
        raf.writeBytes("Algoritmos");

        raf.close();

    }
}

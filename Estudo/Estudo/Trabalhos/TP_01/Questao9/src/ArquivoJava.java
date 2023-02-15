import java.io.RandomAccessFile;
import java.io.File;

public class ArquivoJava {

	public static void main(String[] args) throws Exception {
		File file2 = new File("pub.txt");
		file2.delete();
		
		int n = MyIO.readInt();
		RandomAccessFile raf = new RandomAccessFile("pub.txt", "rw");
		

		for (int i = 0; i < n; i++) {
			raf.writeDouble(MyIO.readDouble());
		}
		raf.close();

		RandomAccessFile file = new RandomAccessFile("pub.txt", "r");
		
		double num = 0.0;
		

		for (int i = n-1; i >= 0; i--) {
			file.seek(i * 8);
			num = file.readDouble();
			if(num % 1 == 0){
				MyIO.println((int) num);
			}else {
				MyIO.println(num);
			}
		}
			file.close();
	}
}

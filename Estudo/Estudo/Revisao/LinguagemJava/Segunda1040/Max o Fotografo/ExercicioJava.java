import java.util.Scanner;

class ExercicioJava {
	public static void comparaH(int centimetros, int fila1[], int fila2[], int pessoas) {
		boolean resp = true;
		for (int i = 0; i < pessoas; i++) {
			if (Math.pow((fila1[i] - fila2[i]), 2) < centimetros) {
				resp = false;
			}
		}
		if (resp) {
			System.out.println("SIM");
		} else {
			System.out.println("NAO");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int casosTeste = sc.nextInt();
		int pessoas;
		int centimetros;
		for (int i = 0; i < casosTeste; i++) {
			pessoas = sc.nextInt();
			centimetros = sc.nextInt();
			int fila1[] = new int[pessoas];
			int fila2[] = new int[pessoas];
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < pessoas; k++) {
					if (j == 0) {
						fila1[k] = sc.nextInt();
					}
					if (j == 1) {
						fila2[k] = sc.nextInt();
					}
				}
			}
			comparaH(centimetros, fila1, fila2, pessoas);
		}
		sc.close();

	}
}

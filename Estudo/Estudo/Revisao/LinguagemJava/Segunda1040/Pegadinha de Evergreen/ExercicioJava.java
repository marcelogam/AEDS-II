import java.util.Scanner;

class ExercicioJava{
	public static String concatenar(String str1, String str2){
		String strCon = "" ;
		int tamanho1 = (str1.length() - 1);
		int tamanho2 = (str2.length() - 1);
		int i = 0;
		while( i < tamanho1 && i < tamanho2){
			strCon += str1.charAt(i);
		    strCon += str1.charAt(i+1);
			strCon += str2.charAt(i);
			strCon += str2.charAt(i+1);
			i += 2;
		}
		for(int j = i; j <= tamanho1; j++){
			strCon += str1.charAt(j);
		}
		for(int j = i; j <= tamanho2; j++){
			strCon += str2.charAt(j);
		}
		System.out.println(strCon);
		return strCon;
	}
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int casosTeste =sc.nextInt();
		String palavra1;
		String palavra2;
		sc.nextLine();
		for(int i = 0; i < casosTeste ; i++){
			palavra1 = sc.nextLine();
			palavra2 = sc.nextLine();
			concatenar(palavra1,palavra2);
		}	
		sc.close();
	}
}

import java.util.Random;

public class AlteraAle {
    public static String alteraAleatorio(String string, Random gerador){
	
		char sorteado1 = ( (char) ('a' + (Math.abs(gerador.nextInt() ) % 26 )));
		char sorteado2 = ( (char) ('a' + (Math.abs(gerador.nextInt() ) % 26 )));
	    
		String resp = "";

		for(int i = 0; i < string.length(); i++){
			
			if(string.charAt(i) == sorteado1){
				resp += sorteado2;
			}else{
				resp += string.charAt(i);
			}
		}

		return resp;
	}
    
    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    public static void main(String[] args) throws Exception {
        String [] str = new String[1000];
		int entrada = 0;

		Random gerador = new Random();
		gerador.setSeed(4);

		do{
			str[entrada] = MyIO.readLine();
			
			if(!isFim(str[entrada])){
				MyIO.println(alteraAleatorio(str[entrada], gerador));
			}

		}while(!isFim(str[entrada++]));
	
    }
}

public class Ciframento {
    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    public static String ciframentoDeCesar(String str){
		String resp = "";

		for(int i = 0; i < str.length(); i++){
			resp += (char)(str.charAt(i) + 3);
			
		}

		return resp;	
	}

    public static void main(String[] args) throws Exception {
        String palavra[] = new String[1000];
		int entrada = 0;
		do{
		
			palavra[entrada] = MyIO.readLine();
			if(!isFim(palavra[entrada])){
				MyIO.println(ciframentoDeCesar(palavra[entrada]));		
			}
		}while(!isFim(palavra[entrada++]));
    }
}

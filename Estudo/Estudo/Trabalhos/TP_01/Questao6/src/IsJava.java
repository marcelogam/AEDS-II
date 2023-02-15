public class IsJava {
	
    public static boolean isFim(String str){
		return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
	}

    public static boolean isVogal(String str){
	
		boolean resp = true;

		for(int i = 0; i < str.length(); i++){
		 
			if(str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u' && str.charAt(i) != 'A' && str.charAt(i) != 'E' && str.charAt(i) != 'I' && str.charAt(i) != 'O' && str.charAt(i) != 'U'){
				resp = false;
				i = str.length();
			}
		}
		return resp;
	}
    
    public static boolean isLetra(char c){
	
		boolean resp = false;
		if(c >= 65 && c <= 90 || c >= 97 && c <= 122){
			resp = true;
		}

		return resp;
	
	}
    public static boolean isConsoante(String str){
		
		boolean resp = true;

		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)  == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || (!isLetra(str.charAt(i)))){
					resp = false;
					i = str.length();
			}

		}

		return resp;
		
	}
    
    public static boolean isReal(String string){
	
		boolean resp = true;
		int cont = 0;

		for(int i = 0; i < string.length(); i++){
			if(string.charAt(i) == ','){
				cont++;
			}
			if(string.charAt(i) == '1' || string.charAt(i) == '2' || string.charAt(i) == '3' || string.charAt(i) == '4' || string.charAt(i) == '5' || string.charAt(i) == '6' || string.charAt(i) == '7' || string.charAt(i) == '8' || string.charAt(i) == '9' || string.charAt(i) == '0' && cont >= 0 && cont <=1 || string.charAt(i) == ','){
				resp = true;
				
			}else{
				resp = false;
				i = string.length();
			}
		
		}

		return resp;
	}
	
    
    public static boolean isInteiro(String str){
	
		boolean resp = true;

		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) >= 48 && str.charAt(i) <=57){
				resp = true;
			}else{
				resp = false;
				i = str.length();
			}
		}

		return resp;
	
	}


    public static void main(String[] args) throws Exception {
        String []palavra = new String[1000];
		int entrada = 0;

		do{
			palavra[entrada] = MyIO.readLine();

		}while(!isFim(palavra[entrada++]));

		entrada--;

		for(int i = 0; i < entrada; i++){
			MyIO.print(isVogal(palavra[i])     == true ? "SIM " : "NAO ");
            MyIO.print(isConsoante(palavra[i]) == true ? "SIM " : "NAO ");
            MyIO.print(isInteiro(palavra[i])   == true ? "SIM " : "NAO ");
            MyIO.println(isReal(palavra[i])      == true ? "SIM" : "NAO");
		
		}
    }
}

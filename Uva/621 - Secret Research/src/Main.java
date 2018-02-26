import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class Main {
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		String  cant = br.readLine().trim();
		
		
		int a = Integer.parseInt(cant);
		for(int i = 0 ; i <  a ; i++){
			String num = br.readLine().trim();
			if(num.equals('1') || num.equals('4') || num.equals("78")){
				System.out.println('+');
			}else if( num.length() >= 2 && num.charAt(num.length() - 1 ) == '5' && 
					   num.charAt(num.length() - 2 ) == '3'  ){
				System.out.println('-');
			}else if(num.length() >= 2 && num.charAt(0) == '9' && num.charAt(num.length() - 1) == '4'){
				System.out.println('*');
			}else if(num.length() >= 3 && num.charAt(0) == '1' &&  num.charAt(1) == '9' && num.charAt(2) == '0'){
				System.out.println('?');
			}
			
		}
		
		
	}

}

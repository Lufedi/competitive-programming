import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
	
	public static void main(String [] args)  throws Exception{
	
		BufferedReader br =  new BufferedReader(new  InputStreamReader(System.in) );
		String datos[] ,  linea , orig;
		
		BigInteger n;
		int num;
		while( br.ready()){
			linea=  br.readLine().trim();
			n = new BigInteger(linea);
			
			
			n  = n.pow(2);
			if(n.toString().endsWith(linea)) System.out.println("Automorphic number of "+linea.length()+"-digit.");
			else System.out.println("Not an Automorphic number.");
			
		}
	}

}

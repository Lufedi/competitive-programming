import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int cont = 0;
		while( br.ready()){
			linea =  read();
			BigInteger s =  new BigInteger(linea);
			if(s.isProbablePrime(100)){
				StringBuffer sb =  new StringBuffer(s.toString());
				String sb3 = new String(sb.toString());  
				StringBuffer sb2 =  sb.reverse();
				if(!(sb3.toString().equals(sb2.toString())) && (new BigInteger(sb2.toString())).isProbablePrime(100)){
					System.out.println(s + " is emirp.");
				}else{
					System.out.println(s + " is prime.");
				}
			}else{
				System.out.println(s + " is not prime.");
			}
		}
	}
}

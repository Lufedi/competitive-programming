import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 10min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		String linea, datos;
		int c,n;
		c = pint(read());
		for(int i = 0 ; i  < c ; i++){
			 n = pint(read());
			String s =  ((((((n*567)/9)+7492)*235)/47)-498) + "";
			System.out.println(s.charAt(s.length()-2));
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 6min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		String linea, datos[];
		int cont = 0;
		while(!(linea= read()).equals("*")){
			
			if(linea.equals("Hajj"))System.out.println("Case "+ (++cont) + ": Hajj-e-Akbar");
			else System.out.println("Case "+ (++cont) + ": Hajj-e-Asghar");
		}
	}
}

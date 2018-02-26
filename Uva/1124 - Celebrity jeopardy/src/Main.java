import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 4min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		while(br.ready())
			System.out.println(read());		
	}
}

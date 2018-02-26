import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;







// tiempo 6 min
public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		
		String linea, datos[];
		
		Scanner sc  = new Scanner(System.in);
		while(!br.ready()){
			linea =  read();
			
			System.out.println(Arrays.toString(linea.split(" ")));
			
		}
		
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 4min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		String linea, datos[];
		int c,n;
		c = pint(read());
		int s = 0;
		for(int i = 0 ; i  < c ; i++){
			linea =  read();
			if(linea.charAt(0) == 'd'){
				s+= pint((linea.split(" "))[1]);
			}else{
				System.out.println(s);
			}
			
		}
	}
}

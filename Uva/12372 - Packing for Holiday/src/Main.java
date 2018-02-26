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
		int c,n;
		c = pint(read());
		int l , w , h;
		for(int i = 0 ; i  < c ; i++){
			datos =  read().split(" ");
			l =  pint(datos[0]);
			w =  pint(datos[1]);
			h =  pint(datos[2]);
			
			if( l > 20 || w  > 20 || h > 20)
				System.out.println("Case "+ (i+ 1) + ": bad");
			else
				System.out.println("Case "+ (i+ 1) + ": good");
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 12min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		int c, w , h;
		String linea,datos[];
		c =  pint(read());
		for(int i = 0; i <  c ; i++){
			datos  =  read().split(" ");
			w = pint(datos[0]) - 2;
			h = pint(datos[1]) - 2;
			int r1 = w/3 + ((w%3 != 0 )?1:0);
			int r2 = h/3 + ((h%3 != 0 )?1:0);
			System.out.println(r1*r2);
		}
	}
}

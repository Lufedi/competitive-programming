import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 10min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		int c, w , h;
		String linea,datos[];
		c =  pint(read());
		int t;
		int p[];
		for(int i = 0; i <  c ; i++){
			t = pint(read());
			p = new int[t];
			datos =  read().split(" ");
			int sum = 0;
			int min = Integer.MAX_VALUE,max = -1;
			for(int j = 0 ; j <  datos.length  ; j++){
				p[j] = pint(datos[j]);
				sum+= p[j];
				min = Math.min(min, p[j]);
				max = Math.max(max, p[j]);
			}
			int prom =  sum/t;
			int res = Math.abs(min - prom) + Math.abs(max - prom) + Math.abs(max - min);
			System.out.println(res);
			
		}
	}
}

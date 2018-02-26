import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 35min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		int c, w , h;
		String linea,datos[];
		int B , N;
		int res[];
		while( !(linea =  read()).equals("0 0")){
			datos = linea.split(" ");
			B =  pint(datos[0]);
			N =  pint(datos[1]);
			
			res =  new int[B];
			datos = read().split(" ");
			for(int i = 0 ; i  <  datos.length ; i++){
				res[i] = pint(datos[i]);
			}
			int u , v , r;
			for(int i = 0 ; i <  N ;  i++){
				datos =  read().split(" ");
				u = pint(datos[0]) - 1;
				v = pint(datos[1]) - 1;
				r = pint(datos[2]);
				res[u]-= r;
				res[v]+= r;
			}
			boolean rta =  true;
			for(int i = 0 ; i < B ;  i++){
				//System.out.println(res[i]);
				if(res[i] < 0)
					rta =  false;
			}
			
			System.out.println((rta)?"S":"N");
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;







// tiempo 10 min
public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		String linea, datos[];
		
		int cont = 0;
		while( !(linea =  read()).equals("0")){
			int res = 0;
			datos =  read().split(" ");
			for(int i = 0 ; i <  datos.length ; i++){
				res += ( pint(datos[i]) == 0)?-1:1;
			}
			System.out.println("Case " + (++cont) + ": " +  res);
		}
		
		
	}
}

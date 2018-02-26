import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int cont = 0;
		while( !(linea = read()).equals("0 0")){
			int N , F;
			datos =  linea.split(" ");
			N =  pint(datos[0]);
			F =  pint(datos[1]);
			BigInteger s =  new BigInteger("0");
			for(int i =  0 ;  i <  N ; i++)
				s =  s.add(new BigInteger(read()));
			System.out.println("Bill #" + (++cont) +" costs "+s
					+": each friend should pay " + (s.divide(new BigInteger(F+""))));
			System.out.println();
		}
		
	}
}

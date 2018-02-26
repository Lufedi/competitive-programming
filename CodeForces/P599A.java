import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String datos[], linea;
		int d1, d2 , d3;
		datos =  br.readLine().split(" ");
		d1 = Integer.parseInt(datos[0]);
		d2 = Integer.parseInt(datos[1]);
		d3 = Integer.parseInt(datos[2]);
		int r = 100000000*4;
		//System.out.println(r);
		System.out.println( Math.min(Math.min(2*d1 + 2*d3, 2*d2+2*d3), Math.min(d1*2+d2*2, d1+d2+d3)));
	}
}
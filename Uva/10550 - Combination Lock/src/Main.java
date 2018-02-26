import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;






//Tiempo : 1n


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		String linea ,  datos[];
		while(!(linea =  read()).equals("0 0 0 0")){
			int p[] =  new int[3];
			int ini;
			datos = linea.split(" ");
			ini =  pint(datos[0]);
			p[0] = pint(datos[1]);
			p[1] = pint(datos[2]);
			p[2] = pint(datos[3]);
			int d1,d2,d3;
			//if( Math.abs(ini - p[0])  > 20){
			//	d1 = (40  -)
			//}
			
			int ans = 1080;
		ans += (ini - p[0]) > 0 ? (ini - p[0]) * 9 : (ini - p[0] + 40) * 9;
		ans += (p[1] - p[0]) > 0 ? (p[1] - p[0]) * 9 : (p[1] - p[0] + 40) * 9;
		ans += (p[1] - p[2]) > 0 ? (p[1] - p[2]) * 9 : (p[1] - p[2] + 40) * 9;
			 
			
			System.out.println(ans);
		}
	}
}

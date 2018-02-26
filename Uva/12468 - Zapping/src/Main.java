	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 8 min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			
			while(!(linea =  read()).equals("-1 -1")){
				datos = linea.split(" ");
				int ini , fin ;
				ini =  pint(datos[0]);
				fin  = pint(datos[1]);
				System.out.println( (Math.abs(fin - ini) > 50)? 100 - (Math.abs(fin - ini)): Math.abs(fin - ini));
				
			}
		}
	}

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 8min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			int casos = pint(read());
			System.out.println("Lumberjacks:");
			for(int c = 0 ; c <  casos ;  c++){
				datos   =  read().split(" ");
				boolean as =  true, ds =  true;
				for(int j = 0 ; j < datos.length  - 1 ; j++){
					as = as && pint(datos[j]) > pint(datos[j + 1]);
					ds = ds && pint(datos[j]) < pint(datos[j + 1]);
				}
				if( as || ds)System.out.println("Ordered");
				else System.out.println("Unordered");
			}
		}
	}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;






//Tiempo : 20min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		
		String linea,datos[];
		int n;
		
		Hashtable<String, Integer> tabla;
		String names[];
		int cont = 0;
		while(br.ready()){
			tabla  =  new Hashtable<String, Integer>();
			n =  pint(read());
			names = new String[n];
			names = read().split(" ");
			for(int i = 0 ; i <  names.length ;  i++){
				tabla.put(names[i], 0);
			}
			for(int  k = 0 ; k <  n ; k ++){
				datos =  read().split(" ");
				int g = pint(datos[1]);
				
				int p = pint(datos[2]);
				
				tabla.put(datos[0] , tabla.get(datos[0]) +  ((p != 0)?g%p:0) - g);
				int div = (p != 0)? g/p:0; 
				for(int i = 3 ; i < (3 + p) ; i++){
					int c =  tabla.get(datos[i]);
					c+= div;
					tabla.put(datos[i], c);
				}
			}
			
			if(cont > 0)System.out.println();
			for(int i = 0 ; i <  names.length ;  i++){
				System.out.println(names[i] + " " + tabla.get(names[i]));
			}
			cont++;
		}
	}
}


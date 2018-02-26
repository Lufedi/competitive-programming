import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static String[]  meses=  new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November" , "December"};

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String datos[];
		String linea;
		
		
		int casos =  Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < casos ;  i++){
			
			int cantBis = 0;
			Fecha f1  , f2;
			datos =  br.readLine().trim().split(" ");
			f1 =  new Fecha(Integer.parseInt(datos[2]) , 
							getNumMonth(datos[0]) , 
							Integer.parseInt(datos[1].substring(0, datos[1].length() -1)) 
							);
		
			datos =  br.readLine().trim().split(" ");
			f2 =  new Fecha(Integer.parseInt(datos[2]) , 
							getNumMonth(datos[0]) , 
							Integer.parseInt(datos[1].substring(0, datos[1].length() -1)) 
							);

		}

	}

	private static int getNumMonth(String a) {
		for(int i = 0 ; i < meses.length ; i++){
			if( meses[i].equals(a)) return i;
		}
		return 0;
	}

}
class Fecha{
	int m , d , y;
	public Fecha(int y , int m , int d){
		this.y = y; this.m = m ; this.m = m;
	}
}

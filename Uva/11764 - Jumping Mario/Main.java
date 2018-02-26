
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	    int casos =  Integer.parseInt(br.readLine().trim());
	    String datos[];int l ;
	    for(int  i =  0; i  < casos ; i++){
	    	l =   Integer.parseInt(br.readLine().trim());
	    	datos =  br.readLine().split(" ");
	    	solve(datos ,  l ,  i  + 1 );
	    }
		
		
		
		
	}

	private static void solve(String[] datos , int l ,  int caso) {
		
		int cont1  = 0 ,  cont2 = 0 ;
		for(int i = 0 ; i  < l - 1 ;i++){
			if( Integer.parseInt(datos[i]) > Integer.parseInt(datos[i + 1])) cont1++;
			else if ( Integer.parseInt(datos[i]) < Integer.parseInt(datos[i + 1])) cont2++;
		} 
		System.out.println("Case " + caso +": "  +  cont2  + " " + cont1);
		
		
	}
}

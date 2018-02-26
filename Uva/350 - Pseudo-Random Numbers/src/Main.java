import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;






public class Main {

	
	public static int Z ,  I  , M , L ;
	//L = (L * Z + I) % M
	
	public static int f(int Z , int I ,  int  M , int L){
		return ( L * Z + I)% M;
	}
	
	
	public static void main(String[] args) throws Exception{

	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	String linea;
	String datos[];
	datos  = br.readLine().trim().split(" ");
	
	Z = Integer.parseInt(datos[0]);
	I = Integer.parseInt(datos[1]);
	M = Integer.parseInt(datos[2]);
	L = Integer.parseInt(datos[3]);
	int caso = 0;
	while( Z != 0 || I != 0 || M != 0 || L != 0){
		System.out.println("Case " + (++caso) + ": "+  solve( Z , I ,  M , L));
		datos  = br.readLine().trim().split(" ");
		
		Z = Integer.parseInt(datos[0]);
		I = Integer.parseInt(datos[1]);
		M = Integer.parseInt(datos[2]);
		L = Integer.parseInt(datos[3]);
	}
		
	}


	private static int solve(int z, int i, int m, int l){
		int x0 =  l;
		Hashtable<Integer , Integer> mem = new Hashtable<Integer , Integer>();
		mem.put(x0, 0);
		int ind = 0;
		x0 = f( z , i ,  m, x0 );
		while( !mem.containsKey(x0)){
			//System.out.println(x0);
			mem.put(x0, ++ind);
			x0 = f(z , i ,  m , x0);
		}
		
		return ( ind - mem.get(x0))  + 1;
	}
	
	
	
	
	
}

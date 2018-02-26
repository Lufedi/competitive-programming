import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.LinkedList;

public class Main {

	
	public static double dist[][];
	public static int N;
	public static void main(String[] args) throws Exception{
	
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			  N = Integer.parseInt(br.readLine().trim());
			
			int cas = 0;
			while( N != 0 ){
			cas++;	
			Tupla[] A= new Tupla[2*N];
			String datos[];
			for(int  i = 0 ; i <  2*N ; i++){
				datos = br.readLine().trim().split(" ");
				A[i] = new Tupla( Integer.parseInt(datos[1])  , Integer.parseInt(datos[2]));
				
			}
	
			
			Hashtable<Integer, Double> mem = new Hashtable<Integer , Double>();
			
			 dist = new double[2*N][2*N];
			for (int i = 0; i < 2 * N; i++) 
				for (int j = 0; j < 2 * N; j++)
				dist[i][j] = Math.sqrt(  ( A[i].x - A[j].x ) * ( A[i].x - A[j].x ) + (A[i].y - A[j].y ) * (A[i].y - A[j].y ));
			
			 
			 double f =  fi(A   , 0 , mem) ;
			 
			System.out.print( "Case " + cas+ ": ");
			 System.out.printf( "%.2f",  f  );
			 System.out.println();
			
			
			N = Integer.parseInt(br.readLine().trim());
			}
	}




	private static double fi(Tupla[] a , int bm , Hashtable<Integer , Double> mem) {

		double res = -1;
		if(mem.containsKey(bm)){
		
			return mem.get(bm);
		}
		else if( bm == (1 << 2*N) - 1){
			return  0;
		}else{
			 res =  Double.MAX_VALUE;
			 for(int i = 0 ; i <  a.length; i++){
				 	if((bm & (1 << i)) == 0){
				 for(int j = i + 1 ; j <  a.length ; j++){
					 	if((bm & (1 << j)) == 0){
							 double d = dist[i][j];
							 res =  Math.min(res , d + fi(a  , bm | (1 << i) | (1 << j)  , mem)); 
						 }
					 }
				 break;
				 }
				 
			 }	
		}
		mem.put(bm, res);
		return res;
		
	}





	
}
class Tupla{
	public int x , y;
	public Tupla(int x , int y){
		this.x  = x;
		this.y = y;
	}
}
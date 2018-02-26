import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Main {


	
	
	
	
	public static int N ,  F ,  T ;
	public static int[][] friends;
	public static int[][] country , fw ,  manhDistance;
	public static int pint(String n){return Integer.parseInt(n);}

	public static void main(String[] args) throws Exception {
		/*Random r =  new Random();
		int t = 25 ; 
		int mat[][] = new int[t][t];
		for(int i = 0 ;  i<  t ;  i++){
			for(int  j = 0 ;  j < t ;  j++)
				System.out.print((r.nextInt(10000) + 1) + " " );
			System.out.println();
		}*/
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String linea  , datos[];
		int id = 0;
		while( !(linea =  br.readLine().trim()).equals("0 0 0")){
			 datos =  linea.split(" ");
			 N = pint(datos[0]);
			 F = pint(datos[1]);
			 T = pint(datos[2]);
			 country = new int[N*N][N*N];
			 for(int i  = 0 ; i <  N*N ;  i++){
				 for(int j = 0 ; j <  N*N ; j++){
					 country[i][j] = Integer.MAX_VALUE;
				 }
			 }
			 if(  N == 1){
				 country[0][0] =  pint(br.readLine());
			 }else{
			 
				 for(int i = 0 ; i <  N ; i++){
					 datos =  br.readLine().trim().split(" ");
					 for(int j = 0 ; j <  N ; j++){
						 int u =  i*N + j;
						 
						 if((u + 1) % N != 0)		{
							 //System.out.println(u + " " );
							 country[u][u + 1] =  pint(datos[j]);
						 }
						 if((u + 1) % N != 1)		country[u][u - 1] =  pint(datos[j]);
						 if(u < N*N - N ) 	country[u][u + N] =  pint(datos[j]);
						 if(u >= N )		country[u][u - N] =  pint(datos[j]);
						 
					 }
				 }
			 }
			 friends =  new int[F][2];
			 for(int i = 0 ; i <  F ; i++){
				 datos =  br.readLine().trim().split(" ");
				 friends[i][0] =  pint(datos[0]);
				 friends[i][1] =  pint(datos[1]);
			 }
			 
			 /*for(int i = 0; i <  N*N ; i++){
				 System.out.println(Arrays.toString(country[i]));
			 }*/
			 fw =  new int[N*N][N*N];
			 manhDistance = new int[N*N][N*N];
			 manhDistance(N*N , N);
			 
			 solve(country , ++id);
		}
		
	}
	
	
	 

	
	
	public static void solve(int[][] country , int id){
		
		//for(int i = 0 ; i <  N*N ;  i++)System.out.println(Arrays.toString(country[i]));
		for(int k = 0; k <  N*N ;  k++){
			for(int  i = 0 ; i <  N*N ;  i++){
				for(int j = 0 ; j < N*N ; j++){
					if(country[i][k]!= Integer.MAX_VALUE && country[k][j]!= Integer.MAX_VALUE && 
							country[i][k] + country[k][j] < country[i][j] && 
							manhDistance[i][k]  +  manhDistance[k][j] <=  T  ){
						country[i][j] =  country[i][k] + country[k][j];//cpasdfasfd
					}
				}
			}
		}
		//System.out.println("lksdfdsb");
		//for(int i = 0 ; i <  N*N ;  i++)System.out.println(Arrays.toString(country[i]));
		
		int min = Integer.MAX_VALUE;
		int res[] =  new int[N*N];
		
		
		Arrays.fill(res,0);
		for(int j = 0 ; j < F ; j++){
			int u = friends[j][0]*N + friends[j][1];
			country[u][u] = 0;
			//System.out.println(Arrays.toString(country[u]));
			
			for(int i = 0 ; i <  N*N ; i++){
				if( res[i] != Integer.MAX_VALUE){
					if(country[u][i] != Integer.MAX_VALUE){
						res[i] +=   country[u][i];
					}else{
						res[i] =  Integer.MAX_VALUE;
					}
				}
					
			}
		}
		int ci  = 0, cj = 0;
		for(int i = 0 ; i <  N ; i ++){
			for(int j = 0 ;  j  < N ; j++){
				int u = i*N + j;
				min = Math.min(min, res[u]);
			}
		}

		ArrayList<Pair> list =  new ArrayList<Pair>(); 
		int count = 0;
		for(int i = 0 ; i <  N ; i ++){
			for(int j = 0 ;  j  < N ; j++){
				int u = i*N + j;
				if( res[u] == min){
					list.add(new Pair(i ,  j));
				}
			}
		}
		Collections.sort(list);

		
		if(min != Integer.MAX_VALUE)
			System.out.println("Case #"+id+": Selected city ("+list.get(0).i +"," + list.get(0).j + 
					") with minimum cost "+min+".");
		else
			System.out.println("Case #"+id+": Impossible.");
		//System.out.println(Integer.MIN_VALUE);
	}

	private static void manhDistance(int N , int n) {
		
		int fi , ci , fj, cj , u , v;
		for(int i = 0 ; i <  N;  i ++){
			for(int j = 0 ; j <  N ;  j++){
				fi = ( i / n)  ;
				ci = (i %  n) ;
				fj = ( j / n) ;
				cj = ( j % n) ;
				//System.out.println(ci + " " + cj);
				
				manhDistance[i][j] = Math.abs(fi - fj) + Math.abs(ci - cj);
				}
			}
		 /*for(int[] a :  manhDistance){
			 System.out.println(Arrays.toString(a));
		 }*/
		}
	
	
	

}

class Pair implements Comparable<Pair>{
	int i ,  j;
	public Pair(int i , int  j){
		this.i =  i ;
		this.j =  j;
	}
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if( this.i < o.i){
			return -1;
		}else if (this.i == o.i ){
			if(this.j < o.j )return -1;
			else return 1;
		}
		return 0;
	}
}
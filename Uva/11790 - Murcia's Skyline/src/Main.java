import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine().trim());
		String datos[];
		int len []  , wid[] , n ;
		
		for(int i = 0 ; i < cases ; i ++) {
			n = Integer.parseInt(br.readLine().trim());
			datos = br.readLine().trim().split(" ");
			len = new int[n];
			wid = new int[n];
			for(int j = 0 ; j <  n ; j++){
				len[j] = Integer.parseInt(datos[j]);
			}
			datos = br.readLine().trim().split(" ");
			for(int j = 0 ; j <  n ; j++){
				wid[j] = Integer.parseInt(datos[j]);
			}
			solve(len , wid ,  n ,  i + 1);
		}
	}

	private static void solve(int[] len, int[] wid, int n , int caso ) {
		Tupla lis[] = LIS(len , wid, n);
		Tupla lds[] = LDS(len ,  wid ,  n);
		
		
		int a  = Integer.MIN_VALUE, b = Integer.MIN_VALUE ;
		for(int i = 0 ; i < n ; i++){
			a = Math.max(a, lis[i].w);
			b = Math.max(b, lds[i].w);
		}
		if( a >= b){
			System.out.println("Case "+caso+". Increasing ("+a+"). Decreasing ("+b+").");
		}else{
			System.out.println("Case "+caso+". Decreasing ("+b+"). Increasing ("+a+").");
		}
	}
	private static Tupla[] LIS(int[] len, int[] wid, int n){
	Tupla DP[] = new Tupla[n];
			
			int maxLength = 1, bestEnd = 0 , maxWidth = -1;
			DP[0] = new Tupla( 1 , wid[0]);
			//prev[0] = -1;
			for (int i = 1; i < n; i++){
			   DP[i] =new Tupla( 1 , wid[i]);
			   for (int j = i - 1; j >= 0; j--){
			      if ( len[j] < len[i]  &&  DP[j].w  +  wid[i]  >  DP[i].w ){
			         DP[i].h = (DP[j].h) + 1;
			         DP[i].w = (DP[j].w) + wid[i];
			      }
			   }
			}
			return DP;
		}
	private static Tupla[] LDS(int[] len, int[] wid, int n){
		Tupla DP[] = new Tupla[n];	
				int maxLength = 1;
				DP[0] = new Tupla( 1 , wid[0]);
				for (int i = 1; i < n; i++){
				   DP[i] =new Tupla( 1 , wid[i]);
				   for (int j = i - 1; j >= 0; j--){
				      if (len[j] > len[i]  &&  DP[j].w  +  wid[i]  >  DP[i].w ){  
				         DP[i].h = (DP[j].h) + 1;
				         DP[i].w = (DP[j].w) + wid[i];
				      }
				   }
				}
				return DP;
			}
}

class Tupla{
	public int h ,  w;
	public Tupla(int h , int w){
		this.h = h;
		this.w = w;
	}
	
}

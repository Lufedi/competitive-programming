import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;






//Tiempo : 10min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int M , N;
	public static int[][] g;
	public static int INF = Integer.MAX_VALUE - 100;
	public static int[][] mov =  new int[][]{
		 {-1,0}
		,{0,-1},{0,1},{1,0}};
	public static void main(String[] args) throws Exception{
		String linea;
		String[] datos;
		int c,n;
		c = pint(read());
		for(int casos = 0 ; casos  < c ; casos++){
			 M =  pint(read());
			 N =  pint(read());
			 g  =  new int[M][N];
			 for(int i = 0 ; i <  M  ; i++){
				 datos =  read().split(" ");
				 for(int j = 0 ; j < datos.length ;  j++){
					 g[i][j] =  pint(datos[j]);
				 }
			 }
			 
			 solve();
		}
	}
	private static void solve() {
		int vis[] =  new int[M*N];
		Arrays.fill(vis, INF);
		int ini,fin;
		ini =  0;
		fin =  M*N - 1;
		//System.out.println(ini + " " + fin);
		vis[ini] = g[0][0];
		PriorityQueue<Node>  q=  new PriorityQueue<Node>();
		q.add(new Node(g[0][0] , 0 , 0));
		while(!q.isEmpty()){
			Node nodo =  q.poll();
			int d =  nodo.d;
			int i =  nodo.i;
			int j =  nodo.j;
			int ni,nj;
			int u =  i*N+j;
			if(d  > vis[u])continue;
			for(int k = 0 ;  k <  mov.length ;  k++){
				ni =  i + mov[k][0];
				nj =  j + mov[k][1];
				if( ni >= 0 && ni < M && nj >= 0 && nj < N){
					int v =  ni * N + nj;
					if(vis[u]  + g[ni][nj] < vis[v] ){
						vis[v] =  vis[u] + g[ni][nj];
						q.add(new Node(vis[v] ,  ni , nj));
					}
				}
			}
		}
		
		
			System.out.println(vis[fin]);
		
		
	}
}


class Pair{
	int f, s;
	public Pair(int f, int s){
		this.f =  f;
		this.s =  s;
	}
}

class Node implements Comparable<Node>{
	int d, i , j;
	public Node(int d , int i , int j){
		this.d =  d;
		this.i =  i;
		this.j =  j;
	}
	@Override
	public int compareTo(Node b) {
		if(this.d  > b.d) return 1;
		else if(this.d < b.d )return -1;
		else return 0;
		
	}
}
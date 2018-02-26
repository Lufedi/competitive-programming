import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/

public class Main {
	static int graph[][];
	static int cont = 0;
	static int res_g[][];
	
	public static void main(String[] args) throws Exception {
		int s  , t , nedges;
		String linea ,  datos[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine().trim());	
		while( v != 0 ){
			cont ++;
			graph = new int[v][v];
			res_g = new int[v][v];
			for(int i = 0 ;  i <  v ; i++){
				for(int  j = 0 ; j <  v ; j++){
					res_g[i][j] = 0;
					graph[i][j] = 0;
				}
			}

			datos  =  br.readLine().trim().split(" ");
			s = Integer.parseInt(datos[0]);
			t = Integer.parseInt(datos[1]);
			nedges = Integer.parseInt(datos[2]);
			
			for(int i = 0 ; i <  nedges ; i ++){
				datos  =  br.readLine().trim().split(" ");
				graph[Integer.parseInt(datos[0]) -  1][Integer.parseInt(datos[1]) - 1]  +=  Integer.parseInt(datos[2]);
				graph[ Integer.parseInt(datos[1]) - 1 ][Integer.parseInt(datos[0]) -  1] +=  Integer.parseInt(datos[2]);
			}
			
			for(int i = 0 ;  i <  v ; i++){
				for(int  j = 0 ; j <  v ; j++){
					res_g[i][j] = graph[i][j];
				}
			}
			for(int i = 0 ;  i <  v ; i++){
				for(int  j = 0 ; j <  v ; j++)
					System.out.print(res_g[i][j] + " ");				
				System.out.println();
			}
			
			solve(s-1  , t-1 , v);
			
			
			v   =  Integer.parseInt(br.readLine().trim());
			
		}
	}

	private static void solve(int s, int  t  ,  int V) {
		int path[]  = new int[V];
		int u ;
		int max_f = 0;
		int min = Integer.MAX_VALUE;
		
		while( existeResG(s , t ,V , path)){
			
			for(int v = t ; v != s ;v=path[v]){
				u = path[v];
				min = Math.min(min , res_g[u][v]);
				
			}
			
			System.out.print(" "  + t);
			for(int v = t ; v != s ; v = path[v]){
				u = path[v];
				System.out.print(" "  + u);
				res_g[u][v] -= min;
				res_g[v][u] += min;
				
			}
			System.out.println("----------");
			
		max_f += min;	

		for(int i = 0 ;  i <  V ; i++){
				for(int  j = 0 ; j <  V ; j++)
					System.out.print(res_g[i][j] + " ");				
				System.out.println();
			}
		}
		System.out.println("Network " + cont);
		System.out.println("The bandwidth is "+max_f+".");
		System.out.println();


	}

	private static boolean existeResG(int s, int t, int cnodos, int[] path) {
		//System.out.println(" " +  cnodos + " " + t + " " + s);
		boolean visited[] = new boolean[cnodos] ;
		
		for(int i = 0 ;  i <  cnodos ; i++)visited[i] = false;
		visited[s] = true;
		Queue<Integer>  q = new LinkedList<Integer>();
		
		q.add(s);
		path[s] = -1;		
		while(!q.isEmpty()){
			int u =  q.poll();
			for(int  v = 0 ; v < cnodos ; v++){
				if(!visited[v] && res_g[u][v] > 0){
					path[v]  = u;
					q.add(v);
					visited[v] = true;
				}	
			}	
		}
		return visited[t];
	}

}


class Point{
	public int u ,  v ,  f;
	public Point(int u ,  int v , int f){
		this.u = u; this.v  = v ; this.f  =f;
	}
}
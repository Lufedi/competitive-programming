import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	
	
	
	
	public static ArrayList<ArrayList<Pair>> adjList;
	public static ArrayList<Pair>  bridges;
	public static int dfs_low[] ,  dfs_num[] ,  dfsNumberCounter, dfs_parent[]  ;
	public static boolean articulation[];
	public static int dfsRoot , rootChildren ;
	public static int UNVISITED = -1;
	public static int V , E ;
	public static void main(String args[]) throws Exception{
		
		
		BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		String  linea , datos[];
		
		int u , v;
		while(  (V =  Integer.parseInt(br.readLine().trim())) != 0){
			adjList =  new ArrayList<ArrayList<Pair>>();
			for(int i = 0 ;  i < V ;  i++) adjList.add(new ArrayList<Pair>());
			while(  !(linea =  br.readLine().trim()).equals("0") ){
				datos =  linea.split(" ");
				u =  Integer.parseInt(datos[0]);
				for(int i = 1   ; i < datos.length ;  i++){
					v =  Integer.parseInt(datos[i]);
					adjList.get(u - 1).add(new Pair( v - 1 , 0));
					adjList.get(v - 1).add(new Pair(u - 1 , 0));
				}
			}
			solve();
		}
		
		
		
	}
	
	public static void solve(){
		
		
		
		dfs_num =  new int[V]; 
		dfs_low =  new int[V];
		dfs_parent =  new int[V];
		articulation   =  new boolean[V];
		dfsNumberCounter  = 0  ;
		Arrays.fill(dfs_num, UNVISITED); 
		Arrays.fill(dfs_low, 0);
		Arrays.fill(dfs_parent ,  0);
		Arrays.fill(articulation, false);
		bridges =  new ArrayList<Pair>();
		for(int i = 0 ; i <  V ;  i++){
			if(dfs_num[i]  == UNVISITED){
				dfsRoot = i  ;  rootChildren = 0 ;
				articulationBridge(i);
				articulation[dfsRoot]   =  (rootChildren > 1);
			}
		}
		int c = 0;
		for(int i  = 0 ; i <  articulation.length ;  i++)
			if(articulation[i]) c++;
		System.out.println(c);
	}

	private static void articulationBridge(int u) {
		dfs_low[u] =  dfs_num[u] =  dfsNumberCounter++;
		for(int  j = 0 ;  j < adjList.get(u).size() ;  j++){
		Pair v =  adjList.get(u).get(j);
			if(dfs_num[v.first]  == UNVISITED){
				dfs_parent[v.first] = u;
				if(u ==  dfsRoot) rootChildren++;
				
				
				articulationBridge(v.first);
				if(dfs_low[v.first] >= dfs_num[u])
					articulation[u] =  true;
				if(dfs_low[v.first] >  dfs_num[u])
					bridges.add(new Pair(u ,  v.first));
				dfs_low[u] =  Math.min(dfs_low[u] ,  dfs_low[v.first]);
			}else if(v.first !=  dfs_parent[u])
				dfs_low[u] =  Math.min(dfs_low[u] , dfs_num[v.first]);
		}
	}
	

}







class Pair{
	public int  first , second;
	public Pair(int f,  int  s){
		this.first =  f;  this.second  =  s;
	}
}

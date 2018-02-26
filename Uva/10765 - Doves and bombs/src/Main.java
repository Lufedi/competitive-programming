import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	
	
	
	
	public static ArrayList<ArrayList<Pair>> adjList;
	public static ArrayList<Pair>  res;
	public static int dfs_low[] ,  dfs_num[] ,  dfsNumberCounter, dfs_parent[]  ;
	public static boolean articulation[];
	public static int dfsRoot , rootChildren ;
	public static int UNVISITED = -1;
	public static int V , E ;
	public static int nv;
	public static void main(String args[]) throws Exception{
		
		
		BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		String  linea , datos[];
		
		int u , v;
		while( !( linea =  br.readLine().trim()).equals("0 0")){
			adjList =  new ArrayList<ArrayList<Pair>>();
			datos = linea.split(" ");
			V  = Integer.parseInt(datos[0]);
			for(int i = 0 ;  i < V ;  i++) adjList.add(new ArrayList<Pair>());
			while(  !(linea =  br.readLine().trim()).equals("-1 -1") ){
				datos =  linea.split(" ");
				u =  Integer.parseInt(datos[0]);
				v =  Integer.parseInt(datos[1]);
				adjList.get(u).add(new Pair( v , 0));
				adjList.get(v).add(new Pair(u , 0));
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
		res =  new ArrayList<Pair>();
		for(int i = 0 ; i <  V ;  i++){
			if(dfs_num[i]  == UNVISITED){
				dfsRoot = i  ;  rootChildren = 0 ;
				articulationBridge(i);
				articulation[dfsRoot]   =  (rootChildren > 1);
			}
		}
		int c = 0;
		int vis[] =  new int[V];
		Arrays.fill(vis , 0);
		for(int i  = 0 ; i <  articulation.length ;  i++)
			if(articulation[i]){
				int pid  =  calcPid(i);
				res.add(new Pair(i , pid));
			}
		
		for(Pair p : res){
			System.out.println(p.first + " " + p.second);
		}
	}

	private static int calcPid(int i) {
		int res = 0;
		for(int j = 0 ;  j < adjList.get(i).size() ; j++){
			Pair v =  adjList.get(i).get(j);
			nv =   0;
			bfs (v.first);
			if(nv > 0 );
			
		}
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	
	
	
	
	public static ArrayList<ArrayList<Pair>> adjList;
	public static int [][]  adjMat;
	public static int LIM = 2000000000;
	public static ArrayList<Pair>  bridges;
	public static int dfs_low[] ,  dfs_num[] ,  dfsNumberCounter, dfs_parent[]  ;
	public static boolean articulation[];
	public static int dfsRoot , rootChildren ;
	public static int UNVISITED = -1;
	public static int V , E  , cont =  0;
	public static void main(String args[]) throws Exception{
		
		
		
		BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner( new InputStreamReader(System.in));
		String   datos[];
		
		int u , v;
		
		while(sc.hasNext()){
			
			V =  sc.nextInt() + 1;
			adjMat =  new int[V][V];
			for(int i = 0 ;  i < V ; i++)
				for(int j = 0 ;  j < V ;  j++)
					adjMat[i][j] = 0;		
			
			
			for(int i = 0 ;  i < V  - 1 ;  i++){
				//datos = br.readLine().trim().split(" ");
				u =  sc.nextInt();
				String s =  sc.next();
				//System.out.println(s + " " + s.substring(1 ,  s.length() - 1) );
				int c  =   Integer.parseInt(s.substring(1 ,  s.length() - 1));
				if(c > 0){
					for(int j = 0 ;  j < c  ; j++){
						v =  sc.nextInt();
						adjMat[u][v] =  adjMat[v][u] = 1;
					}
				}
			}
			solve();
			cont++;
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
		
		for(Pair a   :  bridges) a.org();
		Collections.sort(bridges);
		
		System.out.println(bridges.size() + " critical links");
		for(int i = 0 ; i <  bridges.size() ;  i++){
			System.out.println(bridges.get(i).first + " - "+ bridges.get(i).second);
		}
		System.out.println();
	}

	

	private static void articulationBridge(int u) {
		dfs_low[u] =  dfs_num[u] =  dfsNumberCounter++;
		int [] vecinos =  adjMat[u];
		
		for(int j = 0 ;  j < vecinos.length ; j++){
		
		if(vecinos[j] != 0){
		Pair v = new Pair(j , 0);
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
	

}


class Pair implements Comparable<Pair>{
	public int  first , second;
	public Pair(int f,  int  s){
		this.first =  f;  this.second  =  s;
	}
	public void org() {
		int aux;
		if(first > second){
			aux =  second; second =  first  ;  first =  aux;
		}
		
	}
	@Override
	public int compareTo(Pair o) {
		if( this.first > o.first) return 1;
		else if( this.first < o.first) return -1;
		else {
			if( this.second > o.second) return  1;
			else return  -1;
		}
	}
}

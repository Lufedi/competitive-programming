import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;


public class Main {

	public static  ArrayList<ArrayList<Pair>> adjList;
	public static  ArrayList<ArrayList<Pair>> adjListT;
	
	public static  ArrayList<Integer >  set ;
	public static  Stack<Integer> S =  new Stack<Integer>();
	public static  int  UNVISITED = 0;
	public static  int dfs_num[];
	
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static ArrayList<ArrayList<Integer>>  g ;
	public static int nodos[];
	
	public static void main(String  args[])  throws Exception{
		
		String linea , datos[];
		int v , e;
		linea = br.readLine().trim();
		while( !linea.equals("0 0")){
			 datos = linea.split(" ");
			 e =  Integer.parseInt(datos[1]);
			 v = Integer.parseInt(datos[0]);
			 adjList =  new ArrayList<ArrayList<Pair>>();
			 for(int i = 0; i <  v ; i++)adjList.add(new ArrayList<Pair>());
			 int dir  , u , q;
			for(int i = 0 ;  i <   e ; i++){
				datos =  br.readLine().trim().split(" ");
				dir = Integer.parseInt(datos[2]);
				u =  Integer.parseInt(datos[0]) - 1;
				q =  Integer.parseInt(datos[1]) - 1;
				adjList.get(u).add(new Pair(q , 0));
				if( dir == 2)adjList.get(q).add(new Pair(u , 0));	
			}
			
			getTranspose(v);
			solve(v);
			 
			linea = br.readLine().trim();
		}
		
	}
	public static void getTranspose(int V){
		ArrayList<Pair>  vecinos ;
		adjListT =  new ArrayList<ArrayList<Pair>>();
		for(int i = 0 ; i <  V ; i++) adjListT.add(new ArrayList<Pair>());
		for (int v = 0; v <  V; v++){
	        vecinos =  adjList.get(v);
	        for( int i = 0 ; i <  vecinos.size() ;  i++)adjListT.get(vecinos.get(i).first).add(new Pair(v , 0));
	    }
	}
	

	public static void kosajaru(int u , int pass){
		//pass = 1 ( original) , pass = 2 (  transverse)
		dfs_num[u] = 1;
		ArrayList<Pair> neighbor;
		if(pass == 1) neighbor = adjList.get(u) ;else  neighbor = adjListT.get(u);
		for(int  j = 0 ; j  < neighbor.size(); j++){
			Pair v = neighbor.get(j);
			if( dfs_num[v.first] ==  UNVISITED){
				kosajaru(v.first ,  pass);
			}
		}
		S.add(u);
	}
	
	
	public static void solve(int  V ){

		S = new Stack<Integer>();
		dfs_num = new int[V];
		for(int  i = 0   ; i  < V ; i++) dfs_num[i] =  UNVISITED;
		for(int i = 0 ; i <  V ;  i++ ){
			if( dfs_num[i] == UNVISITED){
				kosajaru(i , 1);
			}
		}

		

	
		int css = 0;
		for(int  i = 0   ; i  < V ; i++) dfs_num[i] =  UNVISITED;
		for(int i =  V -1 ;  i >=  0 ; i--){
			int nodoExpl = S.get(i);
			
			if(dfs_num[nodoExpl] == UNVISITED){
				css++;
				kosajaru(nodoExpl ,  2);
			}
			
		
		}
		if( css  == 1) System.out.println(1);
		else System.out.println(0);
		
		

	}


}




class Pair{
	public int first, second;
	public Pair(int first, int second){
		this.first = first; this.second = second;
	}
}
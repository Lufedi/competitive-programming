





import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class Main{

	public static  ArrayList<ArrayList<Pair>> adjList;
	public static  ArrayList<ArrayList<Pair>> adjListT;
	public static  Hashtable<String, Integer> dic;
	public static  Hashtable<Integer, String> dic2;
	public static  ArrayList<Integer >  set ;
	public static  Stack<Integer> S =  new Stack<Integer>();
	public static  int  UNVISITED = 0;
	public static  int dfs_num[];


	public static void main(String args[])  throws Exception{
		int V  , E ,  c = 0;
		String datos[] ,  linea;
		
		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		while( !(linea = br.readLine().trim()).equals("0 0")){
			datos = linea.split(" ");
			V  = Integer.parseInt(datos[0]);
			E  = Integer.parseInt(datos[1]);
			adjList =  new ArrayList<ArrayList<Pair>>();
			dic =  new Hashtable<String,  Integer>();
			dic2 =  new Hashtable<  Integer , String>();
			int u  , v;
			for(int i = 0 ; i <  V ; i++) adjList.add(new ArrayList<Pair>());
			for(int i = 0; i  <  E ; i++){
				datos= br.readLine().split(" ");
				if(!dic.containsKey(datos[0])) {
					dic.put(datos[0], dic.size());
					dic2.put(dic.size() - 1, datos[0]);
				}
				
				if(!dic.containsKey(datos[1])) {
					dic.put(datos[1], dic.size());
					dic2.put(dic.size() - 1, datos[1]);
				}
				u  = dic.get(datos[0]);
				v  = dic.get(datos[1]);
				adjList.get(u).add(new Pair(v , 0));
			}
			
			
			
			
			getTranspose(V);
			
			

		/*	for(int i = 0 ; i <  adjList.size() ; i++) {
				System.out.print(" " + i   + " :  ");
				for(int j = 0 ; j <  adjList.get(i).size() ; j++){
					System.out.print( adjList.get(i).get(j).first+" ");
				}
				System.out.println();
			}*/
			solve(V , ++c);
			
			
		}
		
		

		
		
		
			
			
		

	}


	public static void solve(int  V ,  int n){

		S = new Stack<Integer>();
		dfs_num = new int[V];
		for(int  i = 0   ; i  < V ; i++) dfs_num[i] =  UNVISITED;
		for(int i = 0 ; i <  V ;  i++ ){
			if( dfs_num[i] == UNVISITED){
				kosajaru(i , 1);
			}
		}

		

	
		ArrayList<ArrayList<Integer>>  res =  new ArrayList<ArrayList<Integer>>();
		for(int  i = 0   ; i  < V ; i++) dfs_num[i] =  UNVISITED;
		for(int i =  V -1 ;  i >=  0 ; i--){
			int nodoExpl = S.get(i);
			
			if(dfs_num[nodoExpl] == UNVISITED){
	
				set =  new ArrayList<Integer>(); 
				kosajaru(nodoExpl ,  2);
				res.add(set);
				
			}
			
		
		}
		
		if(n >  1) System.out.println();
		System.out.println("Calling circles for data set " + n+ ":");
		for(ArrayList<Integer> r :  res){
			for( int i = 0 ; i <  r.size() ; i++){
				if(i !=  r.size() - 1) System.out.print(dic2.get(r.get(i)) + ", ");
				else System.out.println(dic2.get(r.get(i)));
				
			}
		}
		
		

	}

	public static void kosajaru(int u , int pass){
		//pass = 1 ( original) , pass = 2 (  transverse)
		
		
		dfs_num[u] = 1;
		ArrayList<Pair> neighbor;
		if(pass == 1) neighbor = adjList.get(u) ;else  neighbor = adjListT.get(u);
		if(pass == 2) set.add(u); 
		for(int  j = 0 ; j  < neighbor.size(); j++){
			Pair v = neighbor.get(j);
			if( dfs_num[v.first] ==  UNVISITED){
				kosajaru(v.first ,  pass);
			}
		}
		S.add(u);
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

}

class Pair{
	public int first, second;
	public Pair(int first, int second){
		this.first = first; this.second = second;
	}
}
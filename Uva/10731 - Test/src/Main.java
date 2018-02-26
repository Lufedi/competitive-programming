import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Stack;


public class Main {

	public static  Hashtable<String ,  Integer>  dic ; 
	public static Hashtable<Integer , String>  dic2;
	
	 public static  ArrayList<ArrayList<Pair>> adjList;
	 public static  ArrayList<ArrayList<Pair>> adjListT; 
	 public static  ArrayList<Integer >  set ; 
	 public static  Stack<Integer> S =  new Stack<Integer>();
	 public static  int  UNVISITED = 0;
	 public static  int dfs_num[]; 
	 public static  int contt = 0 ;
	    
	public static void main(String args[]) throws Exception{
		 BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		 String linea ,  datos[];
		 int q;

		 while(  ( q = Integer.parseInt(br.readLine().trim())) !=  0 ){
			 dic =  new Hashtable<String  , Integer>();
			 dic2 =  new Hashtable<Integer , String>();
			 adjList =  new ArrayList<ArrayList<Pair>>();
			 adjListT =  new ArrayList<ArrayList<Pair>>();
			 for(int i = 0 ; i  < q ;  i++){
				 datos  =  br.readLine().trim().split(" ");
				 for(int j = 0 ; j < datos.length - 1 ;  j++){
					 int z  =  dic.size();
					 String s =  datos[j];
					 if(!dic.containsKey(s)){
						
						 dic.put(s, dic.size());
						 dic2.put(z, s);
						 adjList.add(new ArrayList<Pair>());
					 } 
				 }
				 String ans =  datos[datos.length - 1] ;  
				 int andE  = dic.get(ans);
				 for(int  j = 0 ;  j <   datos.length - 1 ;  j++){
					 adjList.get(andE).add(new Pair( dic.get(datos[j]),0));
					
				 }
					 
			 }
			 getTranspose(adjList.size());
			 
			 
			 /*for(int i =  0 ;  i <  adjList.size() ; i++){
				 System.out.print(" " +   i + " : ");
				 for(int  j  =  0  ;  j <  adjList.get(i).size() ;  j++)
					 System.out.print(" "  + adjList.get(i).get(j).first);
				 System.out.println();
			 }*/
			 solve(adjList.size());
			 contt++;
		 }
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
		        
		        ArrayList<ArrayList<String>>  res2 =  new ArrayList<ArrayList<String>>();
		        ArrayList<String> pt;
		        int cont = 0 ;
		        for(ArrayList<Integer> r :  res){
		            res2.add(new ArrayList<String>());
		            pt =  res2.get(res2.size() - 1);
		        	for( int i = 0 ; i <  r.size() ; i++){
		                pt.add( dic2.get(r.get(i)));
		            }	              
		        }		        
		        for(ArrayList<String> r :  res2) Collections.sort(r);
		        ordenar(res2);
		        
		        if(contt > 0) System.out.println();
		        for( ArrayList<String> r :  res2){
		        	for(int  i = 0 ; i <  r.size() ;  i++){
		        		if( i == 0) System.out.print(r.get(i));
		        		else System.out.print(" " + r.get(i)  );
		        	}
		        	System.out.println();
		        }
		        
		    }
		  
		private static void ordenar(ArrayList<ArrayList<String>> res2) {
			ArrayList<String > aux;
			for(int i = 0 ; i <   res2.size() ;  i++){
				for(int  j = 0  ;   j <   res2.size() - 1;  j++){
					if( mayor( res2.get(j) ,  res2.get(j + 1))){
						aux =  new ArrayList<String>(res2.get(j));
						res2.set(j, res2.get(j + 1));
						res2.set(j + 1  , aux);
					}
					
				}
			}
			
		}

	

			private static boolean mayor(ArrayList<String> a,
				ArrayList<String> b) {
			return a.get(0).compareTo(b.get(0)) >= 1 ;
		}

			public static void kosajaru(int u , int pass){
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
	
	


class  Pair implements Comparable<Pair>{
	public int first, second;
	public Pair(int first ,  int second){
		this.first =  first;
		this.second =  second;
	}
	@Override
	public int compareTo(Pair o) {
		if( this.first > o.first) return 1;
		else if( this.first < o.first) return -1;
		else return 0;
	}
}

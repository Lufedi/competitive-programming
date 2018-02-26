import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	
	
	public static ArrayList<ArrayList<Integer>> adjList;
	public static int V , E ;
	public static double vel , seg  , dmax  ,  x  , y  ;
	public static Pair g [],  h[];
	
	public static int[] match ,  vis;
	public static void main(String args[]) throws Exception{
		
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String datos[] ;
		while(br.ready()){
			 datos  =  br.readLine().trim().split(" ");
			 V  = Integer.parseInt(datos[0]);
			 E =  Integer.parseInt(datos[1]);
			 seg = Double.parseDouble(datos[2]);
			 vel = Double.parseDouble(datos[3]);
			 dmax =  vel * seg;
			 dmax = dmax * dmax;
			 g =  new Pair[V];
			 h =  new Pair[E];
			 match   =  new int[V + E];vis =  new int[V];
			
			 adjList =  new ArrayList<ArrayList<Integer>>();
			 for(int i = 0 ; i < V ;  i++) adjList.add(new ArrayList<Integer>());
			 for(int i = 0 ;  i < V ;  i++ ){
				 datos =  br.readLine().trim().split(" "); 
				 g[i] =  new Pair( Double.parseDouble(datos[0]) , Double.parseDouble(datos[1]),i);
			 }
			 for(int i  = 0 ; i < E ;  i++){
				 datos =  br.readLine().trim().split(" ");
				 h[i] =  new Pair(Double.parseDouble(datos[0]) , Double.parseDouble(datos[1])  ,  i + V);
			 }
			
			 
			 for(Pair goh :  g){
				 for( Pair hol :  h){
					 double d =  (goh.f  - hol.f)*(goh.f  - hol.f) + (goh.s - hol.s)*(goh.s  - hol.s)  ;
					// System.out.println(goh.id + " " + hol.id + " " + d);
					 
					 if(dmax  + 0.000000001 >= d ){
						// matAdj[goh.id][hol.id] = 1;
						 adjList.get(goh.id).add(hol.id);
					 }
				 }
			 }
			 
			 
			
			 
			 
			solve();
			
		}
		
	}
	
	public static int Aug(int l){
		if(vis[l] == 1)return 0;
		vis[l] =  1;
		for(int j  = 0 ;  j <  adjList.get(l).size();  j++){
			int r  =  adjList.get(l).get(j);
			
				if(match[r] == -1 || Aug(match[r]) == 1){
					match[r] = 1 ;  return  1;
				
			}
		}
		return  0;
	}
	
	public static void solve(){
		/*
		 for(int i = 0 ; i  < V+E ; i++) {
			 for(int j = 0 ; j < V + E ;  j++){
				 System.out.print(matAdj[i][j]  + " ");
			 }
			 System.out.println();
		 }*/
		 
		 
		int MCBM = 0;
		Arrays.fill(match, -1);
		for(int l = 0 ;  l < V ;  l++){
			Arrays.fill(vis, 0);
			MCBM+= Aug(l);
		}
		System.out.println(V - MCBM);
	}

}


class Pair{
	public double f , s  ;
	public int id;
	public Pair(double f , double s   , int id){this.s = s ; this.f = f; this.id =  id;}
}

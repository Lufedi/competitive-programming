import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;






//Tiempo : 10min


public class Main {
	public static ArrayList<ArrayList<Pair>> g;
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int M , N;
	public static int INF = Integer.MAX_VALUE - 100;
	
	public static void main(String[] args) throws Exception{
		String linea;
		String[] datos;
		int c,n;
		c = pint(read());
		for(int casos = 0 ; casos  < c ; casos++){
			 g =  new ArrayList<ArrayList<Pair>>();
			 datos =  read().split(" ");
			 N =  pint(datos[0]);
			 M =  pint(datos[1]);
			 int ini ,  fin;
			 ini = pint(datos[2]);
			 fin = pint(datos[3]);
			 for(int i = 0 ;  i <  N ;  i++)g.add(new ArrayList<Pair>());
			 
			 for(int i = 0 ; i <  M  ; i++){
				 datos =  read().split(" ");
				 int u , v ,  d;
				 u = pint(datos[0]);
				 v = pint(datos[1]); 
				 d = pint(datos[2]);
				 g.get(u).add(new Pair(d , v)) ;
				 g.get(v).add(new Pair(d , u)) ;
			 }
			 int res = solve(ini ,  fin);
			 
			 System.out.println("Case #" + (casos+1) + ": " + ((res == INF)? "unreachable" :  res));
		}
	}
	private static int solve(int ini , int fin) {
		int vis[] =  new int[N];
		Arrays.fill(vis, INF);
		vis[ini] = 0;
		boolean encontrado =  false;
		PriorityQueue<Pair>  q=  new PriorityQueue<Pair>();
		q.add(new Pair(0 , ini));
		while(!q.isEmpty() ){
			Pair nodo =  q.poll();
			int u =  nodo.s;
			int d =  nodo.f;
			if(d > vis[u])continue;
			for(int i = 0 ;  i < g.get(u).size() ; i++){
				Pair v =  g.get(u).get(i);
				
				if(vis[u]  + v.f < vis[v.s]){
						vis[v.s] =  vis[u] + v.f;
						q.add(new Pair(vis[v.s] ,  v.s));
						
					}
				}
			}
		return vis[fin];
	}
		
		
}



class Pair  implements Comparable<Pair>{
	int f, s;
	public Pair(int f, int s){
		this.f =  f;
		this.s =  s;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.f  >  o.f) return 1;
		else if (this.f < o.f) return -1;
		else return 0;
	}
}


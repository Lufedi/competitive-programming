import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;








/*
 * BFS Usando lista de adyacencia
 */

public class Main {

	public static int INF  = Integer.MAX_VALUE;
	public static void main(String[] args) {
		ArrayList<ArrayList<Pair>> g  = new ArrayList<ArrayList<Pair>>();
		int dist[];
		Queue<Pair> q =  new LinkedList<Pair>();
		dist =  new int[g.size()];
		Arrays.fill(dist, INF);
		while( ! q.isEmpty()){
			Pair  node =  q.poll();
			int u =  node.first;
			ArrayList<Pair> vecinos =  g.get(u);
			for(int i = 0 ; i < vecinos.size(); i++ ){
				Pair v = vecinos.get(i);
				if(dist[v.first] != INF){
					dist[v.first] = dist[u] + 1;
					q.add(v);
				}
				
			}
			
		}
			
		
	}
	
}

class Pair{
	public int first,second;
	public Pair(int first,int second){
		this.first =  first;
		this.second = second;
	}
}

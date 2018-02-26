import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;



public class Prim {
	public static ArrayList<String> sol = new ArrayList<String>();
	
	private static class Graph{
		ArrayList<ArrayList<Edge>> ady = new ArrayList<ArrayList<Edge>>();
		int nodos;
		
		public Graph(int n){
			nodos  = n;
			ady.add( null);
			for(int i = 1 ; i <= n ; i++){
				ady.add(new ArrayList<Edge>());
			}
		}
		public void addEdge(int u , int v , int c){
			ady.get(u).add(new Edge( u , v, c));//ady.get(u - 1).add(v - 1);
			ady.get(v).add(new Edge( v , u, c));
			
			//ady.get(u).add(v);//ady.get(u - 1).add(v - 1);
			//ady.get(v).add(u);
		}		
		public ArrayList<Edge> getEdges(int n) {
			return ady.get(n);
		}
		
		public ArrayList<Integer> getVert(){
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int i =  1; i <= nodos ; i++){
				a.add(i);
			}
			return a;		
		}
		
		
	}
	
	
	private static class Edge implements Comparable<Edge>{
		public int or = -1 , des = -1, cost = -1;
		public Edge(int o , int d , int c){
			or = o;
			des = d;
			cost = c;
		}
		@Override
        public int compareTo(Edge e) {
            if (this.cost < e.cost) return 1;
            if (this.cost > e.cost) return -1;
            return 0;
        }
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(7);
		g.addEdge(1, 2 , 7);
		g.addEdge(1, 5 , 9);
		g.addEdge(2, 5 , 9);
		g.addEdge(2, 3 , 8);
		g.addEdge(2, 4 , 7);
		g.addEdge(3, 4 , 5);
		g.addEdge(5, 4 , 15);
		g.addEdge(5, 6 , 6);
		g.addEdge(4, 6 , 8);
		g.addEdge(4, 7 , 9);
		g.addEdge(6, 7 , 11);
		
		Edge a = new Edge(1,2,3);
		Edge b = new Edge(1,2,4);
		if(a.compareTo(b) < 0){System.out.println("<");};
		
		PriorityQueue<Edge> e = new PriorityQueue<Edge>();
		
		e.addAll(g.getEdges(2));
		while(!e.isEmpty()){
			System.out.println(e.remove().cost);
			
		}
		
		
	}
	
	public void prim(Graph g , int inicio){
		HashSet<Edge> tree = new HashSet<Edge>();
		HashSet<Integer> noRevisados = new HashSet<Integer>();
		PriorityQueue<Edge> edgesAv = new PriorityQueue<Edge>();
		noRevisados.addAll(g.getVert());
		
		
		int vert = inicio;
		while(!noRevisados.isEmpty()){
				
			for(Edge e : g.getEdges(vert)){
				
			}
			
		}
		
		
		
		
	}

}

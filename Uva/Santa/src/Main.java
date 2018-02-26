import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;



public class Main {
	public static ArrayList<String> sol = new ArrayList<String>();
	
	private static class Graph{
		//Implementacion con listas de asyacencia
		ArrayList<ArrayList<Integer>> ady = new ArrayList<ArrayList<Integer>>();
		int nodos;
		
		
		public Graph(int n){
			nodos  = n;
			for(int i = 0 ; i < n ; i++){
				ady.add(new ArrayList<Integer>());
			}
		}
		public void addVert(int u , int v){
			ady.get(u - 1).add(v - 1);
			ady.get(v - 1).add(u - 1);
		}		
		public ArrayList<Integer> getAdd(int n) {
			return ady.get(n - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> marked = new HashSet<String>();
		Graph g = new Graph(5);
		g.addVert(1, 2);
		g.addVert(1, 5);
		g.addVert(1, 3);
		g.addVert(5, 2);
		g.addVert(5, 3);
		g.addVert(5, 4);
		g.addVert(4, 3);
		g.addVert(3, 2);
		
			camino(g, 1 , marked , 0 , "" + 1);
		
		Collections.sort(sol);
		for(String s:sol){
			System.out.println(s);
		}
		
	}

	
	public static void camino(Graph g , int n ,  HashSet<String> marked , int cont , String camino){
		ArrayList<Integer> ad  =  g.getAdd(n);
		
		if(cont == 8){
			sol.add(camino);
		}else{
			for(Integer v:ad){
				String e1 = (n + "")+ ((v + 1) + "");
				String e2 = ((v + 1) + "") + (n + "");
				if(!marked.contains(e1) && !marked.contains(e2)){
					marked.add(e1);
					marked.add(e2);
					camino(g ,v  + 1 ,marked  , cont + 1 , camino + String.valueOf(v  + 1));
					marked.remove(e1);
					marked.remove(e2);
				}
				
			}
		}
	
	}

	
}

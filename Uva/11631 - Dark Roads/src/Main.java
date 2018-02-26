import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
	
	public static void main(String[] args) throws IOException{
	
		
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
	
		String ini[];
		int nodos;
		ini = br.readLine().trim().split(" ");
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		
		while(!ini[0].equals("0")  && !ini[1].equals("0") ){
			
			nodos = Integer.parseInt(ini[0]);
			int ed =  Integer.parseInt(ini[1]);
			
			for(int  i = 0 ; i < ed ; i++){
				ini = br.readLine().trim().split(" ");
				
				edges.add(new Edge(Integer.parseInt(ini[0]) ,  
								   Integer.parseInt(ini[1]) ,
								   Integer.parseInt(ini[2])));
				
				
				
			}
			
			solve(edges , nodos);
			ini = br.readLine().trim().split(" ");
			
		}
		
		
	}

	private static void solve(PriorityQueue<Edge> edges, int nodos) {
		HashSet<Edge> res = new HashSet<Edge>();
		UF a = new UF(nodos);
		int tot = 0;
		int numEd = edges.size();
		for(int i = 0 ; i < numEd ; i++){
			
			Edge e = edges.poll();
			tot += e.peso;
			if( !a.juntos(e.ori, e.des)){
				res.add(e);
				a.union(e.ori, e.des);
			}
		}
		int gas = 0;
		for(Edge e :  res) gas += e.peso;
		System.out.println( tot - gas);
	
		
	}
	
	

	
}


class UF{
	
	int[] conj;
	
	public UF(int nodos){
		conj  = new int[nodos];
		for(int i = 0 ; i <  nodos ; i++) conj[i] = i;
	}	
	public boolean juntos(int nodo1 , int nodo2){
		return conj[nodo1] == conj[nodo2];
	}
	
	
	public void union(int p , int q){
		if(juntos(p , q)) return;
		else{
			int idp = conj[p];
			for(int i = 0 ; i < conj.length ; i++){
				if(conj[i] == idp) conj[i] = conj[q];
			}
		}
	}
}

class Edge implements Comparable<Edge>{
	int ori ,  des , peso;
	public Edge(int ori ,  int des , int peso){
		this.ori = ori;
		this.des = des;
		this.peso = peso;
		
	}
	@Override
	public int compareTo(Edge e) {
		if(this.peso > e.peso) return 1;
		else if(this.peso < e.peso) return  -1;
		else return 0;
	}
	
	public String toString(){
		return "o:" + ori + "d:" + des + "p:" + peso;
	}
	
	
	
}

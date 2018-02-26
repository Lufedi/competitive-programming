
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;


public class Main {
	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*PriorityQueue<Edge> a = new PriorityQueue<Edge>();
		
		for(int i = 0 ; i < 4 ;i++){
			String[] xxy = br.readLine().trim().split(" ");
			int x = (int)(Double.parseDouble(xxy[0]));
			int y = (int)( Double.parseDouble(xxy[1]));
			a.add(new Edge( new Nodo(0 ,0)  , new Nodo(x , y)));
		}
		
		while(a.size()  > 0){
			Edge b = a.poll();
			System.out.println(b.c);
		}
*/		
		
		
		
		
		PriorityQueue<Edge> arcos ;
		String []xy;
		int casos = Integer.parseInt(br.readLine().trim() )  ;
		int dots;
		HashSet<Nodo> nodos  ;
		br.readLine();
		for(int i = 0 ; i <  casos ; i++){
			arcos =  new PriorityQueue<Edge>();
			nodos = new HashSet<Nodo>();
			dots= Integer.parseInt(br.readLine().trim());
			
			for(int j = 0 ; j <  dots ; j++){
				xy = br.readLine().trim().split(" ");
				double x = (Double.parseDouble(xy[0])) ;
				double y = (Double.parseDouble(xy[1])) ;
				
				Nodo v = new Nodo(x , y , j);
				for(Nodo u : nodos){
					arcos.add(new Edge( v , u ));
				}
				nodos.add(v);
			}
			
			 if(i > 0)System.out.println();
			 
			
			 System.out.printf("%.2f", solve(nodos  , arcos));
			 System.out.println();
			 if(i < casos - 1)br.readLine();
		}
		
	}

	private static double solve(HashSet<Nodo> nodos, PriorityQueue<Edge> arcos) {
		
		HashSet<Edge> res = new HashSet<Edge>();
		UF conj = new UF(nodos.size() + 1);
		int n = arcos.size();
		for(int i = 0 ; i < n ; i++){
			Edge min = arcos.poll();
			if(!conj.connected(min.o.id, min.d.id)){
				res.add(min);
				conj.union(min.o.id, min.d.id);
			}	
		}
		double r = 0;
		for(Edge a : res){
			//System.out.println("d:" + a.c + " - "  + a.o + "- "  + a.d);
			r+= a.c;
		}
		return r;
		
	}
	
	

}



class UF{
	
	public int [] conj ;
	public int count;
	public UF(int l){
		count = l;
		conj  = new int[l];
		for(int i = 0 ; i < conj.length ; i++)conj[i] = i;
	}
	
	public int find(int p){
		return conj[p];
	}
	
	public boolean connected(int p , int q){
		return conj[p] == conj[q];
	}
	
	public void union(int p , int q){
		if(connected(p ,q)) return;
		else{
			int idp = conj[p];
			for(int i = 0 ; i < conj.length ; i++){
				if(conj[i] == idp) conj[i] = conj[q];
			}
			count--;
			
		}
	}
	
}



class Nodo{
	
	public double x , y;
	public int id;
	public Nodo(double px , double py , int id){
		this.id = id;
		x = px;
		y = py;
	}
	public String toString(){
		return "x:" + x + "y:" + y ;
	}
	
	
}


class Edge implements Comparable<Edge>{ 
	public  Nodo o;
	public  Nodo d;
	public  double c;
	
	public Edge(Nodo or , Nodo de){
		this.o = or;
		this.d = de;
		c =  (Math.sqrt(Math.pow((de.x - or.x) , 2) + Math.pow((de.y - or.y), 2)));
		
	}

	@Override
	public int compareTo(Edge w) {
		if(c > w.c) return  1;
		else if(c  <  w.c) return -1;
		else  return 0;
	}
	
	
	
}

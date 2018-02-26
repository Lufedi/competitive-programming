import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Hashtable;


public class Main {
	private static class Graph{
		Hashtable<String , ArrayList<String>> ady = new Hashtable<String , ArrayList<String>>();
		int nodos;
		
		
		public Graph(){
			
		}
		
		public void addVert(String u , String v){
			ArrayList<String> tmp = null;
			if(ady.containsKey(u)){
				tmp = ady.get(u);
				tmp.add(v);
				ady.put(u , tmp);

			}else{
				tmp = new ArrayList<String>();
				tmp.add(v);
				ady.put(u , tmp);
			}
			
			
			if(ady.containsKey(v)){
				tmp = ady.get(v);
				tmp.add(u);
				ady.put(v , tmp);

			}else{
				tmp = new ArrayList<String>();
				tmp.add(u);
				ady.put(v , tmp);
			}
		
		}
		
		public int card(){
			return ady.size();
		}

		public ArrayList<String> getAdd(String  n) {
			return  ady.get(n);
		}

	
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int cnt = 0;
		
		while(!line.equals("0")){
			
			int n = Integer.parseInt(line);
			int par = 0;
			String a[];
			while( par != n){
				a = format(line);
				par += contarParejas(a);
				
				
			}
			
		}
		br.close();
		System.exit(0);
	}
	
	

	private static int contarParejas(String[] tm) {
		int c = 0;
		for(int i = 0 ; i < tm.length ; i++){
			if(!tm[i].equals(" ") && !tm[i].equals("")){
				c++;
			}
		}
		return c/2;
		
	}

	private static String ultimaPareja(String[] tm) {
		String p1 =  "";String p2 = "";
		for(int i = tm.length - 1 ; i  >= 0 && (p1.equals("") || p2.equals("")) ; i--){
			if(!tm[i].equals(" ")){
				if(p1.equals(""))p1 = tm[i];
				else p2 = tm[i];
			}
		}
		return p1 + p2;
	}

	public static String[] format(String a){
		
		
		String[] res = a.split(" ");
		
		
		for(int i = 0 ; i < a.length() ; i++){
			
			
		}
		
			
		return null;
		}
	
	private static void solve(int n, String def, String casos, int cnt) {

		
		String[] vert = def.split("   ");

		Graph g;
		g = new Graph();
		String[] tmp ;
		for(int i = 0 ; i <  n ; i++){
			tmp = getPareja(vert[i]);
			g.addVert(tmp[0],tmp[1] );
		}

		
		String[] cases = casos.split("   ");
		solveCasos( n , g , cases , cnt );
		
		
		
		
		
		
	}

	private static String[] getPareja(String s) {
		String [] res =  new String[2];
		String[] t = s.split(" ");
		res[0] = "-1"; res [1] = "-1";
		for(int i = 0 ; i <  t.length ;i++){
			if(!t[i].equals(" ")){
				if(res[0].equals("-1") ) res[0] = t[i];
				else  res[1] = t[i]; 
			}
		}
		
		
		return res;
	}

	private static void solveCasos(int n, Graph g, String[] cases ,  int cont) {
		
		String raiz;
		for(int i = 0 ; i <  cases.length - 1 ; i ++){
			HashSet<String> marked = new HashSet<String>();
			
			String or[] = getPareja(cases[i]);
			
			
			raiz = or[0];
			marked.add(raiz);
			camino(g ,  marked  ,  Integer.parseInt(or[1]) , raiz );
			int res = g.card() - marked.size();
			System.out.println("Case "+(cont + 1)+ ": "+ res + " nodes not reachable from node "+ or[0] + " with TTL = "+
					or[1]+".");
			cont++;
		
		}
		
		
	}
	
	private static void camino(Graph g , HashSet<String> marked , int d , String raiz ){
		
		if(d <= 0){
			return;
			
		}else{
		for(int i = 0 ; i < g.getAdd(raiz).size() ; i++){
			marked.add(g.getAdd(raiz).get(i));
			camino(g ,  marked , d - 1 , g.getAdd(raiz).get(i) );
			
		}
		}
	
		
	}
	
		
	
	

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;



public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int M , N;
	public static ArrayList<ArrayList<Integer>>g1 , g2;
	public static int[][] t1 ,t2;
	public static Hashtable<String , Integer> dic1;
	public static Hashtable<String , Integer> dic2;
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int casos = pint(read());
		
		
		for(int c = 0; c <  casos ;  c++){
			dic1 =  new Hashtable<String, Integer>();
			linea = read();
			//System.out.println("blanco " + linea );
			M =  pint(read());
			g1 =  new ArrayList<ArrayList<Integer>>();
			g2 =  new ArrayList<ArrayList<Integer>>();
			for(int i = 0 ; i <  M ; i++){
				
				int u , v;
				datos =  read().split(" ");
				if(!dic1.containsKey(datos[0])){
					u =  dic1.size();
					dic1.put(datos[0] , dic1.size());
					g1.add(new ArrayList<Integer>());
					
				}else{
					u =  dic1.get(datos[0]);
				}
				if(!dic1.containsKey(datos[1])){
					v =  dic1.size();
					dic1.put(datos[1], dic1.size());
					g1.add(new ArrayList<Integer>());
					
				}else{
					v =  dic1.get(datos[1]);
				}
				//System.out.println(u + "-  "  + v);
				g1.get(u).add(v);
				g1.get(v).add(u);
			}

			t1 =  new int[dic1.size()][dic1.size()];
			for(int i = 0 ; i < g1.size(); i++){
				for(int j = 0 ;  j < g1.get(i).size() ;  j++ ){
					t1[i][g1.get(i).get(j)] = 1;
				}
			}
			N =  pint(read());
			boolean res  =  true;
			int si =  g1.size();
			g1 =  new ArrayList<ArrayList<Integer>>();
			for(int i = 0 ; i < si ;  i++){
				g1.add(new ArrayList<Integer>());
			}
			for(int i = 0 ; i <  N  ; i++){
				int u = 0 , v = 0;
				datos =  read().split(" ");
				if(!dic1.containsKey(datos[0]) || !dic1.containsKey(datos[1])){
					res =  false;
				}
				if( res){
					u =  dic1.get(datos[0]);
					v =  dic1.get(datos[1]);
					g1.get(u).add(v);
					g1.get(v).add(u);
				}
				
				
			}
			t2 =  new int[dic1.size()][dic1.size()];
			for(int i = 0 ; i < g1.size(); i++){
				for(int j = 0 ;  j < g1.get(i).size() ;  j++ ){
					t2[i][g1.get(i).get(j)] = 1;
				}
			}
		
			
			if(res){
				for(int  k = 0 ;  k < dic1.size() ; k++){
					for(int i = 0 ;  i <  dic1.size() ; i++){
						for(int j = 0 ;  j < dic1.size() ;  j++){
							t1[i][j] |=  (t1[i][k] & t1[k][j]);
						}
					}
				}
				
				for(int  k = 0 ;  k < dic1.size() ; k++){
					for(int i = 0 ;  i <  dic1.size() ; i++){
						for(int j = 0 ;  j < dic1.size() ;  j++){
							t2[i][j] |=  (t2[i][k] & t2[k][j]);
						}
					}
				}
				
				for(int i = 0 ; i < dic1.size()  && res;  i++){
					for(int j = 0 ;  j < dic1.size()  && res;  j++){
						if(t1[i][j] != t2[i][j])res =  false;
					}
				}
			}
			if(c > 0)System.out.println();
			System.out.println(((res)?"YES":"NO"));
			
		}
		
		
		
	}
	
	
		
		
	
}
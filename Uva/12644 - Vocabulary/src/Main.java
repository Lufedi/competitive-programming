import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	
	public static int V , C ; 
	public static int vis[] ,  matched[] ; 
	public static ArrayList<ArrayList<Integer>> g;
	public static ArrayList<Palabra>  jack , jill;
	public static void main(String[] args)  throws Exception{
		Scanner sc =  new Scanner(System.in);
		while(sc.hasNext()){
			V =  sc.nextInt(); C = sc.nextInt();
			jack =  new ArrayList<Palabra>();
			jill =  new ArrayList<Palabra>();
			matched =  new int[V + C];
			vis =  new int[V];
			
			for(int i =  0 ;  i <  V ; i++){
				jack.add(new Palabra(sc.next() , i + V));
			}
			for(int i = 0 ;  i < C ;  i++){
				jill.add(new Palabra(sc.next()  , i));
			}
			g =  new ArrayList<ArrayList<Integer>>();
			for(int i = 0 ; i < C  ; i++)g.add(new ArrayList<Integer>());
			for(Palabra sh :  jill){
				for(Palabra sv: jack){
					if(match(sh.w , sv.w)){
						g.get(sh.id).add(sv.id);
						System.out.println("matched "  + sh.w +  sh.id + " " + sv.w + sv.id);
					}
				}
			}
			
			for(ArrayList<Integer> a :g)
				System.out.println(a.toString());
			
			solve();
		}
	}
	public static int Aug(int k){
		if( vis[k] ==  1) return 0;
		vis[k] = 0;
		for(int j = 0 ;  j <  g.get(k).size() ;  j++){
			int r =  g.get(k).get(j);
			if( matched[r] == -1 || Aug(matched[r])== 1){
				matched[r] = k; return 1;
			}
		}
		return 0;
	}
	private static void solve() {
		int MCBM = 0 ; 
		Arrays.fill(matched, -1);
		for(int l = 0 ;  l < C  ;  l++){
			Arrays.fill(vis, 0);
			MCBM+=  Aug(l);
		}
		System.out.println(MCBM);
	}
	private static boolean match(String c , String v){
			 int c1  , c2;
			 char actual;
			 ArrayList<Character> visitados =  new ArrayList<Character>();
			 for(int i = 0 ;  i <  c.length() ;  i++){
				 c1 = c2 = 0;
				 actual =  c.charAt(i);
				 
				 if( !visitados.contains(actual)){
					 
					 visitados.add(actual);
					 //contar en c
					 for(int l = 0 ; l < c.length() ;  l++)
						 if(c.charAt(l) ==  actual)c1++;
					 //contar en v
					 for(int l = 0 ;  l <  v.length() ; l++)
						 if(v.charAt(l) ==  actual)c2++;
					 //System.out.println("Checking " + actual + " " + c1  + " "  + c2);
					 if(  c1 >  c2) return false; 
				 }
			 }
		return true;
	}

}
class Palabra{
	public String w;
	public int id;
	public Palabra(String w , int id) {
		this.w =  w ;  this.id =  id;
	}
}
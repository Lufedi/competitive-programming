
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Hashtable;





public class Main{


	public static Hashtable<Integer ,  Integer> mem;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;


		int n =  Integer.parseInt(br.readLine().trim());
		int g[] = new int[12];
		for(int i = 0 ; i <  n ; i++){
			line = br.readLine();
			for(int j = 0 ; j < 12 ; j++){
				if( line.charAt(j)   == '-')g[j] = 0;
				else g[j] = 1;  
			}
			solve(g);
		}

	}




	public static void solve(int[] g){

		mem = new Hashtable<Integer , Integer>();
		System.out.println(jugar(g));
	}


	public static int jugar(int[] g){
		int key = key(g);
		int res = -1; 
		int mint;
		int ming = Integer.MAX_VALUE;
		int der  = Integer.MAX_VALUE;
		int izq = Integer.MAX_VALUE;
		
		if(mem.containsKey(key)){
			res = mem.get(key);
		}else{

			if( !moves(g)){
				
				res = contar(g);
				
			}else{
				for(int i = 0  ; i < 12 ; i++){
					if(i < 10 && g[i + 1] == 1 && g[i] == 1 && g[i + 2] ==0  ){
						g[i + 1] = 0;
						g[i + 2] = 1;
						g[i]  = 0;
						der = jugar(g)  ;
						g[i]  = 1;
						g[i + 1] = 1;
						g[i + 2] =0;
					}
					if(i >  1 && g[i - 1] == 1 && g[i] == 1  && g[i -2] == 0){
						g[i]  = 0;
						g[i - 1] = 0;
						g[i - 2] = 1;
						izq =  jugar(g);
						g[i]  = 1;
						g[i - 1] = 1;
						g[i - 2] = 0;

					}

					mint = Math.min(  der  , izq );
					ming = Math.min(ming , mint);
				}
				res = ming;
			}
			mem.put(key ,  res);
		}
			return res;
	}


	public static boolean moves(int[] g){
		
		
		for(int i = 1 ; i  <  11 ; i++){
			if(g[i - 1] == 1 && g[i] == 1 && g[i + 1] == 0   ){
				return true;
			} 
			if(  g[i - 1] == 0 && g[i] == 1 && g[i  + 1 ] == 1 ) {
				return true;
			}
		}
		return false;
	}

	public static int contar(int[] g){
		int res = 0;
		for(int i = 0 ; i  < g.length ; i++){
			res+= g[i];
		}
		return res;
	}

	public static int key(int[] g){
		int r = 0;
		for(int i = 0 ; i <  12 ; i++){
			r+= g[i]*i;
		}
		return r;
	}

}
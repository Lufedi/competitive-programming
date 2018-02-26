
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main{


	public static int  m , k ;
	public static int A[];
	public static Hashtable<String , Integer> mem;





	public static void solve(){
		System.out.println("solving...");
		mem = new Hashtable<String , Integer>();
		System.out.println(pi(m , A));

	}



	public static String toKey(int B[]){
		String a  = "";
		for(int i = 0; i <  B.length; i++){
			a+= ("-" + B[i]); 
		}
		return a;
	}

	public static int pi(int ind ,  int B[]){
		/*System.out.println(ind);
		for(int i = 0; i < k ; i++){
			System.out.print(" " + B[i]);
		}
		System.out.println();
		*/

		String key = toKey(B);
		if(mem.containsKey(key)){
			System.out.println(" using rec");
			return mem.get(key);
		}else{
			int s = 0;
			if( ind == 0 ){
				s =  1;
			}else if( ind > 0 ){
			
				for(int i = 0 ; i <  k ; i++){
					if( B[i] > 0) {
						B[i]--;
							s += pi(ind - 1 , B);
						B[i]++;
					}
				}
			}
				mem.put(key , s);
				return s;
		}

		

	}


	public static void main(String[] args) throws Exception{


			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String datos[];
			String linea;
			while(  !( linea  = br.readLine().trim()).equals("0 0") ){
				datos = linea.split(" ");
				m = Integer.parseInt(datos[0]);
				k = Integer.parseInt(datos[1]);
				A = new int[k];
				for(int i = 0; i <  k ; i++){
					A[i] = Integer.parseInt(br.readLine().trim());
				}


				solve( );

			}

			 

	} 





}
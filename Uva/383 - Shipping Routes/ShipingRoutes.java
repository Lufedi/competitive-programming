import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ShipingRoutes {

	private static int n , _ne ,  _nq;
	private static String cadena;
	private static String[]  datos;
	private static int casos ; 
	private static int adMatr[][];
	private static Hashtable<String,  Integer>  dict;
	
	
	public static void query(int weight, int s, int d) {
		
		int vi[] =  new int[n];
		for (int i = 0; i < vi.length; i++) {
			vi[i] =  0;
		}
		
		vi[s] =  1;
 		Queue<Integer >  q =  new LinkedList<Integer>();
		
		
		q.add(s);
		
		
		while(!q.isEmpty()){
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	public static void main(String[]  args)  throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		Scanner sc =  new Scanner(System.in);
		
		//casos = Integer.parseInt(br.readLine().trim());
		casos =  sc.nextInt();
		for (int i = 0; i < casos; i++) {
			
			dict =  new Hashtable<String , Integer>();
			//datos = br.readLine().trim().split(" ");
			//n = Integer.parseInt(datos[0]);
			//_ne  = Integer.parseInt(datos[1]);
			//_nq = Integer.parseInt(datos[2]);
			
			n  =  sc.nextInt();
			_ne =  sc.nextInt();
			_nq =  sc.nextInt();
			
			datos = br.readLine().trim().split(" ");
			for (int j = 0; j < n; j++) {
				dict.put( sc.next(), j);
			}
			
			adMatr  =  new int[n][n];
			String wh1 , wh2;
			for (int j = 0; j < _ne; j++) {	
				 wh1 =  sc.next();
				 wh2 =  sc.next();
				adMatr[dict.get(wh1)][dict.get(wh2)] =  1;
			}
			int weight;
			
			for (int j = 0; j < _nq; j++) {
				  weight =  sc.nextInt();
				  wh1 =  sc.next();
				  wh2 =  sc.next(); 
				  query(weight ,  dict.get(wh1) ,  dict.get(wh2));
			}
		}
		
	}
	
	
	
}

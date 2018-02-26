
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Hashtable;




public class Main{

	public static int monedas[][];
	public static int tabla[][];
	public static Hashtable<String , Integer> mem;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m ,  s ;
		String line;
		String datos[];

		int n =  Integer.parseInt(br.readLine().trim());
		
		for(int i = 0 ; i <  n ; i++){
			datos = br.readLine().trim().split(" ");
			m  = Integer.parseInt(datos[0]);
			s = Integer.parseInt(datos[1]);
			monedas = new int[m][2];
			for(int j = 0 ; j <  m ; j++){
				datos = br.readLine().trim().split(" ");
				monedas[j][0] = Integer.parseInt(datos[0]);
				monedas[j][1] = Integer.parseInt(datos[1]);
			}

			solve(monedas ,  s , m);
			if(i < n -1) br.readLine();
		}



	}


	public static void solve(int[][] monedas , int s , int m){
			mem = new Hashtable<String , Integer>();
		int r = eCoins(0  , 0 , m - 1 , s*s);
	
	
		if( r == Integer.MAX_VALUE)System.out.println("not possible");
		else System.out.println(r);
		

	}

	public static int eCoins(int x , int y , int i ,  int s  ){
		String  key = x + "-"  + y;
		int res = Integer.MAX_VALUE;
		if( mem.containsKey(key)){
			res = mem.get(key);
		}else{
			
			if(i == -1  &&   (x*x+y*y)  != s ){
				res = Integer.MAX_VALUE;
			}else{
					if( x*x + y*y == s ){
						res =   0;
					}else if(x*x  + y*y >  s){
						res = Integer.MAX_VALUE;	
					}else  {
						int b;
						int a = Integer.MAX_VALUE;
						if( ( x + monedas[i][0] ) * ( x  + monedas[i][0]) + 
                        (y + monedas[i][1] )*(y + monedas[i][1] ) <=  s ){
						a = eCoins( x + monedas[i][0]  , y 
                            + monedas[i][1] , i , s   ) ;
						}
						
						if ( a == Integer.MAX_VALUE) b = Integer.MAX_VALUE;
						else b = 1 + a;
						res = Math.min( b ,
										eCoins( x ,  y ,  i - 1 ,  s   ) );
					}
			}

			mem.put(key ,  res);


		}
		
		
		return res;
	}

	

}

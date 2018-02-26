import java.io.BufferedReader;
import java.io.InputStreamReader;


public class NewLotteryGame {
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String datos[] ;
		int casos;
		
		casos = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i <  casos; i++){
			datos = br.readLine().trim().split(" ");
			System.out.println("Case #" + (i+1) + ": "  +solve( Integer.parseInt(datos[0]) , Integer.parseInt(datos[1]),
																Integer.parseInt(datos[2])));
			
		}
	}
	
	
	
	
	public static int solve(int a , int b , int k ){
		int res = 0;
		int m = Math.min(a ,  b);
		int z = Math.max(a, b);
		/*for(int i = 0 ; i <  a ; i++)
			for(int j = 0 ; j < b ; j++){
				//System.out.println("i " + i  +  " j " + j + " " + (i&j)  );
				if( (i&j) <  k)res++;
			
			}*/
		for(int i = 0 ; i <  m ; i++){
			for(int j = i ; i <  m ; i++){
				if( (i&j) <  k)res+=2;
			}
		}
		for(int i = 0 ; i < m  ; i++){
			for(int j = m-1  ; j <  z ; j++){
				if( (i&j) <  k)res++;
			}
		}
		
		return res;
	}

}

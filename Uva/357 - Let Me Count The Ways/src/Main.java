


import java.io.InputStreamReader;
import java.io.BufferedReader;

 

public class Main {

	private static int monedas[] = { 1,5,10,25,50};
	private static long[][] mem;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		
		
		// Precalcular todos los valores 
		int d = 30001;
		mem = new long[2][30001];
		int prev = 0 ,  curr = 1 ,  aux; 
		
		for(int i = 0 ; i <  30001 ; i++){
			mem[prev][i] = 1;
		}
		int n  = 2 ; int c = 0;

		while( n <= 5){
			if( c >  30000){
				n = n + 1 ;
				c = 0;
				aux = prev;
				prev = curr;
				curr = aux;
			}else{
				mem[curr][c] = mem[prev][c];
				if(c >= monedas[n - 1]) mem[curr][c] += mem[curr][c - monedas[n - 1]];
				c++;
			}	
		}
		
		while( (line = br.readLine()) != null){
			solve(Integer.parseInt(line));
		}
		br.close();
		System.exit(0);
	}

	private static void solve(int d) {
		long res = mem[0][d];
		
		if(res > 1)System.out.println("There are "+res+" ways to produce "+(d)+" cents change.");
		else System.out.println("There is only 1 way to produce "+(d)+" cents change.");
			
	}
	
	
	/*private static int f(int n, int d) {
	int res = -1;
	if(d == 0){
		res = 1;
	}else if(n == 0 && d > 0){
		res = 1;
	}else if(n >= 0  && monedas[n] <= d){
		res = f(n ,  d - monedas[n]) + f(n - 1  ,d);
	}else if(n >= 0  && monedas[n] > d){
		res = f(n - 1 , d);
	}
	return res;
	}*/
	
	

}

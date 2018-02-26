


import java.io.InputStreamReader;
import java.io.BufferedReader;

 

public class Test {

	private static int monedas[] = { 5 , 10 , 20 ,50 , 100, 200, 500 ,1000, 2000,5000,10000};
	private static long[][] mem;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		
		
		// Precalcular todos los valores 
		int d = 30001;
		mem = new long[2][30001];
		int prev = 0 ,  curr = 1 ,  aux; 
		
		for(int i = 0 ; i <  30001 ; i++){
			if(i == 0) mem[prev][i] = 1;
			else if(i < 5) mem[prev][i] = 0;
			else if( i % 5 == 0) mem[prev][i] = 1;
			else mem[prev][i] = 0;
			//mem[prev][i] = 1;
			
			
		}
		int n  = 2 ; int c = 0;

		while( n <= 11){
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
	

	
	

}

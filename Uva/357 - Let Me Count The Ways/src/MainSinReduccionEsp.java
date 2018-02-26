


import java.io.InputStreamReader;
import java.io.BufferedReader;

 

public class MainSinReduccionEsp {

	private static int monedas[] = { 1,5,10,25,50};
	private static long[][] mem;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		
		int d = 30001;
		mem = new long[30001][5];
		for(int  j = 0 ; j <  5 ;  j++){
			for(int i = 0  ; i < d  ;  i++ ){
				 if(i == 0 ){
					mem[i][j] = 1; 
				}else if(j == 0 && i > 0){
					mem[i][j] = 1;
				}else if(j >= 0  && monedas[j] <= i){
					mem[i][j] = mem[i -  monedas[j]][j] + mem[i][j - 1];
				}else if(j >= 0  && monedas[j] > i){
					mem[i][j] = mem[i][j - 1];
				}
			}
		}
		
		while( (line = br.readLine()) != null){
			solve(Integer.parseInt(line));
		}
		br.close();
		System.exit(0);
	}

	private static void solve(int d) {
		long res = mem[d][4];
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

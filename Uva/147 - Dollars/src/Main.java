


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

 

public class Main {

	private static int monedas[] = { 5 , 10 , 20 ,50 , 100, 200, 500 ,1000, 2000,5000,10000};
	private static long[] mem;
	public static void main(String[] args) throws Exception{
		
		
		Scanner in = new Scanner(System.in);
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		
		
		// Precalcular todos los valores 
		int d = 30001;
		mem = new long[30001];
		
		
		/*for(int i = 0 ; i <  30001 ; i++){
			
			if( i % 5 == 0){
				
				mem[i] = 1;
			}
			else mem[i] = 0;
			
			
			
		}*/
		
		mem[0] = 1;
		int n  = 0 ; int c = 0;

		while( n < 11){
			if( c >  30000){
				n = n + 1 ;
				c = 0;
			}else{
				if(c >= monedas[n]) mem[c] += mem[c - monedas[n ]];
				c++;
			}	
			
			
		}
		
		while( !(line = br.readLine()).equals("0.00")){
			

			StringBuilder temp = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                    temp.append(line.charAt(i));
                }
            }
           


			solve(temp.toString() ,  line);
		}
		br.close();
		System.exit(0);
	}
	


	private static void solve(String s ,String org) {
               
                                
		int d = Integer.parseInt(s);
		long res = mem[d];

		int esp1 = 6 - s.length();
		int esp2 = 17 - ("" + res).length();
		for(int i = 1 ; i <   esp1 ; i++) System.out.print(" ");
		System.out.print(org);
		for(int j = 0 ; j < esp2 ; j++)System.out.print( " ");
		System.out.println(res);
	}
	
	
	
	

}

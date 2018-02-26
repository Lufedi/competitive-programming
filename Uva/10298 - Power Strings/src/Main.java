


import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
	static Scanner sc = new Scanner(new InputStreamReader(System.in));
	
	
	static String cad ;
	static int[]  div;
	static int len; 
	static int c = 0;
	public static void main(String[] args){
		
		while(!(cad = sc.next()).equals(".")){
			
			len = cad.length();
			div  =  new int[len / 2  + 1];
			c = 0;
			for(int i = 1 ; i <=  len / 2 ; i ++){
				if(len % i == 0){
					div[c] = i;
					c++;
				}
			}
			div[c] = cad.length();
			c++;
			solve();
			
			
			
		}
	}
	private static void solve() {
		boolean found =  false;
		//for(int i = 0 ; i <  c ; i++)System.out.println(div[i]);
		for(int i = c - 1 ;  i >  0 && !found ; i --){
			
			int ind = 0;
			//System.out.println("dic " + div[i]);
			String pat = cad.substring(0, len / div[i]);
			boolean r   =  true;
			//int max = len / div[i];
			int max = pat.length();
			//System.out.println("probando con " + div[i] + "p " + pat); 
			while(r && ind < len){
				
				for(int k = 0 ; k < max ;k++){
					r = r && (pat.charAt(k) == cad.charAt(k + ind));
				}
				if(r){
					ind = ind + max;
				}
			}
			
			
			if(r){
				found  =  true;
				System.out.println(div[i]);
			//	System.out.println( "ind o"   + ind   + " " + div[i]);
			}
		}
		if(!found)System.out.println("1");
	}
	

	
	
}

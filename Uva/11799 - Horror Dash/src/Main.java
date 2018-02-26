import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int cant = 0 ;
			cant =  Integer.parseInt(br.readLine().trim());
			
		for(int  i = 0   ; i < cant ; i++){
			String[] n = br.readLine().trim().split(" ");
			int max = Integer.MIN_VALUE;
			for(int  j = 1 ; j <  n.length ; j ++){
				max = Math.max(max ,  Integer.parseInt(n[j]));
			}
			System.out.println("Case "+ (i + 1) + ": " + max);
		}

	}

}

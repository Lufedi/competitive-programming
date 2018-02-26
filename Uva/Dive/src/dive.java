import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class dive {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String surv[] ;
		String line2[]; 
		
		while(!line.equals(null)){
			line2 = line.split(" ");
			surv = br.readLine().split(" ");
			if( line2[0].equals(line2[1])){
				System.out.println("*");
			}else{
				int[] he = new int[Integer.parseInt(line2[0])];
				
				for(int i = 0 ; i < Integer.parseInt(line2[0]) ; i++){
					he[i] = i + 1;
				}
				solve(he ,  surv);
			}
			 line = br.readLine();
			 
		}
		br.close();
		System.exit(0);
	}
	
	private static void solve(int[] he, String[] surv) {
		int index;
		
		for(int i = 0 ; i <  surv.length ; i++){
			index = Arrays.binarySearch(he, Integer.parseInt(surv[i]));
			he[index] = -1;
		}
		for(int j = 0 ; j  <  he.length ; j++){
			if(he[j] != -1)System.out.print(he[j] + " ");
		}
		System.out.println();
		
		
	}

	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main {
	public static boolean found = false;
	public static LinkedList<Integer> ss = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = 0 , k = 0;
		String []nm = br.readLine().trim().split(" ");
		n = Integer.parseInt(nm[1]);
		k = Integer.parseInt(nm[0]);
		
		int[][] a = new int[k][k];
		
		for(int  i = 0 ; i <  k ; i++){
			for(int  j = 0 ; j < k ; j++){
				
				if(i == j) System.out.print(n);
				else System.out.print(0);
				if(j != k - 1) System.out.print(" ");
			}
			System.out.println();
		}

	}
	
	

}

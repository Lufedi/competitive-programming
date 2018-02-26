import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stairs {

	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cut = n-1;	
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ;  j++){
				if( j < cut) System.out.print(" ");
				else System.out.print("#");
			}
			System.out.println();	
			cut--;
		}
		
	}
}
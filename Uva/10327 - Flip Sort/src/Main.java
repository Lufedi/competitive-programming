import java.util.Scanner;


public class Main {

	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			int n = in.nextInt();
			int A[] = new int[n];
			for(int  i = 0 ; i  < n ; i++){
				A[i] = in.nextInt();
			}
			
			
			solve(A);
		}
	}

	private static void solve(int[] a) {
		int cont = 0;
		for(int i = 0 ; i <  a.length; i++){
			for(int j = i + 1 ; j <  a.length ; j++){
				if(a[i] > a[j]){
					cont ++;
				}
			}
		}
		System.out.println("Minimum exchange operations : " + cont );
		
	}

	

	
}

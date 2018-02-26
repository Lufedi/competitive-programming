import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		while(line != null){
			solve(line.split(" "));
			 line = br.readLine().trim();
		}
		br.close();
		System.exit(0);
	}

	private static void solve(String[] l) {
		long i  = Integer.parseInt(l[0]);
		long j = Integer.parseInt(l[1]);
		
		long aux;
		if(j < i){
			aux = i;
			i = j;
			j = aux;
		}
		
		
		long maxi = Long.MIN_VALUE;
		for(long k = i   ; k <= j ; k++  ){
			
			maxi = Math.max(maxi, cl(k));
		}
		System.out.println(i +" " + j + " " + maxi);
		
	}
	
	public static int cl(long n){
		//System.out.println(n);
		int res = 0;
		
		if(n == 1) res = 1;
		else if( n!= 1 && (n%2) == 0){
		//	System.out.println("par");
			res = 1 + cl(n/2);
		}
		else if(n != 1 && (n%2) != 0){
		//	System.out.println("impar");
			res = 1 + cl(3*n + 1);
		}
		
		return res;
		
	}

}

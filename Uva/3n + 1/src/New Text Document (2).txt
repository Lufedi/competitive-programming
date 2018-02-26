import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while(line != null){
			solve(line.split(" "));
			 line = br.readLine();
		}
		br.close();
		System.exit(0);
	}

	private static void solve(String[] l) {
		long i  = Integer.parseInt(l[0]);
		long j = Integer.parseInt(l[1]);
		Hashtable<Long , Long> mem = new Hashtable<Long , Long>();
		long aux;
		if(j < i){
			aux = i;
			i = j;
			j = aux;
		}
		
		
		long maxi = Long.MIN_VALUE;
		for(long k = i   ; k <= j ; k++  ){
			//System.out.println("k" + k  +"cl"+ cl(k));
			System.out.print("para k = " + k  + " ");
			maxi = Math.max(maxi, cl(k , mem ));
			System.out.println();
		}
		System.out.println(i +" " + j + " " + maxi);
		
	}
	
	public static long cl(long n , Hashtable<Long, Long> mem){
		//System.out.println(n);
		long res = 0;
		
		if(n == 1) res = 1;
		else if( n!= 1 && (n%2) == 0){
		System.out.print(n/2 + " ");
			if(mem.containsKey(new Long( (n/2)))) res = 1 + mem.get(new Long((n/2)));
			else res = 1 + cl(n/2 , mem);
		}
		else if(n != 1 && (n%2) != 0){
		System.out.print((3*n + 1) + " ");
			if(mem.containsKey(new Long(3*n + 1))) res = 1 + mem.get(new Long(3*n + 1));
			else res = 1 + cl(3*n + 1 , mem);
		}
		
		return res;
		
	}

}

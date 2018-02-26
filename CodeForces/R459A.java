import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class R459A {
	
	
	
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)  throws Exception{
		String line, data[];
		
		
		HashSet<Integer> set = new HashSet<>();
		int [] fib = new int [1001];
		fib[0] = 1;
		fib[1] = 1;
		set.add(1);
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i-1] + fib[i-2];
			set.add(fib[i]);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		String res = "";
		for (int i = 0; i < n; i++) {
			if( set.contains(i+1)){
				res+= "O";
			}else{
				res+="o";
			}
		}
		
		
		System.out.println(res);
		
		
		
		
		
		
	}
	
	
	

}

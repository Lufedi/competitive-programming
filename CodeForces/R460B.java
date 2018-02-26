import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class R460B {
	
	

public static int pint(String s ){return Integer.parseInt(s);}
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static boolean[] mark= new boolean[5001];
	public static void main(String[] args)  throws Exception{
		String line, data[];
		
		LinkedList<Integer> perfectNumbers = new LinkedList<Integer>();
		HashSet<Integer> set = new HashSet<>();
		
		int c = pint(br.readLine().trim());
		for (int i = 1; i < 11000000; i++) {
			if( perfectNumbers.size() > 10000){
				break;
			}
			if( isPerfect(i)){
				perfectNumbers.add(i);
			}
		}
		
		System.out.println(perfectNumbers.get(c-1));
		
	}
	
	public static boolean isPerfect(int n){
		String number_s = n + "";
		int sum = 0;
		for (int i = 0; i <  number_s.length(); i++) {
			sum+= number_s.charAt(i)  - '0';
			if( sum > 10){
				return false;
			}
		}
		return sum == 10;
	}

}

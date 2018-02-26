import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ER37 {

	public static int pint(String s ){return Integer.parseInt(s);}
	public static String[] reads() throws Exception{return br.readLine().trim().split(" ");}
	public static String read() throws Exception{return br.readLine().trim();};
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		public static void main(String[] args)  throws Exception{
			String line, data[];
			int cases, n , t, taps[];
			cases = pint(read());
			
			for (int c = 0; c < cases; c++) {
				data = reads();
				n = pint(data[0]);
				t = pint(data[1]);
				
				taps = new int[t];
				data = reads();
				for (int i = 0; i < t; i++) {
					taps[i] = pint(data[i]);
				}
				
				int max_distance = taps[0];
				for (int i = 1; i < taps.length; i++) {
					
						max_distance = Math.max(max_distance, taps[i]- taps[i-1])/2+1;
					
				}
				
			
				if((n+1) - taps[t-1] > max_distance){
				
					max_distance =  (n+1) - taps[t-1];
				}
			
				System.out.println(max_distance);
				
			}
			
			
			
			
			
			
		}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Sweetness  {

	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String data[];
		data = br.readLine().split(" ");
		int n = Integer.parseInt(data[0]);
		int k = Integer.parseInt(data[1]);
		long[] cookies = new long[n];
		data =  br.readLine().split(" ");
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for(int  i = 0 ; i< data.length ; i++){
			cookies[i] = Long.parseLong(data[i]);
			pq.add(cookies[i]);
		}
		
			int count = 0;
			boolean done =  false;
			while(pq.peek() < k && pq.size() > 1){
				long c1 =  pq.poll();
				long c2 = pq.poll();
				pq.add(c1 + ( 2*c2));
				count++;
				
			}
			if( pq.size() == 1 && pq.peek() < k)
				System.out.println(-1);
			else
				System.out.println(count);
		
		
		
		
	
		
	}
	public static boolean valid(PriorityQueue<Long > cookies , int k){
		for(Long i :  cookies){
			if( i < k ){
				return false;
			}
		}
		return true;
	}
}

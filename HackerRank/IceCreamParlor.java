import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IceCreamParlor {

	
	public static void main(String[] args)  throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int c  = 0 ;  c < cases ;  c++){
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			String data[] =  br.readLine().split(" ");
			int nums[] =  new int[n];
			for(int i=0; i < n ; i++){
				nums[i] = Integer.parseInt(data[i]);
			}
			boolean done = false;
			for (int i = 0; i < nums.length && !done; i++) {
				for (int j = i + 1; j < nums.length && !done; j++) {
					if(nums[i] + nums[j] == m){
						System.out.println((i+1) + " " + (j+1));
						done =  true;
					}
				}
			}
		}
		
		
		/*ArrayList<Integer> less = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		ArrayList<Integer> equal = new ArrayList<Integer>();
		boolean pair = (m % 2) == 0;
		int limit = m/2;
		for(int i = 0 ; i < nums.length ; i++){
			if( nums[i] > limit ){
				greater.add(nums[i]);
			}else if(nums[i]< limit){
				less.add(nums[i]);
			}else{
				if(pair){
					equal.add(nums[i]);
				}
			}
		}
		
		System.out.println(limit + " l");
		System.out.println(greater.toString());
		System.out.println(less.toString());
		System.out.println(equal.toString());
		
		if(pair && equal.size() > 1){
			System.out.println(limit + " " + limit);
		}else{
			boolean found =  false;
			for(int i = 0 ; i < greater.size() && !found ; i++){
				for(int j = 0 ; j < less.size() && !found; j++){
					if(greater.get(i) + less.get(j) == m){
						found =  true;
						System.out.println(less.get(j) + " " + greater.get(i));
					}
				}
			}
			
			
			
		}*/
		
		
		
		
		
	}
}
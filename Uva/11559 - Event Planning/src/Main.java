import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null){
			int min = Integer.MAX_VALUE;
			String[] cards = line.trim().split(" ");
			int n = Integer.parseInt(cards[0]);
			int b = Integer.parseInt(cards[1]);
			int h = Integer.parseInt(cards[2]);
			int w = Integer.parseInt(cards[3]);
			
			int p;
			for(int i = 0 ; i <  h ; i ++){
				p = Integer.parseInt(br.readLine().trim());
				String[] bedW = br.readLine().trim().split(" ");
				for(int  j = 0 ; j < bedW.length ; j++){
					if(Integer.parseInt(bedW[j]) >= n  &&  p*n <= b  ){
						min = Math.min(min , p*n);
					}
				}
				
			}
			
			if(min == Integer.MAX_VALUE){
				System.out.println("stay home");
			}else{
				System.out.println(min);
			}
			
			
			
		}
		
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlusMinus {

	
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String data[] = br.readLine().split(" ");
		double pos = 0, neg =0, zer =0;
		for(int i = 0  ; i<  n ; i++){
			int num = Integer.parseInt(data[i]);
			if( num > 0){
				pos++;
			}else if(num < 0){
				neg++;
			}else{
				zer++;
			}
		}
		System.out.println(String.format("%.6f", pos/n).replace(",", "."));
		System.out.println(String.format("%.6f", neg/n).replace(",", "."));
		System.out.println(String.format("%.6f", zer/n).replace(",", "."));
		
		
		
	}
}

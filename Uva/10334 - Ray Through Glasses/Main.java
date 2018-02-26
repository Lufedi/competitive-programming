
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] simple= new BigInteger[1002];
		BigInteger[] mult= new BigInteger[1002];

		simple[0] =  BigInteger.ZERO;
		mult[0]= BigInteger.ONE;
		simple[1]=BigInteger.ONE;
		mult[1]= BigInteger.ONE;
		

		for(int n = 2; n < 1002; n++){
				simple[n] = mult[n-1];
			 
				mult[n] = mult[n-1].add(simple[n-1]);
			}
			
		/*	for(long i=0; i<10; i++) System.out.prlongln(
					simple[i].add(mult[i])			
		);
			
			*/
			
			while( br.ready() ){
				int d = Integer.parseInt(br.readLine().trim());
				BigInteger res =  simple[d];
				res =  res.add(mult[d]);
	
				System.out.println(res);
			}
			br.close();
			System.exit(0);
	}
}

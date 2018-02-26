import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args)throws Exception {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger n  = new BigInteger("0");
		
		String cad = br.readLine().trim();
		while(!cad.equals("0")){
			n = n.add(new BigInteger(cad));
			cad = br.readLine().trim();
		}
		System.out.println(n);
		
		
	}

}

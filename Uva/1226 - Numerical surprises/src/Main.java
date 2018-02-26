
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < cases; i++){
			int n = Integer.parseInt(br.readLine());
			BigInteger p = new BigInteger(br.readLine());
			BigInteger mod = p.mod(BigInteger.valueOf(n));
			System.out.println(mod);
		}
		pw.println();
	}

}
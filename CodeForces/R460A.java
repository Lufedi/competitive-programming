import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class R460A {


public static int pint(String s ){return Integer.parseInt(s);}
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static boolean[] mark= new boolean[5001];
	public static void main(String[] args)  throws Exception{
		String line, data[];
	
		int n , m;
		data = br.readLine().split(" ");
		n = pint(data[0]);
		m  = pint(data[1]);
		
		double minimum = Double.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			data = br.readLine().split(" ");
			double cost = pint(data[0]);
			double quantity = pint(data[1]);
			
			minimum = Math.min(minimum,  ( m * cost) / quantity);
			
		}
		
		DecimalFormat df = new DecimalFormat("#.########");
		String res = df.format(minimum);
		System.out.println(res.replace(',', '.'));
		
		
	}
}

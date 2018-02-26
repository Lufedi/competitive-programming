import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class R459B {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)  throws Exception{
		String line, data[];
		
		
		Hashtable<String, String> dic = new Hashtable<>();
		int n, m;
		data = br.readLine().split(" ");
		n = Integer.parseInt(data[0]);
		m = Integer.parseInt(data[1]);
		
		for (int i = 0; i < n; i++) {
			data = br.readLine().split(" ");
			dic.put(data[1], data[0] );
		}
		
		for (int i = 0; i < m; i++) {
			line = br.readLine();
			data = line.split(" ");
			System.out.println(line + " #" +  dic.get(data[1].substring(0, data[1].length()-1)));
		}				
	}
}

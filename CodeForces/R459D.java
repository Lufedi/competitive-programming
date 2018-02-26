import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class R459D {

public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static boolean[] mark= new boolean[5001];
	public static void main(String[] args)  throws Exception{
		String line, data[];
	
		data  = br.readLine().split(" ");
		
		int V, E;
		V = Integer.parseInt(data[0]);
		E = Integer.parseInt(data[1]);
		char g[][] = new char[100][100];
		char R[][] = new char[V][V];
		for (int i = 0; i < g.length; i++) {
			Arrays.fill(g[i], '-');
		}
		for (int i = 0; i < E; i++) {
			
			data = br.readLine().split(" ");
			int u = Integer.parseInt(data[0]);
			int v = Integer.parseInt(data[1]);
			char d = data[2].charAt(0);
			g[u][v] = d;
		}
		
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R.length; j++) {
				
				
			}
		}
	
	}
	
	

}

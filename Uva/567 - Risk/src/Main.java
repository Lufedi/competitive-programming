import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int INF =  Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		String linea, datos[];
		int c,n;
		int cont = 0;
		while(br.ready()){
			int[][] g =  new int[20][20];
			for(int i = 0 ;  i< 20 ;  i++)Arrays.fill(g[i], INF);
			int u , v;
			for(int i = 0 ; i < 19 ; i++){
				datos =  read().split(" ");
				for(int j = 1;  j <  datos.length ;  j++){
					v =  pint(datos[j]) - 1;
					g[i][v] = 1;
					g[v][i] = 1;
				}
			}
			/*for(int i = 0 ;  i< 20 ;  i++)
				System.out.println(Arrays.toString(g[i]));*/
			for(int k = 0 ; k < 20 ; k++){
				for(int i = 0 ;  i < 20; i++){
					for(int j = 0;  j <  20 ;  j++){
						int r =  Integer.MAX_VALUE;
						if(g[i][k] != Integer.MAX_VALUE && g[k][j] != Integer.MAX_VALUE && g[i][k] + g[k][j] < g[i][j] )
							g[i][j] =  g[i][k] + g[k][j];
					}
				}
			}
			int N =  pint(read());
			System.out.println("Test Set #" + (++cont));
			for(int i = 0 ; i <  N ;  i++){
				datos =  read().split(" ");
				u =  pint(datos[0]); 
				v =  pint(datos[1]);
				if(u  < 10)System.out.print(" ");
				System.out.print(u + " to ");
				if(v < 10)System.out.print(" ");
				System.out.print(v);
				System.out.println(": " + g[u - 1][v - 1]);
			}
			System.out.println();
		}
	}
}

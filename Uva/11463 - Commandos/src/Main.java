import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;






//Tiempo : 10min


public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int M , N;
	public static int[][] g;
	public static int INF = Integer.MAX_VALUE - 100;
	public static int der[], res[];

	public static void main(String[] args) throws Exception{
		String linea;
		String[] datos;
		int c,n;
		c = pint(read());
		for(int casos = 0 ; casos  < c ; casos++){
			N =  pint(read());
			M =  pint(read());
			g =  new int[N][N];
			for(int i =  0 ;  i< N ;  i++)Arrays.fill(g[i], -1);
			int u , v;
			int ini, fin;
			for(int i = 0 ; i <  M ;  i++){
				datos =  read().split(" ");
				u =  pint(datos[0]);
				v =  pint(datos[1]);
				g[u][v] = 1;
				g[v][u] = 1;
			}
			datos =  read().split(" ");
			ini =  pint(datos[0]);
			fin =  pint(datos[1]);
			
			der =  new int[N];
			res =  new int[N];
			Arrays.fill(der, INF);
			
			Arrays.fill(res, INF);
			dfsDer(ini);
			dfsRes(fin);
			//System.out.println(Arrays.toString(der));
			int max =  0;
			for(int i = 0 ; i<  N  ;  i++){
				max =  Math.max(max, der[i]+ res[i]);
			}
			System.out.println("Case " + (casos  + 1) + ": "+ max);
			
		}
	}
	private static void dfsDer(int s) {
		der[s] = 0;
		Queue<Integer> q =  new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()){
			int u =  q.poll();
			for(int i = 0 ; i <  N ;  i++){
				if(g[u][i] == 1){
					//System.out.println("der " + i);
					if(der[i] == INF){
						der[i] =  der[u] + 1;
						q.add(i);
					}
				}
			}
		}
	}
	private static void dfsRes(int s) {
		res[s] = 0;
		Queue<Integer> q =  new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()){
			int u =  q.poll();
			for(int i = 0 ; i <  N ;  i++){
				if(g[u][i] == 1){
					if(res[i] == INF){
						res[i] =  res[u] + 1;
						q.add(i);
					}
				}
			}
		}
	}
}

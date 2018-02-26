import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static HashMap<String,Integer> map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		map = new HashMap<>();
		int cases = 0;
		int[][] mat = new int[51][51];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		while(n!=0 || m!=0){
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = Integer.MAX_VALUE/2;
				}
			}
			stk = new StringTokenizer(br.readLine());
			int cont = 0;
			while(cont!=2*m) {
				if(!stk.hasMoreTokens()){
					stk = new StringTokenizer(br.readLine());
				}
				cont++;
				String uu = stk.nextToken();
				if(!stk.hasMoreTokens()){
					stk = new StringTokenizer(br.readLine());
				}
				cont++;
				String vv = stk.nextToken();
				int u = getNumber(uu);
				int v = getNumber(vv);
				mat[u][v] = 1;
				mat[v][u] = 1;
			}
			//System.out.println("Salimos");
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
					}
				}
			}
			boolean sePuede = true;
			int max = -1;
			for(int i = 0; i < n && sePuede ; i++){
				for (int j = 0; j < n  && sePuede; j++) {
					if(mat[i][j] == Integer.MAX_VALUE/2){
						sePuede = false;
					}else{
						if(i!=j)max = Math.max(max, mat[i][j]);
					}
				}
			}
			
			
			if(sePuede){
				pw.printf("Network %d: %d\n",++cases, max);
			}else{
				pw.printf("Network %d: DISCONNECTED\n",++cases);
			}
			pw.println();
			
			map.clear();
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
		}
		pw.close();
	}

	private static int getNumber(String uu) {
		if(!map.containsKey(uu)){
			map.put(uu, map.size());
		}
		return map.get(uu);
	}

}

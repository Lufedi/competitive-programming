import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




public class Main {
	static Scanner sc =  new Scanner(new InputStreamReader(System.in));
	static char  map[][];
	static int vif[][];
	static int vij[][];
	static int dx[]= {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static Queue<Par> qj ;
	static Queue<Par> qf;
	static int r , c  ,  xj  , yj;
	public static void main(String[] args) throws Exception{	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int casos =  Integer.parseInt(br.readLine().trim());
	String datos[];
	String line;
	boolean jenc =  false;
	for(int i = 0 ;  i <  casos ;  i++){
		
		datos =  br.readLine().trim().split(" ");
		
		r =  Integer.parseInt(datos[0]);
		c =  Integer.parseInt(datos[1]);
		
		map =  new char[r][c];
		vif = new int[r][c];
		vij =  new int[r][c];
		qj =  new LinkedList<Par>();
		qf =  new LinkedList<Par>();
		
		for(int  m=  0 ;  m <  r ; m++){
			for(int n = 0 ;  n  < c ; n++ ){
				vif[m][n] =  Integer.MAX_VALUE;
				vij[m][n] =  Integer.MAX_VALUE;
			}
		}
		
		for(int j = 0 ;  j < r ; j++){
			line = br.readLine().trim();
			
			for(int k = 0  ;  k  < c ;  k++){
				if( !jenc && line.charAt(k) == 'J' ){
					xj =  j;
					yj =  k;
				}
				
				
				if( line.charAt(k) ==  'F'){
					qf.add(new Par(j  , k));
					vif[j][k] = 0;
				}
				
				map[j][k] = line.charAt(k);
			}
		}
		
		
		int res =  solve();
		if(res == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
		else System.out.println(res + 1);
		
		
	}
	}
	private static int solve() {
		
		
	
		
		Par inicio = new Par(xj , yj);
		
		qj.add(inicio);
		vij[xj][yj] = 0;
		
		
		//recorrer el jugador
		while(!qj.isEmpty()){
			Par u =  qj.poll();
			for(int i = 0 ;  i <  4 ;  i++){
				int nx =  u.x + dx[i];
				int ny =  u.y + dy[i];
				
				if( nx >= 0  && nx < r && ny >= 0 && ny < c &&  map[nx][ny]!= '#' &&  vij[nx][ny] == Integer.MAX_VALUE ){
					qj.add(new Par(nx , ny));
					vij[nx][ny] =  vij[u.x][u.y] + 1;
				}
			}
		}
		
		
		
		while(!qf.isEmpty()){
			Par u =  qf.poll();
			for(int i = 0 ;  i <  4 ;  i++){
				int nx =  u.x + dx[i];
				int ny =  u.y + dy[i];
				if( nx >= 0  && nx < r && ny >= 0 && ny < c && map[nx][ny]!= '#' &&   vif[nx][ny] == Integer.MAX_VALUE  ){
					qf.add(new Par(nx , ny));
					vif[nx][ny] =  vif[u.x][u.y] + 1;
				}
			}
		}
		
		int minf = Integer.MAX_VALUE;
		for(int  i = 0 ; i < c ;  i++){
			if( vif[0][i] > vij[0][i] ){
				minf = Math.min(minf, vij[0][i]);
			}
			if( vif[r- 1][i] > vij[r - 1][i] ){
				minf = Math.min(minf, vij[r - 1][i]);
			}
		}
		
		for(int  i = 0 ; i < r ;  i++){
			if( vif[i][0] > vij[i][0] ){
				minf = Math.min(minf, vij[i][0]);
			}
			if( vif[i][c - 1] > vij[i][c - 1] ){
				minf = Math.min(minf, vij[i][c - 1]);
			}
		}
		
		return minf;
	}

}

class Par{
	int x ,  y;
	public Par(int x, int y){
		this.x = x;
		this.y = y;
	}
}

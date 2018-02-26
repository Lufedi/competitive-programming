import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EruptingVolcanes {

	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		int[][] land;
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		String data[];
		int n, c, x , y ,w;
		n = pint(br.readLine());
		c = pint(br.readLine());
		int nx, ny;
		
		int[][] mapa =  new int[n][n];
		for(int i = 0 ; i < c; i++){
			data =  br.readLine().split(" ");
			x = pint(data[0]);
			y = pint(data[1]);
			w = pint(data[2]);
			
			mapa[x][y] = Math.max(mapa[x][y], w);
			for(int offset  = 1 ; offset < w ; offset++){
				for(int j = y-offset ; j <= y+offset ; j++ ){
					
					nx =x - offset;
					ny = j;
					
					if( nx >= 0  && nx < n && ny >= 0 && ny < n)
						mapa[nx][ny] = Math.max(w - offset, mapa[nx][ny] + (w - offset));
				}
				for(int j = y-offset ; j <= y+offset ; j++ ){
					nx =x + offset;
					ny = j;
					if( nx >= 0  && nx < n && ny >= 0 && ny < n)
						mapa[nx][ny] = Math.max(w - offset, mapa[nx][ny] + (w - offset));
				}
				for(int j = x-offset+1 ; j < x+offset; j++ ){
					nx =j;
					ny = y - offset;
					if( nx >= 0  && nx < n && ny >= 0 && ny < n)
						mapa[nx][ny] = Math.max(w - offset, mapa[nx][ny]  + (w - offset));
				}
				
				for(int j = x-offset + 1; j < x +offset ; j++ ){
					nx =j;
					ny = y + offset;
					if( nx >= 0  && nx < n && ny >= 0 && ny < n)
						mapa[nx][ny] = Math.max(w - offset, mapa[nx][ny] + (w - offset));
				}
			}
		}
		
		int res = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				res = Math.max(res, mapa[i][j]);
			}
		}
		System.out.println(res);
		
		/*for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				System.out.print(mapa[i][j] +  " ");
			}
			System.out.println();
		}*/
	}

}

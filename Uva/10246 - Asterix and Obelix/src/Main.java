import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	static int[][] map;
	static int[][] parent;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String line;
		String datos[];
		int cont = 0;
		while( !(line= br.readLine().trim()).equals("0 0 0")){
			datos = line.trim().split(" ");
			int c = Integer.parseInt(datos[0]);
			int s = Integer.parseInt(datos[1]);
			int q = Integer.parseInt(datos[2]);
			
			int[] p_ciu = new int[c];
			map = new int[c][c];
			parent = new int[c][c];
			
			for(int i = 0 ; i <  c ; i++){
				for(int j = 0 ; j < c ; j++){
					if(i!=j)map[i][j] = Integer.MAX_VALUE;
					else map[i][j] = 0;
				}
			}
			
			datos = br.readLine().trim().split(" ");
			for(int i = 0 ; i < datos.length ; i++){
				p_ciu[i] = Integer.parseInt(datos[i]);
			}
			for(int i = 0; i < s ; i++){
				datos = br.readLine().trim().split(" ");
				int u  = Integer.parseInt(datos[0])  - 1;
				int v  =  Integer.parseInt(datos[1])  - 1;
				int w  = Integer.parseInt(datos[2]);
				map[u][v] = w ;
				map[v][u] = w;
			}
			

			solve( p_ciu );

			if(  cont > 0) System.out.println("");
			System.out.println("Case #" + (cont + 1));
			for(int i = 0 ; i < q ;i++){
				datos = br.readLine().trim().split(" ");
				int q1 = Integer.parseInt(datos[0]) - 1;
				int q2 = Integer.parseInt(datos[1])  - 1;
				int r;
				if( map[q1][q2] == Integer.MAX_VALUE || parent[q1][q2] == Integer.MAX_VALUE){
					r = -1;
				}else{
					r = map[q1][q2] + parent[q1][q2];
				}
				System.out.println(r);
			}
			cont++;
			
			
		}
	}




	private static void solve( int[] p_ciu) {
		int l = p_ciu.length;
		

		
		for(int i = 0 ; i < l ;i++)
			for(int j = 0 ; j  < j ;j++)
				parent[i][j] = Integer.MAX_VALUE;



        for(int i = 0 ; i < l;i++){
            for(int j = 0 ;  j< l;j++){
                parent[i][j] = Math.max( p_ciu[i] , p_ciu[j]);
            }
        }
		
		int tem , tem1  ,  tem2,  t1 , t2;


		for(int k = 0 ; k < l ; k++){
			for(int i = 0 ; i < l ;i++){
				for(int j = 0 ; j < l ; j++){
					
					if( map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE )
						tem = Integer.MAX_VALUE;
					else
						tem = map[i][k] + map[k][j];
					tem2 =(parent[i][k]>parent[k][j])?parent[i][k]:parent[k][j];

					if( tem == Integer.MAX_VALUE || tem2 == Integer.MAX_VALUE)
						t1 = Integer.MAX_VALUE;
					else
						t1  = tem + tem2;


					if(map[i][j] == Integer.MAX_VALUE || parent[i][j] == Integer.MAX_VALUE)
						t2  = Integer.MAX_VALUE;
					else
						t2 = map[i][j] + parent[i][j];

					if(t1< t2)
			            {
			                map[i][j]=tem;
			                parent[i][j]=tem2;
			            }
					
				}
			}
		}
		

		for(int k = 0 ; k < l ; k++){
			for(int i = 0 ; i < l ;i++){
				for(int j = 0 ; j < l ; j++){
					
					


					if( map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE )
						tem = Integer.MAX_VALUE;
					else
						tem = map[i][k] + map[k][j];
					tem2 =(parent[i][k]>parent[k][j])?parent[i][k]:parent[k][j];

					if( tem == Integer.MAX_VALUE || tem2 == Integer.MAX_VALUE)
						t1 = Integer.MAX_VALUE;
					else
						t1  = tem + tem2;


					if(map[i][j] == Integer.MAX_VALUE || parent[i][j] == Integer.MAX_VALUE)
						t2  = Integer.MAX_VALUE;
					else
						t2 = map[i][j] + parent[i][j];

					if(t1< t2)
			            {
			                map[i][j]=tem;
			                parent[i][j]=tem2;
			            }
					
				}
			}
		}


		//System.out.println("   "  +   map[q1 - 1][q2 - 1]  + " "  +  parent[q1 - 1][q2 - 1]  + " = " + ( map[q1 - 1][q2 - 1]  +  parent[q1 - 1][q2 - 1])   );
		
	}

}

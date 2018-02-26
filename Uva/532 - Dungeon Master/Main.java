import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Queue;
import java.util.LinkedList;





public class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String datos[];String linea;
		while( !(linea = br.readLine()).equals("0 0 0")){
			datos = linea.trim().split(" ");
			int x ,  y ,  z;
			x = Integer.parseInt(datos[0]);
			y = Integer.parseInt(datos[1]);
			z = Integer.parseInt(datos[2]);
			int c1  = 0, c2  = 0, c3 = 0;
			char dungeon[][][] = new char[x][y][z];
			//System.out.println( "x" + x + " " + y + " "  + z);
			for(int i = 0 ; i < x ; i++){
				for(int j = 0 ; j <  y ; j++){
					linea = br.readLine().trim();
					for(int k = 0 ; k < z ; k++){
					//	System.out.println("k "  + k  + " - " + linea);
						if(linea.charAt(k) == 'S'){
							c1 = i ; c2 = j; c3 = k;
						} 
						dungeon[i][j][k] =  linea.charAt(k);
					}
					
				}
				br.readLine();
			}

			solve(dungeon ,  new Point(c1, c2 , c3) ,  new Point(x , y , z));

		}


	}

	private static void solve(char[][][] dungeon ,  Point inicio ,  Point dim){
		
		int visi[][][] = new int[dim.x][dim.y][dim.z];
		for(int i = 0 ; i <  dim.x   ; i++){
			for(int j = 0 ; j <  dim.y ; j++){
				for(int k = 0 ; k <  dim.z ; k++){
					visi[i][j][k] = - 1;  
				}
			}
		}
		visi[inicio.x][inicio.y][inicio.z]  = 0;
		Queue<Point> q = new LinkedList<Point>();
		int sx  =  inicio.x, sy =  inicio.y , sz = inicio.z;
		boolean found = false;
		q.add(inicio);

		//System.out.println("empezando en " + inicio.x  + " " + inicio.y + " " + inicio.z + " "  + dim.x + " " + dim.y + " " + dim.z);
		while(!q.isEmpty() && !found){
			Point u = q.poll();
			if( u.y < dim.y-1 &&  visi[u.x][u.y + 1][u.z] == -1 && dungeon[u.x][u.y + 1 ][u.z] != '#'){
				if(dungeon[u.x][u.y + 1 ][u.z] == 'E'){
					found = true;
					sx = u.x;sy = u.y + 1;sz = u.z;
				}
				visi[u.x][u.y + 1][u.z] = visi[u.x][u.y][u.z] + 1;
				q.add(new Point(u.x   , u.y + 1, u.z));
			}
			if( u.y >  0  && visi[u.x][u.y - 1][u.z] == -1  && dungeon[u.x][u.y - 1][u.z] != '#'){
				if(dungeon[u.x][u.y - 1 ][u.z] == 'E'){
					sx = u.x;sy = u.y - 1;sz = u.z;
					found = true;
				}
				visi[u.x][u.y - 1][u.z] = visi[u.x][u.y][u.z] + 1;
				q.add(new Point(u.x   , u.y - 1, u.z));
			}

			//System.out.println(" " + u.x + " " +( u.x  - 1) +  " " + visi[u.x  - 1][u.y][u.z]  + " " + (dim.x - 1) +  " " + dungeon[u.x - 1 ][u.y][u.z]  );
			if( u.x >  0  && visi[u.x - 1][u.y][u.z] == -1  && dungeon[u.x - 1][u.y][u.z] != '#'){
				if(dungeon[u.x - 1][u.y][u.z] == 'E'){
					sx = u.x - 1;sy = u.y ;sz = u.z;
					found = true;
				}
				visi[u.x - 1][u.y][u.z] = visi[u.x][u.y][u.z] + 1;
				q.add(new Point(u.x  - 1  , u.y, u.z));
			}
			if( u.x < dim.x - 1  && visi[u.x + 1][u.y][u.z] == -1  && dungeon[u.x + 1][u.y][u.z] != '#'){
				if(dungeon[u.x + 1][u.y][u.z] == 'E'){
					found = true;
					sx = u.x + 1;sy = u.y ;sz = u.z;
				}
				visi[u.x + 1][u.y][u.z] = visi[u.x][u.y][u.z] + 1;
				q.add(new Point(u.x  + 1  , u.y, u.z));
			}
			//System.out.println(" " + u.z + " " +( u.z + 1) +  " " + visi[u.x ][u.y][u.z + 1]  + " " + (dim.z - 1) +  " " + dungeon[u.x ][u.y][u.z + 1]  );
			if( u.z < dim.z - 1  && visi[u.x ][u.y][u.z + 1] == -1  && dungeon[u.x ][u.y][u.z + 1] != '#'){
			//	System.out.println(" " + u.z + " " +( u.z + 1));
				if(dungeon[u.x ][u.y][u.z + 1] == 'E'){
					sx = u.x; sy = u.y; sz = u.z + 1;
					found = true;
				}
				visi[u.x][u.y][u.z + 1] = visi[u.x][u.y][u.z] + 1;
				q.add(new Point(u.x , u.y, u.z + 1));
			}
			if( u.z > 0  && visi[u.x ][u.y][u.z - 1] == -1  && dungeon[u.x ][u.y][u.z - 1] != '#'){
				if(dungeon[u.x ][u.y][u.z -1] == 'E'){
					sx = u.x ;sy = u.y ;sz = u.z - 1;
					found = true;
				}
				visi[u.x][u.y][u.z - 1] = visi[u.x][u.y][u.z] + 1;
				q.add(new Point(u.x  , u.y, u.z - 1));
			}
			/*System.out.println("-------");
			for(Point e : q){
				System.out.println(" " + e);
			}*/
		}
		//System.out.println("escape en el " +  sx +  " " + sy + " " + sz);
		if(found) System.out.println("Escaped in "+visi[sx][sy][sz]+" minute(s)." );
		else System.out.println("Trapped!");
	}
	


}

class Point{
	int x , y , z;
	public Point(int x , int y , int z){
		this.x = x;this.y = y;this.z= z;
	}
	public String toString(){
		return this.x + " " + this.y + " " + this.z;
	}
}
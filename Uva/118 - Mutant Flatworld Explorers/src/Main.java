import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;








public class Main {

	public static int[][] g;
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read()throws Exception{return br.readLine();}
	public static int pint(String s){return Integer.parseInt(s);}
	
	
	
	public static void main(String[] args)  throws Exception{

		String linea , datos[];
		int dir[][] =  new int[][]{{0,-1} , {-1,0} ,{0,1},{1,0}};
		int F, C;
		//while(!br.ready()){
			datos =  read().split(" ");
			F = pint(datos[0]);
			C = pint(datos[1]);
			g =  new int[C+1][F+1];
			for(int[] a : g){
				Arrays.fill(a, 0);
			}
			int x,y;
			int d;
		while(br.ready()){
			datos =  read().split(" ");
			x =  C - pint(datos[1]);
			y =  pint(datos[0]);
			d = direccion(datos[2].charAt(0));
			String mov = read();
			//System.out.println(mov);
			
			//System.out.println( x + "  i " + y);
			boolean desborde =  false;
			int nx = x, ny = y;
			for(int i = 0 ; i <  mov.length()  && !desborde;  i++){
				char m = mov.charAt(i);
				if(m == 'R'||  m == 'L')d =  rotar( m,  d);
				else {
					 nx = x + dir[d][0];
					 ny = y + dir[d][1];
				}
				
				//verificar si hay desborde
				if((nx  < 0 || ny < 0 || nx > C || ny > F) ){
					if(g[x][y] != 3){
						desborde =  true;
						//marcar el desborde
						g[x][y] = 3;
					}
						
					
				}else{
					x = nx;
					y = ny;
				}
				//System.out.println(x + " " + y + " " + estado(d) );
				
			}
			
				System.out.print(y + " " + (C - x) +" " + estado(d));
				if(desborde)System.out.println(" LOST");
				else System.out.println();
			
			
		}
	}
	public static int rotar(char c , int d){
		if(c == 'L'){
			return (d == 0)?3:d-1;
		}else if(c == 'R'){
			return (d == 3)?0:d+1; 
		}else{
			return d;
		}
	}
	
	public static int direccion(char c){
		switch(c){
		case 'W':
			return 0;
		case 'N':
			return 1;
		case 'E':
			return 2;
		case 'S':
			return 3;
		default:
			return 0;
		}
	}
	
	public static char estado(int estado){
		switch(estado){
		case 0:
			return 'W';
		case 1:
			return 'N';
		case 2:
			return 'E';
		case 3:
			return 'S';
		default:
			return 'N';
		}
	}
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;






public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static char mat[][];
	public static int[][] dir=  new int[][]{{0,-1} ,{-1,0} , {0,1} , {1,0}};
	public static int acum ;
	public static void main(String[] args) throws Exception{
	
		int N  , M ,  S;
		
		String linea , datos[];
		while(  !(linea = read()).equals("0 0 0")){
			acum = 0;
			datos =  linea.split(" ");
			N =  pint(datos[0]);
			M =  pint(datos[1]);
			S =  pint(datos[2]);
			mat =  new char[N][M];
			for(int i = 0 ; i <  N ;  i++){
				mat[i] =  read().toCharArray();
			}
			int posi = 0, posj = 0;
			int d = 0;
			
			for(int i =  0; i  <  N ; i++){
				for(int j = 0 ;   j <  M   ; j++){
					if( mat[i][j] == 'N' || mat[i][j] == 'O' || mat[i][j] == 'L' || mat[i][j] == 'S'){
						posi  =  i; posj = j;
						if(mat[i][j] == 'N')d =  1;
						else if(mat[i][j] == 'S') d = 3;
						else if(mat[i][j] == 'L') d =  2;
						else d = 0;
					}
				}
			}
			
			linea =  read();
			//System.out.println(posi + " ini  " + posj + " " + d + " " + linea);
			for(int c  = 0 ;  c  <  linea.length(); c++){
				char cc =  linea.charAt(c);
			
				if(cc == 'D'){
					if(d == 3) d = 0;
					else d++;
				}else if(cc == 'E'){
					if(d == 0)d = 3;
					else d--;
				}else if(cc == 'F'){
					int ni , nj;
					ni = posi +   dir[d][0];
					nj = posj +  dir[d][1];
					//System.out.println(ni + " -- " + nj + " " + d);
					if(ni >= 0 && ni < N  && nj >= 0 && nj < M){
						if(mat[ni][nj] !=  '#'){
							posi =  ni; posj =  nj;
							
							if(mat[ni][nj] == '*'){
								mat[ni][nj] ='.';
								acum++;
							}
						}
					}
				}
				//System.out.println(posi + " " + posj + " " + d);
				
			}
			System.out.println(acum);
		}
	}
	
}

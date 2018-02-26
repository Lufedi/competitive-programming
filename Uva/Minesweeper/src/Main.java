import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dim = br.readLine().trim().split(" ");
		int fil  = Integer.parseInt(dim[0]);
		int col = Integer.parseInt(dim[1]);
		char[][] m ;
		String line;
		int cont = 0;
		while( fil != 0 && col != 0){
			cont ++;
			m = new char[fil][col];
			for(int i = 0 ; i < fil ; i++ ){
				line = br.readLine();
				for(int  j = 0 ; j < col ; j++){
					m[i][j] = line.charAt(j);
				}
			}
			
			solve( m  , fil  , col , cont );
			
			
			 dim = br.readLine().trim().split(" ");
			 fil  = Integer.parseInt(dim[0]);
			 col = Integer.parseInt(dim[1]);
		}

	}

	private static void solve(char[][] m, int fil, int col, int cont) {
		
		char [][] res = new char[fil][col];
		int c = 0;
		
		for(int i = 0 ; i < fil ; i++){
			for(int j = 0 ; j  < col ; j ++){
				if(m[i][j] == '*'){
					res[i][j] = '*';
				}else{
				c = contar( m , i , j , fil ,col);
				res[i][j] = Character.forDigit(c, 10);
				}
			}
		}
		
		if(cont > 1)System.out.println();
		System.out.println("Field #"+cont+":");
		for(int i = 0 ; i < fil ; i++){
			for(int j = 0 ; j  < col ; j ++){
				System.out.print(res[i][j]);
				
			}
			System.out.println();
		}
		
	}

	private static int contar(char[][] m, int i, int j , int fil , int col) {
		
		int sum  = 0;
		if(i > 0){
			if(m[i - 1][j] == '*'){sum ++;}
		}
		if(i > 0 && j  > 0){
			if(m[i - 1][j - 1] == '*'){
				sum++;
			}
		}
		if( i > 0 && j < col - 1){
			if(m[i - 1][j  + 1] == '*'){
				sum++;
			}
		}
		if( i < fil - 1){
			if(m[i + 1][j] == '*'){
				sum++;
			}
		}
		if(i < fil - 1 && j > 0){
			if(m[i + 1][j - 1] == '*'){
				sum++;
			}
		}if(i < fil - 1 && j < col - 1){
			if(m[i  +  1][j + 1] == '*'){
				sum++;
			}
		}
		
		if(j < col -1){
			if(m[i ][j + 1] == '*'){
				sum++;
			}
		}
		if(j  > 0){
			if(m[i ][j - 1] == '*'){
				sum++;
			}
		}
		
		return sum;
	}

}

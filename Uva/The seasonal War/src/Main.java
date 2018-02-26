import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cont = 0;
		String linea = "";
		while(!(linea = br.readLine()).equals("0")){
			cont++;
			int s = Integer.parseInt(linea);
			int [][] m = new int[s][s];
			
			for(int i = 0 ; i <  s ; i++){
				linea = br.readLine();
				//System.out.println(linea);
				for(int j = 0 ; j < s ; j++){
					m[i][j] = Integer.parseInt(linea.charAt(j) +"");
				}
			}
			
			
			solve(m ,  s , cont);
			
		}

		
	}


	public static void solve(int [][] m , int size, int cont){
		
		
		int r = 0;
		
		for(int  i = 0 ; i < size ; i++){
			for(int j = 0 ; j < size ; j++){
				if(m[i][j] == 1){
					m[i][j] = 2;
					r += (buscar(m , size ,  i , j));

				}

			}
		}
	
		
		System.out.println("Image number "+cont+" contains "+r+" war eagles.");
	}

	public static int buscar(int [][] m , int size , int i , int j){

		int r = -1;
		if(i > 0){
			if(m[i - 1][j] == 1){
				m[i - 1][j] = 2;
				r = buscar(m , size , i - 1 , j);
			}
		}

		if(i > 0 && j  > 0){
			if(m[i - 1][j - 1] == 1){
				m[i - 1][j - 1] = 2;
				r = buscar(m , size , i - 1 , j - 1);
			}
		}
		if( i > 0 && j < size - 1){
			if(m[i - 1][j  + 1] == 1){
				m[i - 1][j  + 1] = 2;
				r = buscar(m , size , i - 1 , j  + 1);
			}
		}
		if( i < size - 1){
			if(m[i + 1][j] == 1){
				m[i + 1][j] = 2;
				r = buscar(m , size , i + 1 , j);
			}
		}
		if(i < size - 1 && j > 0){
			if(m[i + 1][j - 1] == 1){
				m[i + 1][j - 1] = 2;
				r = buscar(m , size , i + 1 , j - 1);
			}
		}if(i < size - 1 && j < size - 1){
			if(m[i  +  1][j + 1] == 1){
				m[i  +  1][j + 1] = 2;
				r = buscar(m , size , i  + 1 , j + 1);
			}
		}
		
		if(j < size -1){
			if(m[i ][j + 1] == 1){
				m[i][j + 1] = 2;
				r = buscar(m , size , i , j + 1);
			}
		}
		if(j  > 0){
			if(m[i ][j - 1] == 1){
				m[i ][j - 1] = 2;
				r = buscar(m , size , i  , j - 1);
			}
		}
		
		
		return 1;
		

	}
}


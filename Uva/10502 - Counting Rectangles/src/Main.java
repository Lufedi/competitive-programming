import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int r , c;
		String datos[]   , linea;
		
		c = Integer.parseInt( br.readLine().trim());
		int mat[][];
		while( c != 0){
			r = Integer.parseInt(br.readLine().trim());
			mat = new int[r][c];
			
			for(int i = 0; i <  r ; i++){
				linea = br.readLine().trim();
				for(int j = 0; j <   linea.length() ; j++){
					mat[i][j]  = Integer.parseInt(linea.charAt(j) + "");
				}
			}
			
			
			for(int i = 0; i < r  ; i ++){
				for(int  j = 0 ; j <  c ; j++){
					for(int k = i ; k <  r ; k++){
						for(int l = j ; l <  c  ; l++){
							
							
						}
					}
					
					
				}
			}
			c = Integer.parseInt( br.readLine().trim());
			
		}

	}

}

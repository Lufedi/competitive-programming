import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main {

	
	public static void main (String[] args) throws Exception{
		
		BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		
		String linea = br.readLine().trim();
		String[] datos;
		int N , n;
		char[][] cubG , cubP;
		while(! linea.equals("0 0")){
			datos = linea.split(" ");
			N = Integer.parseInt(datos[0]);
			n = Integer.parseInt(datos[1]);
			cubG = new char[N][N];
			cubP = new char[n][n];
			
			for(int i = 0 ; i <  N  ; i++){
					linea = br.readLine();
					cubG[i] = linea.toCharArray();
			}
			
		
			for(int j = 0 ; j < n ; j++){
					linea = br.readLine();
					cubP[j] = linea.toCharArray();
			}
			
			int cont90 = 0 , cont0 = 0 , cont180 = 0 ,  cont270 = 0;
			//verificar normal
			
			boolean compl ;
			compl = true;
			for(int i = 0 ; i <  N; i++){
				for(int j = 0 ; j < N ; j++){
					
					if(cubG[i][j] == cubP[0][0] && j + n <= N && i + n <= N){
						
						compl =  true;
						for(int k = 0 ; k <  n  && compl; k++){
							for(int l = 0 ; l <  n  && compl; l++){
								if(cubG[k + i ][l + j] != cubP[k][l]){
									compl = false;
								}
							}
						}
						
						if(compl) cont0++;
						
					}
				}
			}
			
			
			// 90
			
			compl = true;
			for(int i = 0 ; i <  N; i++){
				for(int j = 0 ; j < N ; j++){
					
					if(cubG[i][j] == cubP[n - 1][0] && j +  n <= N && i + n <= N){
						compl =  true;
						for(int k = 0 ; k < n    && compl; k++){
							for(int l = n - 1 ; l >= 0 && compl; l--){
								if(cubG[k + i ][j + (n - 1  - l)] != cubP[k][l]){
									compl = false;
								}
							}
						}
						
						if(compl) cont90++;
						
					}
				}
			}
			
			//180
			compl = true;
			for(int i = 0 ; i <  N; i++){
				for(int j = 0 ; j < N ; j++){
					
					if(cubG[i][j] == cubP[n - 1][n  - 1] && j + n <= N && i + n <= N){
						
						
						compl =  true;
						for(int k = n - 1 ; k >= 0   && compl; k--){
							for(int l = n  - 1 ; l >= 0 && compl; l--){
								if(cubG[i + (n - 1  - k) ][j + (n - 1  - l)] != cubP[k][l]){
									compl = false;
								}
							}
						}
						
						if(compl) cont180++;
						
					}
				}
			}
			
			
			//270
			compl = true;
			for(int i = 0 ; i <  N; i++){
				for(int j = 0 ; j < N ; j++){
					
					if(cubG[i][j] == cubP[0][n  - 1] && j + n <= N && i + n <= N){
						
						compl =  true;
						for(int k = n  - 1; k >= 0   && compl; k--){
							for(int l = 0 ; l  <  n && compl; l++){
								if(cubG[i + (n - 1  - k)][l + j] != cubP[k][l]){
									compl = false;
								}
							}
						}
						
						if(compl) cont270++;
						
					}
				}
			}
			
			System.out.println(cont0 + " " + cont90 + " " + cont180 + " " + cont270);
			linea = br.readLine().trim();
			
		}
		
		
		br.close();
		System.exit(0);
	}
	
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea =br.readLine().trim();
		
		while(!linea.equals("0 0 0")){
			
			String[] datos = linea.split(" ");
			
			int w ,  h , n;
			w = Integer.parseInt(datos[0]);
			h = Integer.parseInt(datos[1]);
			n = Integer.parseInt(datos[2]);
			boolean spots[][] = new boolean[w][h];
			for(int i = 0 ; i <  w ; i++){
				for(int j = 0 ; j < h ; j++){
					spots[i][j] = false;
				}
			}
			
			int x1 , y1 , x2 , y2;
			for(int i = 0 ; i < n ; i++){
				
				datos = br.readLine().trim().split(" ");
				x1 = Integer.parseInt(datos[0]);
				y1 = Integer.parseInt(datos[1]);
				x2 = Integer.parseInt(datos[2]);
				y2 = Integer.parseInt(datos[3]);
				
				for(int x = x1 - 1 ; x <  x2 ; x++){
					for(int y = y1 - 1 ; y <  y2 ; y++){
						spots[x][y] = true;
					}
				}
			}
			
			
			int res = 0;
			for(int i = 0 ; i <  w ; i++){
				for(int j = 0 ; j <  h ; j++){
					if( !spots[i][j]) res++;
				}
			}
			
			
			
			
			
			if(res == 0){
				System.out.println("There is no empty spots.");
			}else if(res == 1 ){
				System.out.println("There is one empty spot.");
			}else{
				System.out.println("There are "+res+" empty spots.");
			}
			
			
			linea = br.readLine().trim();
		}
		
		
		br.close();
		System.exit(0);
	}
}

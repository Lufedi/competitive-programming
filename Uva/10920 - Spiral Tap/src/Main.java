import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {

	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String linea;
		linea = br.readLine().trim();
		
		while(!linea.equals("0 0")){
			
			String[] datos = linea.split(" ");
			long N = Long.parseLong(datos[0]);
			long num = Long.parseLong(datos[1]);
			long cont = 1;
			int avance = 1;
			long i  =  N / 2  , j = N / 2;
			boolean orFil = true;
			boolean dir = true;
			boolean seguir = true;
			
			
			while(seguir){
				
				for(int l = 0 ; l < 2  && seguir; l++){
				
						if(orFil){
							if(dir){
								i-= avance;
							}else{
								i+= avance;
							}
							
						}else{
							if(dir){
								j-= avance;
							}else{
								j+= avance;
							}
						}
						cont+= avance;
				
					if(cont >= num){
						long dif = cont - num;
						if(orFil){
							if(dir){
								i+= dif;
							}else{
								i-= dif;
							}
							
						}else{
							if(dir){
								j+= dif;
							}else{
								j-= dif;
							}
						}
						seguir = false;
						
					}
					
					orFil = !orFil;
				}
				dir = !dir;
				avance++;
				
				
			}
			System.out.println("Line = "+(N - i)+", column = "+(j + 1)+".");
			linea = br.readLine().trim();
			
		}
		
		
		br.close();
		System.exit(0);
		
	}
}

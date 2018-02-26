import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		
		
		String linea = br.readLine();
		int h  = 0, u  = 0 , d = 0,f = 0;
		while(linea.charAt(0) != '0'){
		
			String[] datos = linea.split(" ");
			 h = Integer.parseInt(datos[0]);
			 u = Integer.parseInt(datos[1]);
			 d = Integer.parseInt(datos[2]);
			 f = Integer.parseInt(datos[3]);
			 
			 	boolean termino = false;
			 	double ini = 0;
				double dtEsc = u;
				
				double fatiga =  (double) (f  *  u)/100; 

				int dias = 0;
				
				while(ini >= 0 && !termino){
					
					if(dias > 0) dtEsc = dtEsc - fatiga;
					
					if(dtEsc > 0)ini += dtEsc;
					if(ini > h){
						System.out.println("success on day " + (dias + 1));
						termino = true;
					}else if(ini < 0){
						System.out.println("failure on day " + (dias + 1));
						termino = true;
					}else{
						ini -= d;
						if(ini < 0 ) System.out.println("failure on day " + (dias + 1));
					}
					dias ++;
				
					
				}
				linea = br.readLine();
		}
		
		
		
		
		
		
	}
	

}

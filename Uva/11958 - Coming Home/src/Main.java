import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String datos[];
		String linea;
		
		int casos =  Integer.parseInt(br.readLine().trim());
		int currTimeM;
		for(int i = 0 ;  i < casos ; i++){
			
			datos =  br.readLine().trim().split(" ");
			int k =  Integer.parseInt(datos[0]);
			datos =  datos[1].split(":");
			currTimeM = ( 60 *(Integer.parseInt(datos[0])) + Integer.parseInt(datos[1]) );
			
			int min = Integer.MAX_VALUE;
			for(int j = 0 ; j <  k ;  j++){
			datos =  br.readLine().trim().split(" ");
			int c =  Integer.parseInt(datos[1]);
			datos =  datos[0].split(":");
			int minHoraTest =   ( 60 *(Integer.parseInt(datos[0])) + Integer.parseInt(datos[1]) );
			
				if( currTimeM <=  minHoraTest){
					int r =  minHoraTest - currTimeM;
					//System.out.println(r);
					min = Math.min(min ,   r  + c);
				}else{
					min = Math.min( 1440-(currTimeM - minHoraTest) + c , min);
				}
			}
			
			System.out.println("Case "  + ( i + 1) + ": " + min);
		}
		
		
		

	}

}

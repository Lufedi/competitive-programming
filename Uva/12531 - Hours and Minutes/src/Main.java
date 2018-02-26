import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static int[] ang =  new int[]{0,72,144,216,288};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String datos[];
		String linea;
		
		
		while(!br.ready()){
			boolean rta = false;
			int d =  Integer.parseInt(br.readLine().trim());
			for(int i = 1; i  <=  60 && !rta; i++){
				int angH = ( i  * 180)/30;
				for(int j = 1 ;  j <=  5 && !rta ; j++){
					int angM = ang[j % 5];
					if( angH >= angM ) {
						if( d == ( angH - angM) ) rta = true;
					}else{
						
					}
				}
				
			}
		}
		
	}

}

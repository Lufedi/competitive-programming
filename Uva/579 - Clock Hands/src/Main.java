import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String datos[];
			String linea;
			
			while( !(linea = br.readLine()).equals("0:00")){
				datos =linea.split(":");
				int h , m ;
				h = Integer.parseInt(datos[0]); m = Integer.parseInt(datos[1]);
				double angH , angM ;
				
				angH=  a_hora(h, m); angM =  a_min(m);
				
				double res ;
				if(  angH >  angM){
					res =  angH - angM;
					if( res > 180){
						res = (360 - angH) + angM;
					}
				}else{
					res  = angM - angH;
					if( res > 180){
						res = (360 - angM) + angH;
					}
				}
				System.out.printf("%.3f\n" , res );
				
			}
			
			
	}

	private static double a_min(double m) {
		return ( (m*6)/1);
	}

	private static double a_hora(double h, double m) {
		// TODO Auto-generated method stub
		return ((h*90)/3  + (m*30)/60);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;






public class Main {

	
	public static BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int casos;
		double f , land ,  animals ,  friend;
		double total;
		casos =  pint(read());
		for(int i = 0 ; i <  casos ; i++){
			f =  pint(read());
			total = 0;
			for(int j = 0 ; j <  f ;  j++){
				datos =  read().split(" ");
				land =  pint(datos[0]);
				animals =  pint(datos[1]);
				friend = pint(datos[2]);
				total += (( land / animals)*friend)*animals;
				//System.out.println("r : " + ((( land / animals)*friend)*animals));
				
			}
			System.out.println((int)total);
		}
		
	}
	
}

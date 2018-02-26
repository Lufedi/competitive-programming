import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	public static int d , n;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String linea , datos[];
		
		while ( !(linea = br.readLine().trim()).equals("0 0")){
			datos = linea.split(" ");
			n = Integer.parseInt(datos[0]);
			d = Integer.parseInt(datos[1]);
			
			boolean res[] =  new boolean[n];
			Arrays.fill(res, true);
			for(int  i = 0 ; i  <  d ; i++){
				datos = br.readLine().trim().split(" ");
				for(int   j = 0; j <   n ; j++){
					res[j] &= ( datos[j].equals("1"));
				}
			}
			
			boolean found =  false;
			for(int  i = 0 ; i <  n  && !found; i++){
				if(res[i]) found = true;
			}
			System.out.println((found)?"yes":"no");

		}
		
		
	}

}

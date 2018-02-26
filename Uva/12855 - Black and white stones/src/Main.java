import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	
	
	
	
	
	public static void main(String[] args)  throws Exception{
		
		//B/W
		
		BufferedReader br =  new BufferedReader(new InputStreamReader( System.in));
		char[] cad;
		String linea;
		String datos[];
		int a  , b ,  i  ,  j ;
		while( br.ready()){
		
		datos =  br.readLine().trim().split(" ");
		
		a = Integer.parseInt(datos[0]);
		b = Integer.parseInt(datos[1]);
		linea=  br.readLine().trim();
		cad = linea.toCharArray();
		i = 0 ;  j = cad.length - 1;
		
		int res = 0;
		while( i  <  j){
			
			while( cad[i]=='B' && i < cad.length - 1)i++;
			while( cad[j]=='W' && j > 0)j--;
			//System.out.println(i + " " + j +  "  " + ((i+1==j)?a - b:a));
			int ans = (i <  cad.length  - 1 -  j)?1:0;
			int and = ( (a - b) < Math.abs(i - j)*a )?1:0;
					
			i++;
			j--;
		}
		System.out.println(res);
		}
	}
}

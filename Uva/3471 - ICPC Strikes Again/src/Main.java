import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static int  n  , r , q , ini ,fin   ,  mitad;
	public static int cont = 0 ;
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line , datos[];
		
		while( !(line =  br.readLine().trim()).endsWith("0")){
			n  = Integer.parseInt(line);
			r = Integer.parseInt(br.readLine().trim());
			
			int pos[] = new int[n];
			int act[] =  new int[n];
			for(int i = 0 ; i <  n ; i++){
				pos[i] = i;act[i] = i; 
			}
			for(int  i = 0 ; i <  r ; i++){
				
			
				
				 datos =  br.readLine().trim().split(" ");
				 ini = Integer.parseInt(datos[0])  - 1; 
				 fin = Integer.parseInt(datos[1]) - 1;

				
				int mitad  = -1, pasosC = -1;
				int aux1 , aux2;
					
				if( (fin - ini)%2 == 0){
					mitad = (fin + ini)/2 - 1; 
					pasosC = ((fin + ini)/2  - ini)*2;
				}else{
				   mitad = ( fin  +  ini)/2;
				   pasosC = ((fin + ini)/2  - ini + 1)*2 - 1;
				}





							
				//System.out.println( mitad + " " + ini  + " " + fin  + " " + pasosC);
				 for(int  j = 0 ; j <= ( mitad  - ini) ; j++ ){
					 
					 aux1  =  act[ini + j ];
					 aux2 =   act[fin - j ];
					 pos[aux1] += pasosC;
					 pos[aux2] -= pasosC;
					 act[ini + j ]=aux2;
					 act[fin - j] =  aux1;
					 pasosC-= 2;
				 }
				 //System.out.println(Arrays.toString(act));
				 //System.out.println(Arrays.toString(pos));
				 
				

				 
			}
			 q = Integer.parseInt(br.readLine().trim());
				 System.out.println("Genome " + (++cont));
				 for(int  j = 0 ; j < q ; j++){
				 	System.out.println( pos[ Integer.parseInt(br.readLine().trim()) - 1 ] + 1);
				 }
		}
	}
}

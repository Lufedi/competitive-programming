import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

 public class Main{

	public static int  n ,  ptos[] , acum[]  , rango , per;
	public static void main(String[] args)  throws Exception{

		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		// read input
		String line , datos[];
		while( !(line =  br.readLine()).equals("0")){
			n =  Integer.parseInt(line);
			datos  =  br.readLine().trim().split(" ");
			//n =  3;
			//datos = new String[]{"1000" ,"1000" , "1000"};
			ptos =  new int[n];
			Arrays.fill(ptos , -1);
			per  = 0;
			int l;			
			for(int i = 0 ;  i <  n ; i++) {
				l =  Integer.parseInt(datos[i]);				
				ptos[i] =  l;
				per +=  l;
			}
			acum = new int[per];
			Arrays.fill(acum , -1);
			per = 0; 	
			acum[0] = 0;
			for(int i = 0; i  <  n ;  i++){
				acum[per] =  1;
				per += ptos[i];
			}			
			int res = -1;
			
			
			boolean done =  false;
			for(int i = n ; i >=  3 && !done  ; i--){
				if( per % i == 0){
					rango =  (per / i);
					for(int j = 0 ; j <  rango && !done ; j++){
						boolean pos =  true;

						for(int k = j; k <  per  && pos; k= k + rango){
//System.out.println("L : " + (k));
							if(acum[k] == -1) pos =  false;
						}
						if( pos == true){
							res =  i;
							done =  true;
						}	
					}
				}
			}
			if( res != -1)System.out.println(n - res);	
			else System.out.println(res);

		}

		
	
	}


}

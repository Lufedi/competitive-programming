import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;






public class Main {

	
	public static BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int casos;
		double f , land ,  animals ,  friend;
		double total;
		String cad;
		int a ,  b;
		int unos[] , ceros[];
		int min, max;
		int cont = 0;
		while(br.ready()){
			cad =  read();
			unos =  new int[cad.length() + 1];
			
			Arrays.fill(unos, 0);
			
			for(int i =  1 ;  i <  unos.length ; i++){
				
				 unos[i] =  unos[i - 1] + ((cad.charAt(i - 1) == '1')?1:0);
			}
			
			//System.out.println(Arrays.toString(unos));
			casos =  pint(read());
			System.out.println("Case " + (++cont) + ":");	
			for(int i =  0;  i <  casos ;  i++ ){
				datos =  read().split(" ");
				a =  pint(datos[0]) + 1;
				b =  pint(datos[1]) + 1;
				min =  Math.min(a, b);
				if(min != 0)min =  min - 1;
				
				max =  Math.max(a, b);
				
				if( unos[min] == unos[max] ){
					
						System.out.println("Yes");
				}else{
					if(unos[max]  - unos[min] == max - min){
						System.out.println("Yes");
					}else{
						System.out.println("No");
					}
				}
			}
			
		}
		
	}
	
}

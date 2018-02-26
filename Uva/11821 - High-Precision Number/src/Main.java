import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int cant =  pint(read());
		
		BigDecimal  s ;
		for(int c = 0 ; c < cant ;  c++){
			s = new BigDecimal("0");
			while(!(linea =  read()).equals("0")){
				s = s.add(new BigDecimal(linea));
			}
			String res = s.toString();
			
			datos = res.split("\\.");
			int liminf , limsup;
			
			if(datos.length  > 1){
				limsup = 0;
				liminf = 0;
				boolean borrar =  true;
				for(int i = datos[1].length() - 1 ; i >=  0 && borrar ; i--){
					if( datos[1].charAt(i) != '0'){
						liminf = i+1;
						borrar =  false;
					}
				}
				//System.out.println(limsup + " " + liminf);
				datos[1] = datos[1].substring(limsup , liminf);
				if( Math.abs(limsup - liminf) == 0)res =  datos[0] + datos[1];
				else res = datos[0] + "." + datos[1];
			}
			
			System.out.println(res);
		}
		
	}
}

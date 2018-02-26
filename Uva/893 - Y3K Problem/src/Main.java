import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;


public class Main {
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String datos[] ;  String linea ;
		
		while(  !(linea  = br.readLine().trim()).equals("0 0 0 0" )){
			datos =  linea.split(" ");
			GregorianCalendar a = new GregorianCalendar(
					Integer.parseInt(datos[3]) , 
					Integer.parseInt(datos[2])-1, 
					Integer.parseInt(datos[1])
					);
			

			a.add(a.DATE, Integer.parseInt(datos[0]));
			System.out.println(
					a.get(a.DAY_OF_MONTH) + " " + 
			(a.get(a.MONTH) +1) + 
			" " + a.get(a.YEAR)
						  
					);
			
		}
		
		
	}

}

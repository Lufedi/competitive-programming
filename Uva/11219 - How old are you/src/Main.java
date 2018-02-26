import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int cant =  pint(read());
		GregorianCalendar date1;
		GregorianCalendar date2;
		for(int c = 0 ; c <  cant ; c++){
			read();
			linea = read();
			datos = linea.split("/");
			date1 = new GregorianCalendar(pint(datos[2]) , pint(datos[1]) , pint(datos[0]));
			linea = read();
			datos = linea.split("/");
			date2 = new GregorianCalendar(pint(datos[2]) , pint(datos[1]) , pint(datos[0]));
			/*long l1 ,l2;
			l1 = date1.getTimeInMillis();
			l2 = date2.getTimeInMillis();
			long res = l1 - l2;
			if( l1 - l2  < 0)System.out.println("Case #" + (c + 1) + ": Invalid birth date");
			else{
				int diffDays = Math.round((float)res / (24* 1000 * 60 * 60));
				int years =  diffDays/365;
				if(years > 130 )System.out.println("Case #" + (c + 1) + ": Check birth date");
				else System.out.println(years);
			}*/
			
			int age = date1.get(Calendar.YEAR) - date2.get(Calendar.YEAR);
			
				if (date1.get(Calendar.MONTH) < date2.get(Calendar.MONTH)) {
					  age--;  
					} else if (date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH)
					    && date1.get(Calendar.DAY_OF_MONTH) < date2.get(Calendar.DAY_OF_MONTH)) {
					  age--;  
					}
				if( age < 0 )
					System.out.println("Case #" + (c + 1) + ": Invalid birth date");
				else if(age > 130 )
					System.out.println("Case #" + (c + 1) + ": Check birth date");
				else 
					System.out.println("Case #" + (c + 1) + ": " + age);
			
			
		}
		
	}
}

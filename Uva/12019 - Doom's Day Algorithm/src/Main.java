import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;


public class Main {
	
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String datos[] ;  String linea ;
		int m , d;
		int casos =  Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < casos ; i++){
			datos = br.readLine().trim().split(" ");
			m =  Integer.parseInt(datos[0]);
			d = Integer.parseInt(datos[1]);
			GregorianCalendar a  =  new GregorianCalendar(2011, (m-1), d);
			System.out.println(getDay(a.get(a.DAY_OF_WEEK) - 1));
			
		}
		
	}

	private static String getDay(int i) {
		switch(i){
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "Saturday";
		}
	}

}

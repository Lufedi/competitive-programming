import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String datos[];
		String linea;
		
		
		int casos = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0 ; i  < casos ; i++){
			
			linea =  br.readLine().trim();
			int mm , dd , yy ;
			
			
			GregorianCalendar a =  new GregorianCalendar(

					Integer.parseInt(linea.substring(4, 8)),
					
					Integer.parseInt(linea.substring(0, 2))-1	,
					Integer.parseInt(linea.substring(2, 4))
					);
			a.add(a.DATE, (7*40));
			mm = a.get(a.MONTH) ;  dd = a.get(a.DAY_OF_MONTH);
			System.out.println((i + 1) + " "  +fix(a.get(a.MONTH) + 1)+
					"/"+  fix(a.get(a.DAY_OF_MONTH))+"/"+a.get(a.YEAR)+ " " +  signo(mm , dd));
			
			
		}
		
	}

	private static String fix(int i) {
		if( i< 10 ){
			return "0"+(i);
		}else{
			return (i)+"";
		}
	}

	private static String signo(int mm, int dd) {

		if( ( mm == 0  && dd >= 21) ||   (mm == 1 && dd <=19 )) return "aquarius";
		if(  (mm == 1 && dd >= 20) || (mm == 2 && dd <=20 )) return "pisces";
		if( (mm == 2 && dd >= 21) || (mm == 3 && dd <=20 )) return "aries";
		if( (mm == 3 && dd >= 21) || (mm == 4 && dd <=21 )) return "taurus";
		if( (mm == 4 && dd >= 22) || (mm == 5 && dd <=21 )) return "gemini";
		if( (mm == 5 && dd >= 22) || (mm == 6 && dd <=22 )) return "cancer";
		if( (mm == 6 && dd >= 23) || (mm == 7 && dd <=21 )) return "leo";
		if( (mm ==7 && dd >= 22) || (mm == 8 && dd <=23 )) return "virgo";
		if( (mm == 8 && dd >= 24) ||(mm == 9 && dd <=23 )) return "libra";
		if( (mm ==9 && dd >= 24) || (mm == 10 && dd <=22 )) return "scorpio";
		if( (mm ==10 && dd >= 23) || (mm == 11 && dd <=22 )) return "sagittarius";
		if( (mm == 11&& dd >= 23) || (mm == 0 && dd <=20 )) return "capricorn";
		return "null"; 
			
	}

}

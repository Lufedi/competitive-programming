import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;


public class Main {

	
	public static void main (String [] args)  throws Exception{
	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	
	String datos[] ;  String linea ;
	
		int casos = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ; i < casos ; i++){
			datos =  br.readLine().split("-");
			int diasAdd  =  Integer.parseInt(br.readLine().trim());
			
			GregorianCalendar a = new GregorianCalendar( Integer.parseInt(datos[0]) ,
					getMonthNum(datos[1]) , 
					Integer.parseInt(datos[2]));
			a.add(a.DATE, diasAdd);

			System.out.println(
					"Case " +  (i + 1) + ": " + a.get(a.YEAR) + "-"+ getMonthString(a.get(a.MONTH)) + "-"+fix(a.get(a.DAY_OF_MONTH))
					);
				
			
		}
		
	}
	
	
	
	private static String getMonthString(int i) {
		switch(i){
		case 0:
			return "January";
		case 1:
			return "February";
		case 2:
			return "March";
		case 3:
			return "April";
		case 4:
			return "May";
		case 5:
			return "June";
		case 6:
			return "July";
		case 7:
			return "August";
		case 8:
			return "September";
		case 9:
			return "October";
		case 10:
			return "November";
		case 11:
			return "December";
		default:
			return "January";
		}
	}



	public static  int getMonthNum(String mes ){
		switch(mes){
		case "January":
			return 0;
		case "February":
			return 1;
		case "March":
			return 2;
		case "April":
			return 3;
		case "May":
			return 4;
		case "June":
			return 5;
		case "July":
			return 6;
		case "August":
			return 7;
		case "September":
			return 8;
		case "October":
			return 9;
		case "November":
			return 10;
		case "December":
			return 11;
		default:
			return  0;
		}
	}
		
		public  static String fix(int day){
			if( day <  10){
				return ("0"  + day);
			}else{
				return day + "";
			}
		}
}



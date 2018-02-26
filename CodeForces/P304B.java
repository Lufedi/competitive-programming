import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)   throws Exception { 
	
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		String line[];
		int aa , mm , dd ; 
		line  =  br.readLine().split(":");
		aa = Integer.parseInt(line[0]);
		mm = Integer.parseInt(line[1]) - 1;
		dd = Integer.parseInt(line[2]);

		
		
		
		GregorianCalendar a =  new GregorianCalendar(aa , mm , dd);
		a.setTimeZone(TimeZone.getTimeZone("GMT"));
		line  =  br.readLine().split(":");
		aa = Integer.parseInt(line[0]);
		mm = Integer.parseInt(line[1]) - 1;
		dd = Integer.parseInt(line[2]);
		GregorianCalendar b =  new GregorianCalendar(aa , mm, dd);
		b.setTimeZone(TimeZone.getTimeZone("GMT"));
		 long  res  =   Math.abs(a.getTimeInMillis() - b.getTimeInMillis());
		 b =  new GregorianCalendar();
		
		 
		 
		long z =  (res /(86400000));

		 System.out.println(z);
		
		
		

	}

}
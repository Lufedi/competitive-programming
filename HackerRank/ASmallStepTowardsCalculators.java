import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws  Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		if(s.split("-").length > 1){
			String data[] =  s.split("-");
			
			System.out.println( pint(data[0]) - pint(data[1]));
		}else{
			String data[] =  s.split("\\+");
			
			System.out.println( pint(data[0]) + pint(data[1]));
		}
		
		
	}
}
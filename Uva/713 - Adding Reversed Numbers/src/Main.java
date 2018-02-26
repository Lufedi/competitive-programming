import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
	public static 		StringBuffer sb =  new StringBuffer();
	public static void main(String [] args)  throws Exception{
		

		BufferedReader br =  new BufferedReader(new  InputStreamReader(System.in) );

		BigInteger  n1, n2, r;
		String datos[] ;
		int casos = Integer.parseInt(br.readLine().trim());
		for(int i = 0 ;  i < casos  ; i++){
			datos = br.readLine().split(" ");
			n1 = new  BigInteger(reverse_d(datos[0]));
			n2 = new BigInteger(reverse_d(datos[1]));
			r = n1.add(n2);
			r = new BigInteger(reverse_d(r+""));
			System.out.println(r);
			
		}
		
	}
	
	
	public static String reverse_d(String a){
		sb =  new StringBuffer();
		sb.append(a.toCharArray());
		sb.reverse();
		return sb.toString();
	}

}

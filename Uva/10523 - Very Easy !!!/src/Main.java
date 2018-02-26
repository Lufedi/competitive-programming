import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		 while(br.ready()){
			 datos =  read().split(" ");
			 int N , A;
			 N =  pint(datos[0]);
			 A =  pint(datos[1]);
			 
			 BigInteger s  = new  BigInteger("0");
			 BigInteger a =  new BigInteger(A+ "");
			 
			 for(int i = 1 ; i  <=  N ; i++){
				 s =  s.add((a.pow(i)).multiply(new BigInteger(i+"")));
			 }
			 	
			 System.out.println(s);
			 
		 }
		
	}
}

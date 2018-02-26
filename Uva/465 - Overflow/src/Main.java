import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;








public class Main {
	public static BigInteger intNormal =  new BigInteger(Integer.MAX_VALUE + "");
	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new  InputStreamReader(System.in) );
		ArrayList<String>  entrada= new ArrayList<String>();
		
		String datos[] , linea;
		while( br.ready()){
			entrada.add(br.readLine().trim());	
			//for(String s :  entrada)System.out.println(s);
		}
		
		BigInteger n1 ,  n2;
		for(String s: entrada){
			System.out.println(s);
			datos =  s.split(" ");
			n1 =  new BigInteger(datos[0]);
			n2 =  new BigInteger(datos[2]);
			if( n1.compareTo(intNormal)  > 0)System.out.println("first number too big");
			if( n2.compareTo(intNormal)  > 0)System.out.println("second number too big");
			
			if( datos[1].equals("+")){
				n1 =  n1.add(n2);
				if(n1.compareTo(intNormal) > 0) System.out.println("result too big");
			}
			if(datos[1].equals("*")){
				n1 =  n1.multiply(n2);
				if(n1.compareTo(intNormal) == 1) System.out.println("result too big");
			}
			
			
		}
		
		
		
		
		
	}
}

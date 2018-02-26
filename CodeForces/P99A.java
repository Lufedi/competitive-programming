import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String cadena =  br.readLine();
		int  a = 0 ,  a2;
		String n = "";
		String datos[] =  cadena.split(".");
		for(int i = 0  ;  i < cadena.length() ;  i++){
			if(cadena.charAt(i) == '.'){
				n =  cadena.substring(0 , i);
				a =  Integer.parseInt(cadena.charAt(i + 1) + "");
				break;
			}
		}
		
		BigInteger c =  new BigInteger(n);
		if(a >= 5 &&  n.charAt(n.length() - 1) != '9' )System.out.println(c.add(BigInteger.ONE).toString());
		else  if( a < 5 && n.charAt(n.length() - 1)!= '9') System.out.println(c.toString() );
		else System.out.println("GOTO Vasilisa.");
		
	}

}
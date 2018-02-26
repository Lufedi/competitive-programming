import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{ return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int cont =  pint(read());
		for(int i =0 ; i < cont  ;  i++){
			
			BigInteger s1 =  new BigInteger(read() ,  2);
			BigInteger s2 =  new BigInteger(read() , 2);
			BigInteger gcd = (new BigInteger(s1.intValue() + "")).gcd(new BigInteger(s2.intValue()+""));
			if(gcd.toString().equals("1")){
				System.out.println("Pair #"+(i+1) + ": Love is not all you need!");
			}else{
				System.out.println("Pair #"+(i+1) + ": All you need is love!");
			}
		}
		
	}
}

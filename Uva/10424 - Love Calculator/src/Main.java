import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;








public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		int z;
		String s1 ,s2;
		int p1=0, p2=0, p;
		//System.out.println((int)'a'  + " " + (int)'z');
		while(br.ready()){
			p1 = 0; p2 = 0;
			s1 =  read();
			s2 =  read();
			for(int i = 0 ; i < s1.length() ; i++){
				p = (int)((s1.charAt(i)+"").toLowerCase()).charAt(0);
				if(p >= 97 && p <= 122 ){
					p1 += (p - 96);
				}
			}
			String num =  p1 + "";
			int suma = 0;
			while( num.length() > 1){
				suma = 0;
				for(int  i = 0 ; i  <  num.length() ; i++){
					suma += pint(num.charAt(i)+ "");
				}
				num = suma +""; 
				p1 = suma;
			}
			
			
			for(int i = 0 ; i < s2.length() ; i++){
				p = (int)((s2.charAt(i)+"").toLowerCase()).charAt(0);
				if(p >= 97 && p <= 122 ){
					p2 += (p - 96);
				}
			}
			num = p2 + "";
			//System.out.println(p2);
			while( num.length() > 1){
				suma = 0;
				for(int  i = 0 ; i  <  num.length() ; i++){
					suma += pint(num.charAt(i)+ "");
				}
				num = suma +""; 
				p2 = suma;
			}
			
			//System.out.println(p1 + " " + p2);
			int max  = Math.max(p1, p2);
			int min  = Math.min(p1, p2);
			double res;
			
				res = (double)min/(double)max;
			//System.out.println( res);
			DecimalFormat df = new DecimalFormat("#0.00");
			System.out.println(df.format(res*100) + " %");
			
		}
		
	}
}

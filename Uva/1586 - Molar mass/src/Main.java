import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	
	public static  Hashtable<String , Double> mem =  new Hashtable<String , Double>();
	
	public static void main(String args[]) throws Exception{
		
		String expReg = "(\\d*[C|H|O|N]?)";
		BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		int casos  = Integer.parseInt(br.readLine().trim());
		mem.put("C",12.01 );
		mem.put("H",1.008);
		mem.put("O" , 16.00);
		mem.put("N", 14.01);
		Pattern p =  Pattern.compile(expReg);
		Matcher m;
		double res ;
		StringBuffer sb;
		for(int  i = 0 ;  i < casos ; i++){
			res = 0;
			sb =  new StringBuffer(br.readLine().trim());
			sb.reverse();
			m = p.matcher(sb.toString());
			String token;
			while(m.find()){
				
				
				token =  m.group();
				if(!token.equals("")){
					//System.out.println("token " + token);
					if(token.length() == 1) res+= mem.get(token);
					else{
						int cant;
						//System.out.println("sub" +  token.substring(1 ,  token.length()));
						sb =  new StringBuffer(token.substring(0 ,  token.length()-1));
						sb.reverse();
						cant=  Integer.parseInt(sb.toString());
						//System.out.println(cant);
						res+= mem.get(token.charAt(token.length()  - 1)+"") * cant;
					}
				}
				
				
			}
			
			
			
			System.out.printf("%.3f\n" , res);
			
		}
		
		
	}

}

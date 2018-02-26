import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	
	
	public static void main(String args[]) throws Exception{
		
		String expReg = "([+|-]?\\d*x?)";
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String datos[] ;
		int casos =  Integer.parseInt(br.readLine().trim());
		for(int i = 0 ;  i < casos  ;  i++){
			datos =  br.readLine().split("=");
			Pattern r =  Pattern.compile(expReg);
			Matcher m =  r.matcher(datos[0]);
			
			String token;
			int var[] =  new int[]{0,0};
			operar(m  ,  var , '+');
			m =  r.matcher(datos[1]);
			operar(m , var , '-');
			
			
			//System.out.println(var[0] + " " + var[1]);
			
			//x  =  Ent / VAr
			//ent =  var[1]  var =  var[0]
			if( var[0] == 0  && var[1]!= 0) System.out.println("IMPOSSIBLE");
			else if( var[0] == 0 && var[1] == 0 ) System.out.println("IDENTITY");
			else {
				double t =  (var[1] * (-1.0) / var[0]);
				System.out.println( (int)Math.floor(t));
				//System.out.println((t >= 0)?Math.floor(t): Math.ceil(t)  + " " + t);
			}
			
			
			
		}
		
	}
	
	
	public static int[] operar(Matcher m , int var[] ,  char operador){
		String token;
		while(m.find()){
			
			token  = m.group();
			if(!token.equals("") ){
				//System.out.println(" token "   + token);
				if(token.contains("x")){
					if(  token.matches("[+|-]?x")){
						int sum ;
						if(token.charAt(0) ==  '+') sum = 1;
						else if(token.charAt(0) == '-')sum = -1;
						else sum = 1;
						var[0]+=(operador == '+')?sum:(-1*sum);
					}
					else var[0] += (operador == '+')?Integer.parseInt(token.substring(0, token.length() - 1)): (-1)*Integer.parseInt(token.substring(0, token.length() - 1));
				}
					
				else
					var[1] += (operador == '+')?Integer.parseInt(token):(-1)*Integer.parseInt(token);
		
			}
		}
		 return var;
		
	}
	
	

}

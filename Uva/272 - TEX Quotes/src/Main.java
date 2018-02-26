import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	// tiempo 13:00 min
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static String read()throws Exception{return br.readLine().trim();}
	public static  int pint(String s){return Integer.parseInt(s);}
	
	
	public static void main(String[] args)  throws Exception{
		int cierra = 0;
		while(br.ready()){
			String s =  read();
			String ns = "";
			
			for(int i  = 0   ; i < s.length() ;  i++){
				char c =  s.charAt(i) ;
				if(c== '\"'){
					if(cierra==0){
						ns += "``";
					}else{
						ns+="''";
					}
					cierra = (cierra == 0)?1:0;  
				}else{
					ns+=c;
				}
			}
			System.out.println(ns);
		}
	}
}

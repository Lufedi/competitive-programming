import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class PasswordCraker {
	
	public static Hashtable<String, String> memo;
	public static String words[];
	public static String res;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		for(int c = 0 ;  c < cases ; c++){
			res= null;
			memo = new Hashtable<String, String>();
			int n = Integer.parseInt(br.readLine());
			
			//System.out.println(n);
			words = br.readLine().split(" ");
			//System.out.println(Arrays.toString(words));
			String tword =  br.readLine();
			//System.out.println(tword + " bf");
			String s = phi(tword, words);
		//	System.out.println(s);
			if(!s.equals("(")){
				
				String[] rsspli = s.split("-");
				
				for(int i = 0 ; i < rsspli.length ; i++){
					if( i == 0) System.out.print(rsspli[i]);
					else System.out.print(" " +rsspli[i]);
				}
				System.out.println();
				
			}else{
				System.out.println("WRONG PASSWORD");
			}
			
			
		}
	}

	public static  String phi(String tword, String words[]){
		
		if(memo.containsKey(tword)){
			//System.out.println("using memo");
			return memo.get(tword);
		}
		if(tword.length()  == 0 ){
			return   "";
		}else{
			String answ = "";
			
			for(int i = 0 ; i < words.length ;  i++){
				if(tword.startsWith(words[i])){
					int l = tword.length();
					String partialWord = tword.substring(words[i].length(), l);
					String temo = phi(partialWord, words);
					if(!temo.contains("(")){
						answ  = words[i] + "-" + temo ;	
					}
					
					
				}
			}
			
			String res;
			if(answ != ""){
				res =  answ;
			}else{
				res = "(";
			}
			memo.put(tword, res );
			
			return res;
			
		}
		
		
	}

}

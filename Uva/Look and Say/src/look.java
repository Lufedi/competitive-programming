
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class look {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		String line = br.readLine();
		Hashtable<String, String> mem = new Hashtable<String, String>();
		while(!line.equals("0 0 0")){
			String[] nums = line.split(" ");
			solve(Integer.parseInt(nums[0]),Integer.parseInt(nums[1])-1,Integer.parseInt(nums[2]), mem);
			line = br.readLine();
		}
		br.close();

	}

	private static void solve(int inicio, int fin, int pos, Hashtable<String, String> mem) {
		String n = inicio+"";
		for(int cont=0;cont<fin;cont++){
			n = siguiente(n);
		}
		
		System.out.println(n.charAt(pos-1));
		
	}
	
	private static String siguiente(String pal){
		StringBuffer res = new StringBuffer();
		char actual = pal.charAt(0);
		int cont = 1;
		boolean go = true;
		if(pal.length() >= 2000){
			pal = pal.substring(0, pal.length()/2);
		}
		for(int i = 1; i < pal.length() && go ; i++){
			
				if(pal.charAt(i) == actual){
					cont++;
				}else{
					res.append(cont);
					res.append(actual);
					cont = 1;
					actual = pal.charAt(i);
				}
			
		}
			
		res.append(cont);
		res.append(actual);
		
		return res.toString();
		
	}


	/*public static  String sig(String pal , Hashtable<String , String> mem ){
		StringBuffer res   = new StringBuffer();
		
		if(pal.length()  ==  1) {
			res.append("1" + pal);
		}
		else if(mem.containsKey(pal)){
			res.append(mem.get(pal));
			
		}else{

			String a ;
			String b ,  c ,d  , e;
			
			a = pal.substring(0, pal.length()/2 );
			b = pal.substring(pal.length()/2  , pal.length() );
			
			
			c =  sig(a, mem);
			
			d =  sig(b , mem);
			
			if(c.charAt(c.length() - 1) == d.charAt(1)){
				int i =  Integer.parseInt(c.charAt(c.length() - 2) + "");
				int j =  Integer.parseInt(d.charAt(0) + "");
				
				int k = i + j;
				c =  c.substring(0 , c.length() - 2);
				d = d.replaceFirst(d.charAt(0) + "", k + "");
				res.append(c );
				res.append(d);
				
			}else{
				res.append(c );
				res.append(d);
			}
		}
		
		mem.put(pal, res.toString());
		return res.toString();
	}*/
	
	

}

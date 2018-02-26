import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TheRepeater {
	public static String a , b;

	public static  int INF = 2000000000;
	public static void main(String[]  args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int casos ;
		int n ;
		casos = Integer.parseInt(br.readLine().trim());
		
		ArrayList<String> palabras;
		for (int i = 0; i < casos; i++) {
			palabras = new ArrayList<String>();
			n = Integer.parseInt(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				palabras.add( br.readLine().trim());
			}
			
			Collections.sort(palabras);
			for(String p :  palabras){
				System.out.print(" " + p+ " ");
			}
			int r = 0;
			for(int k = n - 1 ; k > 0 ; k--){
				a = palabras.get(k);  b = palabras.get(k - 1);
				String c = "";
				r+= solve(c);
				System.out.println( " v "  + c);
			}
			if (r == INF) System.out.println("Case #"+(i+1)+": Fegla Won");
			else System.out.println("Case #"+(i+1)+": " + r);
		}
	
		
		
	/*a = "aabbcc";
		b = "abc";
		System.out.println(solve());
		*/
	}
	
	
	
	public static int solve(String c){
		
		int i = a.length();
		int j = b.length();
		DP( i - 1 , j - 1 , c);
		
		return 0;
		
	}
	
	public static int DP( int i , int j  ,String c){
		
		//System.out.println(" i : " + i + " j : " + j  + " "     +a + "  "  +b  );
		int res = INF;
		if( i == 0 && j == 0 && a.charAt(i) == b.charAt(j)) {
			c+= a.charAt(i);
			return 0;
		}
		else if( i == 0 && j == 0 && a.charAt(i) != b.charAt(j)) return INF;
		else if( i == 0 && j == 0 && a.charAt(i) == b.charAt(j)){ 
			c+= a.charAt(i);
			return 0;
		}
		else if(i > 0 || j > 0 ){
			if (a.charAt(i) == b.charAt(j)){
				if( i > 0 && j > 0){
					c += (a.charAt(i) + "");
					res = DP( i - 1 , j - 1 , c);
				}
				if( i >= 1 && a.charAt(i) == a.charAt(i - 1)){
					c+= a.charAt(i);
					res = Math.min(res , 1 +  DP(i -1 , j  , c));
				}
				if( j >= 1 && b.charAt(j) == b.charAt(j - 1)){
					c+=b.charAt(j);
					res = Math.min(res  ,  1 + DP(i ,  j -1 , c));
				}
			}else{
				res = INF;
			}
		}
		return res;
		
	}

}





import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String line;
		while(!(line = br.readLine()).equals("0 0")){
			StringTokenizer stk = new StringTokenizer(line);
			String m = stk.nextToken();
			String n = stk.nextToken();
			/*pw.println(m+" "+n);
			if(m.equals("0")){
				pw.println(0);
				continue;
			}
			if(n.equals("0")){
				pw.println(1);
				continue;
			}
			int last = ((int)m.charAt(m.length()-1))-'0';
			if(last==0){
				pw.println(0);
			}else if(last == 5 || last == 6 || last == 1){
				pw.println(last);
			}else if(last == 2){
				int a;
				if(n.length()==1){
					a = ((int)n.charAt(n.length()-1))-'0';
				}else{
					a = (((int)n.charAt(n.length()-2))-'0')*10+((int)n.charAt(n.length()-1))-'0';
				}
				a = a%4;
				int[] arr = new int[]{6,2,4,8};
				pw.println(arr[a]);
			}else if(last == 3){
				int[] arr = new int[]{1,3,9,7};
				int a;
				if(n.length()==1){
					a = ((int)n.charAt(n.length()-1))-'0';
				}else{
					a = (((int)n.charAt(n.length()-2))-'0')*10+((int)n.charAt(n.length()-1))-'0';
				}
				a = a%4;
				pw.println(arr[a]);
			}else if(last == 4){
				int[] arr = new int[]{6,4};
				int a = ((int)n.charAt(n.length()-1))-'0';
				a = a%2;
				pw.println(arr[a]);
			}else if(last == 7){
				int[] arr = new int[]{1,7,9,3};
				int a;
				if(n.length()==1){
					a = ((int)n.charAt(n.length()-1))-'0';
				}else{
					a = (((int)n.charAt(n.length()-2))-'0')*10+((int)n.charAt(n.length()-1))-'0';
				}
				a = a%4;
				pw.println(arr[a]);
			}else if(last == 8){
				int[] arr = new int[]{6,8,4,2};
				int a;
				if(n.length()==1){
					a = ((int)n.charAt(n.length()-1))-'0';
				}else{
					a = (((int)n.charAt(n.length()-2))-'0')*10+((int)n.charAt(n.length()-1))-'0';
				}
				a = a%4;
				pw.println(arr[a]);
			}else if(last == 9){
				int[] arr = new int[]{1,9};
				int a = ((int)n.charAt(n.length()-1))-'0';
				a = a%2;
				pw.println(arr[a]);
			}*/
			pw.println(new BigInteger(m).modPow(new BigInteger(n), BigInteger.TEN));
		}
		pw.close();
	}

}





//Numbering Roads 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String line;
		int cases = 0;
		while(!(line = br.readLine()).equals("0 0")){
			StringTokenizer stk = new StringTokenizer(line);
			double r = Integer.parseInt(stk.nextToken());
			double n = Integer.parseInt(stk.nextToken());
			int tmp = (int)Math.ceil((r-n)/n);
			if(tmp<=26){
				pw.printf("Case %d: %d\n",++cases, tmp);
			}else{
				pw.printf("Case %d: impossible\n",++cases);
			}
		}
		pw.close();
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n > 0){
			
			String[] tmp = br.readLine().trim().split(" ");
			long a  = Long.parseLong(tmp[0]);
			long b  = Long.parseLong(tmp[1]);
			if(a > b) System.out.println(">");
			else if(a < b) System.out.println("<");
			else if(a == b) System.out.println("=");
			
			n--;
		}
		br.close();
	}

}

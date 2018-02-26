import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = br.readLine();
		while(!l.equals("0")){
			
			int a = Integer.parseInt(l);
			int ac = 0;
			for(int i = 1 ; i <= a ; i++){
				ac += Math.pow(i, 2);
			}
			
			System.out.println(ac);
		l = br.readLine();
		}
		br.close();
		System.exit(0);
		
	}

}

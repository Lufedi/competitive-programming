import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n != 0){
			int d1 , d2;
			String[] coord = br.readLine().trim().split(" ");
			d1 = Integer.parseInt(coord[0]);
			d2 = Integer.parseInt(coord[1]);
			int q1 , q2;
			for(int i =0 ; i < n ; i++){
				coord = br.readLine().trim().split(" ");
				q1 = Integer.parseInt(coord[0]);
				q2 = Integer.parseInt(coord[1]);
				
				if((q1 == d1) || (q2 == d2)){
					System.out.println("divisa");
				}else if((q1  <   d1) && (q2 > d2)){
					System.out.println("NO");
				}else if((q1  >   d1) && (q2 > d2)){
					System.out.println("NE");
				}else if((q1  >   d1) && (q2 < d2)){
					System.out.println("SE");
				}else if((q1  <   d1) && (q2 < d2)){
					System.out.println("SO");
				}
			}
			 n = Integer.parseInt(br.readLine());
		}
		br.close();
		
	}

}

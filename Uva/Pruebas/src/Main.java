import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		String line = br.readLine();
		long[][] mat = new long[6001][5];
		for(int i=0;i<6001;i++){
			mat[i][4]=1;
			mat[i][3]=i;
			if(i>1){
				mat[i][2]=mat[i-2][3]+mat[i-2][4]+mat[i-2][2];
			}else{
				mat[i][2]=0;
			}
			if(i>4){
				mat[i][1]=mat[i-5][2]+mat[i-5][3]+mat[i-5][4]+mat[i-5][1];
			}else{
				mat[i][1]=0;
			}
			if(i>9){
				mat[i][0]=mat[i-10][2]+mat[i-10][3]+mat[i-10][4]+mat[i-10][0]+mat[i-10][1];
			}else{
				mat[i][0]=0;
			}
			
		}
		while(!br.ready()){
			int n =Integer.parseInt(line);
			int res=n/5;
			long res2 =(mat[res][2]+mat[res][3]+mat[res][4]+mat[res][0]+mat[res][1]);
		if(res2!=1){
			System.out.println("There are "+res2+" ways to produce "+n+" cents change.");
		}else{
			System.out.println("There is only 1 way to produce "+n+" cents change.");
		}
			line = br.readLine();
		}
		br.close();

	}

}

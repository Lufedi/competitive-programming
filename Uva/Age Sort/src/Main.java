import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = br.readLine().trim();
		
		while(!l.equals("0")){
			 
			 l = br.readLine();
			String ages[] = l.split(" ");
			byte ag[] = new byte[ages.length] ;
			for(int j = 0 ; j <  ages.length; j++){ag[j] = Byte.parseByte(ages[j]);}
			Arrays.sort(ag);
			StringBuffer sb = new StringBuffer();
			for(int i = 0 ; i < ag.length ; i++){
				if(i == 0) sb.append(ag[i]);
				else sb.append(" "  + ag[i]);
				
				//System.out.print(ag[i]);
				//if(i  != ag.length - 1)System.out.print(" ");
			}
			System.out.println(sb.toString());
			
			 l = br.readLine();
		}
		br.close();
		System.exit(0);
		
	}

}

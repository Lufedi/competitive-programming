import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	    
		int remaining = Integer.parseInt(br.readLine().trim());
		while(remaining > 0){
			String line1 = br.readLine().trim();
			String line2 = br.readLine().trim();
			String line3 = br.readLine().trim();
			if(remaining>1) br.readLine();
			boolean owin =  (line1.charAt(0)== 'O' && line1.charAt(1)== 'O' && line1.charAt(2)== 'O') ||
					(line2.charAt(0)== 'O' && line2.charAt(1)== 'O' && line2.charAt(2)== 'O') ||
					(line3.charAt(0)== 'O' && line3.charAt(1)== 'O' && line3.charAt(2)== 'O') ||
					(line1.charAt(0)== 'O' && line2.charAt(0)== 'O' && line3.charAt(0)== 'O') ||
					(line1.charAt(1)== 'O' && line2.charAt(1)== 'O' && line3.charAt(1)== 'O') ||
					(line1.charAt(2)== 'O' && line2.charAt(2)== 'O' && line3.charAt(2)== 'O') ||
					(line1.charAt(0)== 'O' && line2.charAt(1)== 'O' && line3.charAt(2)== 'O') ||
					(line1.charAt(2)== 'O' && line2.charAt(1)== 'O' && line3.charAt(0)== 'O');
			
			boolean xwin =  (line1.charAt(0)== 'X' && line1.charAt(1)== 'X' && line1.charAt(2)== 'X') ||
					(line2.charAt(0)== 'X' && line2.charAt(1)== 'X' && line2.charAt(2)== 'X') ||
					(line3.charAt(0)== 'X' && line3.charAt(1)== 'X' && line3.charAt(2)== 'X') ||
					(line1.charAt(0)== 'X' && line2.charAt(0)== 'X' && line3.charAt(0)== 'X') ||
					(line1.charAt(1)== 'X' && line2.charAt(1)== 'X' && line3.charAt(1)== 'X') ||
					(line1.charAt(2)== 'X' && line2.charAt(2)== 'X' && line3.charAt(2)== 'X') ||
					(line1.charAt(0)== 'X' && line2.charAt(1)== 'X' && line3.charAt(2)== 'X') ||
					(line1.charAt(2)== 'X' && line2.charAt(1)== 'X' && line3.charAt(0)== 'X');
			
			int os,xs; os=xs=0;
			for(int i=0; i<3;i++){
				if(line1.charAt(i)=='O') os++;
				if(line1.charAt(i)=='X') xs++;			
			}
			for(int i=0; i<3;i++){
				if(line2.charAt(i)=='O') os++;
				if(line2.charAt(i)=='X') xs++;			
			}
			for(int i=0; i<3;i++){
				if(line3.charAt(i)=='O') os++;
				if(line3.charAt(i)=='X') xs++;			
			}
			if(check(os,xs,owin,xwin)) System.out.println("yes");
			else System.out.println("no");
			remaining--;
		}
		br.close();
	}
	


	
	
	


	private static boolean check(int os , int xs, boolean owin, boolean xwin) {
		if(owin && xwin) return false;
		else{
			if(xwin) return 1+os==xs;
			else{
				if(owin) return os==xs;
				else return 1+os==xs || os==xs;
			}
		}
		
		
		
	}
	
}


	

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class A {

	
	public static int LIM = 1073741825;
	public static int p[]=  new int[31];
	
	public static void prec(){
		int ind = 0;
		int curr = 1;
		int count = 0;
		while( curr <  LIM){
			p[count] = curr;
			//System.out.println(curr);
			curr  = (int)Math.pow(2, ++ind);
			
			
			count++;
		}
		//System.out.println(count);
		//System.out.println();
	}
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		 prec();
		 //System.out.println(Arrays.toString(p));
		 BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		 
		 int n = Integer.parseInt(br.readLine());
		 int r = 0;
		 while(n!=0){
			 int i = 0;
			 while(   p[i] < n){
				 	i++;
			 }
			 if(p[i] == n){
				 n = 0;
			 }else{
				 n = n - p[(i > 0)?i - 1:0];
				 
			 }
			 r++;
			 
			 //System.out.println(n + " " + i);
				 
				
			 
		 }
		 System.out.println(r);
		
	}

}
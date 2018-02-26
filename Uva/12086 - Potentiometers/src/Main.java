import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		
		BufferedReader  br =  new    BufferedReader(new InputStreamReader(System.in));
		Scanner sc =  new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter( System.out));
		
		int rtos  , a[]  ;  
		String linea , datos[];
		
		rtos =  Integer.parseInt(br.readLine().trim());
		int  i  ,  j , cont = 0;
		while(rtos != 0 ){
			 a =  new int[rtos];
			
			 FenwickT  ft =  new FenwickT(rtos);
			
			 for(int t = 0 ; t < rtos ;  t++) {
				 int p = Integer.parseInt(br.readLine().trim());
				 ft.adjust(t+1 , p);		
				 a[t] =  p;
			 }

			 if(cont  > 0 ) bw.newLine();
			 bw.write("Case " + (++cont) + ":");
			 bw.newLine();
			 linea =  br.readLine().trim();
			 while( ! linea.equals("END")){
				 
				 datos  = linea.split(" ");
				 if( datos[0].equals("S")){
					 i =  Integer.parseInt(datos[1]);
					 j =  Integer.parseInt(datos[2]);
					// System.out.println(i + " "   + j );
					 //ft.adjust(i, -ft.ft[i]);
					 ft.adjust(i, -a[i-1]);
					 ft.adjust(i, j);
					 a[i - 1] =  j;					 
				 }
				 if( datos[0].equals("M")){
					 i=  Integer.parseInt(datos[1]);
					 j =  Integer.parseInt(datos[2]);	
					 bw.write(ft.rsq(i , j) + "\n");
				 }
				 linea =  br.readLine().trim();
			 }
			 
			 
				rtos =  Integer.parseInt(br.readLine().trim());
		}
		bw.close();
		
		
	}

}



class FenwickT{
	public static int[] ft;
	
	public FenwickT(int n ){
		ft =  new int[n+1];
		for(int  i = 0 ; i <  n+1 ; i++)  ft[i] = 0 ;
	}
	public int rsq(int b){
		int sum = 0;
		for(int c= b ; c > 0; c-= LSOne(c) ) sum+= ft[c];
		return sum;
	}
	public static int LSOne(int i){ return (i & (-i));}
	public int rsq(int a , int b){
		return rsq(b) - ( a == 1 ? 0 : rsq( a -1));
	}
	
	public static void adjust(int k , int v){
		for(; k < ft.length ; k += LSOne(k)) ft[k]+= v ;
	}
}


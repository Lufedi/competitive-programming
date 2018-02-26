import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static int  n , s ;
	public static int[]  wires;
	public static void main(String args[])  throws Exception{
		BufferedReader br =  new BufferedReader (new InputStreamReader(System.in));
		String linea , datos[];
		n =  Integer.parseInt(br.readLine().trim());
		wires =  new int[n];
		datos =  br.readLine().trim().split(" ");
		for(int  i =  0 ;  i < datos.length  ;  i++)wires[i] =  Integer.parseInt(datos[i]);
		s =  Integer.parseInt(br.readLine());
		
		
		int x , y ,  suben ,  bajan ,  actual;
		for(int  i = 0  ; i < s  ; i++){
			datos =  br.readLine().trim().split(" ");
			x =  Integer.parseInt(datos[0]) - 1;
			y =  Integer.parseInt(datos[1]);
			actual  =  wires[x];
			bajan =  actual - y;
			suben =  actual - bajan - 1;
			if( x  + 1 < n)  wires[x + 1 ]+=  bajan;
			if( x - 1 >= 0 )wires[x - 1]+= suben;
			wires[x]  = 0;
			//System.out.println( suben + " " + bajan );
			//for(int a :  wires)System.out.println(a);
		}
			
		for(int a :  wires)System.out.println(a);
	
	}

}
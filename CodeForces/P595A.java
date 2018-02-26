import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static int pint(String s){ return Integer.parseInt(s);}
	public static  String read() throws Exception{return br.readLine();}
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args)  throws Exception{
		int n , m;
		int r = 0;
		String linea , datos[];
		datos = read().split(" ");
		n = pint(datos[0]);
		m = pint(datos[1]);
		
		for(int i= 0; i <  n ; i++){
			datos = read().split(" ");
			for(int j = 0 ; j < m; j++){
				
				r+= ( datos[j*2].equals("1") || datos[j*2+1].equals("1"))?1:0;
			}
		}
		System.out.println(r);
		
	}
	
	
}
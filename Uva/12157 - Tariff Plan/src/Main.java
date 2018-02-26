	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 16 min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			int casos =  pint(read());
			int n, calls[];
			for(int c = 0 ; c< casos ;  c++){
				n =  pint(read());
				calls =  new int[n];
				datos =  read().split(" ");
				int m  = 0 , u = 0;
				for(int j = 0 ; j <  datos.length ; j++){
					calls[j] = pint(datos[j])+ 1;
					m+= ( (calls[j]/30)*10 + ((calls[j]%30 != 0)?10:0) );
					u+= ( (calls[j]/60)*15 + ((calls[j]%60 != 0)?15:0) );
				}
				
				if(m <  u){
					System.out.println("Case " + (c + 1) + ": Mile " + m);
				}else if( m > u){
					System.out.println("Case " + (c + 1) + ": Juice " + u);
				}else{
					System.out.println("Case " + (c + 1) + ": Mile Juice " + m);
				}
			}
		}
	}

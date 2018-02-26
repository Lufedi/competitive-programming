	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 10 min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			int n =  pint(read());
			String [] names =  new String[n];
			String song[];
			String g = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you";
			song  =  g.split(" ");
			for(int  i = 0 ; i <  n ; i ++){
				names[i] =  read();
			}
			int total =  n /16 + ((n % 16 != 0)?1:0);
			for(int i = 0 ; i < total*16 ; i++){
				System.out.println(names[i%names.length] + ": " + song[i%16]);
			}
		}
	}

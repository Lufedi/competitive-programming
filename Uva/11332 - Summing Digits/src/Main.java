	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 6min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			while( !(linea =  read()).equals("0")){
				int sum = pint(linea);
				while(linea.length() > 1){
					sum = 0;
					for(int i = 0; i  < linea.length() ; i++){
						sum+= pint(linea.charAt(i) + "");
					}
					linea =  sum + "";
					//System.out.println(linea);
				}
				System.out.println(sum);
			}
		}
	}

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 6:30 min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			int casos = pint(read());
		
			String [][] tabla;
			for(int c = 0 ; c <  casos ;  c++){
				tabla  =  new String[10][2];
				int max = 0;
				for(int i = 0 ; i <  10 ; i++){
					tabla[i] =  read().split(" ");
					max = Math.max(max , pint(tabla[i][1]));
				}
				System.out.println("Case #" + (c+1) + ":");
				for(int i = 0 ; i < 10 ; i++){
					if(pint(tabla[i][1]) == max){
						System.out.println(tabla[i][0]);
					}
				}
			}
		}
	}

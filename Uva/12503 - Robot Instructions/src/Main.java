	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.text.DecimalFormat;
	
	
	
	
	
	
	//Tiempo : 12 min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			int casos =  pint(read());
			int n, steps[] , pos = 0;
			for(int c = 0 ; c< casos ;  c++){
				n = pint(read());
				steps=  new int[n];
				pos = 0;
				for(int  j = 0 ;  j < n ; j++){
					linea =  read();
					if( linea.equals("LEFT")){
						steps[j] = -1;
						pos -= 1;
					}else if(linea.equals("RIGHT") ){
						steps[j] = 1;
						pos+= 1;
					}else{
						int temp =  pint( (linea.split(" "))[2])-1;
						steps[j] =  steps[temp];
						pos+= steps[j];
					}
					//System.out.println(pos);
				}
				System.out.println(pos);
			}
		}
	}

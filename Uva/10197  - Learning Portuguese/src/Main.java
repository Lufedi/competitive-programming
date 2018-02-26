	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
	
	
	
	
	
	
	//Tiempo : 8min
	
	
	public class Main {
		public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		public static int pint(String s){return Integer.parseInt(s);}
		public static String read() throws Exception{ return br.readLine().trim();}
		public static void main(String[] args) throws Exception{
			String linea ,  datos[];
			int casos  = pint(read());
			//int h;
			for(int c = 0 ; c <  casos ; c++){
				//h = 1;
				linea  = read();
				/*for(int j = 0 ;  j < linea.length()  ; j++){
					if(linea.charAt(j) == 'R')
						h++;
					else if(linea.charAt(j) == 'F')
						h--;
					
				}*/
				//System.out.println(h);
			
				String map[][] = new String[110][linea.length()+4];
				for(String [] a : map)
					Arrays.fill(a, " ");
				System.out.println("Case #" + (c+1)+":");
				int i = 49;
				int t = i;
				int h = i;
				//int j = 2;
				int dir = 0;
				//System.out.println(i + " ** " + j);
				for(int k = 0 ; k <  linea.length() ; k++){
					if(linea.charAt(k) == 'R'){
						
						if(dir == -1){
							i--;
							map[i][k+2] = "/";
						}
						else{
							map[i][k+2] = "/";
						}
						dir  = -1;
					}
					else if(linea.charAt(k) == 'F'){
						if(dir == 1){
							i++;
							map[i][k+2] = "\\";
							
						}
						else if(dir  == -1)
							map[i][k+2] = "\\";
						else{
							if(k!= 0)i++;
							
							map[i][k+2] = "\\";
							
						}
						dir  = 1;
					}
					else{
						
						if(dir == 1){
							map[i][k+2] = "_";
							dir = 0;
						}
						else if(dir == -1){
							map[i-1][k+2] = "_";
							i--;
							dir = 0;
						}else{
							map[i][k+2] = "_";
						}
						
					}
					//System.out.println(i + " ** " + k);
					h = Math.min(h, i);
					t = Math.max(t , i);
				}
				//System.out.println(h);
				for(int  k = 0 ; k  <  t + 2 ; k++){
					if(k == (t+1))map[k][0] = "+";
					else map[k][0] = "|";
				}
				for(int k = 1 ; k <  linea.length() + 4  ; k++){
					map[t+1][k]  = "-";
				}
				//System.out.println(h + " " + t);
				for (int l =h; l < t + 2; l++) {
					
					for (int k = 0; k < linea.length() + 3; k++) {
						System.out.print(map[l][k]);
					}
					System.out.println();
				}
				/*for (int l =0; l < map.length; l++) {
					
					for (int k = 0; k <map[l].length; k++) {
						System.out.print(map[l][k]);
					}
					System.out.println();
				}*/
				System.out.println();
				
			}
		}
	}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;







// tiempo 6 min
public class Main {
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine().trim();}
	public static void main(String[] args) throws Exception{
		String linea, datos[];
		int c = pint(read());
		String uno = "one";
		String dos = "two";
		for(int i = 0 ; i <  c ; i++){
			linea = read();
			if(linea.length() == 5){
				System.out.println("3");
			}else{
				int on = 0;
				for(int j= 0 ; j < 3 ; j++){
					if(uno.charAt(j) == linea.charAt(j))on++;
				}
				if(on>=2) System.out.println("1");
				else System.out.println("2");
			}
		}
		
	}
}

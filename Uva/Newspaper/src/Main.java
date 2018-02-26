import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Hashtable;


public class Main {
	
	
	public static void main (String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Hashtable<String , Integer> precios ;
		DecimalFormat formateador = new DecimalFormat("0.##$");
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator('.');
		formateador.setDecimalFormatSymbols(otherSymbols);
		
		
		String line , res;
		String tmp[];
		int k ,sum , l;
		
		while(n > 0){
			precios =  new Hashtable<String , Integer>();
			 k = Integer.parseInt(br.readLine());
			for(int i = 0 ; i < k ; i++){
				line = br.readLine().trim();
				tmp = line.split(" ");
				precios.put(tmp[0], Integer.parseInt(tmp[1]));
			}
			 l = Integer.parseInt(br.readLine());
			 sum = 0;
			while(l > 0){
				sum += solve(br.readLine().trim() , precios);
				l--;
			}
			 res = String.valueOf(formateador.format((float)sum/100));
			bw.write(res);
			bw.flush();
			n--;
		}
	}

	private static int solve(String texto, Hashtable<String, Integer> precios) {
		int sum = 0 ;
		for(int i = 0 ;  i < texto.length() ; i++){
			if(precios.containsKey(texto.charAt(i) + "")){
				sum += precios.get(texto.charAt(i) + "");
			}
		}
		return sum;
		
	}
	
	

}

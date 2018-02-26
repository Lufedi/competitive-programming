import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;






public class Main {

	public static void main(String[] args)  throws Exception{
		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		
		int casos = Integer.parseInt(br.readLine().trim());
		String datos[];
		String dato;
		for(int i = 0; i < casos ; i++){
			datos = br.readLine().trim().split(" ");
			int cantDatos =  Integer.parseInt(datos[0]);
			int lista[]  =  new int[cantDatos];
			for(int j = 1  ; j <=  cantDatos ; j++)lista[j-1] =  Integer.parseInt(datos[j]);
			Arrays.sort(lista);
			int media = lista[ lista.length/2];
			int sum = 0;
			for(int j = 0 ; j <  lista.length ; j++){
				sum+= Math.abs(lista[j] - media) ;
			}
			System.out.println(sum);
		}
		
	}

}
 
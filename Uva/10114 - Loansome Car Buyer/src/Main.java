import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	
	
	public static void main (String[]  args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String linea ;
		String[] datos;
		linea = br.readLine().trim();
		int duracion  , numMeses;
		double pago , deuda ;
		ArrayList<Tupla> caidas ;
		while( !(linea.charAt(0) == '-')){
			datos = linea.split(" ");
			caidas = new ArrayList<Tupla>();
			duracion = Integer.parseInt(datos[0]);
			pago 	 = Double.parseDouble(datos[1]);
			deuda 	 = Double.parseDouble(datos[2]);
			numMeses = Integer.parseInt(datos[3]);
			
			
			for(int i = 0 ; i < numMeses ; i++){
				datos = br.readLine().trim().split(" ");
				caidas.add(new Tupla(Integer.parseInt(datos[0]) ,   Double.parseDouble(datos[1])));
			}
			
			int cont = 0;
			for(int j = 0 ; j <  duracion ; j++){
				deuda += pago;
				if(cont < caidas.size() && caidas.get(cont).mes <= j){
					double dt = caidas.get(cont).dto;
					deuda = (deuda + pago)*( 1.0 - caidas.get(cont).dto);
				}
				
			}
			
		}
		
	}

}


class Tupla{
	public int mes;
	public double dto;
	
	public Tupla(int m  , double d){
		this.mes = m ;
		this.dto = d;
		
	}
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine().trim();
		int cont = 0;
		while( !linea.equals("0 0")){
			cont ++;
			String[] datos = linea.split(" ");
			int n =  Integer.parseInt(datos[0]);
			int p =  Integer.parseInt(datos[1]);
			double compl = 0;
			for(int i = 0 ; i < n ; i++)br.readLine();
			String min = null , aux;
			double cmMin = 0;
			double vl  = 0 , vlAux;
			int cant;
			for(int  i = 0 ; i < p ; i++){
				
				aux = br.readLine().trim();
				datos =  br.readLine().trim().split(" ");
				vlAux = Double.parseDouble(datos[0]);
				cant = Integer.parseInt(datos[1]);
				for(int j = 0 ; j < cant ; j ++) br.readLine();
				
				if(cant > cmMin){
					min = aux;
					cmMin = cant;
					vl = vlAux;
				}else if(cant  == cmMin &&  vlAux < vl ){
					min = aux;
					vl = vlAux;
					
				}
			}
			if(cont > 1) System.out.println();
			System.out.println("RFP #"+cont);
			System.out.println(min);
			linea = br.readLine();
		}
		
	}
	
	
}

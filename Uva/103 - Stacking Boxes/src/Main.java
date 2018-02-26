import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String linea;
		while( (linea  = br.readLine()) != null){
			
			int cajas ,  dim ;
			String[] datos = linea.split(" ");
			cajas = Integer.parseInt(datos[0]);
			dim = Integer.parseInt(datos[1]);
			Caja[] boxes = new Caja[cajas]; 
			for(int i = 0 ; i <  cajas ; i ++){
				boxes[i] = new Caja(dim , i + 1);
				datos = br.readLine().trim().split(" ");
				for(int  j = 0 ; j <  dim ; j++){
					boxes[i].agregar( j ,  Integer.parseInt(datos[j]) );
				}
				Arrays.sort(boxes[i].dimensiones);
			}
			
			bubbleSort(boxes);
			solve(boxes);
		}
	}
	
	public static void bubbleSort(Caja[] arr) {
	      boolean swapped = true;
	      int j = 0;
	      Caja tmp;
	      while (swapped) {
	            swapped = false;
	            j++;
	            for (int i = 0; i < arr.length - j; i++) {                                       
	                  if (arr[i].compareTo(arr[i + 1])  == 1) {                          
	                        tmp = arr[i];
	                        arr[i] = arr[i + 1];
	                        arr[i + 1] = tmp;
	                        swapped = true;
	                  }
	            }                
	      }
	}
	
	private static void solve(Caja[] boxes) {	
		
	LISI(boxes , boxes.length);
	}
	
	
	
	private static int LISI(Caja[] boxes  , int dim){
		int DP[] = new int[dim]; 
		int prev[] = new int[dim];
		ArrayList<Integer> camino = new ArrayList<Integer>();
		camino.add(boxes[0].id);
		int maxLength = 1, bestEnd = 0;
		DP[0] = 1;
		prev[0] = -1;
		for (int i = 1; i < dim; i++){
		   DP[i] = 1;
		   prev[i] = -1;
		
		   for (int j = i - 1; j >= 0; j--){
			   
		      if (DP[j] + 1 > DP[i] && boxes[j].compareTo(boxes[i]) == -1 ){
		    	  if(camino.size() == 0) camino.add(boxes[j].id);
		         DP[i] = DP[j] + 1;
		         prev[i] = j;
		      }
		   }
		   if (DP[i] > maxLength){
			  camino.add(boxes[i].id);
		      bestEnd = i;
		      maxLength = DP[i];
		     
		   }
		}
		System.out.println(maxLength);
		for(int i  = 0 ; i < camino.size() ; i++){
			if( i  == camino.size() - 1){
				System.out.print(camino.get(i));
			}else{
				System.out.print(camino.get(i) + " ");
			}
		}
		System.out.println();
		
		return maxLength;
	}
}


class Caja implements Comparable<Caja>{
	
	public int dimensiones[];
	public int id , total = 0;
	public Caja(int n ,  int id){
		dimensiones = new int[n];
		this.id = id;
	}
	
	public void agregar(int j, int valor) {
		dimensiones[j] = valor;
		total+= valor;
	}
	
	@Override
	public String toString(){
		return   this.id + "";
	}

		
	@Override
	public int compareTo(Caja e) {
		
		boolean band = true;
		
		for(int i = 0 ; i <  this.dimensiones.length && band ; i++){
			if(this.dimensiones[i] > e.dimensiones[i]) return  1;
		}
		band = true;
		for(int i = 0 ; i <  this.dimensiones.length  && band; i++){
			if(!(this.dimensiones[i] < e.dimensiones[i])) band  = false;
		}
		if(band)return -1;
		
		band = true;
		for(int i = 0 ; i <  this.dimensiones.length  && band; i++){
			if(!(this.dimensiones[i] == e.dimensiones[i])) band  = false;
		}
		if(band)return 0;
		return 0;	
	}	


	
}
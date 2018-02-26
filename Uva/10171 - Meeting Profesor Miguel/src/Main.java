import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;


public class Main {

	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static int pint(String s){return Integer.parseInt(s);}
	public static String read() throws Exception{ return br.readLine();}
	public static Hashtable<String , Integer> toId;
	public static Hashtable<Integer , String> toName;
	public static int[][] g1, g2  ;
	public static int N;
	public static void main(String[] args)  throws Exception{
		int casos;
		String yy = "";
		String linea, datos[];
		int cont = 0;
		/*
		 * Cargar pruebas
		 * 
		 */
		ArrayList<String > tt = new ArrayList<String>();
		/*while( !(linea =  read()).equals("0")){
			tt.add(read());
		}*/
		while( !(linea =  read()).equals("0")){
			cont++;
			
			int l = pint(linea);
			String[] lineas = new String[l+1];
			

			toId = new Hashtable<String , Integer>();
			toName = new Hashtable<Integer , String>();
			for(int i = 0 ; i < l ; i++ ){
				lineas[i] = read();
				datos = lineas[i].split(" ");
				if(!toId.containsKey(datos[2])){
					 int s = toId.size();
					 toId.put(datos[2], s);
					 toName.put(s, datos[2]);
				}
				if(!toId.containsKey(datos[3])){
					 int s = toId.size();
					 toId.put(datos[3], s);
					 toName.put(s, datos[3]);
				}
			}
			lineas[l] = read();
		
			
			N = toId.size();
			
			g1 = new int[N][N];
			g2 = new int[N][N];
	
			for(int i = 0 ; i < N ; i ++){
				Arrays.fill(g1[i], -1);
				Arrays.fill(g2[i], -1);			
			}
			
			
			
		
			
			for(int i = 0 ; i < lineas.length - 1; i++){
				 datos = lineas[i].split(" ");
				 //Y = 1 ,  M = 2
				int u , v;
				u =  toId.get(datos[2]);
				v =  toId.get(datos[3]);
			
				
				 
					 int d = pint(datos[4]);
					 if (datos[0].equals("Y"))
						 g1[u][v] = d;
					 if (datos[0].equals("M"))
						 g2[u][v]= d;
					 
					 if(datos[1].equals("B")){
						 if (datos[0].equals("Y"))
							 g1[v][u] = d;
						 if (datos[0].equals("M"))
							 g2[v][u]= d;
					 }
				 
			}

			datos =  lineas[l].split(" ");
			int ini  = 0, fin = 0;
			
				ini =  (toId.containsKey(datos[0])?toId.get(datos[0]):-1);
				fin =  (toId.containsKey(datos[1])?toId.get(datos[1]):-1);
				//FW
				for(int i = 0 ;i <  N ; i++){
					g1[i][i] = 0;
					g2[i][i] = 0;
				}
				if( fin != -1 && ini != -1 ){
		
					for(int k = 0 ; k < N ;  k++){
						for(int  i = 0 ; i < N ; i++){
							for(int j = 0 ; j < N  ;  j++){
								
								/*Hay que tener cuidado cuando se inicializa 
								enn -1 la matriz en el FW por em Math.min toma por defecto
								la casilla incializada en-1 y no toma rutas nuevas */
								if (g1[i][k] != -1 && g1[k][j] != -1 ){
									if(g1[i][j] >  g1[i][k]  + g1[k][j] || g1[i][j] == -1)
										g1[i][j] = g1[i][k]  + g1[k][j];
								}
								if (g2[i][k] != -1 && g2[k][j] != -1 ){
									if(g2[i][j] >  g2[i][k]  + g2[k][j] || g2[i][j] == -1)
										g2[i][j] = g2[i][k]  + g2[k][j];	
								}
							}
						}
					}
				

					
					ArrayList<Pair> res = new ArrayList<Pair>();
					int c = Integer.MAX_VALUE;
					int s = 0;
					for(int k = 0 ; k < N ; k++){
						if(g1[ini][k] != -1 && g2[fin][k] != -1){
							int d  = g1[ini][k] + g2[fin][k] ;
							if( d < c){
								c = d;
								res.clear();
								res.add(new Pair(d,  toName.get(k)));
							}else if(d  == c){
								res.add(new Pair(d,  toName.get(k)));
							}
						}
					}
					if(c != Integer.MAX_VALUE){
						Collections.sort(res);
						System.out.print(c);
						for (int i = 0; i < res.size(); i++) {
							System.out.print(" "+ res.get(i).s);
						}
						System.out.println();
					}else{
						System.out.println("You will never meet.");
						//yy = "You will never meet.";
					}
				}else{
					if(!datos[0].equals(datos[1]))
						System.out.println("You will never meet.");
					else
						System.out.println("0 " + datos[0] );
				}
			
		}
	
	}
	
	
}

class Pair implements Comparable<Pair>{
	public int d;
	public String s;
	public Pair(int d, String s){
		this.d = d;
		this.s = s;
	}
	@Override
	public int compareTo(Pair o) {
		return this.s.compareTo(o.s);
	}
	
}
import java.io.InputStreamReader;
import java.io.BufferedReader;

 

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader  br =  new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < casos ; i ++){
			int d = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int monedas[] = new int[n];
			for(int  j = 0 ; j < n ; j++){
				monedas[j] = Integer.parseInt(br.readLine());
			}
			solve(d ,  n - 1 ,  monedas);
		}
	}

	private static void solve(int d, int n, int[] monedas) {
	
		d = d + 1;
		n = n + 2;
		Tupla mem[][] = new Tupla[d][n];
		for(int i = 0 ; i <  d ; i ++){
			mem[i][0] = new Tupla(Integer.MAX_VALUE , Integer.MAX_VALUE);
		}
		
		for(int j = 1 ; j <  n ; j++){
			for(int i = 0 ; i <  d ; i++){
	
				if(i <= 0){
					mem[i][j] = new Tupla( 0 ,0);
				}else if(j < 0 && i > 0){
					mem[i][j] = new Tupla( Integer.MAX_VALUE ,Integer.MAX_VALUE);
				}else if( j >= 0 && i > 0){
					int a  , b , c , e;
					Tupla n1 = ( i  - monedas[j-1] <= 0 )? new Tupla( 0 ,0) :  mem[i - monedas[j-1]][j - 1];
					a = ( n1.cantidad != Integer.MAX_VALUE)? n1.cantidad + 1	       : Integer.MAX_VALUE;
					b = ( n1.valor != Integer.MAX_VALUE)?    n1.valor + monedas[j  - 1]     : Integer.MAX_VALUE;
					n1 = mem[i][j - 1];
					c = n1.cantidad;
					e = n1.valor;
					if(b == e){
						if(c < a){
							mem[i][j] = new Tupla( e , c);
						}else{
							mem[i][j] = new Tupla( b , a);
						}
					}else if( b < e){
						mem[i][j] = new Tupla( b , a);
					}else if(b > e){
						mem[i][j] = new Tupla( e , c);
					}
				}
				
				
			}
		}
		Tupla fin = mem[d - 1][n - 1];
		System.out.println(fin.valor + " "  + fin.cantidad );

	}

	
	
}

class Tupla{
	public int valor ,  cantidad;
	public Tupla(int valor ,  int cantidad){
		this.valor = valor;
		this.cantidad = cantidad;
	}
	
}
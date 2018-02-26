import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

		public static void main(String[] args) throws Exception{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
			String linea , datos[];
			while( (linea = br.readLine()) != null){
				 
				int A[] = new int[6];
				datos = linea.split(" ");
				A[0] = Integer.parseInt(datos[0]);
				A[1] = Integer.parseInt(datos[1]);
				A[2] = Integer.parseInt(datos[2]);
				A[3] = Integer.parseInt(datos[3]);
				A[4] = Integer.parseInt(datos[4]);
				A[5] = Integer.parseInt(datos[5]);
				
				solve( A);
			}
		}
		static double er = 0.000000000000001;
		
		
		
		private static void solve(int A[]) {
			double res;
			double lo = 0 , hi ,  mid;
			if( Math.abs(f(A ,  0)) < er) {
				res = 0.000;
				
			}else if( Math.abs(f(A , 1)) <  er){
				
				res = 1.000;
			}else if( f(A , 0) * f(A , 1)  > er){
				System.out.println("No solution");
				return;
			}else{
				 hi = 1 ;int cont = 0;
				 mid = lo + ( hi - lo) / 2;
				 
				while(Math.abs( f( A ,   ( lo + ( hi - lo) / 2)) )> er && cont <= 60 ){
					
					mid =  ( lo + ( hi - lo)/2);
					if( f( A ,  mid) > 0){
						lo = mid;
					}else{
						hi = mid;
					}
					cont++;
					
				}
				res = mid;
			}
			
			System.out.printf("%.4f" , res);
			System.out.println();
		}
		
		
		
		private static double f(int A[] ,  double x ){
			
			double p1 = A[0] *  Math.pow(Math.E, (-1) * x);
			double p2 = A[1] * Math.sin(x);
			double p3 = A[2] * Math.cos(x);
			double p4 = A[3] * Math.tan(x);
			double p5 = A[4] * Math.pow(x, 2);
			return p1 + p2 + p3 + p4 + p5 + A[5];
			
		}
}

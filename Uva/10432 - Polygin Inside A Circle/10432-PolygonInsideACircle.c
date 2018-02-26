
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{



	public static int r , div ;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String datos[];

		while(br.ready()){

			datos = br.readLine().trim().split(" ");
			r = Integer.parseInt(datos[0])  ; div = Integer.parseInt(datos[1]);
			solve(r , div);

		}

	}

	public static void solve(int r,  int div){
		double p = 2*(Math.PI)*r;
		double corte = p / div;
		double alf = (corte * (2*Math.PI))/p;
		double  l =  2 *  r * Math.sin( alf / 2);
		double  h =   r * Math.cos( alf / 2);
		double area =   (( l * h ) / 2);
		System.out.printf("%.3f\n" ,   area*div);

	}

}

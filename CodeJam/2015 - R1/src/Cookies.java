import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Cookies {
	private static double C  , F, X;
	
	public static void main(String[]  args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int casos =  Integer.parseInt(br.readLine().trim());
		String datos[];
		
		for(int c = 0 ; c <  casos ; c++){
			datos = br.readLine().trim().split(" ");
			C = Double.parseDouble(datos[0]);
			F = Double.parseDouble(datos[1]);
			X = Double.parseDouble(datos[2]);
			solve(c);
		}
	}

	private static void solve(int caso) {
		
		
		double f = 2;
		double t = 0;
		boolean end = false;
		double w1 = 0 , w2 = 0;
		while( !end){
			w1 = 0;w2 = 0;
			
			
			 w1 += C/f + X/(f + F);
			 w2 += X/(f);
			 //System.out.println("c "  +  w1 + "  / "  +w2);
			if( w1 < w2){
				//System.out.println("t " + C/f);
				t+= C/f;
				f+= F;
			}else{
				//System.out.println("e " + X/f);
				t+= X/f;
				end = true;
			}
			
		}
		
		System.out.printf("Case #%d: %.7f\n" , caso + 1, t );
		//System.out.println(cook(0  ,2));
	}

	/*private static double cook(double x, double f) {
		
		System.out.println("x: " + x   + "f " + f + " " + X + " " + C + " " + F);
		double res = Integer.MAX_VALUE;
		
		if( x >= X || f >= X)res = 0;
		else if( x < C){
			res = 1  + cook(x + f , f);
		}else if( x >= C)  {
			res = Math.min( (C/f  + cook(x - C , f + F)),
							(C/f  + cook(x + C , f)) );
			
		}
		return res;
	
	}
	*/
	

}

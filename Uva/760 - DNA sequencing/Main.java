import java.io.BufferedReader;
import java.io.InputStreamReader;





public class Main{


	public static void main(String[] args) throws Exception{

		BufferedReader  br =   new BufferedReader(new InputStreamReader(System.in));
		String c1 ,  c2;


		while(!br.ready()){
			 c1  =  br.readLine().trim();
			 c2  =  br.readLine().trim();

			solve(c1 ,  c2);
			br.readLine();


		}
	}



	public static void solve(String c1 ,  String c2){
		int l1 =  c1.length() ;

		int l2 =  c2.length();

		int lp = Math.min(l1,l2);
		int lt;
		String  t , p;


		if(l1 >  l2){
			t =  c1 ;
			p = c2 ; 
			lp = l2;
			lt = l1;
		}else{
			t = c2;
			p = c1;
			lp = l1;
			lt = l2;
		}

		/*for(int i = 0 ; i < lp ; i++){
			for(int  j = i ;  j <  lp ; j++){
				for(int k = 0 ; k < lt - (j - i)  ; k++){
					for(int l = k ; l  <  (j- i) ; l++){
						if( t.chatAt(l) == p.chatAt(i+l))
					}
				}
			}
		}*/

		System.out.println(" "  + t + " " + p + " " + lp + " " +  lt);

		boolean c = true;

		for(int i = 0 ; i < lp - 1 ; i++){
			for(int  j = i  + 1 ;  j <  lp ; j++){
				c = true;
				for(int k = 0 ; k < lt - (j - i)  ; k++){
					for(int l = 1 ; l  <  (j- i) - 1 ; l++){
						if( t.charAt(l + k) != p.charAt(l + i)){
							c = false;
						}
					}

					if(c) {
						System.out.println(t.substring(i , j)  + " i" + i + " " + j);
						
					}
				}
			}
		}








	}



}
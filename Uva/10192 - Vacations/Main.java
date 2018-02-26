
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main{


	public static int mem[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line ,cad1 , cad2;
		int cont = 0;
		while( ! ((cad1= br.readLine()).equals("#") ) ){
			
			cad2 = br.readLine();
			solve(cad1 ,  cad2 , ++cont);

			
			 
		}


	}


	public static void solve( String cad1 , String cad2 ,  int caso){
				genTabla(cad1 , cad2);
				int tab = mem[ cad1.length()][cad2.length()];
				System.out.println("Case #"+caso+": you can visit at most "+tab+" cities.");

	}



	/*public static int lcs(String cad1 , String cad2 , int l1 , int l2){
		int res = -1;
		if( l1 == 0 || l2 ==0){
			res =  0;
		}else if( cad1.charAt(l1 - 1)==(cad2.charAt(l2 - 1))){
			res = 1 +  lcs(cad1 , cad2 , l1 - 1 , l2 - 1);
		}else {
			res = Math.max( lcs(cad1 ,  cad2 , l1 , l2 - 1) ,  
						    lcs(cad1 ,  cad2 , l1 - 1 , l2));
		}
		return res;
	}*/


	public static void genTabla(String a , String b){

		int  la = a.length() + 1;
		int  lb = b.length() + 1;

		 mem = new int[la][lb];


		 for(int i = 0 ; i < la ; i++){
			for(int j = 0 ; j  < lb ; j++){
				if( i == 0 || j ==0){
					mem[i][j] =  0;
				}
			}
		}

		for(int i = 1 ; i < la ; i++){
			for(int j = 1 ; j  < lb ; j++){
				if( a.charAt(i - 1)==(b.charAt(j  - 1))){
					mem[i][j] = 1 +  mem[i - 1][ j - 1];
				}else {
					mem[i][j] = Math.max( mem[i][j - 1] ,  mem[ i - 1][j]);
				}
			}
		}
		
	}
	
	

}
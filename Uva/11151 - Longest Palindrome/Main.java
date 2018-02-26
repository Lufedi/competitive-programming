import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;


class Main {
	public static Hashtable<String , Integer > mem ;
	public static void main(String[] args) throws Exception{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int casos = Integer.parseInt(br.readLine());

	String cad;
	for(int i = 0 ; i < casos ; i ++){
		cad  = br.readLine().trim();
		solve( cad);
	}

	}



	public static void solve(String cad){
		mem = new Hashtable<String ,Integer>();
		System.out.println(fi(0 , cad.length() - 1 ,   cad , mem));


	}


	public static int fi(int i ,  int j ,  String cad , Hashtable<String , Integer> mem ){
		
		int res = -1;
		if( mem.containsKey(i + "," + j)){
			res = mem.get(i + "," + j);
		}else{
			if(i > j){
				res = 0;
			}
		   else if(i == j   ){
				res =  1 ; 
			}else if(cad.charAt(i) == cad.charAt(j)   && i != j ){
				
				res = fi( i + 1  ,  j - 1 ,  cad , mem) + 2;
			}else{
				res = Math.max( fi( i + 1 , j ,  cad , mem ) ,  fi( i , j - 1 , cad , mem) ); 
			}
			
			mem.put(i + "," + j, res);
		}
		
		return res;
	}



}




	
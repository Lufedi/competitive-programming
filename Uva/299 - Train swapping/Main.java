import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
	
	public static void main(String[] args) throws Exception{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int casos = Integer.parseInt(br.readLine());
	int n ;
	int arr[] ;
	String datos[];
	for(int i = 0 ; i < casos ; i ++){
		n  = Integer.parseInt( br.readLine());
		arr= new int[n];
		datos = br.readLine().trim().split(" ");
		for(int j = 0 ; j < n ; j++){
			arr[j] =  Integer.parseInt(datos[j]);
		}
		solve(arr);
	}

	}



	public static void solve(int[] a){

			int cont = 0;
		for(int i = 0 ; i <  a.length; i++){
			for(int j = i + 1 ; j <  a.length ; j++){
				if(a[i] > a[j]){
					cont ++;
				}
			}
		}
		System.out.println("Optimal train swapping takes "+cont+" swaps.");


	}


}

import java.io.InputStreamReader;
import java.io.BufferedReader;




public class Main{


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int m , k;
		int[] books;
		String line;
		String [] datos;
		for(int  i = 0 ; i <  a ; i++){
			datos = br.readLine().trim().split(" ");
			m = Integer.parseInt(datos[0]);
			k = Integer.parseInt(datos[1]);
			datos= br.readLine().trim().split(" ");
			books = new int[datos.length];
			for(int j = 0 ; j < datos.length ; j++){
				books[j] = Integer.parseInt(datos[j]);
			}

			solve( m , k , books);

		}



	}


	public static void solve(int  m , int k  , int [] books){
		//for(int  i =  0 ;  i < m ; i++) System.out.print(books[i] +  " " );
		//System.out.println("m " + m   +  "k " + k);

		int tot = 0; 
		int media;
		for(int  i = 0 ; i <  m ; i++) tot+= books[i];
		media = tot/k;
		System.out.println("media:" + media);

		String res = "" + books[0];
		int cant = 0;
		int wri=0;
		int carry = books[0];
		
		for(int i = 1 ; i <  m ; i++){

			if( carry  + books[i] >  media &&  wri < k - 1){
				res += " /";
				carry = 0;
				wri++;
				i--;


			}else{
				carry += books[i];
				res+= " " + books[i];
			}

		}

		System.out.println(res);

	}


	

}
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static int  A[] ;
	public static int  lis[] ;
	public static int  lds[] ;
	public static int cadena[] = new int[10020];
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
	
		
		
		while(  in.hasNext() ){
			
			int l = in.nextInt();
			
			cadena = new int[l + 1];
			for(int  i = 0  ; i <  l ; i++){
				cadena[i] =  in.nextInt();
			}
			int L = 1;
			A = new int[10020];
			
			lis = new int[10020];
			lds = new int[10020];
			
			
			LIS(cadena  , l);
			LDS(cadena  , l);
			
			lis[0] = 0;
			lds[0] = 0;
			L = 1;
			for(int  j = 1 ; j <= l ; j++){
						//	System.out.println( " (" + lis[j] + ", " + lds[j] + ")");
							L = Math.max(L,   Math.min(lis[j],lds[j]));
							
			}
					System.out.println((L * 2) - 1);					
		}
	
		
		System.exit(0);
	}
	

	public static void LIS(int[] seq  , int l ){
		
		int sz=0;
		
		for (int i=0; i <= l; i++) 
		 {
		  int pos =  binarySearchMenor(A,  1 , sz  , seq[i] ) ;
		  //System.out.println("pos" + pos);
		  if (pos == -1) {
			  A[++sz] =seq[i];
		  }
		  else{
			  A[pos] = seq[i];
		  }
		  lis[i] = sz;
		  
		 
		 }
		
	}
	
	
	
	public static void LDS(int[] seq , int  l ){
		int sz=0;
		
		
		
		for (int i= l; i >= 0; i--)
		 {
			  int pos = binarySearchMayor( A , seq[i] , 1 ,sz  );
			 // System.out.println("i :"+  i  + "pos" + pos);
			  if (pos==-1) {
				  A[++sz] = seq[i];
				  
			  }
			  else {
				  A[pos] = seq[i];
			  }
			  lds[i] = sz;
		 }
		
	}
	
	
	private static int binarySearchMenor(int[] a , int ini, int fin, int key) {
		 int low,hi,mid;
		 low = ini; hi = fin;
		 do
		 {
		  mid = (low+hi)/2;
		  if (a[mid]>=key) hi = mid;
		  else low = mid;
		 } while (hi-low>1);
		 
		 if (a[low]>=key) return  low;
		 else if (a[hi]>=key) return hi ;
		 else return -1 ;
		}
	

	private static int binarySearchMayor(int[] a, int key , int ini, int fin ) {
		
		 int low,hi,mid;
		 low = ini; hi = fin;
		 do
		 {
		  mid = (low+hi)/2;
		  if (a[mid]>=key) hi = mid;
		  else low = mid;
		 } while (hi-low>1);
		 
		 if (a[low]>=key) return  low;
		 else if (a[hi]>=key) return hi ;
		 else return -1 ;

	}
}

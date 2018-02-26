import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main {
	public static boolean found = false;
	public static LinkedList<Integer> ss = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> ses = new LinkedList<Integer>();
		int n = 0 , k = 0;
		String []nm = br.readLine().trim().split(" ");
		n = Integer.parseInt(nm[1]);
		k = Integer.parseInt(nm[0]);
		desc( n ,  k , n , ses);
		int[][] a = new int[k][k];
		int p = 0;
		for(int  i = 0 ; i <  k ; i++){
			for(int  j = 0 ; j < k ; j++){
				a[i][j] = ss.get(j);
			}
			ss.add(ss.getFirst());
			ss.removeFirst();
			
		}
		
		for(int  i = 0 ; i <  k ; i++){
			for(int  j = 0 ; j < k ; j++){
				System.out.print(a[i][j]);
				if(j != k - 1) System.out.print(" ");
			}
			System.out.println();
		}

	}
	
	public static void desc(int n ,  int k ,  int p  ,LinkedList<Integer > s ){
		
		LinkedList<Integer> sec = null ;
		
		if(n == 0 && k == 0){
			found = true;
			ss.addAll(s);
			
			
		}else if(n == 0 && k > 0){}
		else if(n != 0 && k == 0){}
		else if(p == (-1)){}
		else {
					if(!found)desc(n , k , p - 1 , s );
					
					if(!found){
						s.add(p);
			    	desc( n - p , k - 1 , p - 1  , s);
			    	s.removeLast();
					
					}
					
					if(!found){
			    	s.add(p);
			    	desc(n - p , k - 1,  p   , s);
			    	s.removeLast();
					}
			    
		
		}
	
	}

}

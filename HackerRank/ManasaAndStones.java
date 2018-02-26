import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MasanaAndStones {
	
	
	
	public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	      int c = scanner.nextInt();
	      for(int cases = 0 ;  cases < c ;  cases++ ){
	    	  int n  = scanner.nextInt();
	    	  int a  = scanner.nextInt();
	    	  int b  = scanner.nextInt();
	    	  ArrayList<Integer> res = new ArrayList<Integer>();
	    	  if( a == b){
	    		 
	    			  res.add( a* (n-1));
	    		  
	    	  }else{
	    		  if( a > b){
		    		  int temp  = a;
		    		  a = b ; b =  temp;
		    	  }
		    	  
		    	  
		    	  int mini = a * (n  - 1);
		    	  res.add( mini);
		    	  for(int i = 1 ; i < n ; i++ ){
		    		  res.add( ( Math.abs(a - b) * i ) + mini);
		    	  }
	    	  }
	    	  
	    	  
	    	  Collections.sort(res);
	    	  for(int i = 0 ; i< res.size();i++){
	    		  if(i == 0){
	    			  System.out.print(res.get(i));
	    		  }else{
	    			  System.out.print(" " + res.get(i));
	    		  }
	    	  }
	    	  System.out.println();
	    	  
	      }
	        
	    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.*;


public class Main {
  public static void main(String args[]) throws IOException{
		Scanner Input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int TestCases = Input.nextInt();
		
		while ( TestCases-- > 0 ){
			BigDecimal First = Input.nextBigDecimal();
			BigDecimal Second = Input.nextBigDecimal();
			BigDecimal Result = First.add(Second);
			 if (Result.compareTo(BigDecimal.ZERO) == 0) {
			        System.out.println("0.0");
			        continue;
			      }
			 char OutPut[] = Result.toString().toCharArray();
			 int Length = OutPut.length - 1;
			 
			 while (Length >= 0 && OutPut[Length] == '0') 
				 Length--; 
		      if (Length >= 0 && OutPut[Length] == '.') {
		        Length++;
		        OutPut[Length] = '0';
		      }
		      for (int i = 0; i <= Length; i++)
		    	  System.out.print(OutPut[i]);
		      System.out.println();
		}
			
		}

}
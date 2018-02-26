import java.util.Arrays;
import java.util.Scanner;

public class Gemstones {
	
	
	public static void main(String[] args) {
	
		
		Scanner sc= new Scanner(System.in);
		int rocks = sc.nextInt();
		
		int occurrences[] = new int[100];
		for(int c = 0 ; c < rocks ; c++){
			
			boolean checked[] = new boolean[100];
			String word = sc.next();
			for(int i = 0 ; i< word.length() ; i++){
				int index = (word.charAt(i) - '0') - 49;
				
				if(!checked[index]){
					checked[index] = true;
					occurrences[ index]++;
				}
			}
		}
		int res = 0;
		
		for(int i = 0  ; i < occurrences.length ;  i++){
			if(occurrences[i] == rocks) res++;
		}
		System.out.println(res);
		
	}
}

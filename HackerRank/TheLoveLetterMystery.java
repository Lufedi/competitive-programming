import java.util.Scanner;

public class TheLoveLetterMystery {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c  = 0 ;  c < cases ; c++){
			String word = sc.next();
			int l , h ;
			int word_size =  word.length();
			if( word_size % 2 == 0){
				l = word_size/2 -1;
				h = word_size/2;
			}else{
				l = word_size/2;
				h = word_size/2;
			}
		
			int res = 0;
			int limit = (word_size%2 == 0)?(word_size / 2) :(word_size / 2) + 1;
			for(int i = 0 ; i < limit ; i++){
				res+= Math.abs(word.charAt(l-i) - word.charAt(h+i));
			}
			System.out.println(res);
		}
	}
}
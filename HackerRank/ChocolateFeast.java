import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int wrapps = 0;
            int answer = 0;
            
            
            int division = n / c;
            
            wrapps += division;
            answer += division;
            
            while( wrapps >= m ){
            	answer+= wrapps/m;
            	wrapps =  wrapps/m + wrapps%m;
            } 
            System.out.println(answer);
        }
    }
}

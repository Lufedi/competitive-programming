import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        int cs = sc.nextInt();
        for(int c = 0 ;  c < cs ; c++){
            long k = sc.nextInt();
            if( k % 2 == 0){
                System.out.println( (k/2) * (k/2));
            }else{
                System.out.println( ( (k/2) + 1) * (k/2));
            }
        }
    }
}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	
	public static int pint(String s){
		return Integer.parseInt(s);
	}
    public static void main(String[] args)  throws Exception{
    	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    	int c = pint(br.readLine());
    	for(int i = 0 ; i < c; i++){
    		
    		System.out.println(pint(br.readLine())+1);
    	}
    	
    }
}
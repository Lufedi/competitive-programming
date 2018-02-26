package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;




public class Main {

	
	
	public static int pint(String s){return Integer.parseInt(s);}	
	public static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static String read()  throws Exception{return br.readLine();}
	
	
	public static void main(String[] args)  throws Exception {
		String datos[], linea;
		while(br.ready()){
			int c;
			String n;
			datos =  read().split(" ");
			c = pint(datos[0]);
			n =  datos[1];
			for(int i = 0 ; i <  c ;  i++){
				n = nextPal(n);
				System.out.println(n);//dfdfefrqewfd
			}
			
		}	
	}
	
	
	
	
	public static String nextPal(String s){
	    String res = "";
		if(checkNines(s)){
			
			for(int i = 0 ; i < s.length()  + 1; i++){
				if(i == 0 || i == s.length())
					res +="1";
				else
					res+="0";
			}
		}else{
			int l = s.length();
			boolean isPal = true;
			int n  =  (l % 2 == 0)?l:l/2 + 1;
			int i = 0;
			int j = s.length() - 1;
			int io,jo;
			boolean esPar;
			if( l% 2 == 0){
			    i = l/2-1;
			    j = l/2;
			    esPar =  true;
			}else{
			    i = l/2;
			    j = l/2;
                esPar =  false;
			}
			
			io = i ;
			jo = j;
			int lvl = 0;
			char[] lt =  s.toCharArray();
			while( i != -1 && lt[i] == lt[j]){
			    i--;
			    j++;
			    lvl++;
			}
			//System.out.println(i + " " + j + "es pla" + " " + io + " " + jo);
			
			//es palindrome
			if(i == -1){
			    res = "";
			    	i = io;
			    	j = jo;
			    	boolean cont =   true;
			    	while( cont && i >= 0){
			    		//sumar
			    		if( lt[i] == '9'){
			    			lt[i] = '0';
			    			lt[j] = '0';
			    		}
			    		else{
			    			lt[i] = ((Character.getNumericValue(lt[i])  + 1) + "").charAt(0);
			    			if(i != j)lt[j] = ((Character.getNumericValue(lt[j])  + 1) + "").charAt(0);
			    			cont =  false;
			    		}
			    		i--;
			    		j++;
			    	}
			  res =  String.valueOf(lt);
			}else{
				//System.out.println("no es pal");
			    //new StringBuffer(string).reverse().toString();
			        for(int  k =   io; k   >=  0 ;  k--){
			            lt[lt.length - 1 - k] = lt[k];
			        }
			    res =  String.valueOf(lt);
			    //System.out.println(s + "a " + res);
			    if(gt(s, res)){
			    	//System.out.println(s + "  gt " + res);
			    	res = "";
			    	i = io;
			    	j = jo;
			    	boolean cont =   true;
			    	while( cont && i >= 0){
			    		//sumar
			    		if( lt[i] == '9'){
			    			lt[i] = '0';
			    			lt[j] = '0';
			    		}
			    		else{
			    			lt[i] = ((Character.getNumericValue(lt[i])  + 1) + "").charAt(0);
			    			if(i != j)lt[j] = ((Character.getNumericValue(lt[j])  + 1) + "").charAt(0);
			    			cont =  false;
			    		}
			    		i--;
			    		j++;
			    	}
			    }
			    res =  String.valueOf(lt);
			}
		}
		return res;
	}
	
	private static boolean gt(String s, String res) {
		//System.out.println(s  + " " + res);
		int a ,b;
		
		for(int i = 0 ;  i <  s.length() ;  i++){
			a = Character.getNumericValue(s.charAt(i)) ;
			b = Character.getNumericValue(res.charAt(i));
			//System.out.println(i + " " + Character.getNumericValue(s.charAt(i))  + " "  +  Character.getNumericValue(res.charAt(i)));
			if(a < b){
				
				return false;
			}else if( a > b){
				return true;
			}else{
				
			}
		}
		return false;
	}


	public static boolean checkNines(String s){
		for(int i = 0 ; i <  s.length() ; i++){
			if(s.charAt(i) != '9')
				return false;
		}
		return true;
	}
}
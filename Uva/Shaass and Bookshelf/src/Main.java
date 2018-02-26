import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class Main {
	public static int b;
	public static int[][] libros;
	public static ArrayList<Libro> lib;
	public static Hashtable<String  , Integer> mem;
	public static void main(String args[])  throws Exception{
		
		mem =  new Hashtable<String , Integer>();
		BufferedReader br =  new BufferedReader (new InputStreamReader(System.in));
		String linea , datos[];
		b =  Integer.parseInt(br.readLine().trim());
		libros =  new int[b][2];
		lib =  new ArrayList<Libro>();
		int w , res = 0; 
		for(int i = 0 ; i < b ; i++){
			datos =  br.readLine().trim().split(" ");
			//libros[i][0] =  Integer.parseInt(datos[0]);
			//libros[i][1] =  Integer.parseInt(datos[1]);
			w =   Integer.parseInt(datos[1]);
			res += w;
			lib.add(new Libro(Integer.parseInt(datos[0]) , w, lib.size()));
		}
		Collections.sort(lib);
		int k = 0;
		for(Libro a   : lib){
			System.out.println( a.t  +  " " + a.w + "  "  );
		
		}
		
		System.out.println(fi(0 ,  res));
		//System.out.println(res);
		
		
		int tt   = 0, wt = 0 ;
		int tt2  = 0, wt2 = 0; 
		boolean ter =  false;
		int res1 ,  res2;
		res1 =  res;
		res2 =  res;
		int s1  =  Integer.MAX_VALUE , s2= Integer.MAX_VALUE;
		for(int i = 0 ;  i < lib.size() && !ter ;  i++){
			tt += lib.get(i).t;
			res-= lib.get(i).w;
			System.out.println(tt + "-  " + res);
			if(tt  >= res) {
				s1 = tt;
				tt -= lib.get(i).t;
				res2 =  res + lib.get(i).w;
				if(i < lib.size() - 1){
					tt += lib.get(i + 1).t;
					res2-= lib.get(i + 1).w;
					System.out.println("  "+tt + "-  " + res2);
					if( tt >= res2){
						s2 =  tt;
					}
				}
				if( s1 < s2){
					if(s1 >= res){
						ter =  true;
						tt =  s1;
					}
				}else{
					if(s2 >= res2){
						ter =  true;
						tt =  s2;
					}
				}
				System.out.println(s1 + " -  " + s2  + " " + res);	
			}
		}
		System.out.println(tt);
		
	}
	
	
	public  static int fi(int t ,  int w ){
		int res =  Integer.MAX_VALUE;
		String key="";
		
		for(Libro s :  lib){
			key+="-" + s.u; 
		}
		
		if(mem.containsKey(key)){
			//System.out.println("use");
			return mem.get(key);
		
		}
		else{
			if( t >= w){
				if(res == 16) System.out.println("res " + t);
				mem.put(key    , t);
				return t;
			}
			else{
				for(int i = 0 ;  i < lib.size() ; i++){
					Libro temp =  lib.get(i);
					lib.remove(i);
					res = Math.min( res , fi(t + temp.t ,  w - temp.w) );
					lib.add(i , temp);
				}
				return res;
			}
		}
	}
	
	

}


class Libro implements Comparable {
	int t , w , o ,  u;
	public Libro(int t , int w, int u){
		this.t = t ;  this.w = w;
		this.o =  t + w;
		this.u = u;
	}

	@Override
	public int compareTo(Object o) {
		Libro l =  (Libro)o;
		if(this.o >  l.o) return -1;
		else if( this.o <  l.o) return 1;
		else{
			if(this.w >  l.w) return -1;
			else if(this.w < l.w)  return 1;
			else return 0;
			
		}
	}


}

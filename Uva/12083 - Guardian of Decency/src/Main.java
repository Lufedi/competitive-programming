import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static ArrayList<Persona> mujeres , hombres;
	public static ArrayList<ArrayList<Integer>>  g;
	public static int n , cm;
	public static int vis[] , matched[];
	public static void main(String[] args)  throws Exception{ 
		// TODO Auto-generated method stub

		
		Scanner sc =  new Scanner(System.in);
		String linea , datos[] ; 
		int casos ;
		
		casos =  sc.nextInt();
		for(int i = 0 ;  i < casos ;  i++){
			n =  sc.nextInt();
			cm = 0;
			hombres = new ArrayList<Persona>();
			mujeres =  new ArrayList<Persona>();
			g  =  new ArrayList<ArrayList<Integer>>();
			int he  ;
			String music , sport , sex;
			for(int  j =  0 ;  j < n ;  j++){
				
				he =  sc.nextInt();
				sex =  sc.next(); music =  sc.next() ; sport =  sc.next();
				
				if(sex.equals("M")){
					mujeres.add(new Persona(he, sex ,  music , sport));
					cm++;
				}else{
					hombres.add(new Persona(he , sex ,  music , sport));
				}
					
			}

			for(int k = 0 ; k <  cm ;  k++) mujeres.get(k).id = k;
			for(int k = 0 ; k <  hombres.size() ;  k++) hombres.get(k).id  =  k + cm;
			
			for(int j = 0 ;  j< cm ;  j++)g.add(new ArrayList<Integer>());
			
			 matched =  new int[n];
			 vis =  new int[cm];
			
			for(Persona m :  mujeres){
				for(Persona h :  hombres){
					if(Math.abs(m.h -  h.h)  <= 40 &&   m.music.equals(h.music) && 
							!m.sport.equals(h.sport)){
						g.get(m.id).add(h.id);
					}
				}
			}
			
			
			solve();
		}
		
	}

	private static int  Aug(int k){
		if(vis[k] == 1)return 0;
		vis[k] = 1;
		for(int j  = 0 ;  j <  g.get(k).size() ;  j++){
			int r = g.get(k).get(j);
			if(matched[r] == -1 || Aug(matched[r]) == 1){
				matched[r] =  k;return  1;
			}
		}
		return 0;
	}
	private static void solve() {
		int MCBM = 0 ; 
		Arrays.fill(matched , -1);
		
		for(int l= 0 ;  l <  cm ;  l++){
			Arrays.fill(vis, 0);
			MCBM+= Aug(l);
		}
		System.out.println(n - MCBM);
	}

}

class Persona{
	public int h  , id;
	public String sex ,  music ,  sport;
	public Persona(int h , String sex  , String music , String sport ){
		this.h = h ;  this.sex =  sex; this.music =  music ;  this.sport =  sport;
		this.id = id;
	}
	
	
}

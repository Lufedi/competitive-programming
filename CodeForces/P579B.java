import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class B {

	
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
	
		 //System.out.println(Arrays.toString(p));
		 BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		 String linea, datos[];
		 int n = Integer.parseInt(br.readLine());
		 int m[] =  new int[2*n];
		 ArrayList<Tripla> p =  new ArrayList<Tripla>();
		 for(int i  = 0 ; i <  2*n - 1 ;  i++){
			linea =  br.readLine();
			datos  = linea.split(" ");
			for(int j = 0 ;  j<  datos.length; j++){
				p.add(new Tripla(Integer.parseInt(datos[j]) , i + 2 , j+1));
			}
		 }
		 Collections.sort(p);
		 /*for(int i = 0 ; i <  p.size() ;  i++){
			 System.out.println(p.get(i).v + " " + p.get(i).i  + " " + p.get(i).j );
		 }*/
		 for(int i = p.size() - 1 ; i >=0  ; i--){
			 Tripla  t =  p.get(i);
			 if(m[t.i - 1] == 0 && m[t.j - 1] ==0){
				 m[t.i - 1] = t.j;
				 m[t.j - 1] = t.i;
			 }
		 }
		 for(int i = 0 ; i < m.length; i++){
			 if(i == 0){
				 System.out.print(m[i]);
			 }else{
				 System.out.print(" " + m[i]);
			 }
		 }
		 System.out.println();
		
	}

}

class Tripla implements Comparable<Tripla>{
	int v, i , j;

	public Tripla(int v, int i, int j) {
		super();
		this.v = v;
		this.i = i;
		this.j = j;
	}

	@Override
	public int compareTo(Tripla o) {
		if(this.v > o.v){
			return 1;
		}else if(this.v < o.v){
			return -1;
		}else{
			return 0;
		}
	}
	
}
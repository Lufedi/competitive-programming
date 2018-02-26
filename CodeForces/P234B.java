
 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br =  new BufferedReader( new FileReader("input.txt"));
		
		BufferedWriter bw =  new BufferedWriter( new FileWriter("output.txt"));
		String datos[] = br.readLine().trim().split(" ");
		int a , b;
		
		a =  Integer.parseInt(datos[0]);
		b =  Integer.parseInt(datos[1]);
		//System.out.println("res" + a + " " + b);
		datos =  br.readLine().trim().split(" ");
		//System.out.println(Arrays.toString(datos));
		Light lights[] =  new Light[a];
		for(int i = 0; i <  datos.length ; i++){
			lights[i] =  new Light( i + 1 ,  Integer.parseInt(datos[i]));
		}
		Arrays.sort(lights);
		bw.write(lights[lights.length - b].v  + "");
		
		//System.out.println(lights[lights.length - b].v + " " + Arrays.toString(lights));
		bw.newLine();
		int res[] =  new int[b];
		for(int i = 0 ; i <  b ; i++){
			res[i] =  lights[lights.length - 1 - i].id;
		}
		Arrays.sort(res);
		for(int i = 0 ; i <  res.length ; i++){
			if( i == 0 ) bw.write(res[0] + "");
			else bw.write(" "+res[i]);
		}
		bw.newLine();
		br.close();
		bw.close();
		
		// TODO Auto-generated method stub

	}

}



class Light implements Comparable<Light>{

	public int id ,  v;
	public Light(int id , int v){this.id = id ; this.v = v;}
	public int compareTo(Light o) {
		 if( this.v  >  o.v) return 1 ;
		 else if( this.v < o.v)return -1;
		 else return 0;
	}
	public String toString(){
		return this.v+" "+id;
	}
	
	
}
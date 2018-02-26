import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	
	public static void main(String[] args)  throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String line , datos[];
		int d ;
		Queue<Nodo> cola = new LinkedList<Nodo>();
		line  =  br.readLine();
		datos=  line.split(" ");
		d =  Integer.parseInt(datos[1]);
		
		datos =  br.readLine().split(" ");
		for(int i = 0 ; i <  datos.length ; i++){
			cola.add(new Nodo(i + 1 ,  Integer.parseInt(datos[i])));
		}
		Nodo a ;
		while( cola.size() >  1){
			 a= cola.peek();
			if(a.n > d){
				a.n -= d;
				Nodo b =  cola.poll();
				cola.add(b);
			}else{
				cola.poll();
			}
		}
		System.out.println(cola.peek().id);
	}
}

class Nodo{
	int id ,  n ; 
	public Nodo(int id , int n){
		this.id =  id ; this.n = n;
	}
}
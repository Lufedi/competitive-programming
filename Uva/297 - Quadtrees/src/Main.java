import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	
	public static void main(String args[]) throws Exception{
		

		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String datos[] ;
		int casos =  Integer.parseInt(br.readLine().trim());
		String a1 , a2;
		/*for(int i = 0 ;  i < casos  ;  i++){
			a1 =   br.readLine().trim();
			a2 =  br.readLine().trim();
			Node.fin = 0;
			Node a =  new Node(a1);
			Node.fin = 0;
			Node b =  new Node(a2);
			a.print();
			System.out.println();
			b.print();
			
			a.Union(b);
			a.print();
			
		
		}*/
		
			
			
			Node.fin = 0;
			Node a =  new Node("pefef");
			Node.fin = 0;
			Node b =  new Node("pefef");
			a.print();
			System.out.println();
			b.print();
			
			a.Union(b);
			System.out.println("despues de union");
			a.print();
			
		
		
		
	}
	
	
	
	
}





class Node{
	public static int fin = 0;
	public static char PP  = 'p',  EE = 'e' ,  FF = 'f'  ;
	private char  valor;
	private  Node hijos[];

	
	
	public Node(String s  ){
		
		if(Node.fin < s.length() &&( s.charAt(Node.fin) == EE || s.charAt(Node.fin) == FF)){
			this.valor = s.charAt(Node.fin);
			
		}else{
			this.hijos =  new Node[4];
			this.valor =  PP;
			for(int i = 0 ; i <  4  && Node.fin < s.length();  i++){
				/*if( i > 0){
					this.hijos[i] =  new Node(s , Node.fin);
				}
				else this.hijos[i] =  new Node(s ,  inicio + 1);*/
				Node.fin++;
				this.hijos[i] =  new Node(s);
			}
		}
	}
	
	public  void print(){
		if(this.valor !=  PP) System.out.print( this.valor + " -> ") ;
		else{
			System.out.print( this.valor + " -> ");
			for(Node i : hijos){
				if(i  != null)i.print();
			}
		}
		
	}
	
	public void Union(Node other){
		
		if(this.valor == FF || other.valor ==  FF) this.valor =  FF;
		else if(this.valor == EE && other.valor ==  EE) this.valor = EE;
		else if( this.valor == EE  && other.valor == PP ){
			this.valor =  PP;
			this.hijos = new Node[4];
			for(int i = 0 ; i < 4 ; i++ ){
				this.hijos[i].Union(other.hijos[i]);
			}
		}else if( this.valor == PP && other.valor == PP){
			for(int i = 0 ; i < 4 ; i++ ){
				this.hijos[i].Union(other.hijos[i]);
			}
			int f = 0 , e = 0 ;
			for(Node i : hijos){
				if(i.valor == FF) f++;
				else if(i.valor == EE)e++;
			}
			if(f == 4)  this.valor =  FF;
			else if(e == 4) this.valor =  EE;
			else this.valor = PP;
			
		}
		
		
	}
	
}

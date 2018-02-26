import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;






public class Main {

	public static double EPS = 1e-9;
	public static BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
	public static String read() throws Exception{return br.readLine().trim();}
	public static int pint(String s){return Integer.parseInt(s);}
	public static void main(String[] args)  throws Exception{
		String linea , datos[];
		int casos ,  v;
		while(!(linea =  br.readLine()).equals("0")){
			v =  pint(linea);
			Poligono g1 = new Poligono();
			for(int  i = 0 ;  i < v ;  i++){
				datos =  read().split(" ");
				g1.puntos.add(new Punto(pint(datos[0]) ,  pint(datos[1])));
				if(i == v -1)g1.puntos.add(new Punto(pint(datos[0]) ,  pint(datos[1])));
			}
			v =  pint(read());
			Poligono g2 = new Poligono();
			for(int  i = 0 ;  i < v ;  i++){
				datos =  read().split(" ");
				g2.puntos.add(new Punto(pint(datos[0]) ,  pint(datos[1])));
				if(i == v -1)g2.puntos.add(new Punto(pint(datos[0]) ,  pint(datos[1])));
			}
			
			//verificar intersecciones
			ArrayList<Punto> inter =  new ArrayList<Punto>();
			for(int i =  0 ;  i <  g1.puntos.size() - 2 ;  i++){
				Linea l1 =  toLinea(g1.puntos.get(i) , g1.puntos.get(i + 1));
				for(int j = 0 ; j < g2.puntos.size()  - 2;  j++){
					Linea l2 =  toLinea(g2.puntos.get(i) , g2.puntos.get(i + 1));
					Punto p =  intersecta(l1,l2);
					if(p != null){
						inter.add(p);
					}
				}
			}
			
			
			//inpolygon g1 en g2
			for(int i = 0 ;  i <  g1.puntos.size() ;  i++){
				Punto p =  g1.puntos.get(i);
				if(inPolygon( p, g2)){
					inter.add(p);
				}
			}
			for(int i = 0 ;  i <  g2.puntos.size() ;  i++){
				Punto p =  g2.puntos.get(i);
				if(inPolygon( p, g1)){
					inter.add(p);
				}
			}
			//intersecciones
			for(int i = 0 ;  i <  inter.size() ;  i++){
				System.out.println(inter.get(i).x + " "  + inter.get(i).y);
			}
			
		}
		
		
	}
	
	public static double angle(Punto a, Punto  o, Punto b) { // returns angle aob in rad
		Vec oa = toVec(o, a), ob = toVec(o, b);
		return Math.acos(dot(oa, ob) / Math.sqrt(norm_sq(oa) * norm_sq(ob))); 
	}

	static double dot(Vec  a, Vec b) { return (a.x * b.x + a.y * b.y); }
	static double norm_sq(Vec  v) { return v.x * v.x + v.y * v.y; }
	
	public static Vec toVec(Punto a , Punto b){
		return new Vec(b.x - a.x , b.y - a.y);
	}
	public static double cross(Vec a ,  Vec b){
		return a.x*b.y - a.y*b.x;
	}

	public static boolean ccw(Punto p, Punto q, Punto r) {
		return cross(toVec(p, q), toVec(p, r)) > 0; 
	}
	 // returns true if point p is in either convex/concave polygon P
	public static boolean inPolygon(Punto pt, Poligono P) {
	if ((int)P.puntos.size() == 0) return false;
	double sum = 0; // assume first vertex = last vertex
	for (int i = 0; i < (int)P.puntos.size()-1; i++) {
	
		if (ccw(pt, P.puntos.get(i), P.puntos.get(i+1)))
			sum += angle(P.puntos.get(i), pt, P.puntos.get(i+1)); // left turn/ccw
		else 
			sum -= angle(P.puntos.get(i), pt, P.puntos.get(i+1)); } // right turn/cw
		return Math.abs(Math.abs(sum) - 2*Math.PI) < EPS; 
	}
	
	public static Punto intersecta(Linea l1 , Linea l2){
		Punto p =  new Punto();
		if(paralelas(l1 , l2)) return null;
		p.x =  (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a *l2.b);
		if(Math.abs(l1.b) > EPS)p.y -=(l1.a * p.x + l1.c);
		else p.y -= (l2.a * p.x + l2.c);
		return p;
		
	}
	private static boolean paralelas(Linea l1, Linea l2) {
		return (Math.abs(l1.a - l2.a)< EPS) && (Math.abs(l1.b - l2.b) < EPS);
	}
	public static Linea toLinea(Punto p1 , Punto p2){
		Linea l  =  new Linea();
		if(Math.abs(p1.x - p2.x) < EPS){
			l.a = 1.0;
			l.b = 0.0;
			l.c = -p1.x;
		}else{
			l.a = -(double)(p1.y - p2.y)/(p1.x - p2.x);
			l.b = 1.0;
			l.c = -(double)(l.a * p1.x) - p1.y;
		}
		return l;
	}
	
}
class Vec{
	double x,y;
	public Vec(double x , double y){
		this.x =  x ;
		this.y = y;
	}
}
class Punto{
	double x , y;
	public Punto(double x, double y){
		this.x =  x;
		this.y = y;
		
	}
	public Punto() {
		// TODO Auto-generated constructor stub
	}
}

class Poligono{
	public ArrayList<Punto> puntos;
	public Poligono(){
		puntos =  new ArrayList<Punto>();
	}
}

class Linea{
	double a, b , c;
	public Linea(double a , double b, double c){
		this.a =  a;
		this.b =  b;
		this.c =  c;
	}
	public Linea() {
		// TODO Auto-generated constructor stub
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class Main{



static String name  , line; 
static double lat ,  lon;

public static int  earthRadius = 6378; 
public static double PI = 3.14;

public static void main(String[] ars) throws Exception{

	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	Hashtable<String , Vector>  memoria =  new Hashtable<String , Vector>();	
	Hashtable<String,  Point> memo  =  new Hashtable<String , Point>();

	line = br.readLine();
	String datos[];
	while( !line.equals("#")){
		datos  = line.split(" ");
		lat = Double.parseDouble(datos[1]);
		lon = Double.parseDouble(datos[2]);

		Vector v  = new Vector(convertSphericalToCartesian(lat , lon) );
		memoria.put(datos[0] ,   v);
		System.out.println(v);
		memo.put(datos[0] ,  new Point(lat  ,  lon));
		memo.put(datos[0] , new Point(lat , lon));
		line = br.readLine();
		
	}
	line = br.readLine();
	while( !line.equals("# #")){
		
		datos =  line.split(" ");
		Vector u =  memoria.get(datos[0]);
		Vector v = memoria.get(datos[1]);

		System.out.println(datos[0] + " - " + datos[1]);


		if(memoria.containsKey(datos[0]) && memoria.containsKey(datos[1])){
			System.out.println(arc( u,  v));
			Point r = memo.get(datos[0]);
			Point t = memo.get(datos[1]);
			double k = kjsdf(r.la , r.lo  , t.la , t.lo);
			System.out.println((int) Math.round(k) + " km");
			
		}else{
			System.out.println("Unknown");
		}
		line = br.readLine();
	}
}

public static double arc(Vector  u ,  Vector v){

	double ang = angulo(u  , v);
	ang = ang*(180/Math.PI);
	return  ((ang/360)*2*PI*earthRadius);


}

public static double kjsdf( double lat1  , double lon1 ,  double lat2 ,  double lon2){
 
  double dLat = deg2rad(lat2-lat1);  // deg2rad below
  double dLon = deg2rad(lon2-lon1); 
  double a = 
  Math.sin(dLat/2) * Math.sin(dLat/2) +
  Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
  Math.sin(dLon/2) * Math.sin(dLon/2); 
  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  double d = earthRadius * c; // Distance in km
  return d;
}


public static double deg2rad(double deg) {
  return deg * (Math.PI/180);
}






public static double angulo(Vector u , Vector v){
	return Math.acos( dot(u,v) / Math.sqrt( norm_sq(u)*norm_sq(v)));
}
public static double dot( Vector u , Vector v){
	return (u.x*v.x +  u.y*v.y + u.z*v.z);
}
public static double norm_sq(Vector u){
	return (u.x*u.x  + u.y*u.y + u.z*u.z);
}


public static  Cartesiana3D convertSphericalToCartesian(double lat , double lon)
{


	

    lat = lat * Math.PI / 180;
    lon = lon * Math.PI / 180;

    double x = earthRadius * Math.sin(lat) * Math.cos(lon);
    double y = earthRadius * Math.sin(lat) * Math.sin(lon);
    double z = earthRadius * Math.cos(lat);

    //System.out.println(" to " + x + "  " + y + "  " + z);
    return new Cartesiana3D(x,y,z);
}


}

class Cartesiana3D{

	double x, y , z;
	public Cartesiana3D(double _x , double _y , double _z){
		x = _x; y = _y ; z = _z;
	}
}

class Vector{
	double x , y , z;
	public Vector(Cartesiana3D a){
		x = a.x;
		y = a.y;
		z = a.z;
	}
	public String toString(){
		return (x +" , " + y + " , " + z);
	}

}

class Point{
	double la , lo ;
	public Point(double _la, double _lo){
		la = _la;
		lo = _lo;
	}
}


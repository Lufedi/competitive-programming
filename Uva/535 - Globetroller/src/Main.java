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

	line = br.readLine();
	String datos[];
	while( !line.equals("#")){
		




	
		datos  = line.split(" ");
		lat = Double.parseDouble(datos[1]);
		System.out.println(lat);
		lon = Double.parseDouble(datos[2]);
		System.out.println(lon);

		Vector v  = new Vector(convertSphericalToCartesian(lat , lon) );
		System.out.println(" adding " +  datos[0] + " " + v);
		memoria.put(datos[0] ,   v);
		line = br.readLine();
		
	}

	
	
	line = br.readLine();
	while( !line.equals("# #")){
		datos =  line.split(" ");
		Vector u =  memoria.get(datos[0]);
		Vector v = memoria.get(datos[1]);
		System.out.println( u );
		System.out.println(datos[0] + " - " + datos[1]);
		System.out.println(arc( u,  v));
		line = br.readLine();
	}
}

public static double arc(Vector  u ,  Vector v){

	double ang = angulo(u  , v);
	return  ((ang/360)*2*PI*earthRadius);


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
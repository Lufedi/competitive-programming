import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		
		
	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	String datos[] ;  String linea ;
	
	int fechas;
	
	
	while((fechas = Integer.parseInt(br.readLine().trim()))!= 0){
		int contGr = 0;
		long contCn = 0;
		boolean quiebre =  false;
		Consumo dts[] = new Consumo[fechas];
		for(int i = 0 ; i < fechas ;  i++){
			datos =  br.readLine().trim().split(" ");
			dts[i] =  new Consumo( 
		  new GregorianCalendar( Integer.parseInt(datos[2]), Integer.parseInt(datos[1]) - 1 , Integer.parseInt(datos[0])) ,
		  			Integer.parseInt(datos[3])
					);
		}
		
		for(int i = 0 ; i < fechas - 1 ; i++){
			dts[i].a.add(GregorianCalendar.DATE, 1);
			if( igual( dts[i].a, dts[i + 1].a )){
				contGr++;
				contCn+= (dts[i + 1].c  - dts[i].c);
			}
		}
		
		System.out.println(contGr + " " + contCn);
		
		
			
	}
		
	}

	private static boolean igual(GregorianCalendar a, GregorianCalendar b) {
		return ( a.get(a.YEAR) == b.get(b.YEAR)  && 
				a.get(a.DAY_OF_MONTH) == b.get(b.DAY_OF_MONTH) && 
				a.get(a.MONTH) == b.get(b.MONTH));
	}

	
	
	
}
class Consumo{
	public GregorianCalendar a ;
	public long c;
	
	Consumo(GregorianCalendar a , long c){
		this.a = a ;
		this.c = c;
	}
	
}

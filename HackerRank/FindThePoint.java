import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Point {

	
	
	public static int pint(String s){
		return Integer.parseInt(s);
	}
	public static void main(String[] args)  throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<  n ;  i++){
			String data[] = br.readLine().split(" ");
			int px  = pint(data[0]) , py  = pint(data[1]), qx = pint(data[2]) ,qy = pint(data[3]);
			int rx, ry;
			int dx = Math.abs(px - qx);
			int dy = Math.abs(py - qy);
			if( px < qx){
				rx = qx + dx;
			}else if(px > qx){
				rx = qx - dx;
			}else{
				rx = qx;
			}
			
			if( py < qy){
				ry = qy + dy;
			}else if(py > qy){
				ry = qy - dy;
			}else{
				ry = qy;
			}
			System.out.println(rx +" "+ ry);
		}
		
		
		
		
	}
}

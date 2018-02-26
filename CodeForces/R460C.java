import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class R460C {

	
	

public static int pint(String s ){return Integer.parseInt(s);}
public static String[] reads() throws Exception{return br.readLine().trim().split(" ");}
public static String read() throws Exception{return br.readLine().trim();};
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static boolean[] mark= new boolean[5001];
	public static void main(String[] args)  throws Exception{
		String line, data[];
		
		data = reads();
		int rows=  pint(data[0]);
		int columns=  pint(data[1]);
		int friends=  pint(data[2]);
		
		int room[][] = new int[rows][columns];
		for(int i = 0 ;  i <  rows ;  i++){
			line =  read();
			for(int j = 0 ; j < columns ; j++){
				if(line.charAt(j) == '.'){
					room[i][j] = 0;
				}else{
					room[i][j] = 1;
				}
			}
		}
		int res  = 0;
		if( friends == 1){
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					res+= (room[i][j] == 0)?1:0;
				}
			}
		}else{
			
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					
					
					if( j + friends <= columns){
						boolean valid =  true;
						for(int k = 0 ; k < friends; k++){
							valid = valid &&  room[i][j+k] == 0;
						}
						if(valid) {
						
							res++;
						}
					}
					
					if( i + friends <= rows){

						boolean valid =  true;
						for(int k = 0 ; k < friends; k++){
					
							valid = valid &&  room[i+k][j] == 0;
						}
						if(valid){
				
							res++;
						}
					}
					
				}
			}
		}
		
		
		
		System.out.println(res);
	}
}

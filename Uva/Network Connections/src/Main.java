import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String linea = null;
		
			linea = br.readLine().trim();
			int cases = Integer.parseInt(linea);
			br.readLine();
			for(int i = 0 ; i <  cases ; i ++){
				if(i > 0)System.out.println();
				int ac = 0 , wr = 0;
				int tot = Integer.parseInt(br.readLine().trim());
				int ntw[] = new int[tot];
				for(int j = 0 ;j < tot ; j++) ntw[j] = j;
				String a[] ;
				while( (linea = br.readLine()) != null){
					if(linea.equals("")) break;
					
					a = linea.split(" ");
					//System.out.println("c" + a[0] + "1" + a[1] + "2" + a[2]);
					if(a[0].equals("c")){
						int i1 = ntw[Integer.parseInt(a[1]) - 1];
						int i2 = ntw[Integer.parseInt(a[2]) - 1];
						for(int k = 0 ; k < tot ; k++){
							if(ntw[k] == i1) ntw[k] = i2;
						}
						
					}else{
						if(ntw[Integer.parseInt(a[2]) - 1] == ntw[Integer.parseInt(a[1]) - 1])ac++;
						else wr++;
					}
				}
				
				System.out.println(ac + "," + wr);
				
				
			}
			
		}

	
}

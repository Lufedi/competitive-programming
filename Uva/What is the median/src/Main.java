import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> a  =  new ArrayList<Integer>();
       while((line = br.readLine()) != null){
             a.add(Integer.parseInt(line.trim()));
        	
        	Collections.sort(a);
        	int m = a.size()/2;
        	if(a.size() % 2 == 0){
        		//sb.append((a.get(m - 1) + a.get(m))/2 + "\n");
        		System.out.println((a.get(m - 1) + a.get(m))/2);
        	}else{
        		//sb.append(a.get(m) + "\n");
        		System.out.println(a.get(m));
        	}
        	

        }
        //System.out.print(sb.toString() );
        br.close();
        System.exit(0);
    
    
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;


public class Main2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		br.readLine();
		
		Hashtable<String , Integer> db ;
		LinkedList<String> names;
		
		
		
		int tmp , total;
		for(int i = 0 ; i < n ; i++){
			if(i> 0)System.out.println();
			
			db =  new Hashtable<String , Integer>();
			names = new LinkedList<String>();
			String line;
			total = 0;
			
			while((line = br.readLine().trim()) != null && (!line.isEmpty())){
				if(db.containsKey(line)){
					tmp  = db.get(line);
					tmp++;
					db.put(line , tmp);
					
				}else{
					db.put(line, 1);
					names.add(line);
				}
				total++;
				
			}
			Collections.sort(names);
			for(int d = 0 ; d < names.size() ; d++){
					String str=names.get(d);
					  double val=(double)db.get(str)*100/total;
				 System.out.printf("%s %.4f\n", str,val);
				
			}
			
			
		}
		
		

	}

}

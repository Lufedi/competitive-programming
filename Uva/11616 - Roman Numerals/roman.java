

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class roman {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

		String[] unid = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String[] dece = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] cent = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] mill = new String[]{"","M","MM","MMM"};
		String line;
		
		/*for(int  i = 1; i < 4000 ; i++ ){
			int res =  arabe(romano(i , unid , dece , cent , mill));
			if( i != res) {
				System.out.println(i);
			}

		}*/
		
		while(br.ready()){
			line = br.readLine().trim();
			if( line.charAt(0) == 'I' ||line.charAt(0) == 'V'  || 
				line.charAt(0) == 'X' || line.charAt(0) == 'L'|| 
				line.charAt(0) == 'C'|| line.charAt(0) == 'D' ||
				line.charAt(0) == 'M'){
				
				System.out.println(arabe(line));
			}else{
				System.out.println(romano( Integer.parseInt(line)   , unid , dece , cent , mill));
			}
		}
		
		br.close();System.exit(0);
		
		
		
	}

	private static int arabe(String Srom) {
		int l =Srom.length();
		int[] Vrom = new int[l];
		
		for(int i=0; i<l; i++){
			switch(Srom.charAt(i)){
			case 'M': Vrom[i] = 1000; break;
			case 'D': Vrom[i] = 500; break;
			case 'C': Vrom[i] = 100; break;
			case 'L': Vrom[i] = 50; break;
			case 'X': Vrom[i] = 10; break;
			case 'V': Vrom[i] = 5; break;
			case 'I': Vrom[i] = 1; break;
			}
		}
		int rta, index=l-1;
		rta=Vrom[index];
		index--;
		while(index>=0){
			if(Vrom[index] < Vrom[index+1]) rta -= Vrom[index];
			else rta += Vrom[index];
			index--;
		}
		return rta;
	}

	private static String romano(int arab, String[]unid, String[]dece, String[]cent, String[]mill) {
		int[] Varab = new int[4];
		for(int i=0; i<4 ;i++){
			Varab[i] = arab%10;
			arab = arab/10;
		}
		return mill[Varab[3]]+cent[Varab[2]]+dece[Varab[1]]+unid[Varab[0]];
	}
}

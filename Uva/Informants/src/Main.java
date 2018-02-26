import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		String line = br.readLine();
		while(!line.equals("0")){
			int n =Integer.parseInt(line);
			String[] moves = br.readLine().split(" ");
			solve(moves);
			line = br.readLine();
		}

		br.close();

	}

	private static void solve(String[] moves) {
		String estado = "+x";
		boolean signo = true;
		for(int cont=0;cont<moves.length;cont++){
			if(estado.equals("+x") && !moves[cont].equals("No")){
				estado = moves[cont];
			}else if(estado.charAt(1)==moves[cont].charAt(1) && !moves[cont].equals("No")){
				if(estado.charAt(0)==moves[cont].charAt(0)){
					estado= estado.charAt(0)=='-'?"+x":"+x";
					signo = !signo;
				}else{
					estado= "+x";
				}
			}
		}
		if(signo){
			System.out.println(estado);
		}else{
			char cambio = estado.charAt(0);
			if(cambio=='+'){
				cambio='-';
			}else{
				cambio ='+';
			}
			System.out.println(new Character(cambio)+""+ estado.charAt(1)+"");
		}
		
		
		
	}

}

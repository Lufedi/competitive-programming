
//Round 496 D3 1005B
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1, s2;
        s1 = br.readLine();
        s2 = br.readLine();

        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 < l2){
            String aux = s1;
            s1 = s2;
            s2 = aux;

            int auxL = l1;
            l1 = l2;
            l2 = auxL;
        }

        int cont = 0;
        for(int i = 1 ; i <= s2.length(); i++){
            if( s2.charAt( l2 - i)  == s1.charAt(l1 - i)){
                cont++;
            }else{
                break;
            }
        }
        System.out.println( (l1 - cont) + (l2 - cont));
    }
}

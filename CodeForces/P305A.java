import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    
    
    public static void main(String[] args)  throws Exception{
        
        BufferedReader br =  new BufferedReader(new  InputStreamReader(System.in));
        int p;
        int n[]  , res[];
        
        p = Integer.parseInt(br.readLine());
        String datos[]  = br.readLine().split(" ");
        n =  new int[datos.length]; res=  new int[datos.length];
        int added = 0 ,  noAv = 0 , pos1  = -1 , pos2 = -1 , pos3 = -1;
        for (int i = 0; i < datos.length; i++) {
            n[i] =  Integer.parseInt(datos[i]);
            if( n[i] == 0 || n[i] == 100){
                res[added++] =  n[i]; 
            }
            if(n[i] > 0 && n[i] < 10)pos1 = i;
            if(n[i] > 0 && n[i] < 100 ) {
                if(n[i] % 10 == 0) pos2 = i;
                else pos3 = i;
            }
            
        }
        // < 10;
        
        if(added > 0 && pos1 != -1)res[added++] =  n[pos1];
        if(added > 0 && pos2 != -1)res[added++] =  n[pos2];
        if(added == 0 && pos1 != -1 && pos2 != -1){
            res[added++] =  n[pos1] ;res[added++] =  n[pos2];
        }
        if(added >  0 && pos1 == -1 && pos2 == -1 && pos3 != -1)res[added++] = n[pos3];
        if( added == 0){
            res[added++] =  n[0];
        }
        System.out.println(added);
        for(int i  = 0 ;i < added ; i++){
            if(i == 0){
                System.out.print(res[i]);
            }else{
                System.out.print(" " + res[i]);
            }
        }
        System.out.println();

    }
}
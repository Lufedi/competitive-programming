import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;



public class C1023 {


    
    public static void main(String[] Public) throws Exception {

    
        //InputStream inputStream = new FileInputStream("src/p.in");
        InputStream inputStream = System.in;
        InputStreamReader input = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(input);
        String data[] = br.readLine().split(" ");
        long n, m;
        n = Long.parseLong(data[0]);
        m = Long.parseLong(data[1]);
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
      
        StringBuilder answer = new StringBuilder();
        int cont  = 0;
        int balance = 0;
        for(int i = 0 ; i < s.length() && cont < m ; i++){
            if(s.charAt(i) == '('){
               
                answer.append("(");
                balance += 1;
                cont+=2;
               
            }else{
                balance -= 1;
                answer.append(")");
               
            }
            
        }

        
        if(balance > 0){
            for(int i = 0 ; i < balance; i++){
                answer.append(")");
            }
        }
        System.out.println(answer.toString());

       
    }


}

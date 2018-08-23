import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileInputStream;

public class A1023 {



    public static void main(String[] args)  throws Exception{
        //InputStream source = new FileInputStream("src/p.in");
        InputStream source = System.in;
        InputStreamReader input = new InputStreamReader(source);
        BufferedReader br = new BufferedReader(input);
        br.readLine();
        String s = "-" + br.readLine() + "-";
        String t = "-" + br.readLine() + "-";

        boolean match = false;
        String data[] = s.split("\\*");
        //System.out.println(Arrays.toString(data));
        
        if(data.length > 1 ){
            if( t.startsWith(data[0]) && t.endsWith(data[1]) &&
                data[0].length() <=  t.length()-data[1].length() ) { // no overlapping
                match = true;
            }
       }else{
            match = s.equals(t);
       }
        if(match){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }
}

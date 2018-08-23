import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class B1023 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data[] = br.readLine().split(" ");
        long n, m;
        n = Long.parseLong(data[0]);
        m = Long.parseLong(data[1]);
        long mid = m/2;
        long res =  Math.max(Math.min(n, m-1) - mid, 0);

        System.out.println( res);


    }
}

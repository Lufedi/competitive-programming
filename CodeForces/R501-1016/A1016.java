import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class A1016 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data[]  = br.readLine().split(" ");

        int n = Integer.parseInt(data[0]), m = Integer.parseInt(data[1]);

        Long days[] = Stream.of( br.readLine().split(" "))
                .map(Long::parseLong).toArray(Long[]::new);

        long currentPage= 0;
        long currentWords = 0;
        long[] results = new long[n];

        for(int i = 0 ; i < days.length ; i++){

            currentWords+= days[i];
            long pages = currentWords / m;
            results[i] = pages - currentPage;
            currentPage = pages;
        }

        for(int i = 0 ; i < results.length; i++){
            System.out.print(results[i]);
            if( i != results.length-1){
                System.out.print(" ");
            }

        }
        System.out.println();


    }
}

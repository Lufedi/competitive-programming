import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A1006 {

    public static  void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int n =  Integer.parseInt(br.readLine());
        String data[] = br.readLine().split(" ");
        int numbers[] = new int[n];
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] %2 == 0){
                numbers[i]--;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if(i != numbers.length -1){
                System.out.print(" ");
            }
        }
        System.out.println();

    }
}

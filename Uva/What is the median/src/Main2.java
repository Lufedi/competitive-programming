import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder("");
        String m = "";
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while ((m = br.readLine()) != null) {
            int x = Integer.parseInt(m.trim());
            boolean stat = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) > x) {
                    arr.add(i, x);
                    stat = true;
                    break;
                }
            }
            if (!stat) {
                arr.add(x);
            }
            if (arr.size() % 2 == 0) {
                int x1=arr.get(arr.size()/2);
                int x2=arr.get((arr.size()/2)-1);
                int temp=(x1+x2)/2;
                sb.append(temp).append("\n");
            } else {
                sb.append(arr.get((arr.size()/2))).append("\n");
            }
        }
        System.out.print(sb);
    }
}
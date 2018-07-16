import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1006 {




    public static  void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n ,  k;
        String data[];
        data = br.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        k = Integer.parseInt(data[1]);

        int numbers[] = new int[n];
        int numbersCopy[] = new int[n];
        data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
            numbersCopy[i] = Integer.parseInt(data[i]);

        }

        Arrays.sort(numbersCopy);
        List<Integer> maxDailyProfit = new ArrayList<>();

        for (int i = numbers.length - k; i < numbers.length; i++) {
            maxDailyProfit.add( numbersCopy[i]);
        }
        int jobsByDay[] = new int[k];
        int pivot = 0;
        int totalProfit= 0;
        int numberOfJobs  = 0;
        boolean done = false;

        for (int i = 0; i < numbers.length && !done; i++) {
            int searchIndex =  Collections.binarySearch(maxDailyProfit, numbers[i]);
            if( searchIndex >= 0){

                maxDailyProfit.remove(searchIndex);

                if((pivot + 1) == k && i != numbers.length -1){
                    numberOfJobs += (numbers.length - i - 1);
                    done = true;
                }
                numberOfJobs++;
                totalProfit +=  numbers[i];
                jobsByDay[pivot] = numberOfJobs;
                numberOfJobs = 0;
                pivot++;

            }else{
                numberOfJobs++;
            }
        }

        System.out.println(totalProfit);
        for (int i = 0; i < jobsByDay.length; i++) {
            System.out.print(jobsByDay[i]);
            if(i != jobsByDay.length -1){
                System.out.print(" ");
            }
        }
    }
}
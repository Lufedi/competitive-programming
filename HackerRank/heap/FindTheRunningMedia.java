import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FindTheRunningMedia{

    public static void main(String[] args) {
        FindTheRunningMedia s = new FindTheRunningMedia();
        int a[] = new int[]{
            29689,
61859,
43888,
90223,
33129,
51730,
71991,
61487,
97324,
49578,
86085,
6099,
43042,
50425,
77959,
43848,
40864
        };
        double res[] = s.runningMedian(a);
        Arrays.stream(res).forEach( d ->  System.out.println(d));
    }
    public static double[] runningMedian(int[] a){
        double res[] = new double[a.length];
        PriorityQueue<Double> minValues  = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> maxValues = new PriorityQueue<>();
        minValues.add(-1*Double.MAX_VALUE);
        maxValues.add(Double.MAX_VALUE);
        int j = 0;
        for(int i = 0 ; i < a.length ; i++){
            double n = (double)a[i];
            if(minValues.size() == 0 && maxValues.size() == 0){
                minValues.add(n);
            }else{
                if(n  < maxValues.peek()){
                    minValues.add(n);
                }else{
                    maxValues.add(n);
                }
                if(Math.abs(maxValues.size() - minValues.size()) > 1){
                    if(maxValues.size() > minValues.size()){
                        minValues.add(maxValues.poll());
                    }else{
                        maxValues.add(minValues.poll());
                    }
                }
            }
            int totalSize  = minValues.size() + maxValues.size();
            if(totalSize % 2 == 0){
                res[j] = (minValues.peek() + maxValues.peek())/2;
            }else{
                res[j] = minValues.size() > maxValues.size() ? minValues.peek() : maxValues.peek();
            }
            
            j++;
        }
        return res;
    } 
}
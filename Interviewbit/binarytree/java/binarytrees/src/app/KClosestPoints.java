package app;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints{
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[][] points = new int[][]{{1,3}, {-2,2}};
        int k = 1;
        int res[][] = s.kClosest(points, k);
        System.out.println(Arrays.toString(res));
    }
}
class Solution2 {

   

    public int[][] kClosest(int[][] points, int K) {
        
        
        Point[] pts = new Point[points.length];
        for(int i = 0 ; i < points.length; i++){
            pts[i] = new Point(points[i][0], points[i][1]);
        }
        Point[] res = kClosest(pts, K);
        

        int[][] ans = new int[K][2];
        for(int i = 0 ; i < res.length ; i++){
            ans[i] = new int[]{res[i].x, res[i].y};
        }
        return ans;

    }

    public Point[] kClosest(Point[] points, int k){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Point[] res = new Point[k];
        for(Point a: points){
            queue.add(a);
        }

        for(int i = 0 ; i < k; i++){
            res[i] = queue.remove();
        }
        return res;
    }
}


class Point implements Comparable<Point>{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }



    @Override
    public int compareTo(Point o) {
        return (int)(this.x*this.x + this.y*this.y) - (int)(o.x*o.x + o.y*o.y);
    }
}



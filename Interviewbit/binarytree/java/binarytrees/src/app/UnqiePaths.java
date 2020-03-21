package app;
import java.util.Hashtable;



class Solution {


    public int counter;
    public int M, N;
    public Hashtable<String, Integer> memo = new Hashtable<>();

    public int uniquePaths(int m, int n) {
        M = m - 1;
        N = n - 1;
        return move(0, 0);
        
    }

    public int move(int x, int y) {
        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int totalMoves = 0;
        if (x == N && y == M) {
            return 1;
        }
        if (x > N || y > M) {
            return 0;
        }
        int moves[][] = new int[][] { { 1, 0 }, { 0, 1 } };
        for (int[] move : moves) {
            int dx = x + move[0];
            int dy = y + move[1];
            totalMoves += move(dx, dy);
        }

        memo.put(key, totalMoves);
        return totalMoves;
    }

}
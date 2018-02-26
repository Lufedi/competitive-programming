import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	
	public static int[] cont ,  res;
	public static boolean[]vis ;
	public static Queue<Integer>  s;
	public static int[][]  g ; 
	public static int N , M , added = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);		
		N =  sc.nextInt();
		M =  sc.nextInt();
		g =  new int[N + 1][N + 1];
		cont =  new int[N + 1];
		vis = new boolean[N + 1];
		res =  new int[N + 1];
		Arrays.fill(cont, 0);
		int u , v;
		for(int i = 0 ;  i <  M  ; i++){
			u =  sc.nextInt();
			v =  sc.nextInt();
			g[u][v]  = 1 ;
			cont[v]++;
		}
		
		/*for(int[] a :  g){
			System.out.println(Arrays.toString(a));
		}*/
		//System.out.println(Arrays.toString(cont));

		DFS(0);
		for(int i = 0 ; i <  N ;  i++){
			if( !vis[i]){
				//System.out.println("Topo desde " + i );
				toposort(i);//fill queue
			}
		}
		/*for(int k = 0 ;  k < cont.length ;  k++){
			System.out.println(res[k]);
		}*/
		Arrays.fill(vis, false);
		DFS(0);
		//System.out.println(Arrays.toString(vis));
		int pipes= 0;
		for(int i = 0 ; i < res.length ;  i++){
			if( !vis[res[i]]){
				//System.out.println("sdfasfd"  +  res[i]);
				pipes++;
				DFS(i);
			}
		}
		System.out.println(pipes);
	}
	private static void DFS(int i) {
		vis[i] = true;
		for(int j = 0 ;  j <  N + 1 ;  j++){
			if(g[i][j] == 1 && !vis[j]){
				DFS(j);
			}
		}
	}
	private static void toposort(int i) {      
        int c =  getCandidato();
       // System.out.println("Candidato" + c);
        while( c != Integer.MAX_VALUE){
        	//System.out.println( "Candidato" + c);
             res[added] = c;
             added++;
             for(int  j = 0 ;j <  cont.length; j++ ){
                 if( g[c][j] == 1) cont[j] -= 1;
             }
            c =  getCandidato();
        }
        
    }
  
    private static int getCandidato(){
        int res  =  Integer.MAX_VALUE;
        for(int i= 0 ; i < cont.length; i++){
            if(cont[i] == 0  && !vis[i]){
                res=i;
            }
        }
        if(res != Integer.MAX_VALUE)cont[res] = -1;
        //System.out.println("candidato " + res);
        return  res;
    } 
}

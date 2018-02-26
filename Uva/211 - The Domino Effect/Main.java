import java.io.*;
import java.util.Arrays;
public class Main{  
public static int   R = 7;  
public static int C = 8;  
public static int N = 30;  
//public static int d[][] = new int [][]{{0, 1}, {1, 0}};  
public static int d[][] = new int[2][2];

public static  int ans;
public static int  t[][] = new int[R][C] ;
public static int  g[][] = new int[R][C];
public static int  vis[][] = new int[R][C] ;
public static int  rec[] = new int[N];  
public static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


public static boolean init() throws  Exception  {

     ans = 0;  
        String datos[];
    Arrays.fill(rec  , 0);
    for(int [] a : vis )Arrays.fill(a, 0);
    for (int i = 0; i < R; i++){
                if(!br.ready())return false;
                datos =  br.readLine().trim().split(" ");
               for (int j = 0; j < C; j++){
                    g[i][j] = Integer.parseInt(datos[j]);
               }  
              
    }
     return true;



}


public static void setInit() {  
d[0][0] = 0 ;
d[0][1] = 1;
d[1][0] = 1 ;
d[1][1] = 0;

/*mem =  new Hashtable<String , Integer>();
for(int i = 0 ; i < 7  ; i++){
    for(int j = i ; i  < 7 j++ ){
        mem.put("" + i + "-" + "j" ,  )
    }
}*/
    int c = 1;  
    for (int i = 0; i < R; i++)  
        for (int j = i; j < R; j++) {
             t[i][j] = c;
             t[j][i] = c;
             c++;
        } 
             
}  
  
public static void put() {  
    for (int i = 0; i < R; i++) {  
        for (int j = 0; j < C; j++) 
            System.out.printf("%4d", vis[i][j]);  
         System.out.printf("\n");  
    }  
    System.out.printf("\n");  
}  
  
public static void dfs(int x, int y, int c) {  
    System.out.println("x " + x + " y " +  y);
    put();

    if (c == 28) {  
        
        ans++; put();  
        return;  
    }  
  
    if (y == C) {  
        x++; y = 0;  
    }  
    if (vis[x][y] == 1) dfs(x, y + 1, c);  
    else {  
  /*
        for (int i = 0; i < 2; i++) {  
            int p = x + d[i][0], q = y + d[i][1];  
            if (p < R && q < C && vis[p][q] != 1){
                int k = t[g[x][y]][g[p][q]];  
                 if (rec[k] != 1) { 
                    vis[x][y] = k;
                    vis[p][q] = k; 
                    rec[k] = 1;  
                    dfs(x, y + 1, c + 1);  
                    vis[x][y]  = 0;
                    vis[p][q] = 0; rec[k] = 0;
                    } 
            }  
             */
        for (int i = 0; i < 2; i++) {  
            int p = x + d[i][0], q = y + d[i][1];  
            if ( p < R && q < C && vis[p][q] !=1) {

            int k = t[g[x][y]][g[p][q]];  
            if (rec[k] != 1) {

            vis[x][y] = k ;
            vis[p][q] = k; rec[k] = 1;  
            dfs(x, y + 1, c + 1);  
            vis[x][y] = 0 ;
             vis[p][q] = 0; rec[k] = 0;  
                }
                }
        }  
          
    }  
}  
  
public static void main(String[] args) throws Exception{  
   
    setInit();  
    int cas = 0;  
    String linea , datos[];

    while (init()) {



          
   /* ans = 0;  
    memset(rec, 0, sizeof(rec));  
    memset(vis, 0, sizeof(vis));  
    for (int i = 0; i < R; i++)  
        for (int j = 0; j < C; j++) 
                if (scanf("%d", &g[i][j]) != 1) return false;  
    return true; 
*/

            //Lectura
   
    
 //ll


        if (cas == 1) {
            System.out.printf("\n\n\n");

            } 
        System.out.printf("Layout #%d:\n\n", ++cas);  
        for (int i = 0; i < R; i++) {  
            for (int j = 0; j < C; j++)  
                System.out.printf("%4d", g[i][j]);  
            System.out.printf("\n");  
        }  
  
        System.out.printf("\nMaps resulting from layout #%d are:\n\n", cas);   
        dfs(0, 0, 0);  
        System.out.printf("There are %d solution(s) for layout #%d.\n", ans, cas);  
    }  

} 


}
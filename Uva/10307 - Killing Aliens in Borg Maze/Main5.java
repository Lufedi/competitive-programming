import java.io.BufferedReader;    
import java.io.InputStreamReader;    
import java.util.HashMap;   
import java.util.HashSet;    
import java.util.Hashtable;  
import java.util.PriorityQueue;  
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
        
public class Main{    
            
    static char[][] tab;    
    static int[][] vi;   
   //static ArrayList<Nodo> n_found;  
    static Nodo[] n_found;

    static int w , h , si ,  sj;    
    public static void main(String[] args) throws Exception{    
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        String linea , datos[];    
        int casos =  Integer.parseInt(br.readLine());    
         si  = 0;    
         sj = 0;    
                
        Nodo s = null;
        for(int k = 0 ; k < casos ; k++){    
            Nodo.cont = -1;
            datos = br.readLine().trim().split(" ");    
            w = Integer.parseInt(datos[0]);    
            h = Integer.parseInt(datos[1]);     
            //n_found =  new ArrayList<Nodo>();  
            n_found = new Nodo[100];




            //edges =  new HashSet<Edge>();  
          
            tab =  new char[h][w];    
            for(int i = 0 ; i < 100;i++) n_found = null;
            int cn = 0;
            vi =  new int[h][w];   
            for(int i = 0 ; i  < h ; i++){    
                linea = br.readLine();    
                for(int j = 0 ;  j  < w ;  j++){    
                         
                          
                    //System.out.println(linea.length());   
                    tab[i][j] = linea.charAt(j);    
                    if(tab[i][j] == 'S') {    
                        si  = i ;     
                        sj  = j ;   
                       s =  new Nodo(i ,  j);  
                    }    
                    if( tab[i][j] == 'A'){  
                        n_found[cn] = new Nodo(i ,  j);  
                        cn++;
                            
                    }  
                }    
            }    
        
        
            solve(tab , w  , h   , s);    
        
        }    
    }    
        
        
    private static void solve(char[][]  tab , int w , int h , Nodo s){    
        


         
            PriorityQueue<Edge> q_edges =  new PriorityQueue<Edge>(); 

            for(int i = 0 ;  i < n_found.length  && n_found != null; i++){
                reload();
                q_edges.add(new Edge(s , n_found[i] ,  dfs( s.x  , s.y , 0 , s , n_found[i])));
            }
           

             tab[s.x][s.y] = ' ';
            for(int i = 0 ; i  < n_found.length && n_found[i] != null  ; i++){
                for(int j = 0 ; j  < n_found.length && n_found[j] != null;  j++ ){
                   if(i > j){ reload();
                    Nodo u = n_found[i];
                    Nodo v = n_found[j];
                   // int r = dfs(u.x , u.y , 0 , u,  v);
                      q_edges.add(new Edge(u , v,  dfs( u.x  , u.y , 0 , u , v)));
                    }
                }
            }

           


                
         
            kruskal( q_edges ,  n_found.size()); 
            //Krusal  
                
              
          
            
        
        
        
        
        
        
        
        
    }    
          
    private static void reload(){   
         for(int i = 0 ; i  < h ; i++){    
             for(int j = 0 ;  j  < w ;  j++){    
                 vi[i][j]  = -1;   
             }   
         }   
    }   
        
       

   

    /*public static int dfs(int si ,  int sj , int time  , Nodo head ,  Nodo tail){     
        int res  = Integer.MAX_VALUE ,  r1 = Integer.MAX_VALUE ,r2  = Integer.MAX_VALUE,r3 =Integer.MAX_VALUE,r4 = Integer.MAX_VALUE;
        

        vi[si][sj] =  1;   
       // System.out.println("head " + head.x + " " + head.y + " " + si + "  " + sj  + " "  + tab[si][sj]);  
        if((tab[si][sj] == 'A') && (si != head.x || sj != head.y) && (si == tail.x && sj == tail.y)){   
            res = time;      
        }else{    
        
            if(si  >  0  && tab[si - 1][sj] != '#' &&  vi[si - 1][sj] !=  1){  
                
                r1 = dfs(si -1 , sj  , time + 1 ,  head , tail); 

            }    
          
            if(sj >  0 && tab[si][sj - 1] != '#' && vi[si][sj - 1] != 1){ 
                  
                r2 = dfs(si , sj - 1 , time + 1 , head , tail);    
                
            }    
            if(sj < h - 1 && tab[si][sj + 1] != '#' && vi[si][sj  + 1] != 1){    
                
                r3 = dfs(si ,  sj + 1 , time + 1 , head , tail);    
               
            }    
               
            if(si  < h - 1  && tab[si  + 1][sj] != '#' && vi[si  + 1 ][sj] != 1){    
                
                r4 = dfs(si + 1  , sj ,  time + 1 , head , tail);    
               
            }    


            res =   Math.min ( Math.min(r1 , r2) , Math.min(r3 ,r4));
                    
        }
        vi[si][sj ] = -1;
        return res;    
    } */ 
        
    public static int bfs( Nodo head ,  Nodo tail , Point dim ){     
         reload();
        vi[si][sj] =  0;   
       
      
        Queue<Point> q = new LinkedList<Point>();
        Point inicio = new Point(head.x , head.y);
        q.add(inicio);


        while(!q.isEmpty()){
            Point u = q.poll();
            if( u.y < dim.y-1 &&  vi[u.x][u.y + 1] == -1 && tab[u.x][u.y + 1 ] != '#' &&
             (tab[u.x][u.y + 1 ] != 'A'  || (u.x == tail.x && u.y + 1 == tail.y))){
               if(vi[u.x][u.y] + 1 > vi[u.x][u.y + 1]) vi[u.x][u.y + 1] = vi[u.x][u.y] + 1;
                q.add(new Point(u.x   , u.y + 1, u.z));
            }
            if( u.x < dim.x-1 &&  vi[u.x + 1][u.y] == -1 && tab[u.x + 1][u.y ] != '#' &&
             (tab[u.x + 1][u.y] != 'A'  || (u.x + 1 == tail.x && u.y == tail.y))){
               if(vi[u.x][u.y] + 1 > vi[u.x + 1][u.y]) vi[u.x + 1][u.y ] = vi[u.x][u.y] + 1;
                q.add(new Point(u.x   + 1 , u.y, u.z));
            }
             if( u.x > 0 &&  vi[u.x - 1][u.y] == -1 && tab[u.x - 1][u.y ] != '#' &&
             (tab[u.x - 1][u.y] != 'A'  || (u.x - 1 == tail.x && u.y == tail.y))){
               if(vi[u.x][u.y] + 1 > vi[u.x - 1][u.y]) vi[u.x - 1][u.y ] = vi[u.x][u.y] + 1;
                q.add(new Point(u.x - 1 , u.y, u.z));
            }
             if( u.y > 0 &&  vi[u.x][u.y - 1] == -1 && tab[u.x][u.y - 1 ] != '#' &&
             (tab[u.x][u.y - 1] != 'A'  || (u.x == tail.x && u.y - 1 == tail.y))){
               if(vi[u.x][u.y - 1] + 1 > vi[u.x][u.y - 1]) vi[u.x][u.y - 1 ] = vi[u.x][u.y - 1] + 1;
                q.add(new Point(u.x , u.y - 1, u.z));
            }


        }

        return vi[tail.x][tail.y];    
    } 
        



    private static void kruskal(PriorityQueue<Edge> edges, int nodos) { 
       


        HashSet<Edge> res = new HashSet<Edge>();   
        UF a = new UF(nodos + 1);   
        
        int tot = 0;   
        int numEd = edges.size();   
        for(int i = 0 ; i < numEd ; i++){   
                  
            Edge e = edges.poll();   
               
            if( !a.connected(e.u.id, e.v.id)){
                
                res.add(e);   
                tot += e.w;
                a.union(e.u.id, e.v.id);   
            }   
        }   
           
        System.out.println( tot );   
          
              
    }   
        
        
}    
        
        
class Point{
    int x , y;
    public Point(int x , int y){
        this.x = x;
        this.y = y;
    } 
}       

class Nodo{    
    static int cont = -1;    
    int id, x , y;    
    public Nodo(int x,  int y){    
        cont++;    
        this.id = cont; this.x = x; this.y = y;    
    }    
}    
    
class Edge implements Comparable<Edge>{    
    public Nodo u ,  v;    
    int w;     
    public Edge(Nodo u , Nodo v  , int w){    
        this.u = u ; this.v = v;this.w = w;    
    }    
          
    public String toString(){ 
        return ("(" + this.u.id + ","  + this.v.id+ ")" );  
        //return ("id:" + this.u.id+ "(" + this.u.x + "," + this.u.y + ")" + " - id" + this.v.id + "(" + this.v.x  + "," + this.v.y + ")" + "l:" + w);   
    }   
        
    @Override
    public int compareTo(Edge e) {   
        if(this.w > e.w) return 1;   
        else if(this.w < e.w) return  -1;   
        else return 0;   
    }   
}  
    
    
    
      
 class UF {
    private int[] id;     // id[i] = parent of i
    private byte[] rank;  
    private int count;    // number of components

    public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        rank = new byte[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        if (p < 0 || p >= id.length) 
    throw new IndexOutOfBoundsException();
        while (p != id[p]) {
            id[p] = id[id[p]];    // path compression by halving
            p = id[p];
        }
        return p;
    }
    public int count() {return count;}

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // make root of smaller rank point to root of larger rank
        if      (rank[i] < rank[j]) id[i] = j;
        else if (rank[i] > rank[j]) id[j] = i;
        else {
            id[j] = i;
            rank[i]++;
        }
        count--;
    }

}


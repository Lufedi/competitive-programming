import java.io.BufferedReader;    
import java.io.InputStreamReader;    
import java.util.HashMap;   
import java.util.HashSet;    
import java.util.Hashtable;  
import java.util.PriorityQueue;  
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Main{    
            
    static char[][] tab;    
    static int[][] vi;   
    static ArrayList<Nodo> n_found;  
    static  PriorityQueue<Edge> q_edges;

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
             
            n_found =  new ArrayList<Nodo>();  

            //edges =  new HashSet<Edge>();  
          
            //System.out.println(" "  + h + "  " + w);
            tab =  new char[h][w];    
            vi =  new int[h][w];   
            for(int i = 0 ; i  < h ; i++){    
                linea = br.readLine();    
                for(int j = 0 ;  j  < w ;  j++){    
                         
                          
                  //  System.out.println(linea.length());
                   // System.out.println(linea);   

                    if( j  < linea.length() ) tab[i][j] = linea.charAt(j);
                    else   tab[i][j] = ' ';

                    if(tab[i][j] == 'S') {    
                        si  = i ;     
                        sj  = j ;    
                       s =  new Nodo(i ,  j);  
                    }    
                    if( tab[i][j] == 'A'){  
                        n_found.add(new Nodo(i ,  j));  
                            
                    }  
                }    
            }    
        
        
            solve(tab , w  , h   , s);    
        
        }    
    }    
        
        
    private static void solve(char[][]  tab , int w , int h , Nodo s){    
        


         
            q_edges  =  new PriorityQueue<Edge>();

            for(int i = 0 ;  i < n_found.size() ; i++){
                bfs( n_found.get(i));
            }
                bfs(s);

            
            for(Edge e :  q_edges){
               System.out.println(e);
            }

           
            //System.out.println("2");

                
         
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
       
        if((tab[si][sj] == 'A') && (si != head.x || sj != head.y) && (si == tail.x && sj == tail.y)){ 
        //System.out.println(" re " +  time + " " );  
            res = time;      
        }else{    
        
            if(si  >  0  && tab[si - 1][sj] != '#' &&  vi[si - 1][sj] !=  1){  
                
                r1 = dfs(si -1 , sj  , time + 1 ,  head , tail); 

            }    
          
            if(sj >  0 && tab[si][sj - 1] != '#' && vi[si][sj - 1] != 1){ 
                  
                r2 = dfs(si , sj - 1 , time + 1 , head , tail);    
                
            }    
             //System.out.println(sj+" " +  (h - 1)  +"head " + head.x + " " + head.y + " " + si + "  " + sj  + " "  + tab[si][sj+ 1] + " "  +vi[si][sj + 1]);  
            if(sj < w - 1 && tab[si][sj + 1] != '#' && vi[si][sj  + 1] != 1){    
             //   System.out.println("e");
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


    public static void bfs( Nodo head ){
        reload();
        Queue<Point> q  = new LinkedList<Point>();
        vi[si][sj] = 1;
        q.add( new Point(head.x , head.y , 0));
        
        int dx[] = {0  , 0 , 1 , -1};
        int dy[]  ={-1 , 1 , 0 ,  0};
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0 ; i <  4 ; i++){

                int x  = p.x + dx[i];
                int y =  p.y + dy[i];
                if (x < 0 || y < 0 || x > w- 1 || y > h - 1 || vi[x][y] == 1 || tab[x][y] == '#')
                    continue;
                vi[x][y] = 1;
                q.add(new Point(x ,  y, p.d + 1));


             if(tab[x][y] == 'A' || tab[x][y] == 'S'){

                Nodo tail = getNode(x ,  y);

                //System.out.println("edges added" + head + " " + tail + " " + (p.d + 1)  + " en" + x + " " + y);
                 if(  head.x != tail.x || head.y != tail.y) q_edges.add(new Edge(head , tail, p.d + 1 ));

             }

            }


        }



    } 
        

    public static Nodo getNode(int si , int  sj){
        for(int i = 0 ; i < n_found.size() ; i++){
            Nodo a = n_found.get(i);
            if(a.x == si  && a.y == sj) return a;
        }
        return null;
    }
        
    private static void kruskal(PriorityQueue<Edge> edges, int nodos) { 
       

 
        UF a = new UF(nodos + 1);   
        
        int tot = 0;   
        int numEd = edges.size();   
        for(int i = 0 ; i < numEd ; i++){   
                  
            Edge e = edges.poll();   
               
            if( !a.connected(e.u.id, e.v.id)){
                
               
                tot += e.w;
                a.union(e.u.id, e.v.id);   
            }   
        }   
           
        System.out.println( tot );   
          
              
    }   
        
        
}    
        
class Point {
    int x,  y ,  d;
    public Point(int x , int y , int d){
        this.x = x;
        this.y = y;
        this.d  = d;
    }
}
        
        
class Nodo{    
    static int cont = -1;    
    int id, x , y;    
    public Nodo(int x,  int y){    
        cont++;    
        this.id = cont; this.x = x; this.y = y;    
    }   

    public String toString(){
        return ("id:" + this.id+"x:" + this.x + "y:" + this.y);
    } 
}    
    
class Edge implements Comparable<Edge>{    
    public Nodo u ,  v;    
    int w;     
    public Edge(Nodo u , Nodo v  , int w){    
        this.u = u ; this.v = v;this.w = w;    
    }    
          
    public String print(){
        return  ("(" + this.u.id + ","  + this.v.id+ ")" + " "  + this.w + " " + this.u.x + "-"+this.u.y  +  "   " + this.v.x + " " + this.v.y);  
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


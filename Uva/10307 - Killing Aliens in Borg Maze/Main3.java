import java.io.BufferedReader;   
import java.io.InputStreamReader;   
import java.util.HashMap;  
import java.util.HashSet;   
import java.util.Hashtable; 
import java.util.PriorityQueue; 
      
public class Main3{   
          
    static char[][] tab;   
    static int[][] vi;  
    static HashSet<Nodo> n_found;   
  //  static HashSet<Edge> edges; 
     static HashMap<String  , Edge> edges = new  HashMap<String  , Edge>();   
    static int w , h , si ,  sj;   
    public static void main(String[] args) throws Exception{   
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        String linea , datos[];   
        int casos =  Integer.parseInt(br.readLine());   
         si  = 0;   
         sj = 0;   
              
      
        for(int k = 0 ; k < casos ; k++){   
            datos = br.readLine().trim().split(" ");   
            w = Integer.parseInt(datos[0]);   
            h = Integer.parseInt(datos[1]);   
      
            n_found =  new HashSet<Nodo>(); 
            //edges =  new HashSet<Edge>(); 
            edges =  new HashMap<String,  Edge>(); 
            tab =  new char[h][w];   
            vi =  new int[h][w];  
            for(int i = 0 ; i  < h ; i++){   
                linea = br.readLine();   
                for(int j = 0 ;  j  < w ;  j++){   
                       
                        
                    //System.out.println(linea.length());  
                    tab[i][j] = linea.charAt(j);   
                    if(tab[i][j] == 'S') {   
                        si  = i ;    
                        sj  = j ;   
                        n_found.add(new Nodo(i ,  j)); 
                    }   
                    if( tab[i][j] == 'A'){ 
                        n_found.add(new Nodo(i ,  j)); 
                          
                    } 
                }   
            }   
      
      
            solve(tab , w  , h  , si ,  sj);   
      
        }   
    }   
      
      
    private static void solve(char[][]  tab , int w , int h , int si , int sj){   
      
        System.out.println("star "  + si + " " + sj );  
        Nodo inicio = new Nodo(  si ,  sj);   
   
        dfsAliens( si , sj);  
        for(Nodo u  : n_found){   
            System.out.println( u.x + " " + u.y);   
        }   
          
      
      
      
      
      
      
      
      
    }   
        
    private static void reload(){  
         for(int i = 0 ; i  < h ; i++){   
             for(int j = 0 ;  j  < w ;  j++){   
                 vi[i][j]  = -1;  
             }  
         }  
    }  
      
      public static Nodo getNodo(int si ,  int sj){
        for(Nodo n : n_found){
            if(n.x == si && n.y == sj){
                return n;
            }
        }
        return null;
    }
    public static void dfsAliens(int si ,int  sj){  
          
            reload(); 
            dfs(si , sj , 0 , new Nodo(si ,  sj)); 
              
            tab[si][sj] = ' '; 
              
            for(Nodo u  : n_found){   
                reload();  
                System.out.println(u.x+"," + u.y + " " + u.id); 
                dfs(u.x , u.y ,  0 , u);  
                     
             }  
            PriorityQueue<Edge> q =  new PriorityQueue<Edge>();  
            for(Edge e :  edges.values()){  
                
                System.out.println(e +  " " + e.w);
                q.add( new Edge( getNodo(e.u.x , e.u.x) , getNodo(e.v.x ,  e.v.y)   , e.w));
            
            }
              
            //Krusal 
                 kruskal( q ,  n_found.size()); 
            
    }  
    public static void dfs(int si ,  int sj , int time  , Nodo head){   
      
          
        vi[si][sj] =  1;  
       // System.out.println("head " + head.x + " " + head.y + " " + si + "  " + sj  + " "  + tab[si][sj]); 
        if((tab[si][sj] == 'A') && (si != head.x || sj != head.y)){   
            Nodo r = new Nodo( si , sj);  
           // n_found.add(r);   
            //System.out.println("entre"); 
              
            if(!edges.containsKey( (new Edge(head ,  r  , time)).toString() ) && !edges.containsKey( (new Edge(r , head  , time)).toString() )){ 
                Edge tm =  (new Edge(head ,  r  , time));
                edges.put(   tm.toString() ,  tm); 
            } 
  
                
        }else{   
      
            if(si  >  0  && tab[si - 1][sj] != '#' &&  vi[si - 1][sj] !=  1){   
                dfs(si -1 , sj  , time + 1 ,  head);   
            }   
        
            if(sj >  0 && tab[si][sj - 1] != '#' && vi[si][sj - 1] != 1){   
                dfs(si , sj - 1 , time + 1 , head);   
            }   
            if(sj < h - 1 && tab[si][sj + 1] != '#' && vi[si][sj  + 1] != 1){   
                dfs(si ,  sj + 1 , time + 1 , head);   
            }   
             
            if(si  < h - 1  && tab[si  + 1][sj] != '#' && vi[si  + 1 ][sj] != 1){   
                dfs(si + 1  , sj ,  time + 1 , head);   
            }   
                  
        }   
    } 
      
      private static void kruskal(PriorityQueue<Edge> edges, int nodos) { 

        for(Edge e :  edges){
            System.out.println(e.u.id +  " " + e.v.id);
        }


       
        UF a = new UF(nodos);   
        System.out.println("nodos " + nodos );
        int tot = 0;   
        int numEd = edges.size();   
        for(int i = 0 ; i < numEd ; i++){   
                  
            Edge e = edges.poll();   
            System.out.println(e + " " + e.w);
             System.out.println(e.u.id +  " " + e.v.id);
            if( !a.juntos(e.u.id, e.v.id)){
                System.out.println(e) ; 
                  
                tot += e.w;
                a.union(e.u.id, e.v.id);   
            }   
        }   
           
        System.out.println( "res"  + tot );   
          
              
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
        return (  this.u.x + "," + this.u.y + " - " + this.v.x  + "," + this.v.y   );  
    }  
      
    @Override
    public int compareTo(Edge e) {  
        if(this.w > e.w) return 1;  
        else if(this.w < e.w) return  -1;  
        else return 0;  
    }  
} 
  
  
  
    
    
  
  
  
class UF{  
    
int[] conj;  
    
public UF(int nodos){  
    conj  = new int[nodos];  
    for(int i = 0 ; i <  nodos ; i++) conj[i] = i;  
}     
public boolean juntos(int nodo1 , int nodo2){  
    return conj[nodo1] == conj[nodo2];  
}  
    
    
public void union(int p , int q){  
        if(juntos(p , q)) return;  
        else{  
            int idp = conj[p];  
            for(int i = 0 ; i < conj.length ; i++){  
                if(conj[i] == idp) conj[i] = conj[q];  
            }  
        }  
    }  
}  
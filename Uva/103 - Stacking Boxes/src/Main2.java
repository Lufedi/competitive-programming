import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.util.ArrayList;  
import java.util.Arrays;  
    
    
public class Main2 {  
        
    public static void main(String[] args) throws Exception{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
            
        String linea;  
        while( (linea  = br.readLine()) != null){  
                
            int cajas ,  dim ;  
            String[] datos = linea.split(" ");  
            cajas = Integer.parseInt(datos[0]);  
            dim = Integer.parseInt(datos[1]);  
            Caja[] boxes = new Caja[cajas];   
              
              
              
            for(int i = 0 ; i <  cajas ; i ++){  
                boxes[i] = new Caja(dim , i + 1);  
                datos = br.readLine().trim().split(" ");  
                for(int  j = 0 ; j <  dim ; j++){  
                    boxes[i].agregar( j ,  Integer.parseInt(datos[j]) );  
                }  
                Arrays.sort(boxes[i].dimensiones);  
            }  
               
           // Arrays.sort(boxes); 
            sortit(boxes);  
            solve(boxes);  
        }  
    }  
        
    public static void sortit(Caja[] arr){ 
        Caja aux ; 
          
        for(int i = 0   ;  i < arr.length ; i++){ 
            for(int j = 0 ;  j < arr.length  - 1; j++){ 
                 if( arr[j].compareTo(arr[j + 1] ) == 1){ 
                     aux =  arr[j]; 
                     arr[j] =  arr[j  + 1]; 
                     arr[j + 1] =  aux; 
                 } 
                  
            } 
        } 
    } 
      
      
        
    private static void solve(Caja[] boxes) {     
    LISI(boxes , boxes.length);  
    }  
        
        
        
    private static int LISI(Caja[] boxes  , int dim){  
        int DP[] = new int[dim];   
        int prev[] = new int[dim];  
        ArrayList<Integer> camino = new ArrayList<Integer>();  
        
        int maxLength = 1, bestEnd = 0;  
        DP[0] = 1;  
        prev[0] = -1;  
        for (int i = 1; i < dim; i++){  
           DP[i] = 1;  
           prev[i] = -1;  
            
           for (int j = i - 1; j >= 0; j--){  
                   
              if (DP[j] + 1 > DP[i] && boxes[j].compareTo(boxes[i]) == -1 ){  
                  //if(camino.size() == 0) camino.add(boxes[j].id); 
                 DP[i] = DP[j] + 1;  
                 prev[i] = j;  
              }  
           }  
           if (DP[i] > maxLength){  
            //  camino.add(boxes[i].id);  
              bestEnd = i;  
              maxLength = DP[i];  
                 
           }  
        }  
          
        int index =  bestEnd; 
        for(int i = 0 ; i < maxLength ;i++){     
            camino.add(boxes[index].id); 
            index =  prev[index]; 
        } 
          
        System.out.println(maxLength);  
        for(int i  = camino.size()  - 1 ; i >= 0  ; i--){  
            if( i  == 0){  
                System.out.print(camino.get(i));  
            }else{  
                System.out.print(camino.get(i) + " ");  
            }  
        }  
        System.out.println();  
            
        return maxLength;  
    }  
}  
    
    
class Caja implements Comparable<Caja>{  
        
    public int dimensiones[];  
    public int id , total = 0;  
    public Caja(int n ,  int id){  
        dimensiones = new int[n];  
        this.id = id;  
    }  
        
    public void agregar(int j, int valor){  
        dimensiones[j] = valor;  
        total+= valor;  
    }  
        
    @Override
    public String toString(){  
        return   this.id + "";  
    }  
    
            
    @Override
    public int compareTo(Caja e) {  
            
        boolean band = true;         
      
        for(int i = 0 ; i <  this.dimensiones.length  && band; i++){  
            if(!(this.dimensiones[i] < e.dimensiones[i])) band  = false;  
        }  
        if(band)return -1;  
        band =  true; 
        for(int i = 0 ; i <  this.dimensiones.length  && band; i++){  
            if(!(this.dimensiones[i] > e.dimensiones[i])) band  = false;  
        }  
        if(band) return 1; 
           
       return 1;  
    }     
}
//package MatrioskasContest;
//import Matriosks.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Resuelve el problema de la maraton internacional  de programación 2013, Problema H
 * @autor (Marcos Andres Tocora Lasso)
 * @author (Luis Felipe Diaz Chica) 
 * @version (3.2)
 */
public class MatrioskasProblem
{
	
	
    /**
     * Resuelve el problema de acomodar una fila de munecas en matrioskas en la minima cantidad de pasos 
     * de tres forma , logica , textual(pasos explicitos) , visual(representacion gráfica del problema)
     * @param b modo en el que se va a resolver el problema  l = lógico , t = textual ,  v = visual 
     * @param c arreglo con el tamaño de las munecas en fila respectivamente
     * @return   retorna la respuesta correspondiente al modo elegido
     */
    public static String solve(int[] c, char b)
    {
        ArrayList<String> path  = new ArrayList<String>();
        String r = null;
        if( b == 'l' ){
           r =   logico(c , path);
        }
        else if( b == 't'){
           r =   textual(c);
        }else if(b == 'v'){
         // visual(c);  
        }
       
       return  r;
    }
    
    /**
    * Resuelve el problema de acomodar una fila de munecas en matrioska en la minima cantidad de pasos 
    * @param c arreglo con el tamaño de las munecas en fila respectivamente
    * @param path retorna el camino(movimientos) que se siguió para encontrar la respuesta  
    * @return retorna la cantidad de aperturas minimas que se hacen para resolver el problema ,  "impossible" si el 
    *                  problema no puede solucionarse 
    */
    private static  String logico( int[] c , ArrayList<String> path){
    	
    	  Hashtable<String , Integer> mem2 = new Hashtable<String , Integer>();
    	  Hashtable<ArrayList<ArrayList<Integer>> , Stack<String>> memp = new Hashtable<ArrayList<ArrayList<Integer>> , Stack<String>> ();
    	  Hashtable<ArrayList<ArrayList<Integer>> , Integer> memg = new Hashtable<ArrayList<ArrayList<Integer>> , Integer>();
            
            ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>();
            for(int i = 0 ; i < c.length ; i++){
                    m.add(new ArrayList<Integer>());
                    m.get(i).add( new Integer(c[i]));
            }
            String res = null;
            Stack<String>  camino = new Stack<String>();
            
            int r = sol(m , camino , memg, mem2 , memp);
            if(r == Integer.MAX_VALUE){
               res =  "Impossible";  
            }else{
               res =  String.valueOf(r);
               while( !camino.empty() ){path.add(camino.pop());}  
            }
            return res;
        
    }
    
    /**
    * Resuelve el problema de  acomoar una fila de munecas en matrioskas retornano los movimientos que se deben seguir para 
    * resolverlo
    * @param c arreglo con el tamaño de las munecas en fila respectivamente
    * @eturn string con la concatenación de los pasos que seben hacerse para solucionar el ejercicio 
    * con la minima cantidad de aperturas
    */
    
    private static String textual(int[] c){
        ArrayList<String> path  = new ArrayList<String>();
        Stack<String>  camino = new Stack<String>();
        String res = "";
            logico( c, path);
            for(int i = 0 ; i < path.size() ; i++){
                if(i != path.size() - 1)res =  res +  path.get(i)  + ",";
                else res =  res +  path.get(i);
            }
            res.trim();
            return res;   
    }
    
    

    /**
    * Resuelve el problema de  acomoar una fila de munecas en matrioskas mostrando graficamente los movimientos que deben
    * ser efectuados   
    * @param c arreglo con el tamaño de las munecas en fila respectivamente
    * @return  
    */
    /*private String visual(int[] c ){
        ArrayList<String> path  = new ArrayList<String>();
       Matrioskas m = new Matrioskas(c);
        String camino = textual(c); 
        m.makeVisible();
        
        String[] pasos = camino.split(",");
        for(int i = 0 ; i < pasos.length ; i++){
             if(pasos[i].charAt(3) == 'R'){
                 m.combineRight( Integer.parseInt( ""+pasos[i].charAt(1)) +  1 ) ;
             }else{
                 m.combineLeft( Integer.parseInt( ""+pasos[i].charAt(1))  +  1 );
             }
             m.arrange();
        }
        return  " ";
    }*/




    /**
    * Resuelve el problema de acomoar una fila de munecas en matrioskas  con la menor cantidad de aperturas 
    * al combinar las matrioskas
    * @param m arreglo de matrioskas con sus tamaños enteros 
    * @param pathfinal pila con los movimientos necesarios para solucionar el problema con la menor
    * cantidad de aperturas
    * @return retorna  un entero con la camtidad minima de aperturas que se pueden hacer la reolver el problema
    * en dado que no sea posible retorna "infinito"o su equivalente
    *
    */
 private static   int sol  ( ArrayList<ArrayList<Integer>>  m ,  Stack<String> pathfinal , 
		 Hashtable<ArrayList<ArrayList<Integer>> , Integer> memg ,
		 Hashtable<String ,Integer> mem2 , 
		 Hashtable<ArrayList<ArrayList<Integer>> , Stack<String>>  memp ){ 
	 	int  res = -1;
	 
         
        
         

         
        if(memg.containsKey(m)){
        	 pathfinal = memp.get(m);
        	 //System.out.println("P" + m.toString() + "r" +memp.get(m).toString() );
        	 res =    memg.get(m);
        	 System.out.println("E" + m.toString() + "r" +  memg.get(m));
        }else{
        	
        	
        	 ArrayList<ArrayList<Integer>> cpy = new ArrayList<ArrayList<Integer>>();
             for(int k = 0 ; k < m.size() ; k++)  cpy.add( copiarArray(m.get(k)) );  
        	int N = m.size(), min = Integer.MAX_VALUE ;
            
            Stack<String> path = new Stack<String>();
            Stack<String> patha = new Stack<String>();
            Stack<String> pathb = new Stack<String>();
            
            
	        if(m.size() == 1){
	            if(check(m))res = 0;
	            else res = Integer.MAX_VALUE;
	        }else if(m.size() == 0){ res = Integer.MAX_VALUE;}
	        else if(check(m)){ res = 0;}
	        else if(m.size() > 1){
	
	        	
	        for(int i = 0; i < N ; i++){
	            patha = new Stack<String>();
	            pathb = new Stack<String>();
	            ArrayList<ArrayList<Integer>> c1 = new ArrayList<ArrayList<Integer>>();
	            int t = 0 ,a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
	            for(int k = 0 ; k < m.size() ; k++)  c1.add( copiarArray(m.get(k)) );                
	                if(i >= 0 && i < m.size() -1  &&  m.get(i + 1).get(0)  < m.get(i).get(0) && !contiene( m.get(i) , m.get(i + 1))){
	                         a = combineRight(i , m , t , patha , memg ,mem2 , memp);
	                         m = c1;   
	                }
	                if(i > 0 && i < m.size() && m.get(i  -  1).get(0)  < m.get(i).get(0) &&  !contiene( m.get(i) , m.get(i  - 1))){
	                        b = combineLeft(i , m , t , pathb ,  memg ,mem2 , memp);
	                        m = c1;          
	                }    
	                if(a != Integer.MAX_VALUE || b != Integer.MAX_VALUE  ) {
	                    if(a <= b && a < min){
	                        path = new Stack<String>();
	                        while( !patha.empty() ){path.push(patha.pop()); }                           
	                    }else if(b < a && b < min){
	                        path = new Stack<String>();
	                        while( !pathb.empty() ){ path.push(pathb.pop());}
	                    }
	                    min = Math.min(min,(Math.min(a , b)));      
	                }
	           }
	        
	           while( !path.empty() ){ pathfinal.push(path.pop());}
	           res = min;
	        }
	        
	        memp.put(cpy, pathfinal);
            memg.put(cpy , res);
            
           // System.out.println("G" + cpy.toString() + "P" + pathfinal.toString());
            System.out.println("G" + cpy.toString() + "R" + res);
        }
    return res;
    }
    
    /**
    *retorna la cantidad de aperturas que hay que hacer al una matrioska en la posicion i a su derecha
    *@param i matrioska que se va a combinar a la derecha
    *@param m arreglo completo de las matrioskas
    *@param path camino que se debe hacer para resolver el problema si combinamos la derecha
    *
    */
    private static  int combineRight(int i  ,  ArrayList<ArrayList<Integer>> m  , int t , Stack<String> path ,
    		Hashtable<ArrayList<ArrayList<Integer>> ,Integer> memg ,
    		Hashtable<String ,Integer> mem2 ,
    		 Hashtable<ArrayList<ArrayList<Integer>> , Stack<String>>  memp 		
    		){
        int a = Integer.MAX_VALUE;
                        a = (combine(m , i , i + 1, mem2));
                        
                         t =  sol(modificar(m ,  i , i + 1) , path , memg , mem2 ,memp) ;   
                         if(t == Integer.MAX_VALUE ){a = Integer.MAX_VALUE;}
                         else { a = a + t;

                            //path.push("(" + (i + 1) + ","+  i + ")");
                            path.push("(" + (i + 1) + ":"+  "L" + ")");
                         }
                    return a;
    }

    
    
    
   
   /**
   * retorna la cantidad de aperturas que hay que hacer al una matrioska en la posicion i a su izquierda
    *@param i matrioska que se va a combinar a la izquieda
    *@param m arreglo completo de las matrioskas
    *@param path camino que se debe hacer para resolver el problema si combinamos la izquieda
    *
    */
    private static  int combineLeft(int  i ,  ArrayList<ArrayList<Integer>> m , int t , Stack<String> path , 
    		Hashtable<ArrayList<ArrayList<Integer>> , Integer> memg ,Hashtable<String ,Integer> mem2 , 
    		Hashtable<ArrayList<ArrayList<Integer>> , Stack<String>>  memp ){
        int b = Integer.MAX_VALUE;
    
                     b = (combine(m , i , i - 1 , mem2)); 
                     t =  sol(modificar(m ,  i , i - 1) , path , memg , mem2 , memp) ;
                     if(t == Integer.MAX_VALUE ){ b = Integer.MAX_VALUE; }
                     else { 
                    	 b = b + t;
                        path.push("(" + (i - 1) + ":"+  "R" + ")");
                        //path.push("(" + (i - 1) + ","+  i + ")");
                     }
                return b;
    }
    
/**
* retorna si un arreglo de l1 contiene todos los elementos de l2
* @param l1 arreglo  base
* @param l2 arreglo sobre el cual se busca la compraracion
* @retorn  si lo contiene o no 
*/    
private static  boolean contiene(ArrayList<Integer> l1 , ArrayList<Integer> l2){
    boolean rta = false;
    for(int i = 0 ; i < l2.size()  && !rta ; i++){
        if( l1.contains(l2.get(i))){
            rta = true;
        }

    }
    return rta;
}

/**
* Checkea bajo las condiciones del problema si el arreglo de matiroskas es valido
* @param mem arreglo de matrioskas 
* @return retorna si cada una de las matiroskas de mem cumple la condicion de matrioskas (valga la redundancia)
*/


private  static boolean check(ArrayList<ArrayList<Integer>> mem){
    boolean rta = true;
    for(int i = 0 ; i < mem.size() && rta; i ++){
        if(mem.get(i).size()  > 1){
            rta = (mem.get(i).get(mem.get(i).size() - 1)  == 1);
            for(int j = 1 ; j < mem.get(i).size()  && rta ; j++){
                if(mem.get(i).get(j -1)  - 1 !=  mem.get(i).get(j)){
                    rta = false;
                }
            }
        }else if(mem.get(i).size() == 1 && mem.get(i).get(0) != 1){
            return false;
        }
        
    }
    return rta;

}


/**
*Modifica un arreglo de matrioskas combinando dos matrioskas y  dejando la combinacion ordenada 
*@param mem arreglo de matrioskas
*@param ca1 indice de la matrioksa a la que le va a llegar una matrioska
*@parma ca2 indice de la matrioska que va a ser combinada hacia otra
*@return retorna el arreglo de matrioskas modificado
*
*/
private static ArrayList<ArrayList<Integer>> modificar (ArrayList<ArrayList<Integer>> mem , int ca1 , int ca2){
    mem.get(ca1).addAll(mem.get(ca2));
    Collections.sort(mem.get(ca1));
    Collections.reverse(mem.get(ca1));
    mem.remove(ca2);
    return mem;

}

/**
*coppia un arrayList de enteros en otro sin perder la referencia del primero
*@param s arreglo que se va a copiar
*@return retorna el arreglo nuevo con la copia del primero
*/

private  static ArrayList<Integer>  copiarArray(ArrayList<Integer> s){
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(int i = 0 ; i < s.size() ; i++){
                copy.add(s.get(i));
        }
        return copy;
}



/**
*Retorna la cantidad de aperturas que hay que hacer al combinar ca2 en ca1a
*@param ca1 ArrayList de enteros ordenado descendentemente
*@param ca2 ArrayList de enteros ordenado descendentemente
*@return 
*
*/
private static int combine(ArrayList<ArrayList<Integer>> mem , int ca1 , int ca2 , Hashtable<String , Integer> mem2){
    ArrayList<Integer> a = new ArrayList<Integer>();
    ArrayList<Integer> b = new ArrayList<Integer>();
    a = copiarArray(mem.get(ca1));
    b = copiarArray(mem.get(ca2));
    int r = fi(a , b , mem2);
    return r;
}

/**
* Retorna la cantidad de aperturas que se deben hacer para combinar dos matrioskas
* @param ca1 primera matrioska
* @param ca2 segunda matrioska
* @return cantidad de aperturas que hay que hacer para combinar dos matrioskas
*
*/

private static int fi(ArrayList<Integer> ca1  , ArrayList<Integer> ca2 ,  Hashtable<String , Integer> mem2){
        //PRE :
	
	
    int res = -1;
    if(mem2.containsKey(ca2.toString() + ca1.toString())){
    	res = mem2.get(ca2.toString() + ca1.toString());
    	
    }
    else if(ca1.size() == 1 && ca2.size() == 1){
        res = 1;
    }else if( ca2.size() == 1 && ca1.size() > 1){
        res = caida(ca1 , ca2);
    }
    else if(ca2.size() > 1 && ca1.size() == 1){
        res = 1;
    }
    else if(consec(ca2) && ca1.get(ca1.size() - 1) > ca2.get(0)){
        res = caida(ca1 , ca2);
    }
    else if(ca2.size() > 1){
        int temp = caida(ca1 , ca2);    
        res = temp + fi( cortar(ca1 , ca2) , ca2 , mem2);  
    }
    
    mem2.put(ca2.toString() + ca1.toString(), res);
    return res;

}

/**
*Retorna si una matiroska tiene sus hijos consecutivos y no hay saltos
*@return Retorna si una matiroska tiene sus hijos consecutivos y no hay saltos
*
*/
private static boolean consec(ArrayList<Integer> c){
    boolean rta = true;
    for(int j = 1 ; j < c.size() && rta ; j++){
        if(c.get(j -1) <  c.get(j)){
                    rta = false;
        }
    }

    return rta;
    
}

/**
*comiba  de ca2 en ca1 y despues corta solos los que esten por arriba del primer elementi de ca2
*@param ca1 arreglo de enteros primero  al cual de hace el merge
*@param ca2 arreglo de enteros segunso   que se mueve 
*@retorn retorna c1 cortado  su parte supersior desdepeues del merge hata donde aparece 
* el primer elemento de ca2 que fue el que se mezclo
*
*/
private static ArrayList<Integer> cortar(ArrayList<Integer>  ca1  , ArrayList<Integer> ca2){
        ca1.add(ca2.get(0));
        Collections.sort(ca1);
        Collections.reverse(ca1);
        int i = ca1.indexOf(ca2.get(0));
        ca2.remove(0);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int j = i ; j < ca1.size() ; j++){
            res.add(ca1.get(j));
        }
        return res;


}
/**
*retorna el número de elementos consecutivos  de l1 que son mayores que el primer elemento de l2
*@param l1 arreglo de enteros 
*@param l2 arreglo de enteros
*@return  número de elementos consecutivos  de l1 que son mayores que el primer elemento de l2
*/
private static  int caida(ArrayList<Integer>  l1  , ArrayList<Integer> l2){
    int res = -1;
    boolean termino = false;
    if(l2.size() != 1){

        for(int i = 0 ; i < l1.size() && !termino ; i++){
            if(l1.get(i).compareTo(l2.get(0))  < 0){
                res = i;
                termino = true;
            }
        }

    }
    else{
        for(int i = 0 ; i < l1.size() && !termino ; i++){
            if(l1.get(i).compareTo(l2.get(0))  < 0){
                res = i;
                termino = true;
            }
        }
        if(res == -1) res = l1.size();
        else res= res + 1;
        
    }
    if(res == -1) res = l1.size();
    return res;
}





public static void main(String[] args){
	MatrioskasProblem p = new MatrioskasProblem();
	
	System.out.println(solve(new int[]{4,3,1,2}, 'l'));
	System.out.println(solve(new int[]{4,1,5,2,3}, 'l'));
	System.out.println(solve(new int[]{1, 2, 3, 2, 4, 1, 3}, 'l'));//7
	//System.out.println(solve(new int[]{1, 2 ,1 ,2 ,4 ,3 ,3}, 'l'));//Imp
	//System.out.println(solve(new int[]{1, 1 ,1 ,1, 1, 1, 1, 1, 1, 1}, 'l'));//0
//	System.out.println(solve(new int[]{1, 2 ,1 ,2 ,1 ,2, 1, 2 ,1 ,2}, 'l'));//5
//	System.out.println(solve(new int[]{1, 2 ,1 ,2 ,1, 2 ,1 ,2 ,1}, 'l')); //4
//	System.out.println(solve(new int[]{1, 7 ,6 ,2 ,5 ,4 ,3}, 'l'));//12
//	System.out.println(solve(new int[]{1, 7 ,6 ,5 ,2 ,4 ,3}, 'l'));//12
//	System.out.println(solve(new int[]{10, 9 ,8 ,7 ,6, 5, 4, 3, 2, 1}, 'l'));//9
//	System.out.println(solve(new int[]{1 ,10 ,3 ,8 ,5 ,6 ,7 ,4 ,9, 2}, 'l'));//23
//	System.out.println(solve(new int[]{1 ,3 ,5 ,7 ,9 ,10, 8 ,6 ,4 ,2}, 'l'));//17
//	System.out.println(solve(new int[]{1 ,2 ,8 ,2 ,6 ,7 ,5 ,3 ,4 ,1}, 'l'));//14
//	System.out.println(solve(new int[]{4, 2 ,6 ,1 ,3, 5, 1, 2, 4, 3, 1, 4, 5 ,3, 2}, 'l'));//20
//	System.out.println(solve(new int[]{1 ,2, 3 ,2 ,1 ,1 ,1 ,3 ,4 ,2 ,5 ,1 ,2 ,3 ,6 ,1 ,4 ,5 ,7 ,8} ,'l')); //20


	
	
	}

}



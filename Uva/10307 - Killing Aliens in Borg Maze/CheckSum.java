import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class CheckSum {
     
     
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
         
        //Leer los campos   que conforman el header del TCP
        String data;
        int puertoOrigen , puertoDestino ,  lenUDP;
        String res = "";
        /*System.out.println("Ingrese los datos : ");
        data =  br.readLine();
        System.out.println("Ingrese el puerto de origen: ");
        puertoOrigen = Integer.parseInt(br.readLine());
        System.out.println("Ingrese el puerto de destino: ");
        puertoDestino =  Integer.parseInt(br.readLine());
        System.out.println("Ingrese la longitud del UDP: ");
        lenUDP = Integer.parseInt(br.readLine());
         
         
        //Tranformar la entrada a cadena binaria
         
        res = convertir(data)  +  
                Integer.toBinaryString(puertoOrigen) + 
                Integer.toBinaryString(puertoDestino )+ 
                "0" + 
                Integer.toBinaryString(17) + 
                Integer.toBinaryString(lenUDP);
        System.out.println("res = " +  res );*/
         
        res = "011001100110000001010101010101011000111100001100";
        //Anadir los ceros faltantes a la cadena y cortarla en  cadenas de 16 bits
        String fragmentos[] =  cortar(completar(res));
        res =  sumar(fragmentos);
         
        System.out.println("res :"  + res);
        /*
        String palabra  = "hola"  , r1 , r2;
        //System.out.println("r1" + convertir(palabra));
        //System.out.println("r2" + convertir2(palabra));
        r1 =  convertir(palabra);
        //r2 =  convertir2(palabra);
        System.out.println("#" + r1);
        System.out.println(Integer.toString(20, 2));
        System.out.println(Integer.toBinaryString(20));
        //System.out.println("#" + r2);
        */
         
    }
     
    private static String sumar(String[] fragmentos) {
        for(String a : fragmentos)System.out.println("f " +  a);
        String res = "0000000000000000";
        int sum ;
        for(int i =  0 ; i < fragmentos.length ; i++){
            System.out.println(" sumando " + res + " " + fragmentos[i]);
            sum = Integer.parseInt(res, 2) + Integer.parseInt(fragmentos[i] , 2);
            res =  Integer.toBinaryString(sum);
             
            System.out.println("res "  + i  + " "  + res);
        }
        return res;
    }
 
    private static String[] cortar(String res) {
        String[] frag =  new String[res.length()/16];
         
        for(int i = 0 ; i <  res.length()/16 ; i++){
            frag[i] = "";
            for(int j = 0 ;  j <  16 ;  j++){
                frag[i]+=  res.charAt(16*i + j)+"";
            }
        }
        return frag;
    }
 
    private static String completar(String res) {   
        int r =  res.length() / 16 ;
        int faltantes =  res.length() - 16 * r  ;
        System.out.println("faltan " + faltantes);
        for(int i = 0 ;  i < faltantes ; i++) res+="0";
        return res;
    }
 
 
     
    public  static String convertir(String letras){
        String  n  , res =  "";
          int x=0;
          for (int i=0; i<letras.length(); i++){
          x=letras.charAt(i);
          n=Integer.toBinaryString(x);
            res+=n;
          }
        return res;
    }
 
}
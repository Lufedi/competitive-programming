import java.io.*;
import java.util.Arrays;

public class F{
public static  long ll;  
public static int h[] ;
public static int sh[] , n,m,num;  
public static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


public static int solve(int mi)  
{ return (mi-1)*h[mi]-sh[mi-1];  
}  


public static void main(String args[] )throws Exception  
{


 int  k,l,r,mi,water,t=0;  
  double ans;  
  String linea , datos[];
  while(!(linea = br.readLine()).equals("0 0")){ 
    datos=  linea.trim().split(" ");
    n = Integer.parseInt(datos[0]);
    m = Integer.parseInt(datos[1]);
    num=n*m;  
    h =  new int[num + 1];
    sh = new int[num  + 1];
    sh[0]=0;

    int filled = 1; 
    for( int i = 1 ; i <=  n ; i++){
          linea = br.readLine();
         // System.out.println(linea);
        datos = linea.trim().split(" ");
       for(int j = 0; j < datos.length ; j++){
        h[filled++] =  Integer.parseInt(datos[j]);
       }
       
        
    }
   
    /*for(i=1;i<=num;i++)  
     scanf("%lld",&h[i]);  */
     Arrays.sort(h);
    //for(int i = 0 ; i <  num  + 1; i++)
    //    System.out.print(h[i] + " ");
    
    //sort(h+1,h+1+num);  
    

    for( int i=1;i<=num;i++)  
     sh[i]=sh[i-1]+h[i];  
    //scanf("%lld",&water);  
    water = Integer.parseInt(br.readLine().trim());
    l=1;r=num+1;  
    while(l<r)  
    { mi=(l+r)/2;  
      if(solve(mi)*100<water)  
       l=mi+1;  
      else  
       r=mi;  
    }  
    r--;  
    if(water>0)  
     ans=1.0*(1.0*water/100+sh[r])/r;  
    else  
     ans=h[1];  
    System.out.printf("Region %d\nWater level is %.2f meters.\n%.2f percent of the region is under water.\n\n",++t,ans,100.0*r/num);  
  }  
}  
}
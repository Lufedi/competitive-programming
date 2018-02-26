#include <math.h>  
#include <iostream>  
#include <cstdlib>  
#include <cstdio>  
#include <vector>  
#include <algorithm>  
#define EPS 1e-9  
#define FOR(i, a ,b) for(i = a ; i < b ;i++)  
#define igual(a,b)  fabs(a  - b) < EPS  
     
using namespace std;  
     
     
     
int x , y;  
int n;  
     
     
     
struct Point{  
double x , y; 
   
Point(){x =  0 ;  y = 0;}  
Point(double _x ,double _y){x= _x ; y = _y;}  
};  
  
struct Vector{ 
    double  i , j; 
    Vector(double  _i , double _j){  i =  _i; j = _j;} 
}; 
   
Vector toVec(Point a , Point b){ 
    return Vector( b.x - a.x ,  b.y  - a.y); 
} 
    
struct Linea{  
double a , b , c;  
Point   pa , pb; 
    Linea(){}  
    Linea(double _a,  double  _b  , double _c , Point _pa , Point _pb) {  
        a  = _a ;  
        b = _b ;  
        c = _c;  
        pa = _pa; 
        pb = _pb; 
     
    }  
};  
     
Point pivot;  
vector<Point> P(4);  
// To find orientation of ordered triplet (p, q, r).  
// The function returns following values  
// 0 --> p, q and r are colinear  
// -1 --> Clockwise  
// 1 --> Counterclockwise  
     
bool ccw2(Point  p2 , Point p3 ){  
    return (p2.x - pivot.x)*(p3.y - pivot.y) - (p2.y - pivot.y)*(p3.x - pivot.x) >= 0;  
}  
     
int ccw3(Point p1 ,  Point  p2 , Point p3 ){  
     double res = ( p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);  
    if(  res >   0 ) return 1;  
    else if( res < 0 ) - 1;  
    else return  0 ;  
}  
    
double dist_sqr(Point a, Point b){  
    return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);  
}  
//Convertir dos putnos a una linea                     
     
void toLinea(Point a , Point  b , Linea &l){  
     l.pa = a ; 
     l.pb = b; 
    if(fabs(a.x - b.x) < EPS){  
        l.a  =  1 ;  l.b =  0.0; l.c = -a.x;  
    }else{  
        l.a =  -(double) (a.y - b.y) /(a.x - b.x);  
        l.b = 1.0;  
        l.c = -(double)(l.a*a.x)-a.y;  
    }  
}  
    
     
 //Verificar si dos lineas son paralelas   
bool lineasParalelas(Linea l1  , Linea l2){  
    return ( fabs( l1.a - l2.a)  < EPS  && fabs(l1.b -  l2.b ) < EPS ) ;  
}  
     
 //Verificar si dos lineas son paralelas   
bool lineasPerpendiculares(Linea l1 , Linea l2){  
     Vector va =  toVec(l1.pa , l1.pb); 
     Vector vb =  toVec(l2.pa , l2.pb);   
    return  fabs( (va.i*vb.i+va.j*vb.j) )  < EPS;  
    
}  
     
     
     
void ordenar( ){  
//cout << P[0].x << endl;  
 int i , j;  
  n =  (int)P.size();  
     
 int P0  =  0;  
 //Encontrando el que es mas hacia  abajo e izquierda  
 FOR(i , 0 , 4){  
    if(P[i].y < P[P0].y || ( P[i].y == P[P0].y && P[i].x > P[P0].x))  
        P0 =  i;  
 }  
     
     
     
     
     
     
     
 Point temp = P[0] ;  
 P[0] =  P[P0];  
 P[P0] =  temp;  
 pivot =  P[0];  
      
     
 sort(++P.begin() , P.end() ,  ccw2);  
}  
     
     
double area(vector<Point> t , int n){  
double ptmp;  
ptmp=0.0;  
int i = 0;  
int j =  n - 1;  
for (int p=i;p<j;++p) ptmp+=(t[p%n].x*t[(p+1)%n].y-t[(p+1)%n].x*t[p%n].y);  
     
ptmp+=t[j%n].x*t[i%n].y-t[i%n].x*t[j%n].y;  
return fabs(ptmp*0.5);  
     
}  
  
double dot(Point a, Point b){ 
    return(a.x*b.x+a.y*b.y); 
} 
double norm_sq(Point vec){ 
    return vec.x * vec.x + vec.y * vec.y; 
} 
      
double angle(Point a , Point  b  , Point c){ 
        //Crear los vectores ab   ,   bc 
        Point v_ab(b.x - a.x , b.y - a.y) ; 
        Point v_bc(c.x - b.x , c.y - b.y); 
        //cout  << "  "  << v_ab.x  << "  " << v_ab.y << " - " << v_bc.x << " " << v_bc.y << endl; 
        double pp  =  dot(v_ab , v_bc); 
        double n1 =  norm_sq(v_ab); 
        double n2 =  norm_sq(v_bc); 
        double pc =  sqrt( n1 *  n2); 
       // cout <<n1  << " " <<  n2 <<" "<<  pp << " " <<  pc << endl; 
        return  acos( pp /pc); 
} 
    
     
int main(){  
    int casos;  
    int cont = 0 ;  
    cin >>  casos;  
 
    while(casos --){  
     
        int i ;  
        int   x , y;  
        FOR(i , 0  , 4){  
            scanf("%d %d" , &x  , &y);  
            P[i] = Point(x , y);  
        }  
        ordenar(); // ordenar los puntos   
          //cout << " res" << endl;  
      /* FOR(i  , 0 ,  (int)P.size()){  
            cout << P[i].x << " " << P[i].y << endl;  
        }  */
            
        Linea l1 , l2 , l3 , l4;  
        toLinea(P[3] ,  P[0] , l1);  
        toLinea(P[1] , P[2] , l2);  
        toLinea(P[0] ,  P[1] , l3);  
        toLinea(P[2],  P[3] , l4);  
            
        printf("Case %d: " , ++cont);
        if( lineasParalelas(l1 , l2) && lineasParalelas(l3 , l4) ) {  
              if( lineasPerpendiculares(l1 , l3)  && lineasPerpendiculares(l3 , l2)   
              &&  lineasPerpendiculares(l2 , l4)  && lineasPerpendiculares(l4 , l1) ){
                  
                 // cout <<  dist_sqr(l1.pa, l1.pb) << " - "  <<  dist_sqr(l2.pa, l2.pb ) << endl;
                 // cout <<  dist_sqr(l3.pa, l3.pb) << " - "  <<  dist_sqr(l4.pa, l4.pb ) << endl;
                    
                  if( igual( dist_sqr(l1.pa, l1.pb) ,dist_sqr(l3.pa, l3.pb )) && 
                      igual( dist_sqr(l3.pa, l3.pb) ,dist_sqr(l2.pa, l2.pb )) &&
                     igual(dist_sqr(l2.pa , l2.pb)  ,dist_sqr(l4.pa, l4.pb))  ) { 
                      printf("Square\n");      
                  }else{ 
                        printf("Rectangle\n");       
                  }      
              }else{ 
                     
                     
                    if( igual( dist_sqr(l1.pa, l1.pb) ,dist_sqr(l3.pa, l3.pb )) && 
                      igual( dist_sqr(l3.pa, l3.pb) ,dist_sqr(l2.pa, l2.pb )) &&
                     igual(dist_sqr(l2.pa , l2.pb)  ,dist_sqr(l4.pa, l4.pb)) ){ 
                        printf("Rhombus\n");         
                    }else{ 
                          printf("Parallelogram\n"); 
                    }        
              }                   
                                  
                                      
           }else{ 
                 if(   lineasParalelas(l1 , l2) ||  lineasParalelas(l3 , l4) ){ 
                       printf("Trapezium\n"); 
                 }else{ 
                       printf("Ordinary Quadrilateral\n"); 
                       } 
                          
                   
           }  
   }  
            
     
     
      
     
     
     
     
return 0 ;

}

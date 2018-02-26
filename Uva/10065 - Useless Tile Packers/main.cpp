#include <math.h>
#include <iostream>
#include <cstdlib>
#include <cstdio>

#define EPS 1e-9
#define FOR(i, a ,b) for(i = a ; a < b ;i++)
#define igual( a ,  b)  fabs( a  - b) < EPS

using namespace std;

int casos;

struct Point{
double x , y;
Point(double _x ,double _y){x= _x ; y = _y;}
};

struct Linea{
double a , b , c;
    Linea(double _a,  double  _b  , double _c) {
        a  = _a ;
        b = _b ;
        c = _c;

    }
};
void toLinea(Point a , Point  b , Linea &l){
    if(fabs(a.x - b.x) < EPS){
        l.a  =  1 ;  l.b =  0.0; l.c = -a.x;
    }else{
        l.a =  -(double) (a.y - b.y) /(a.x - b.x);
        l.b = 1.0;
        l.c = -(double)(l.a*a.x)-a.y;
    }
}

/*
struct Vector{
    double  i , j;
    Vector(double  _i , double _j){  i =  _i; j = _j;}
};

Vector toVec(Point a , Point b){
    return Vector( b.x - a.x ,  b.y  - a.y);
}*/



double dist(Point a, Point b){
    return sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
}
double dot(Point a, Point b){
    return(a.x*b.x+a.y*b.y);
}
double norm_sq(Point vec){
    return vec.x * vec.x + vec.y * vec.y;
}
bool pendiente(Point a , Point b){
    return (b.y  - a.y)/(b.x - a.x);
}
bool lineasParalelas(Linea l1  , Linea l2){
    return ( fabs( l1.a - l2.a)  < EPS  && fabs(l1.b -  l2.b ) < EPS ) ;
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


int x , y;
int main(){


scanf("%d" ,  &casos);
while(casos--){

    cout << "CASE " << casos << endl;
        scanf("%d %d" , &x  , &y);
        Point a = Point(x, y);
        scanf("%d %d" , &x  , &y);
        Point b(x , y);
        scanf("%d %d" , &x  , &y);
        Point c(x , y);
        scanf("%d %d" , &x  , &y);
        Point d(x , y);


        cout << "  "  <<  a.x <<  " " << a.y << endl;
        cout << "  "  <<  b.x <<  " " << b.y << endl;
        cout << "  "  <<  c.x <<  " " << c.y << endl;
        cout << "  "  <<  d.x <<  " " << d.y << endl;
    //ab cd
    //ac bd
    //bc ad


        double m_ab =  pendiente(a  , b);
        double m_cd =  pendiente(c  , d);
        double m_bc =  pendiente(b , c);
        double m_da =  pendiente(d , a);


        double d_ab =  dist(a , b);
        double d_cd =  dist(c, d);
        double d_bc =  dist(b , c);
        double d_da =  dist(d , a);

        double a_abc =  angle(a  , b  , c);
        double a_bcd =  angle( b , c ,d);
        double a_cda  = angle( c , d , a);
        double a_dab =  angle( d , a , b);


    cout <<  "m " <<  m_ab << endl;
    cout <<  "m " <<  m_cd << endl;
    cout <<  "m " <<  m_bc << endl;
    cout <<  "m " <<  m_da << endl;
    cout <<  "d " <<  d_ab << endl;
    cout <<  "d " <<  d_cd << endl;
    cout <<  "d " <<  d_bc << endl;
    cout <<  "d " <<  d_da << endl;
    cout <<  "a " <<  a_abc << endl;
    cout <<  "a " <<  a_bcd << endl;
    cout <<  "a " <<  a_cda << endl;
    cout <<  "a " <<  a_dab << endl;
    /*ab -  cd
      ac  - bd
      ad  - bc
    */





        if( fabs(m_ab   -  m_cd)  <  EPS ) {
            if( fabs(m_bc  - m_da)  < EPS){
                if( igual(d_ab ,  d_cd) ){
                    if(igual(d_bc ,  d_da)){
                     if( igual(a_abc , 1.5708)
                         && igual(a_bcd , 1.5708)
                         && igual(a_cda , 1.5708)
                         && igual(a_dab , 1.5708)){
                            printf("Square\n");
                    }else if(!igual(a_abc , 1.5708)
                         && !igual(a_bcd , 1.5708)
                         && !igual(a_cda , 1.5708)
                         && !igual(a_dab , 1.5708)){
                            printf("Rombo\n");
                         }
                    }else{
                        printf("Rectangle\n");
                    }
                }else{

                }
            }else{


            }
        }




}




return  0;
}

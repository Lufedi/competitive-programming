#include <math.h>
#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <vector>
#include <algorithm>
#define EPS 1e-9
#define FOR(i, a ,b) for(i = a ; i < b ;i++)
#define igual( a ,  b)  fabs( a  - b) < EPS

using namespace std;



int x , y;
int n;




struct Point{
double x , y;
Point(){x =  0 ;  y = 0;}
Point(double _x ,double _y){x= _x ; y = _y;}
};

Point pivot;
// To find orientation of ordered triplet (p, q, r).
// The function returns following values
// 0 --> p, q and r are colinear
// -1 --> Clockwise
// 1 --> Counterclockwise

bool ccw2(Point  p2 , Point p3 ){
    return (p2.x - pivot.x)*(p3.y - pivot.y) - (p2.y - pivot.y)*(p3.x - pivot.x) > 0;
}

int ccw3(Point p1 ,  Point  p2 , Point p3 ){
     double res = ( p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);
    if(  res >   EPS ) return 1;
    else if( res < EPS )  return -1;
    else if (igual(res , EPS)) return  0;
}





vector<Point> CH(vector<Point>  P ){
//cout << P[0].x << endl;
 int i , j;
  n =  (int)P.size();

 int P0  =  0;
 //Encontrando el que es mas hacia  abajo e izquierda
 FOR(i , 0 , n){
    if(P[i].y < P[P0].y || ( P[i].y == P[P0].y && P[i].x > P[P0].x))
        P0 =  i;
 }



//cout << endl <<  P[P0].x  << " ---   " <<  P[P0].y << endl;



 Point temp = P[0] ;
 P[0] =  P[P0];
 P[P0] =  temp;
 pivot =  P[0];

 //cout << endl <<  pivot.x  << " ---   " <<  pivot.y << endl;

 sort(++P.begin() , P.end() ,  ccw2);


 vector<Point> S;

 S.push_back(P[n -1]);
 S.push_back(P[0]);
 S.push_back(P[1]);


 i = 2;
 while(i < n){
     j =  (int)S.size() - 1;
     if(ccw3(S[j - 1] , S[j] ,P[i]) == 1) {//left turn
     S.push_back(P[i++]);
     }
     else S.pop_back();
 }

return S;

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


int main(){
    int casos;
    int cont = 0 ;
    cin >>  casos;



    while(casos  != 0){

        //cout << casos << " casos ";
        vector<Point> puntos;

        int i ;
        int   x , y;
        FOR(i ,  0  , casos){
            scanf("%d %d" , &x  , &y);
            puntos.push_back(Point((double)x , (double)y));

        }
        vector<Point> chRes =  CH(puntos);

         //cout << " res" << endl;


        //FIND AREA OF Polygon


        double areaPoligono =  area(puntos ,  (int)puntos.size());
        double areaCH = area(chRes , (int)chRes.size());
        //FIND convex hull

        //cout << " pol A " << areaPoligono << " " << areaCH << endl;
        //if(cont >= 1) cout << endl;
        cout << "Tile #" << (cont + 1)  <<  endl;
        cout << "Wasted Space = " ;
        printf("%.2lf %%\n"  , (areaCH -  areaPoligono)*100.0 / areaCH );
        cout << endl;
        cont++;

    scanf("%d" ,  &casos);


}




return  0;
}

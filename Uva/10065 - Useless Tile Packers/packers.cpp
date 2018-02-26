
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
int ccw(Point p, Point q, Point r)
{
    int val = (q.y - p.y) * (r.x - q.x) -
              (q.x - p.x) * (r.y - q.y);
    if (val == 0) return 0;  // colinear
    return (val > 0)? 1:-1; // clock or counterclock wise
}


bool angleCmp(Point a , Point b){
    double d1x  =  a.x - pivot.x ;
    double d2x  =  b.x - pivot.x;
    double d1y  =  a.y  - pivot.y;
    double d2y  =  b.y   - pivot.y;
    return (atan2(d1y,d1x) - atan2(d2y, d2x));
}



vector<Point> CH(vector<Point>  P ){
//cout << P[0].x << endl;
 int i , j;
  n =  (int)P.size();

 int P0  =  0;
 //Encontrando el que está mas hacia  abajo e izquierda
 FOR(i , 0 , n){
    if(P[i].y < P[P0].y || ( P[i].y == P[P0].y && P[i].x > P[P0].x))
        P0 =  0;
 }



cout << endl << "  i " <<    P0 << endl;

 /*Point temp = P[0] ;
 P[0] =  P[P0];
 P[P0] =  temp;
 */pivot =  P[P0];



 sort(++P.begin() , P.end() ,  angleCmp);

   FOR(i  , 0 ,  (int)P.size()){
            cout << P[i].x << " " << P[i].y << endl;
        }

cout << "DDDD";
 vector<Point> S;

 S.push_back(P[0]);
 S.push_back(P[1]);
 S.push_back(P[2]);


cout << " " << P[n  - 1].x << " "<< P[n - 1].y << endl;

 i = 2;
 while(i < n){
     j =  (int)S.size() - 1;
     if(ccw(S[j - 1] , S[j] ,P[i])) {

        cout << " " << S[j-1].x << " "<< S[j - 1].y << "*";
        cout << " " << S[j].x << " "<< S[j].y << "*";
        cout << " " << P[i].x << " "<< P[i].y << "*" << endl;
     S.push_back(P[i++]);
     }
     else S.pop_back();
 }

return S;

}


double area(vector<Point> P){
    double res , x1 , x2 , y1 , y2 , i;
    FOR(i ,  0 ,  (int)P.size()-1){
        x1 =  P[i].x ; x2 = P[i+1].x;
        y1 =  P[i].y ; y2 = P[i+1].y;
        res += ( x1*y2 - x2*y1);
    }
    return fabs(res)/2.0;
}


int main(){
    int casos;
    cin >>  casos;



    while(casos  != 0){

        cout << casos << " casos ";
        vector<Point> puntos;

        int i ;
        int   x , y;
        FOR(i ,  0  , casos){
            scanf("%d %d" , &x  , &y);
            puntos.push_back(Point((double)x , (double)y));

        }


        vector<Point> chRes =  CH(puntos);

         cout << " res" << endl;
         FOR(i  , 0 ,  (int)chRes.size()){
            cout << chRes[i].x << " " << chRes[i].y << endl;
        }

        //FIND AREA OF Polygon

        int areaPoligono =  area(puntos);
        int areaCH =  area(chRes);
        //FIND convex hull

        cout << " pol A " << areaPoligono << " " << areaCH << endl;

        cout << (areaPoligono  - areaCH)*100 / areaPoligono <<  endl;


    scanf("%d" ,  &casos);

    }




return  0;
}


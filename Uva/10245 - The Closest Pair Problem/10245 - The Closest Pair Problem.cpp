#include <bits/stdc++.h>
#define INF 2000000000
#define EPS 1e-9
using namespace std;




int c_puntos;


struct Punto{
    double first , second;
    Punto(double _f ,  double  _s){
        first   = _f ;
        second = _s;
    }
    Punto(){}

};


Punto puntos[10005];



bool cmp(Punto a , Punto b){
    if( a.first <  b.first) return true;
    else if(  a.first  ==  b.first){
        return  a.second < b.second;
    }else{
        return false;
    }
}

double sqr(double n){ return n*n;}



double distEs(Punto a ,   Punto b){
    return sqr((a.first - b.first))  + sqr(( a.second - b.second));
}

double solve(){

    // ordenar los puntos

    sort(puntos , puntos+c_puntos   ,  cmp );


    if(c_puntos > 1){
        double minDist = distEs(puntos[0] , puntos[1]);
        for(int i = 0; i <  c_puntos ;i++){
            for(int j = i - 1 ;  j >= 0 &&  sqr(puntos[i].first - puntos[j].first)  <  minDist ; j--){
                minDist = min(minDist ,  distEs(puntos[i] ,  puntos[j]));
            }
        }

        return minDist;
    }else{
         return 100000;
    }
}






int main(){
    cin >>  c_puntos;

    while(c_puntos != 0){
        int x ,  y;

        for(int i = 0 ; i < c_puntos  ;i++ ){
                cin >> puntos[i].first;
                cin >> puntos[i].second;
        }

        double res = solve();
        if( res  > 10000  || fabs(res - 10000) < EPS)  printf("INFINITY\n");
        else printf("%.4lf\n" ,  sqrt(res));
        cin >> c_puntos;
    }
}

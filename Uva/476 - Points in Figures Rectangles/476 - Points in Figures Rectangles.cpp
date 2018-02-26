#include<bits/stdc++.h>
using namespace std;



struct Point{
    double x , y;
    Point(double _x ,  double _y){
        x = _x; y = _y;
    }

};


struct Rect{
    double ptos[4];
    Rect(){}
};



char  r  ;
int d , n_puntos , n_rects;
double coord;
vector<Rect>  rects;
vector<Point> puntos;



void solve(){

    int cont = 0;
    bool dentro = false;
    for(int i = 0 ; i <  n_puntos ;i++ ){
        dentro = false;
        for(int j = 0 ;  j <  n_rects ;j++){

            if(   puntos[i].x >  rects[j].ptos[0] && puntos[i].x < rects[j].ptos[2] &&
                   puntos[i].y >  rects[j].ptos[3] && puntos[i].y <  rects[j].ptos[1] ){
                    dentro = true;
                    cout << "Point "<< (i + 1) << " is contained in figure " <<  (j + 1) <<  endl;
                   }
            }
        if(!dentro)cout << "Point "<< (i + 1)<<" is not contained in any figure" << endl;
    }

}





int main(){


    cin >> r;
    int cont = 0;
    n_rects = 0;
    while( r != '*'){
        rects.push_back( Rect());
        cin  >>  coord;
        rects[cont].ptos[0] = coord;
        cin  >>  coord;
        rects[cont].ptos[1] = coord;
        cin  >>  coord;
        rects[cont].ptos[2] = coord;
        cin  >>  coord;
        rects[cont].ptos[3] = coord;
        cont++;
        n_rects++;
        cin >>  r;

    }
    n_puntos = 0;
    double coord2;
    cin  >>  coord;
    while( fabs(coord - 9999.9) > 1e-9){
        cin >> coord2;
        n_puntos++;
        puntos.push_back(Point(coord , coord2));
        cin >>  coord;
    }

    //cout << " n  puntos" <<  n_puntos << endl;
    solve();






return 0;
}

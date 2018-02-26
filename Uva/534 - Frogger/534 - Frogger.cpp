#include<bits/stdc++.h>
#define INF 2000000000
using namespace std;


int nodes ,edges;
int x , y;
int puntos[205][2];
double dist[205][205];


void calcularDistancias(){

    for(int  i = 0 ; i < nodes ;i++){
        for(int j = 0 ; j  < nodes ; j++){
            if(i != j ){
                double d = sqrt(
                           (puntos[i][0] - puntos[j][0])*( puntos[i][0] - puntos[j][0])
                        +  (puntos[i][1] - puntos[j][1])*( puntos[i][1] - puntos[j][1])
                                );
                dist[i][j] = d;
                dist[j][i] = d;
            }else  dist[i][j] = 0;
        }
    }
}

void calcularDistMinima(){
    for(int k = 0 ; k <  nodes ; k++){
        for(int  i = 0 ; i <  nodes ; i++){
            for(int  j = 0 ; j <  nodes ; j++){
                //if(dist[i][k] + dist[k][j] <  dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
                // minimax
                dist[i][j] = dist[j][i]= min( dist[i][j] , max(dist[i][k] , dist[k][j]));

            }
        }
    }



}

int main(){

    int n_nodes;
    int scenario = 0;
    cin >>  nodes;

    while(  nodes != 0 ){

        scenario++;
        for(int i = 0; i <  nodes ; i++){

            cin >>  x ; cin >> y;
            puntos[i][0] = x;
            puntos[i][1] = y;

        }

        calcularDistancias();
        calcularDistMinima();

        printf("Scenario #%d\n" , scenario);
        printf("Frog Distance = %.3lf\n\n" ,  dist[0][1]);

        cin >> nodes;
    }



return 0;
}

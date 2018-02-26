#include <cstdio>
#include <iostream>
#include <string>
#include <cstdlib>

#define FOR(i , a , b) for(i = a ; i  < b ; i++)
#define LIM   100
#define INF 1000000000
#define SET(mat, c)         memset(mat, c, sizeof(mat))


using namespace std;




int main(){
    int casos ;
    int nodos;
    string dato;
    int i , j , k  ,  c;
    int mat[LIM][LIM];

    while(cin >> casos){
    nodos = casos;
    FOR(i , 0 ,  nodos)
          FOR(j , 0 ,  nodos)
                mat[i][j] = INF;
    c = 1;
    casos --;

    while(casos--){
        FOR(i ,  0  , c ){
               cin >> dato;
               if( dato == "x") mat[c][i] = INF;
               else mat[c][i] = atoi(dato.c_str());
               //scanf("%d",  &(mat[c][i] ) ) ;
               mat[i][c] = mat[c][i];

        }
        c++;
    }

    /*FOR(i , 0 ,  nodos ){
          FOR( j , 0 ,  nodos)
               printf("%d" ,  mat[i][j]);
          printf("\n");
    }*/

    FOR(k , 0  , nodos)
          FOR(i , 0 , nodos)
                FOR(j , 0 ,  nodos)
                      mat[i][j] = min(mat[i][j] ,  mat[i][k] + mat[k][j]);

    int maxi = 0;




    FOR(i , 0 , nodos)
                maxi = max(maxi , mat[i][0]);



    printf("%d",  maxi);
    printf("\n");


    }
 return  0;
}


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
    int M ,  N , i;
    int cant;
    int sz[6] , j;

    string dato ;

    scanf("%d" ,  &casos);
    while(casos--){
        FOR( j , 0 , 6) sz[j] = 0;
        scanf("%d %d" ,  &N ,  &M);
        cant = N/6;
        bool res = true;

        string ppl[M][2];
        FOR(i , 0 , M){
            string ca1 , c2;
            scanf("%s %s" , &ppl[i][0] , &ppl[i][1]);
        }

        cout << " " << cant <<  " " << M << " " << N;
        scanf("%d" , i);
        FOR(i , 0 , M){
           cout << ppl[i][0] << " " << ppl[i][1];
        }

        FOR(i , 0  ,  6){
            if(sz[i] > cant)res = false;
        }
        if(res) printf("YES");
        else printf("NO");
        printf("\n");

    }

 return  0;
}

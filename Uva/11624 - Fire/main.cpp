



#include <cstdio>
#include <algorithm>
#include <iostream>
#define FOR(i, a, b)        for(i=a; i<b; i++)
#define INF_MAX 2147483647
#include <queue>
using namespace std;
    char mapa[1005][1005];
    int vif[1005][1005];
    int vij[1005][1005];
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int r , c;

struct Par{
    int i ,  j;
    Par( int ii ,  int jj ) { i = ii ; j = jj;}
};


void bfs_joe( int i , int j){
Par inicio(i , j);
vij[i][j] = 0;
queue<Par> qj;
qj.push(inicio);

while(!qj.empty()){
    int i ;
    int nx ,  ny;

    Par u  = qj.front();
    qj.pop();
    FOR( i , 0 , 4){
        nx = u.i + dx[i];
        ny = u.j + dy[i];

        if( nx  >=  0 &&  nx <  r && ny >= 0 &&  ny < c && vij[nx][ny] == INF_MAX && mapa[nx][ny] != '#'){
            vij[nx][ny] = vij[u.i][u.j] + 1;
            qj.push(Par(nx , ny));
        }
    }
}


}

int main(){
    int casos;

    scanf("%d" ,  &casos);


    while(casos--){


    scanf("%d  %d" ,  &r , &c);

    queue<Par> qf;


    int i , j  ,  xj , yj;
    FOR(i ,  0 , r )
        FOR(j , 0 , c){
            vif[i][j]  =INF_MAX;
            vij[i][j]  = INF_MAX;
        }

    FOR(i , 0 , r){
        scanf("%s"  , mapa[i]);
         FOR( j  , 0 ,  c){
            if(mapa[i][j] == 'J'){
              xj = i ; yj = j;
            }
            if(mapa[i][j] == 'F'){
                Par a(i , j);
                qf.push(a);
                vif[i][j] = 0;
            }
        }

    }

    //Hacer el bfs para joe
    bfs_joe(xj ,  yj);

    //
    int res;



    while(!qf.empty()){

        Par u = qf.front();
        qf.pop();
        int i ;
        FOR( i , 0 ,  4){
            int nx =  u.i + dx[i];
            int ny =  u.j + dy[i];
				if( nx >= 0  && nx < r && ny >= 0 && ny < c && mapa[nx][ny]!= '#' &&   vif[nx][ny] == INF_MAX ){
					qf.push( Par(nx , ny));
					vif[nx][ny] =  vif[u.i][u.j] + 1;
				}
        }
    }




		int minf = INF_MAX;
		for(int  i = 0 ; i < c ;  i++){
			if( vif[0][i] > vij[0][i] ){
				minf = min(minf, vij[0][i]);
			}
			if( vif[r - 1][i] > vij[r - 1][i] ){
				minf = min(minf, vij[r - 1][i]);
			}
		}

		for(int  i = 0 ; i < r ;  i++){
			if( vif[i][0] > vij[i][0] ){
				minf = min(minf, vij[i][0]);
			}
			if( vif[i][c - 1] > vij[i][c - 1] ){
				minf = min(minf, vij[i][c - 1]);
			}
		}


        if(minf == INF_MAX) printf("IMPOSSIBLE\n");
        else printf("%d\n"   ,  (minf + 1));








    }

    return  0;

}



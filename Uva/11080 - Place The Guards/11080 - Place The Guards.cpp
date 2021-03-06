#include <bits/stdc++.h>
#define INF 2000000000

using namespace std;

typedef vector<int> vi;
typedef pair<int , int> ii;
typedef vector<ii> vii;




vector<vii> adjList;
int nodes , edges;


/*
int minimun_guards(){

    int grd = 0;
    vi vis(nodes ,  -1);
    vis[0] = 1;
    queue<int> q;
    q.push(0);
    grd++;

    while( !q.empty()){
        int u = q.front();
        q.pop();
        for(int j = 0 ; j <  (int)adjList[u].size() ; j++){
                ii v = adjList[u][j];
                if( vis[v.first] == -1 ){
                    vis[v.first] = 1;
                    q.push(v.first);
                    grd++;
                }
        }


    }


}
*/


int minimun_guards(){


    /*for (vii::iterator j = adjList[1].begin(); j != adjList[1].end(); j++)
        printf("Edge 0-%d (weight = %d)\n", j->first, j->second);
*/
    int guards  =  0;
    vi vis(nodes , INF);
    bool bicol = true;

    for(int i = 0 ;i <  nodes  && bicol; i++){



        if(vis[i] == INF ){
           //     cout << "probando con  " <<  i <<  endl;

            vis[i] = 1;
            guards++;

            //1 black
            //-1 white
            queue<int> q;
            q.push(i);
            int myColor = 1 ;
            while(!q.empty() && bicol){

                int u = q.front();
                q.pop();
                myColor = vis[u]*(-1);
                for(int j = 0; j < (int)adjList[u].size() ;j++){
                    ii v = adjList[u][j];
                    if( vis[v.first]  == INF ){
                        if(myColor == 1) guards++;
                        vis[v.first] = myColor;
                        q.push(v.first);
                    }else{
                        if( vis[v.first] == vis[u]){
                            bicol = false;
                        }
                    }
                }
            }

        }

    }




     if(bicol) return guards;
     else return -1;
}


int main(){



        int casos , u , v;
        cin >> casos;
        for(int i = 0 ;i < casos ; i++){

            cin >> nodes ; cin >> edges;
            adjList.assign(nodes , vii());
            for(int j = 0 ; j <  edges ; j++){
                cin >>  u ; cin >> v;
                adjList[u].push_back(ii(v,0));
                adjList[v].push_back(ii(u,0));
            }
            cout <<  minimun_guards() << endl;
        }


}

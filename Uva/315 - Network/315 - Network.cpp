#include<bits/stdc++.h>
#define FOR(i ,  a,  b)  for(i = a  ;  i < b ;  i++)
using namespace std;




typedef vector<int> vi;
typedef pair<int, int> ii;
typedef vector<ii> vii;



vector<vii> adjList;

int nodes;
int edges;



int find_critical(){



    int res = 0;
    for(int noPermitido = 0 ; noPermitido  < nodes ; noPermitido++){

        vi vis(nodes , -1);
        int inicio ;
        //seleccionando el inicio de la busqueda
        if( noPermitido == nodes - 1) inicio = 0;
        else inicio = noPermitido + 1;
        vis[inicio] = 1;
        queue<int> q;
        q.push(inicio);
        while( !q.empty()){
            int u = q.front();
            q.pop();
            for(int j = 0;   j < (int)adjList[u].size() ;j++){
                    ii v = adjList[u][j];
                    if( vis[v.first] == -1 && v.first != noPermitido){
                            vis[v.first] = 1;
                            q.push(v.first);
                    }
            }
        }
        bool flag = true;

        for(int k  = 0 ; k <  nodes && flag; k++){
            if(vis[k] == -1 &&  k != noPermitido){
               flag = false;
            }
        }
        if(!flag) res++;
    }
return res;
}


int main(){


    string line ,  token;

    getline(cin , line);
    nodes = atoi(line.c_str());
    while(nodes !=  0 ){


                int u , v;


                adjList.assign(nodes , vii());


                while(getline(cin,line)){
                        stringstream ss(line);
                        ss>>u;
                        if(u==0)
                            break;
                         while(ss >> token ){
                              //  cout << " u " << u << " v " <<  token <<  endl;
                                v = atoi(token.c_str()) - 1 ;
                                adjList[u - 1].push_back(ii( v, 0));
                                adjList[v].push_back( ii(u  - 1, 0));
                               // adjMat[u - 1][ atoi(token.c_str())]  =  1;
                        }
                    }


       /*          for(int  u = 0 ; u  < nodes ; u++){
            cout <<  " u : "  <<  u << endl;
        for(int  v = 0 ; v <  (int)adjList[u].size() ; v++){
            cout <<  adjList[u][v].first <<  " " ;
        }
        cout <<  endl;
    }*/
    cout << find_critical() << endl;
    getline(cin , line);
    nodes = atoi(line.c_str());
    }
   return 0;
    }

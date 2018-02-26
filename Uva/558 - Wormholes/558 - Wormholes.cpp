#include<bits/stdc++.h>
using namespace std;




#define INF 2000000000
typedef vector<int> vi;
typedef pair<int, int> ii;
typedef vector<ii> vii;


int n , m;
vector<vii> adjList;


void solve(){

vi  dist(n ,  INF);
dist[0] = 0;
for(int i = 0 ; i <  n - 1 ; i++){
    for(int u = 0 ; u < n ; u++){
        for(int j  = 0; j <  (int)adjList[u].size() ; j++){
            ii v  = adjList[u][j];
            dist[v.first] = min(dist[v.first] ,  dist[u] + v.second);
        }
    }
}


//check if there is som cycle
bool negCycle = false;
for(int u = 0 ; u < n ; u++){
    for(int j = 0 ; j <  (int)adjList[u].size() ; j++){
        ii v = adjList[u][j];
        if(dist[v.first] >  dist[u] + v.second)
            negCycle = true;
    }
}
    if(!negCycle) cout << "not possible" << endl;
    else cout << "possible" << endl;

}


int main(){

    int casos , u , v , t;
    cin >> casos;
    while(casos--){
        cin >> n;cin >> m;
        adjList.assign(n  ,  vii());
        for(int i = 0 ; i < m ;i++){
            cin >> u ; cin >> v ; cin >> t;
            adjList[u].push_back(ii(v  ,t));
        }
        solve();
    }
return 0;
}

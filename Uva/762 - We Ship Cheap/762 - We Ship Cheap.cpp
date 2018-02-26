#include<bits/stdc++.h>

using namespace std;
typedef pair<string,int> si;
typedef pair<int, string> is;
typedef pair<int , int> ii;
typedef vector<int>  vi;
typedef vector<ii> vii;

int edges;
map<string , int> dic1;
map<int ,string>  dic2;
vector<vii> adjList;
int nodos;


void solve(int qu , int qv){
    /*for(int  k = 0; k <  nodos;k++){
        cout << dic2[k] <<   " " << dic1[dic2[k]] << endl;
    }*/
//cout <<  qu << " " <<  qv << endl;
vi vis(nodos , -1);
vis[qu] = 1;
vi pr(nodos , 0);
for(int i = 0; i <  nodos ; i++)pr[i] = i;
queue<int>  q;
q.push(qu);
bool llego = false;
while( !q.empty()){
    int u  =  q.front();
    q.pop();
    for(int j = 0; j <  (int)adjList[u].size() ; j++){
        ii v =  adjList[u][j];
        if(vis[v.first] == -1){
            vis[v.first] = 1;
            q.push(v.first);
            pr[v.first] = u;
            if( v.first == qv) llego = true;
        }
    }





}
/*
for(int i = 0; i <  nodos ; i++) cout << pr[i] << " ";
    cout << endl;
*/
if( llego ){
    stack<string> camino;
    //imprimir camino
        int i = qv;
        while(pr[i] != i){
            //cout << " "  << pr[i] << endl;
            string s( dic2[i]);
            string s2(dic2[pr[i]]);
            s =  s2 + " " +  s  ;
            camino.push(s);
            i = pr[i];
        }
        while(camino.size() != 0 ){
            cout << camino.top() << endl;
            camino.pop();
        }
}else{
    cout << "No route" << endl;
}
}
int main(){
    int cant = 0;

    while(cin >> edges){

        while(adjList.size() != 0) adjList.pop_back();
        dic1.clear();
        dic2.clear();
        //cout << adjList.size() << dic1.size()  << dic2.size() <<  endl;
        string s1 , s2;
        int u ,  v;
        nodos = 0 ;
        for(int i = 0; i <  edges ; i++){
            cin >> s1;
            if( dic1.count(s1) == 0){
                dic1.insert( si(s1 , nodos));
                dic2.insert( is(nodos ,s1));
                adjList.push_back(vii());
                u = nodos;
                nodos++;
            }else{
                u = dic1[s1];
            }
            cin >> s2;
            if(dic1.count(s2) == 0){
                dic1.insert(si(s2 , nodos));
                dic2.insert(is(nodos , s2));
                adjList.push_back(vii());
                v  = nodos;
                nodos++;
            }else{
                v = dic1[s2];
            }
            adjList[u].push_back(ii(v , 0));
            adjList[v].push_back(ii(u , 0));

        }
        int qu , qv;
        cin >> s1; cin >> s2;

        if(cant > 0) cout << endl;
        if( dic1.count(s1) != 0 && dic1.count(s2) != 0){
                qu = dic1[s1] ; qv = dic1[s2];
            solve(qu ,  qv);
        }else
            cout << "No route" << endl;
        cant++;

    }


return 0;
}

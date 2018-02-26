#include <bits/stdc++.h>
#define FOR(i , a , b) for(i = a  ;  i < b; i++)
//#define INF 2000000000
#define INF 2147483647
using namespace std;
/*
#include <bits/stdc++.h>
#define _ std::ios_base::Init i; std::ios_base::sync_with_stdio(false); std::cin.tie(0);

using namespace std;

int main() { _
	string g;
	cin >> g;
	cout << g << endl;
	deque<char> SDS;
	for ( char a = 'A'; a <= 'Z'; a++ ) {
		SDS.push_front(a);
	}
	random_shuffle(SDS.begin(), SDS.end());

	for (auto g: SDS ){
		cout << g << " ";
	}
}
*/


typedef pair<int  , int> ii;
typedef vector<ii> vii;
typedef vector<int> vi;


vector<vii> adjList;

int nodes;
int edges;



bool bicolored(){


    /*for (vii::iterator j = adjList[1].begin(); j != adjList[1].end(); j++)
        printf("Edge 0-%d (weight = %d)\n", j->first, j->second);
*/

    vi vis(nodes , INF);
    vis[0] = 1;
    bool bicol = true;
    //1 black
    //-1 white
    queue<int> q;
    q.push(0);
    int myColor = 1 ;
    while(!q.empty() && bicol){

        int u = q.front();
        q.pop();
        myColor = vis[u]*(-1);
        for(int j = 0; j < (int)adjList[u].size() ;j++){
            ii v = adjList[u][j];
            if( vis[v.first]  == INF ){
                vis[v.first] = myColor;
                q.push(v.first);
            }else{
                if( vis[v.first] == vis[u]){
                    bicol = false;
                }
            }
        }
    }

    return bicol;
}

int main(){

    cin >>  nodes;

    while(nodes != 0){
        cin >> edges;
        adjList.assign(nodes , vii());
        int i , u ,v;
        FOR(i , 0 ,  edges){
            cin >> u ;
            cin >> v;
            adjList[u].push_back(ii(v , 0));
            adjList[v].push_back(ii(u , 0));
        }

        if( bicolored()) cout << "BICOLORABLE." <<  endl;
        else  cout  << "NOT BICOLORABLE." << endl;
        cin >> nodes;
    }












}

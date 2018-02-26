#include<bits/stdc++.h>
using namespace std;


long long choose[52][52] , d[50];
int N = 50;

int main(){


    for (int i=0; i<=N; ++i) choose[i][0] = choose[i][i] = 1;
    for (int i=1; i<=N; ++i)
        for (int j=1; j<i; ++j)
            choose[i][j] = choose[i-1][j-1] + choose[i-1][j];

    d[0] = 1, d[1] = 0;
    for (int i=2; i<=N; ++i) d[i] = (i-1)*(d[i-2] + d[i-1]);
    //for (int i=0; i<=N; ++i)  cout << d[i] << endl;


    int n  , m ;

    while( cin >> n >> m) {
        long long ans = 0;
        for(int k = 0; k <= m ; k++){
            ans += choose[n][k] * d[n   -  k];
        }
        cout << ans << endl;
    }





}

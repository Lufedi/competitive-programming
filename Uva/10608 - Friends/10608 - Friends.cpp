

#include<bits/stdc++.h>


using namespace std;

typedef vector<int> vi;

class UnionFind{

private:
    vi p, rk ,  cnt;
    int  n;
public:
    UnionFind(int N){
        n = N;
        rk.assign(N , 0);
        cnt.assign(N , 1);
        p.assign(N ,0);
        for(int i = 0 ; i < N ;i++)p[i] = i;
    }
    int findSet(int i){
        return ( p[i] == i)? i :  (p[i] = findSet(p[i]));
    }

    void unionSet(int i , int j){
        int fi = findSet(i);
        int fj = findSet(j);
        if( fi !=  fj){
            int s1 , s2;
            s1 =  cnt[fi];
            s2 =  cnt[fj];
            cnt[fi] = s1 + s2;
            cnt[fj] = s1 + s2;
            if(rk[fi] >  rk[fj]) {
                    p[fj] = fi;
            }else{
                p[fi] = fj;
                if(rk[fj] == rk[fi])rk[fj]++;
            }

        }

    }

    int getMax(){
        int maxi = -1;
        for(int i = 0 ;  i <   n  ;i++){
            if(cnt[i] > maxi ) maxi =  cnt[i];
        }
        return maxi;
    }
};


int casos , M  , N   , u , v;
int main(){


    cin >>  casos;

    for(int  i = 0 ; i <  casos ; i++){

        cin >> N ; cin >>  M;
        UnionFind uf(N);

        for(int  j = 0 ; j < M ; j++){
            cin >> u;
            cin >> v;
            uf.unionSet(u - 1 ,  v - 1);
        }
        cout << uf.getMax() << endl;
    }
return  0;
}

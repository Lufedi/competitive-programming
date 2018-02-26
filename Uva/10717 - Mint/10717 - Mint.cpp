#include<bits/stdc++.h>
#define FOR(i , a , b) for(i = a ; i <  b ; i++)
#define INF 2000000000
using namespace std;
typedef long long unsigned int ll;

int monedas[55];
int mesas[13];

int  o , e;


/*

int gcd(int a , int b){
    while( a != b){
        if (a > b){
            a = a - b;
        }else{
            b = b - a;
        }
    }
    return a;
}

int lcm(int a , int b){
    return  a *( gcd( a , b) * b);
}*/

int gcd(int a , int b){return b == 0? a : gcd( b , a%b);}
int lcm(int a , int b){return a * ( b / gcd(a , b));}

void solve(){
    int i ;
    //FOR(i , 0 , o) cout << " " << monedas[i];
    //FOR(i , 0 , e) cout << " " << mesas[i];



    FOR( i , 0 , e){


        int p ,q ,r ,s , t , r1  = -1, r2 = INF;
        FOR( p , 0 , o)
            FOR(q , p + 1 , o)
                FOR(r , q + 1  , o)
                    FOR(s , r + 1 , o){
                        int len = lcm( monedas[p] , lcm(monedas[q] , lcm(monedas[r] ,  monedas[s])));
                        int cont = 2;
                        int _copy = len ;
                        while(len < mesas[i]){len += _copy;}
                        //cout <<   "len : " << len <<  endl;
                        if(len == mesas[i]){
                            r1 = len;
                            r2 = len;
                        }else{
                            r1 =  max( r1 , len - _copy);
                            r2 =  min( r2 , len);
                        }

                    }




        cout << r1 << " " << r2 << endl;


    }

}


int main(){


    cin >>  o >> e;
    while(o != 0 && e != o){
        int i;
        FOR( i ,  0 , o){
            cin >> monedas[i];
        }
        FOR(i , 0 ,  e){
            cin >> mesas[i];
        }



        solve();
        cin >> o >> e;

    }


}

#include<bits/stdc++.h>


using namespace std;


typedef long long ll;
typedef vector<int> vi;

ll criba_size;
bitset<10000005> bs;
vi primos;


void criba( ll limite){
    criba_size = limite + 1;
    bs.set();
    bs[0] = bs[1] = 0;
    for(ll i = 2 ; i <= criba_size ; i++){
        if(bs[i]){
            //eliminar  lor multiplis de i empezando por i*i
            for(ll j  = i * i;  j <= criba_size ; j+=i)bs[j] = 0;
            primos.push_back((int)i);
        }
    }

}

    //Euler phi sacar los primos  relativos a  N

ll EulerPhi(ll N){
// Precondicion haber calculado los primos anteriores a  N
ll PF_index = 0;
ll PF = primos[PF_index];
ll ans = N;
    while( PF * PF  <= N ){
        if( N % PF == 0) ans -= ans / PF;
        while(N % PF == 0) N /= PF;
        PF  = primos[++PF_index];
    }
if(N != 1) ans -= ans / N;
return ans;
}


int main(){
    criba(10000000);

    long long n ;
    cin >>  n;

    while( n !=  0){
        if(n == 1) cout << 0 << endl;
        else cout << EulerPhi(n) << endl;
        cin >>  n;
    }



return 0;
}

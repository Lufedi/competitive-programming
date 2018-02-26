#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef vector<int> vi;

ll criba_size;
bitset<10000005> bs;
vi primos;
int mu[1000005][2] ;

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

ll numPF(ll N){
    ll PF_idx = 0, PF = primos[PF_idx] , ans = 0 ;
    while( PF * PF  <= N){
        while( N % PF == 0){ N /= PF; ans ++;}
        PF = primos[++PF_idx];
    }
    if(N != 1) ans++;
    return ans;
}

ll numdiffPF(ll N){
    ll PF_idx = 0 , PF = primos[PF_idx] , ans = 0;
    while( PF * PF  <= N){
        if( N % PF == 0) ans++;
        while( N%PF == 0){ N /= PF;}
        PF = primos[++PF_idx];
    }
    if( N != 1) ans++;
    return ans;

}


void calcularMu(){
    int c , d;
    mu[1][0] = 1 ; mu[1][1] = 1;
    mu[0][0] = 0 ; mu[0][1] = 0;
    for(int i = 2 ; i < 1000005 ; i++){
        mu[i][0] = i;
        c = numPF( i );  d = numdiffPF( i );
        if( c ==  d ){
            if( c % 2 == 0) mu[i][1] = 1;
            else  mu[i][1] = -1;
        }else{
            mu[i][1] = 0;
        }
    }
}

int n ;


int main(){

    criba(1000005);
    calcularMu();
    cin  >> n ;

    while( n !=  0){
        int s  = 0;
        for(int i = 1 ; i <= n ; i++){
            s += mu[i][1];
        }
        //printf("-------*-------*-------*\n");
        cout <<  setw(8) <<  n <<  setw(8) << mu[n][1] << setw(8) << s << endl;

        //
        //printf("\t%d\t%d\t%d\n" ,  n ,  mu[n][1] , s);

        cin >>  n;
    }





return 0;
}

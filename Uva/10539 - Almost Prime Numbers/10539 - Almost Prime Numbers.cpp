#include<bits/stdc++.h>


using namespace std;


typedef long long ll;
typedef vector<int> vi;

ll criba_size;
bitset<10000005> bs;
vi primos;
int cont = 0;

void criba( ll limite){
    criba_size = limite + 1;
    bs.set();
    bs[0] = bs[1] = 0;
    for(ll i = 2 ; i <= criba_size ; i++){
        if(bs[i]){
            //eliminar  lor multiplis de i empezando por i*i
            for(ll j  = i * i;  j <= criba_size ; j+=i)bs[j] = 0;
            primos.push_back((int)i);
            cont++;
        }
    }

}

// numPF nos dice cuandos factores primos tiene


int main(){
    //precalcular todos los numeros primos

    criba(1000000);
    long long almost[90000];
    int top = 0;
    long long int i ,  j;
    //precalcular todos los casi primos
    for(i=0;i<=1000000;i++){
		if(bs[i]){
            for(j=i*i;j<=1000000000000;j*=i){
				almost[top++] = j;
            }
		}
    }


    int casos;
    long long n1 ,  n2 ;
    cin >>  casos;
    for(int i = 0; i <  casos ; i++){

        cin >>  n1 >> n2;
        int res  = 0;

        for(ll j = 0  ; j <  top ; j++){
            if( almost[j] >= n1 && almost[j] <= n2) {
                //cout << almost[j] << endl;
                res++;
            }
        }
        cout << res << endl;
    }





return 0;
}

/*
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
static char* primes;

void cachePrimes(int n)
{
	int i,j,k;
	primes = (char*) malloc((n+1)*sizeof(char));
	for(i = 0;i<=n;i++)
		primes[i] = 0;
	primes[0]=1;
	primes[1] = 1;
	k = sqrt(n);
	for(i = 2;i<=k;i++)
		if(!primes[i])
			for(j=i*i;j<=n;j+=i)
				primes[j] = 1;
}
int main()
{
	cachePrimes(1000000);
	int c ;
	register long long int i;
	register long long int j;
	long long int almost[80070];
	long long int n,m;
	int top = 0;
	int count = 0;
	for(i=2;i<=1000000;i++)
		if(!primes[i])
			for(j=i*i;j<=1000000000000;j*=i)
				almost[top++] = j;
	scanf("%d",&c);
	while(c>0)
	{
		scanf("%lld %lld",&n,&m);
		count = 0;
		for(i=0;i<80070;i++)
			if(almost[i]>=n&&almost[i]<=m)
				count++;
		printf("%d\n",count);
		c--;
	}
	return 0;
}
*/

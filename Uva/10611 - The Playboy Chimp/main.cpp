#include <iostream>
#include <string>
using namespace std;
#define len(a) sizeof(a)/sizeof(int)
void buscarDer(int a[] , int s , int l ){

int lo ,  hi  ,  mid ;
lo = 0 ;
hi = l;

    while( lo + 1  !=  hi ){
        mid = lo   +  (  hi - lo) /2;
            if(a[mid] == s){
                hi  =  mid;
            }else if( a[mid] >  s){
                hi = mid;
            }else{
                lo = mid;
            }
    }
    if(a[hi]< s)cout << a[hi] << " ";
    else if(a[lo]< s)cout << a[lo] << " ";
    else cout << "X"  << " ";

}




int buscarIzq(int a[] , int s , int l){
int lo ,  hi  ,  mid ;
lo = 0 ;
hi = l;

while( lo  +  1 !=  hi ){
    mid = lo  +  (  hi - lo) /2;
        if( a[mid] >  s){
            hi = mid;
        }else{
            lo = mid;
        }
}

    if(a[hi] >s)cout << a[hi] << endl;
    else if(a[lo]> s)cout << a[lo] << endl;
    else cout << "X"  << endl;




}


void solve(int a[] , int s , int l){


    buscarDer(a ,  s , l - 1);
    buscarIzq(a ,  s , l -1);
}

int main(){
int n , q  ,  s , l;
string linea;
    while(cin >> n){
        int a[n];
        for(int i = 0 ; i < n ; i++){
            cin >> a[i];
        }
        cin >> l;
        int qrs[l];
        for(int i = 0 ; i < l;i++){
            cin >> qrs[i];
        }

        for(int i = 0 ; i <  l ; i++){
            solve(a , qrs[i] , n);
        }
    }
}

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <list>
#include <stack>
#include <map>
#include <set>
#include <cstring>
using namespace std;


#define Max(a, b)  (a < b ? b : a)
#define Min(a, b)  (a > b ? b : a)


int tab[51][51];


int cs(int l ,  int h ,  int cuts[] ){

    int  min = 1077952576;
    if(  h - l == 1 ) return  0;
    else{

         if( tab[l][h] == -1){
        for(int i = l + 1  ; i <  h ; i++){
                int r =  cuts[h] - cuts[l]  + cs( l , i , cuts) + cs(i ,  h ,  cuts);
                if (  r  <   min) {
                      min =  r;
                }
        }
        }else{

              min = tab[l][h];
              }


     }
       tab[l][h] = min;
     return  min;
}

int solve(int cuts[] , int n){
    return cs(0 , n  + 1, cuts);
}



int main(){

    int n , len;
    cin >> len;


    while(len != 0){
    cin >> n;
    memset(tab,-1,sizeof(tab));
    int cuts[n + 2];
    cuts[0] = 0;
    cuts[n + 1] = len;


    for(int i = 1 ; i <  n + 1 ; i++){
            cin >> cuts[i];

            }
    cout<<"The minimum cutting is "<<solve(cuts ,  n)<<"."<<endl;


    cin >> len;
    }
 return 0;
}

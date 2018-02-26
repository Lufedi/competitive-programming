#include <bits/stdc++.h>
#include <cstdio>
using namespace std;



char palabras[10005][25];
int contP;

int main(){

    contP = 0;
    scanf("%s" , palabras[contP]);
    while( strcmp( palabras[contP] , "#")  != 0){
        contP++;
        scanf("%s"  , palabras[contP]);
    }


    queue<char> q;
    set<char> s;
    int l ;
    for(int i = 0 ; i <   contP ; i++){
        l = strlen(palabras[i]);
        for(int j = 0 ; j <  l ; j++){
           // cout << " c " <<  palabras[i][j] << endl;
            if(s.count(palabras[i][j]) == 0) {
                    q.push(palabras[i][j]);
                    s.insert(palabras[i][j]);

            }
        }
    }

    for( int i = 0; i <  s.size() ; i++){
        cout << q.front();
        q.pop();

    }
            cout << endl;


return 0;
}

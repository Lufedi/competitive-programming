#include <bits/stdc++.h>
using namespace std;





struct Tablero{
    int tablero[5][5];
    Tablero(){
    }
};

typedef pair<int , Tablero>  it;


Tablero tab;
int dx[] = {-2 , -1 , 1 , 2 , 2  , 1 , -1 , -2};
int dy[] = {1  , 2 , 2 , 1 , -1, -2 , -2 , -1};

void solve(){









}




#define FOR(i ,  a ,  b) for(i = a ; i <  b ; i++)
bool check_fin(){

    bool rta =  true;
    //check triangulo superios
    for(int i = 0; i <  5  && rta ; i ++){
        for(int j = (i + 1)  ; j <  5  && rta; j++){
            if( tab.tablero[i][j] != 1) rta =  false;
        }
    }
    //check triangulo inferior
    for(int i = 0; i <  5  && rta ; i ++){
        for(int j = (i + 1)  ; j <  5  && rta; j++){
            if( tab.tablero[j][i] != 0) rta =  false;
        }
    }

    if( !(tab.tablero[0][0] == 1 && tab.tablero[1][1] == 1 &&
        tab.tablero[2][2] == 2 && tab.tablero[3][3] == 0 &&
        tab.tablero[4][4] == 0 )) rta =  false;


}

int main(){


    int casos;
    cin >>  casos;
    string s;
    while(casos--){

        for(int i = 0; i < 5 ; i++){
                cin >> s;
            for(int j = 0 ; j <  5 ; j++){
                tab.tablero[i][j]  = s[j];
            }
        }
    }
 return 0;
}

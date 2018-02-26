#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <list>
#include <stack>
#include<string>
#include <cstring>

using namespace std;
char cad[200];
char *c;

stack<string> * p;


list< stack<string> > cards;
int cont;
int main(){


    gets(cad);
    while(cad != "#"){

        cont = 0;
        p = cards.get_allocator().allocate(53);
        cards.assign(53 , stack<string>());

        c = strtok(cad , " ");

        while (c != NULL){

            p[cont].push_back(c);
            c = strtok(NULL, " ");

        }



        gets(cad);
    }



return 0;
}

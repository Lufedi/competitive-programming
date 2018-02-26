#include <cstdio>
#include <cstring>
#include <algorithm>
#include <utility>
#include <vector>
#include <cmath>
#define FOR(i, a, b)        for(i=a; i<b; i++)
#define LIM     22
#define SET(mat, c)         memset(mat, c, sizeof(mat))
using namespace std;

int main(void){
    double a, b, c, s, res;
    while (scanf("%lf%lf%lf", &a, &b, &c)==3){
        s=(a+b+c)/2.0;
        res=sqrt(s*(s-a)*(s-b)*(s-c));
        if (a<1e-9 || b<1e-9 || c<1e-9) printf("The radius of the round table is: 0.000\n", res/s);
        else printf("The radius of the round table is: %.3lf\n", res/s);
    }
    
    return 0;
}

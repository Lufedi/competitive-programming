


#include<bits/stdc++.h>
#include<cstdio>



using namespace  std;



int r ,  d;


int main(){


    while (cin >> r >> d){
        double p = 2*(3.14159265359)*r;
		double corte = p / d;
		double alf = (corte * (2*3.14159265359))/p;
		double  l =  2 *  r * sin( alf / 2);
		double  h =   r * cos( alf / 2);
		double area =   (( l * h ) / 2);
		printf("%.3f\n" ,   area*d);

    }

return 0;
}

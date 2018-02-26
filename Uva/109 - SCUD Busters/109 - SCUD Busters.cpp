#include <cstdio>
#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#include <algorithm>

#define K 102;
#define EPS 1e-9
#define FOR(i, a ,b) for(i = a ; i < b ;i++)
#define igual( a ,  b)  fabs( a  - b) <= EPS
#define mp make_ii
#define X first
#define  PI acos(-1.0)
#define Y second

using namespace std;

typedef pair<int, int> ii;
typedef vector<ii> vii;


vector<vii> kingdoms;
vector<vii> CHS;
int elim[102];



int n;
int i ;
int x , y , ex, ey;


ii pivot;

// To find orientation of ordered triplet (p, q, r).
// The function returns following values
// 0 --> p, q and r are colinear
// -1 --> Clockwise
// 1 --> Counterclockwise

bool ccw2(ii  p2 , ii p3 ){
    return (p2.X - pivot.X)*(p3.Y - pivot.Y) - (p2.Y - pivot.Y)*(p3.X - pivot.X) >= 0;
}

int ccw3(ii p1 ,  ii  p2 , ii p3 ){
     double res = ( p2.X - p1.X)*(p3.Y - p1.Y) - (p2.Y - p1.Y)*(p3.X - p1.X);
    if(  res >   EPS ) return 1;
    else if( res < EPS )  return -1;
    else if (igual(res , EPS)) return  0;
}





vii CH(vii P ){
//cout << P[0].X << endl;
 int i , j;
  n =  (int)P.size();

 int P0  =  0;
 //Encontrando el que es mas hacia  abajo e izquierda
 FOR(i , 0 , n){
    if(P[i].Y < P[P0].Y || ( P[i].Y == P[P0].Y && P[i].X > P[P0].X))
        P0 =  i;
 }



//cout << endl <<  P[P0].X  << " ---   " <<  P[P0].Y << endl;



 ii temp = P[0] ;
 P[0] =  P[P0];
 P[P0] =  temp;
 pivot =  P[0];

 //cout << endl <<  pivot.X  << " ---   " <<  pivot.Y << endl;

 sort(++P.begin() , P.end() ,  ccw2);


 vector<ii> S;

 S.push_back(P[n -1]);
 S.push_back(P[0]);
 S.push_back(P[1]);


 i = 2;
 while(i < n){
     j =  (int)S.size() - 1;
     if(ccw3(S[j - 1] , S[j] ,P[i]) == 1) {//left turn
     S.push_back(P[i++]);
     }
     else S.pop_back();
 }

return S;

}



bool collinear(ii a,ii b,ii c){
    return (b.X - a.X) * (c.Y - a.Y) == (c.X - a.X) * (b.Y - a.Y);
}

bool within(int p,int  q,int  r){
    return p <= q <= r or r <= q <= p;
}


bool iInLine(ii a, ii b, ii c){
    bool r ;
    if(a.X != b.X){
        r = within(a.X ,  c.X , b.X);
    }else{
        r = within(a.Y , c.Y , b.Y);
    }

    return (collinear(a, b, c)
            and r);

            }




double dot(ii a, ii b){
    return(a.X*b.X+a.Y*b.Y);
}
double norm_sq(ii vec){
    return vec.X * vec.X + vec.Y * vec.Y;
}

double angle(ii a , ii  b  , ii c){
        //Crear los vectores ab   ,   bc
        ii v_ab(b.X - a.X , b.Y - a.Y);
        ii v_bc(b.X - c.X , b.Y - c.Y);
        //cout  << "  "  << v_ab.x  << "  " << v_ab.y << " - " << v_bc.x << " " << v_bc.y << endl;
        double pp  =  dot(v_ab , v_bc);
        double n1 =  norm_sq(v_ab);
        double n2 =  norm_sq(v_bc);
        double pc =  sqrt( n1 *  n2);
       // cout <<n1  << " " <<  n2 <<" "<<  pp << " " <<  pc << endl;
        return  acos( pp /pc);
}



bool ckeckLinea(ii p ,  vii ch){
    FOR(i , 0 ,  (int)ch.size() - 1){
        if(iInLine( p , ch[i] , ch[i+ 1])) return true;
    }
    return false;
}

bool inPolygon(ii p ,  vii ch){



    //printf("%d %d : " , p.X , p.Y);

if((int)ch.size() == 0) return false;
double sum = 0;
int  g ;
FOR( g , 0 ,  (int)ch.size() - 1){
    double ang = ccw3(p ,  ch[g] , ch[g +1]);
    if(ang == 1){
   // printf("%lf add+ \n" ,angle(ch[g] , p , ch[g + 1]) );
        sum += angle(ch[g] , p , ch[g + 1]);
    }else{
        sum -= angle(ch[g] , p , ch[g + 1]);
   // printf("%lf add- \n" ,angle(ch[g] , p , ch[g + 1]) );
    }
}




//printf("%lf \n"  , sum);


return fabs(fabs(sum) - 2* PI) < EPS  ;
}


double area(vii t , int n){
double ptmp;
ptmp=0.0;
int i = 0;
int j =  n - 1;
for (int p=i;p<j;++p) ptmp+=(t[p%n].X*t[(p+1)%n].Y-t[(p+1)%n].X*t[p%n].Y);
ptmp+=t[j%n].X*t[i%n].Y-t[i%n].X*t[j%n].Y;
return fabs(ptmp*0.5);
}


int main(){
    scanf("%d" , &n );
    kingdoms.assign(102 , vii());
    int o;
    FOR(o , 0 , 102){
        elim[o] = 0;
    }
    int cont  = 0;
    while( n != -1 ){
        FOR( i ,  0 ,   n){
            scanf("%d %d " ,  &x , &y);
            kingdoms[cont].push_back(ii(x ,y));
        }
        CHS.push_back( CH(kingdoms[cont]) );
    cont++;
    scanf("%d" ,  &n);
    }
    int j = 0;

    double area_res= 0;
    //printf("-- %d\n" , cont);
    int k;
    while( scanf("%d %d" , &ex ,  &ey) == 2){
            // printf("punto %d  , %d dentro de " , ex  , ey  );
        FOR(k  , 0 ,  cont){
            if( inPolygon(ii(ex , ey) , CHS[k]) && elim[k] != 1){
                   // printf("punto %d  , %d dentro de %d  area %lf \n" , ex  , ey ,  k , area(CHS[k] , (int)CHS[k].size()));
                area_res += area(CHS[k] , (int)CHS[k].size());
                elim[k] = 1;
            }
        }

    }

    printf("%.2lf" ,  area_res);

return 0 ;
}

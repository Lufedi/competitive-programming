#include<bits/stdc++.h>
#define INF 2000000000


using namespace std;
typedef long long ll;
map<ll , ll>  dic;


int main(){
    string s ;
    getline(cin ,  s);
    ll dias;
    ll bills;
    ll bill;
    ll maxi  , mini;
    ll total;

    dias = atoi(s.c_str());
    while( dias != 0 ){
            dic.clear();

           // cout <<  dias <<  endl;
            maxi = -1;
            mini = INF;
            total = 0;

            for(int j  = 0 ; j  <  dias ; j ++){
                getline(cin , s);
                stringstream ss(s);
                ss >> bills;


                for(int i = 0  ; i <  bills ;  i++){
                    ss  >>  bill;
                    if( dic.count(bill) == 0){
                        dic.insert(make_pair(bill ,  1));
                    }else{
                        dic[bill]  +=  1;
                    }

                }
                mini = (dic.begin())->first;
                maxi = (--dic.end())->first;
                //cout << maxi  << "  n " <<  mini << endl;
                total +=   fabs(maxi - mini);
                dic[maxi] -= 1;
                dic[mini] -= 1;
                //cout << " c " <<  dic[maxi] << " - " << dic[mini] << endl;
                if(dic[maxi] == 0)dic.erase(maxi);
                if(dic[mini] == 0)dic.erase(mini);


            }
            cout <<  total <<  endl;
        string s ;
        getline(cin ,  s);
        dias = atoi(s.c_str());
    }





return 0;
}

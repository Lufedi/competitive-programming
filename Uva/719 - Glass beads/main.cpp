



#include<iostream>
#include<string>
#include<algorithm>

using namespace std;


int LCS(string s){
     int n = s.size();
     int k =  0;
     s+= s;
     int f[2*n];
     int i ;
     
     for(int l = 0 ; l < 2*n  ;l++){
       f[l] = -1;              
     }
     
     for(int j = 1 ; j <  2*n ; j++){
             i = f[j - k  -1];
             while(i != -1 && s[j] != s[k+i+1]){
                     if(s[j] < s[k+i+1]){
                             k = j - i - 1;                
                     }
                     i = f[i];
             }    
             if( i == -1 && s[j] != s[k + i + 1]){
                 if(s[j] <  s[k + i + 1]){
                         k = j;
                 }
                 f[j - k] = -1;
             }else{
                 f[j - k] = i + 1;      
             }    
     } 
     return k;
     
     
     
     
}



int main(){

    int casos;
    cin >> casos;
    string s;
    
    for(int i = 0 ; i  < casos ; i++){
            cin >>  s;
            cout << (LCS(s) + 1) << endl;
            }



return 0;
}

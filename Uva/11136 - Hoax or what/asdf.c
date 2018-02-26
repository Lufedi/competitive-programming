#include <iostream>
#include <algorithm>
#include <string>
#include <cstdlib>

using namespace std;

int main(void)
{
    string astring("hola hugo ya");
    remove (astring.begin(), astring.end(),' ');
    cout<<astring<<endl;
    system("PAUSE");
    return 0;
}

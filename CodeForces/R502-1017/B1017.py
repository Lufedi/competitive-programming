

from sys import stdin
from functools import reduce, cmp_to_key


def main():

    n = int(stdin.readline().strip())
    a = stdin.readline().strip()
    b = stdin.readline().strip()

    pairs = {}
    candidates_1 = 0
    candidates_0 = 0
    total = 0;
    ones = 0
    ceros = 0
    for i in range(n):
        if(a[i] == '1'):
            total+= candidates_0
            ones+=1
        else:
            ceros+=1
            total+= candidates_1

        if( a[i] == '0' and  b[i] == '0' or 
            a[i] == '1' and  b[i] == '0'):
        
            if(a[i] == '0'):
                total+= ones - candidates_1
                candidates_0+=1
            else:
                total+= ceros - candidates_0
                candidates_1+=1
            
    print(total)


main()
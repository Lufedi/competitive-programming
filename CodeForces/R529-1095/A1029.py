
from sys import stdin

def main():
    b = stdin.readline()
    s = stdin.readline()
    res = ""
    aux = 1
    cont = 1
    for i in range(len(s)):
        if( i + 1 == aux):
            res+= s[i]
            aux+= cont
            cont+=1
    print(res)
main()
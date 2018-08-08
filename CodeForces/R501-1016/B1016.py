

from sys import stdin


def main():

    n, m , q = [ int(s) for s in stdin.readline().split(" ")]
    s = stdin.readline().strip()
    t = stdin.readline().strip()

    queries = []
    for line in range(0, q) :
        queries.append( [ int(s) for s in stdin.readline().split(" ")])
    
    acum = [0 for i in range(n+1)]
    for i in range( 1 , n+1):
        acum[i] = acum[i -1]
        
        if checkIndex(i, s, t, n, m):
            acum[i]+=1
    
    for query in queries:
        if(query[1]- query[0]  + 1< m):
            print(0)
        else:
            print(acum[query[1]-m+1] - acum[query[0]-1])

def checkIndex(fromIndex, s, t, n , m):
    valid = True
    if( n - fromIndex + 1 < m): return False
    for i in range(0, m):
        valid = valid and (t[i] == s[fromIndex + i-1])
        if not valid: break
    
    return valid





main()
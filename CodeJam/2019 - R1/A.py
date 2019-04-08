from sys import stdin
def main():
    c = int(stdin.readline().strip())
    for k in range(c):
        n = stdin.readline().strip()
        if not '4' in n:
            print('Case #' +str(k+1) + ": 0"  + " " + n)
        else:
            n = list(n)
            B = 0
            for i in range(len(n)-1,-1,-1):
                if n[i] == '4':
                    B += pow(10, len(n)-1-i)
                    n[i] = '3'
            print('Case #' + str(k+1) + ": " +  ''.join(n) + " " + str(B))
main()
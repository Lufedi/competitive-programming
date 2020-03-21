from sys import stdin

def main():
    n, k = [int(x) for x in stdin.readline().strip().split()]
    if k == 1 or k == n:
        print(n*3)
    else:
        dis = min(k - 1, n - k)
        print( dis + 3*n)
    
main()
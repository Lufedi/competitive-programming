from sys import stdin
def main():
    c = int(stdin.readline().strip())
    for k in range(c):
        N = int(stdin.readline().strip())
        S = list(stdin.readline().strip())
        R = []
        for i in range(len(S)):
            if S[i] == 'S':
                R.append('E')
            else:
                R.append('S')
        print("Case #" + str(k+1) + ": " + ''.join(R))
main()
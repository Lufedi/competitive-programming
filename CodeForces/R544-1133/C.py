from sys import stdin

def main():
    n = int(stdin.readline().strip())
    std = [int(s) for s in stdin.readline().strip().split(" ")]
    r = {}
    for i in std:
        if not i in r:
            r[i] = 0
        r[i] += 1
    maxg = 1
    for i in std:
        total = 0
        for j in range(6):
            total+= r[i-j] if i-j in r else  0
        maxg = max(maxg, total)
    print(maxg)

main()


from sys import stdin

def main():
    q = int(stdin.readline().strip())
    for i in range(q):
        line = [int(x) for x in stdin.readline().strip().split()]
        ops = []
        if line[0] % 2 == 0:
            ops.append( (line[0] // 2) * line[2] )
        else:
            ops.append( ((line[0] // 2) * line[2]) +  line[1])
        
        ops.append( line[1]*line[0])
        print(min(ops))
main()

from sys import stdin
def main():
    n = int(stdin.readline().strip())
    nums = [int(i) for i in stdin.readline().strip().split(' ')]
    
def isSorted(l):
    for i in range(l):
        if i > 0 and l[i] < l[i-1]:
            return False
    return True
main()

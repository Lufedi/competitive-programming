from sys import stdin

def main():
    inp = stdin
    #inp = open("A.in")
    n = int(inp.readline())
    pages = []
    for i in range(n):
        pages.append([int(x) for x in inp.readline().strip().split()])
    k = int(inp.readline())
    for i in range(len(pages)):
        if k >= pages[i][0] and k <= pages[i][1]:
            print(n - i)
            break
    
main()
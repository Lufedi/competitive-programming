from sys import stdin

def main():
    stdin.readline()
    arr = [ int(x) for x in stdin.readline().strip().split(" ") ]
    if(len(arr) <= 2 ):
        print(0)
    else:
        res = 0
        maxi = max(arr)
        mini = min(arr)
        arr.remove(maxi)
        res = max(arr) - mini
        arr.append(maxi)
        arr.remove(mini)
        res = min(maxi - min(arr), res)
        print(res)
main()
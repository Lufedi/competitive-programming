from sys import stdin
def main():
    n,k=[int(x) for x in stdin.readline().strip().split()]
    d = {0:0}
    boxes = [int(x) % k for x in stdin.readline().strip().split()]
    for box in boxes:
        if not box in d:
            d[box] = 0
        d[box]+=1
    total = 0
    for key in d.keys():
        comp = k - key
        if comp in d:
            take = min(d[key], d[comp])
            take = take//2 if comp*2 == k else take
            total+= take
            d[key]-= take
            d[comp]-= take
    print(total*2  +  (d[0]//2)*2)

main()


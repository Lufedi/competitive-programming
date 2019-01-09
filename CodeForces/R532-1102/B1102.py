

from sys import stdin

def main():
    N,k = [ int(x) for x in stdin.readline().strip().split(" ")]
    arr = [ int(x) for x in stdin.readline().strip().split(" ")]

    countNumbers = {}
    for n in arr:
        if n in countNumbers:
            countNumbers[n] = countNumbers[n] + 1
        else:
            countNumbers[n] =  1

 
    res = []
    isValid = True
    for key in countNumbers:
        if countNumbers[key] > k:
            isValid = False
    if(not isValid):
        print("NO")
    else:
        
        colorsDict = {}
        for a in range(1, k +1): colorsDict[a] = []

        color = 1
        for n in arr:
            
            if not n in colorsDict[color]:
                colorsDict[color].append(n)
                res.append(color)
                
            else:
                while(n in colorsDict[color]):
                    color = nextColor(color, k)

                res.append(color)
            color =nextColor(color, k)

        print("YES")
        print(' '.join(str(e) for e in res))

def nextColor(color, k):
    color = color +1
    if color  == k + 1:
        color = 1
    return color

main()

'''
4 2
1 2 2 3
outputCopy
YES
1 1 2 2
inputCopy
5 2
3 2 1 2 3
outputCopy
YES
2 1 1 2 1
inputCopy
5 2
2 1 1 2 1'''
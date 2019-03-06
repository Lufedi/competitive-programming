from sys import stdin

def main():
    N,k = [ int(x) for x in stdin.readline().strip().split(" ")]
    arr = [ int(x) for x in stdin.readline().strip().split(" ")]

    countNumbers = {}
    for n in arr:
        if n in countNumbers:
            countNumbers[n]= countNumbers[n] + 1
        else:
            countNumbers[n] =  1

 
    res = [-1 for x in arr]
    isValid = True
    for key in countNumbers:
        if countNumbers[key] > k:
            isValid = False
    if(not isValid):
        print("NO")
    else:
        
        filledNumbers = 0
        colorsDict = {}
        for a in range(1, k +1): colorsDict[a] = {}
        color = 1
        n = 0
        while color != k+1:
            if res[n] == -1 and  not arr[n] in colorsDict[color]:
                colorsDict[color][arr[n]]=1
                res[n] = color
                #next color
                color += 1
            n = (n+1)%N
        for i in range(0, len(arr)):
            if res[i] == -1:
                res[i] = findColor(arr[i], colorsDict)
                
        print("YES")
        print(' '.join(str(e) for e in res))

def findColor(e, colors):
    for color in colors:
        if not e in colors[color]:
            colors[color][e] = 1
            return color
    return -3
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